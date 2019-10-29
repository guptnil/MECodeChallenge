package com.transaction.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.transaction.dataManager.TransactionDataManager;
import com.transaction.dataManager.TransactionInstanceFactory;
import com.transaction.model.Transaction;
import com.transaction.model.TransactionInfo;
import com.transaction.util.Util;

public class TransactionServiceImpl implements TransactionService{
	
	TransactionDataManager transactionDataManager;

	public TransactionServiceImpl() {
		transactionDataManager = TransactionInstanceFactory.getTransactionDataManager();
	}

	@Override
	public TransactionInfo getTransactionInfo(String accountId, Date fromDate, Date toDate) {
		Double relativeBalance = 0.0;
		Integer noOfTransactions = 0;
		Map<String, Transaction> transactionsMap = transactionDataManager.getTransactions();
		Collection<Transaction> transactions = transactionsMap.values();
		
		// This is collecting all those transaction records which are against given accountId , have createdAt within given timeframe and transaction type is PAYMENT
		
		List<Transaction> transactionList = transactions.stream().filter(x -> (x.getFromAccountId().equals(accountId) || x.getToAccountId().equals(accountId)) &&
									 Util.isWithinRange(x.getcreatedAt(), fromDate, toDate) &&
									 x.getTransactionType().equals("PAYMENT")).collect(Collectors.toList());
		
		// This is omitting all those transactions from the list which have a corresponding REVERSAL transaction and generates filtered list
		
		List<Transaction> filteredList = transactionList.stream().filter(x -> transactions.stream().
									 filter(t -> t.getRelatedTransaction()!=null).anyMatch(t -> !t.getRelatedTransaction()
									 .equals(x.getTransactionId()))).collect(Collectors.toList());
		
		// This is adding up the amount of all those transactions where the given accountId is the toAccount 
		
		relativeBalance = filteredList.stream().filter(x -> (x.getToAccountId().equals(accountId))).mapToDouble(Transaction::getAmount).sum();
		
		// This is subtracting the total amount of all those transactions where the given accountId is the fromAccount 
		
		relativeBalance = relativeBalance - filteredList.stream().filter(x -> (x.getFromAccountId().equals(accountId))).mapToDouble(Transaction::getAmount).sum();
		
		noOfTransactions = filteredList.size();
		TransactionInfo transactionInfo = new TransactionInfo(relativeBalance, noOfTransactions);
		return transactionInfo;
	}
	
	
	
}
