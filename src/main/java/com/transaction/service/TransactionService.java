package com.transaction.service;

import java.util.Date;

import com.transaction.model.TransactionInfo;

/**
 * This is the interface for business service which is responsible to apply any business logic.
 *
 */
public interface TransactionService {
	
	/**
	 * This method is responsible to derive the transaction info like relative balance, no. of transactions
	 * for a given acocuntId and timeframe while keeping in mind the business rules and constraints 
	 * 
	 * @param accountId This is the accountId for which the transaction detail has to be fetched
	 * @param fromDate This is the from time of timeframe within with transaction has to be present
	 * @param toDate  This is the to time of timeframe within with transaction has to be present
	 * @return TransactionInfo This object holds detail like relative balance and no. of transactions
	 */
	public TransactionInfo getTransactionInfo(String accountId,Date fromDate, Date toDate);

}
