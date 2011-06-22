package org.twuni.money.exchange.model;

import org.twuni.money.common.Token;

public class Payment {

	private String id;
	private float paymentAmount;
	private Token token;

	public String getId() {
		return id;
	}

	public void setId( String id ) {
		this.id = id;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount( float paymentAmount ) {
		this.paymentAmount = paymentAmount;
	}

	public void setToken( Token token ) {
		this.token = token;
	}

	public Token getToken() {
		return token;
	}

}
