package com.transaction.dataManager;

import com.transaction.service.TransactionService;
import com.transaction.service.TransactionServiceImpl;

/**
 * This class is responsible for instantiating the transactionService and dataManager objects.
 * In actual production applications, better alternative to use could be spring IOC but using that framework
 * could be an overkill here, hence we are implementing this way.
 * We have implemented Singleton design pattern here.
 *
 */
public class TransactionInstanceFactory {
	
	private static TransactionDataManager transactionDataManager;
	
	private static TransactionService transactionService;
	
	public static TransactionDataManager getTransactionDataManager() {
		if(transactionDataManager == null) {
			transactionDataManager = new TransactionFileDataManagerImpl();
		}
		return transactionDataManager;
	}
	
	public static TransactionService getTransactionService() {
		if(transactionService == null) {
			transactionService = new TransactionServiceImpl();
		}
		return transactionService;
	}

}
