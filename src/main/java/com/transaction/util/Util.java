package com.transaction.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class to perform date related operations
 *
 */
public class Util {
	
	/**
	 * @param dateStr
	 * @return Date
	 * @throws ParseException
	 */
	public static Date getDateTime(String dateStr) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date date = format.parse(dateStr);
		return date;
	}
	
	/**
	 * @param date
	 * @return String
	 */
	public static String getDateStr(Date date)  {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
        String strDate = dateFormat.format(date);
        return strDate;
	}
	
	/**
	 * @param date
	 * @param fromDate
	 * @param toDate
	 * @return boolean
	 */
	public static boolean isWithinRange(Date date, Date fromDate, Date toDate) {
		boolean withinRange = false;
		
		int fromDateDiff = date.compareTo(fromDate);
		int toDateDiff = date.compareTo(toDate);
		
		if(fromDateDiff >= 0 && toDateDiff <= 0) {
			withinRange = true;
		}
		
		return withinRange;
	}
	
	public static String addDollarSign(Double relativeBalance) {
		String balanceStr = String.valueOf(relativeBalance);
		if(balanceStr.contains("-"))
			balanceStr = balanceStr.substring(0,1) + "$" + balanceStr.substring(1,balanceStr.length());
		
		return balanceStr;
	}

}
