package com.transaction.dataManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.transaction.model.Transaction;
import com.transaction.util.Util;

/**
 * This is the file implementation of TransactionDataManager wherein it fetches the transaction data
 * from an underlying TransactionRecords.csv (which is prepopulated).
 *  
 */
public class TransactionFileDataManagerImpl implements TransactionDataManager{
	
	static Logger logger = Logger.getLogger(TransactionFileDataManagerImpl.class.getName());
	
	private static Map<String,Map<String,Transaction>> transactionMap = new ConcurrentHashMap<String,Map<String, Transaction>>();

	/**
	 * This methods reads the underlying file and stores in a hashmap called transactionMap in jvm so that it doesn't have to parse the file everytime
	 * lookup for transactions are required. Ideally the jvm/local cache should store the data against the business date of application or should ideally have an expiry mechanism
	 * but given that is not in the scope of this assignment, hence we are storing the data against system date(without timestamp).
	 */
	public Map<String, Transaction> getTransactions() {
		String businessDate = getBusinessDate();
		
		// It checks if the data has already been loaded in local cache for a given date, then it simply returns else it populates this local cache
		
		if(!transactionMap.containsKey(businessDate)) {
			logger.info("transactionMap is empty , going to populate it");
			Map<String, Transaction> map = new HashMap<String, Transaction>();
			try (BufferedReader br = Files.newBufferedReader(Paths.get("src/main/resources/TransactionRecords.csv"))) {
				//skipping the header line
				br.readLine();
				
				while(br.ready()) {
					String line = br.readLine();
					String[] values = line.split(",");
					
					// Putting TransactionId(1st field in file) as key and entire record as value
					
					map.put(values[0], new Transaction(line));
				}
				transactionMap.put(businessDate, map);
		    }
			catch (IOException | ParseException e) {
				logger.log(Level.SEVERE, "An Error occured in fetching the transaction details from file, hence request could not be processed");
			}
						
		}
		return transactionMap.get(businessDate);
	}
	
	/**
	 * We are returning current date as business date for now, in actual application business date would be the actual date.
	 */
	private String getBusinessDate() {
		Date date = Calendar.getInstance().getTime(); 
		return Util.getDateStr(date);
	}
	


}
