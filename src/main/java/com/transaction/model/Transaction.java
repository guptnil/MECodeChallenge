package com.transaction.model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.StringTokenizer;

import com.transaction.util.Util;

/**
 * This is domain object for transaction details
 *
 */
public class Transaction implements Serializable{
	

	private static final long serialVersionUID = -7327212172736388800L;
	
	/**
	 * Id of Transaction
	 */
	private String transactionId;
	
	/**
	 * The id of the account to transfer money from
	 */
	private String fromAccountId;
	
	/**
	 * The id of the account to transfer money to
	 */
	private String toAccountId;
	
	/**
	 * the date and time the transaction was created (in the format of “DD/MM/YYYY hh:mm:ss”)
	 */
	private Date createdAt;
	
	/**
	 * The amount that was transferred including dollars and cents
	 */
	private Double amount;
	
	/**
	 * he type of the transaction which could be either PAYMENT or REVERSAL
	 */
	private String transactionType;
	
	/**
	 * In case of a REVERSAL transaction, this will contain the id of the transaction it is reversing. In case of a PAYMENT transaction this field would be empty
	 */
	private String relatedTransaction;

	public Transaction() {
		super();
	}

	public Transaction(String transactionId, String fromAccountId, String toAccountId, Date createdAt,
			Double amount, String transactionType, String relatedTransaction) {
		super();
		this.transactionId = transactionId;
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.createdAt = createdAt;
		this.amount = amount;
		this.transactionType = transactionType;
		this.relatedTransaction = relatedTransaction;
	}
	
	public Transaction(String line) throws ParseException  {
		StringTokenizer stk = new StringTokenizer(line, ",", false);
		this.transactionId = stk.nextToken();
		this.fromAccountId = stk.nextToken();
		this.toAccountId = stk.nextToken();
		this.createdAt = Util.getDateTime(stk.nextToken());
		this.amount = Double.valueOf(stk.nextToken());
		this.transactionType = stk.nextToken();
		if(stk.hasMoreTokens())
			this.relatedTransaction = stk.nextToken();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public String getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}

	public Date getcreatedAt() {
		return createdAt;
	}

	public void setcreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getRelatedTransaction() {
		return relatedTransaction;
	}

	public void setRelatedTransaction(String relatedTransaction) {
		this.relatedTransaction = relatedTransaction;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		return true;
	}

	
	

}
