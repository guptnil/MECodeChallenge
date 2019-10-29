package com.transaction.common;

import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;

import com.transaction.util.Util;

/**
 * This class is responsible for parsing the inputs supplied by user to get the account id, from and to.
 * 
 */
public class CommandLineParser {
	
	static Logger logger = Logger.getLogger(CommandLineParser.class.getName());
	
	/**
	 * This method checks and parses the command line arguments and prompts the user if command line arguments are not entered in expected format
	 * 
	 */
	public UserInput parse(String[] args){
		UserInput userInput = null;
		try {
			Scanner in = null;
			if(args==null || !(args.length > 0)) {
				in = new Scanner(System.in);  
				System.out.print("Please enter accountId , from and to");
				args = new String[3];
				args[0] = in.nextLine();
				args[1] = in.nextLine();
				args[2] = in.nextLine();
	            
	        }
			String accountId = args[0].split(": ")[1]; 
            String from = args[1].split(": ")[1];
            String to = args[2].split(": ")[1];
            Date fromDate= Util.getDateTime(from);
			Date toDate= Util.getDateTime(to);
            userInput = new UserInput(accountId, fromDate, toDate);
            logger.info("User entered accountId = "+ accountId + " and " +from + " = "+ from + " and to = " +to);
		 } catch (Exception e) {
			String helpMessage = getHelpMessage();
			logger.info(helpMessage);
			System.exit(0);
		 }
		return userInput;
	 }
	
	
	/**
	 * This method builds the message to help user with the expected input format
	 */
	private String getHelpMessage() {
		StringBuffer sb = new StringBuffer("Please enter accountId , from and to in below format");
		sb.append(System.lineSeparator());
		sb.append("accountId: <accountId>");
		sb.append(System.lineSeparator());
		sb.append("from: <dd/mm/yyyy hh:mm:ss>");
		sb.append(System.lineSeparator());
		sb.append("to: <dd/mm/yyyy hh:mm:ss>");
		return sb.toString();
	}
	
	
}

/**
 * This class holds the inputs entered by user on command line
 *
 */
class UserInput {
	
	private String accountId;
	
	private Date from;
	
	private Date to;
	
	public UserInput(String accountId, Date fromDate, Date toDate) {
		super();
		this.accountId = accountId;
		this.from = fromDate;
		this.to = toDate;
	}

	public String getAccountId() {
		return accountId;
	}

	public Date getFrom() {
		return from;
	}

	public Date getTo() {
		return to;
	}
	
}
