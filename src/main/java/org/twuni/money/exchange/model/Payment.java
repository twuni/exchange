package org.twuni.money.exchange.model;

import org.twuni.money.common.Token;

public class Payment {

	private Integer id;
	private String transactionId;
	private float amount;
	private Token token;

	public Payment() {
	}

	public Payment( float amount, String transactionId, Token token ) {
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

	public float getAmount() {
		return amount;
	}

	public void setAmount( float amount ) {
		this.amount = amount;
	}

	public void setToken( Token token ) {
		this.token = token;
	}

	public Token getToken() {
		return token;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

}
