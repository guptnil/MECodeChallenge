package com.transaction.dataManager;

import java.util.Map;

import com.transaction.model.Transaction;

/**
 * DBImpl is currently not supported but this is kept here as a placeholder just to demonstrate
 * that it can be implemented/enhanced in future
 *
 */
public class TransactionDBDataManagerImpl implements TransactionDataManager{

	@Override
	public Map<String, Transaction> getTransactions() {
		throw new UnsupportedOperationException();
	}

}
