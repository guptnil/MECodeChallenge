package com.transaction.dataManager;

import java.util.Map;

import com.transaction.model.Transaction;

/**
 * This is the interface for data manager layer which is responsible to retreive the transactions data from underlying data source.
 * It can have multiple implementations, currently having two implementations file and db wherein db is not yet supported as that could be an overkill
 * for this application, so currently only file implementation is implemented but in actual production applications , data is typically stored in database  
 *
 */
public interface TransactionDataManager {
	
	/**
	 * This method is responsible to return a map of transaction ids and transaction objects where Transaction object
	 * contains information like transaction id, amount etc
	 * @return  Map<String,Transaction>
	 */
	public Map<String,Transaction> getTransactions();

}
