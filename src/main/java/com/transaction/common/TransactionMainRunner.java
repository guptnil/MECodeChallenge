package com.transaction.common;

import java.util.Date;
import java.util.logging.Logger;

import com.transaction.dataManager.TransactionInstanceFactory;
import com.transaction.model.TransactionInfo;
import com.transaction.service.TransactionService;
import com.transaction.util.Util;

/**
 * This class acts as the main entry point to run the application
 *
 */
public class TransactionMainRunner {
	
	static Logger logger = Logger.getLogger(TransactionMainRunner.class.getName());
	
	TransactionService transactionService;
	
	CommandLineParser parser ;
	
	public TransactionMainRunner() {
		transactionService = TransactionInstanceFactory.getTransactionService();
		parser = new CommandLineParser();
	}

	public static void main(String[] args) {
		TransactionMainRunner runner = new TransactionMainRunner();
		TransactionInfo transactionInfo = runner.run(args);
		runner.printTransactionInfo(transactionInfo);
	}
	
	/**
	 * This method calls the command line parser to get the user inputs and then calls the business service to get the transaction info
	 */
	public TransactionInfo run(String[] args) {
		UserInput userInput = parser.parse(args);
		String accountId = userInput.getAccountId();
		Date fromDate = userInput.getFrom();
		Date toDate = userInput.getTo();
		
		TransactionInfo transactionInfo = transactionService.getTransactionInfo(accountId, fromDate, toDate);
		return transactionInfo;
	}
	
	/**
	 * This method prints the transaction info details
	 */
	private void printTransactionInfo(TransactionInfo transactionInfo) {
		String relativeBalance = Util.addDollarSign(transactionInfo.getRelativeBalance());
		System.out.println("Relative balance for the period is: " + relativeBalance);
		System.out.println("Number of transactions included is: " + transactionInfo.getNoOfTransactions());
	}

}
