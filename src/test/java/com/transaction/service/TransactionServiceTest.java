package com.transaction.service;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.transaction.model.TransactionInfo;

public class TransactionServiceTest {
	
	TransactionService transactionService ;
	
	@Before
	public void setup() {
		transactionService = new TransactionServiceImpl();
	}
	
	@Test
	public void testGetTransactionInfo() {
		String accountId =  "ACC334455";
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 9, 20, 00, 00, 00);
		Date fromDate = calendar.getTime();
		
		calendar.set(2018, 9, 20, 19, 00, 00);
		Date toDate = calendar.getTime();
		TransactionInfo transactionInfo = transactionService.getTransactionInfo(accountId, fromDate, toDate);
		
		assertEquals("Relative balance should be same",new Double(-15.5),transactionInfo.getRelativeBalance());
		assertEquals("Number of Transactions should be same",new Integer(3),transactionInfo.getNoOfTransactions());
	}


}
