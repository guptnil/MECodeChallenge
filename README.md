# MECodeChallenge

Project Description : This is a console based application.The objective of this application is to print the relative account
balance for a given account in a given timeframe provided a pre initialised input file containing transactions records.
The relative account balance is the sum of funds that were transferred to / from an account in a given time frame, 
it does not account for funds that were in that account prior to the timeframe.

Installation/Execution Steps : As below

$ git clone https://github.com/guptnil/MECodeChallenge 
$ cd MECodeChallenge 
$ mvn -X clean install exec:java -Dexec.mainClass="com.transaction.common.TransactionMainRunner"

It would prompt to enter the 'accountId', 'from' and 'to' on command prompt. On entering the required fields, it will print the relative account 
balance and number of transactions.

Design Strategy: As below

TransactionMainRunner is the main entry point for this application having the main method.
It calls CommandLineParser (a helper class) to parse the command line arguments.
Then TransactionMainRunner calls the TransactionService class (Business service) to calculate the relative account balance and no. of transactions.
TransactionService calls the TransactionDataManager to fetch transaction details from underlying datasource (file).
TransactionDataManager parses the prepouulated file (TransactionRecords.csv) and returns the transaction data.

Technology : Have used Java 8 version for implementation, have not used Spring,Hibernate, in memory db etc for the sake of simplicity and 
not to overkill.

Build Tool : Have used maven having pom.xml.

Testing : Have used Junit frameowrk to write unit test cases for all the classes .They are running successfully.

