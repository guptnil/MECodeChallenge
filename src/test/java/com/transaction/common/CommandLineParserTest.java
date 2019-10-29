package com.transaction.common;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommandLineParserTest {
	
	CommandLineParser commandLineParser;
	
	
	@Before
	public void setup() {
		commandLineParser = new CommandLineParser();
	}
	
	@Test
	public void testParse() {
		String[] args  = {"accountId: ACC334455", "from: 20/10/2018 12:00:00", "to: 20/10/2018 19:00:00"};
		UserInput userInput = commandLineParser.parse(args);
		assertEquals("Account id should be same","ACC334455", userInput.getAccountId());
		
	}
	
	
	@After
	public void tearDown() {
		commandLineParser = null;
	}

}
