package org.twuni.money.exchange.model;

import org.twuni.money.common.Token;

public class Payment {

	private String transactionId;
	private double amount;
	private Token token;

	public Payment() {
	}

	public Payment( double amount, String transactionId, Token token ) {
		this.amount = amount;
		this.transactionId = transactionId;
		this.token = token;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId( String id ) {
		this.transactionId = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount( double amount ) {
		this.amount = amount;
	}

	public void setToken( Token token ) {
		this.token = token;
	}

	public Token getToken() {
		return token;
	}

}
