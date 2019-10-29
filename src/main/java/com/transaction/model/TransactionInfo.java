package com.transaction.model;

/**
 * This class holds the transaction information required for printing as output of the application
 *
 */
public class TransactionInfo {
	
	/**
	 * The relative account balance is the sum of funds that were transferred to / from an account in a given time frame, it does not account for funds that were in that account prior to the timeframe
	 */
	private Double relativeBalance;
	
	/**
	 * Number of payment transactions for given account that fall within timeframe and exclude the reversal transactions
	 */
	private Integer noOfTransactions;
	
	public TransactionInfo(Double relativeBalance, Integer noOfTransactions) {
		super();
		this.relativeBalance = relativeBalance;
		this.noOfTransactions = noOfTransactions;
	}

	public Double getRelativeBalance() {
		return relativeBalance;
	}

	public void setRelativeBalance(Double relativeBalance) {
		this.relativeBalance = relativeBalance;
	}

	public Integer getNoOfTransactions() {
		return noOfTransactions;
	}

	public void setNoOfTransactions(Integer noOfTransactions) {
		this.noOfTransactions = noOfTransactions;
	}

	

}
