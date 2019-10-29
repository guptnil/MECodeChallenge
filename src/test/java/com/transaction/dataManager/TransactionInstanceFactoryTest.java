package com.transaction.dataManager;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.transaction.service.TransactionService;

public class TransactionInstanceFactoryTest{
	
	@Test
	public void testServiceInstance() {
		TransactionService transactionService1 = TransactionInstanceFactory.getTransactionService();
		TransactionService transactionService2 = TransactionInstanceFactory.getTransactionService();
		assertSame(transactionService1, transactionService2);
	}
	
	@Test
	public void testDataManagerInstance() {
		TransactionDataManager transactionDataManager1 = TransactionInstanceFactory.getTransactionDataManager();
		TransactionDataManager transactionDataManage2 = TransactionInstanceFactory.getTransactionDataManager();
		assertSame(transactionDataManager1, transactionDataManage2);
	}

}
