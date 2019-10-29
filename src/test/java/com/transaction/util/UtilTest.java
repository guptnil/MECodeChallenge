package com.transaction.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class UtilTest {
	
	@Test
	public void testGetdate() throws ParseException {
		Date expected = new GregorianCalendar(2018, Calendar.OCTOBER, 20).getTime();
		String dateStr = "20/10/2018 00:00:00";
		Date actual = Util.getDateTime(dateStr);
		Integer diff = expected.compareTo(actual);
		assertEquals("Dates should be same",new Integer(0),diff);
		
	}
	
	@Test
	public void testWithinRange() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 9, 20, 00, 47, 00);
		Date date = calendar.getTime();
		
		calendar.set(2018, 9, 20, 00, 40, 00);
		Date fromDate = calendar.getTime();
		
		calendar.set(2018, 9, 20, 00, 50, 00);
		Date toDate = calendar.getTime();
		
		boolean withinRange = Util.isWithinRange(date, fromDate, toDate);
		assertTrue(withinRange);
	}

}
