package com.transaction.dataManager;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.transaction.model.Transaction;

public class TransactionFileDataManagerTest {
	
	TransactionDataManager transactionDataManager;
	
	@Before
	public void setup() {
		transactionDataManager = new TransactionFileDataManagerImpl();
	}
	
	@Test
	public void testGetTransactions() {
		Map<String,Transaction> transactions = transactionDataManager.getTransactions();
		assertEquals(7, transactions.size());
	}

}
