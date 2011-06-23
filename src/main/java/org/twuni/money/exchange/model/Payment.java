package org.twuni.money.exchange.model;

import org.twuni.money.common.Token;

public class Payment {

	private String id;
	private float amount;
	private Token token;

	public String getId() {
		return id;
	}

	public void setId( String id ) {
		this.id = id;
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

}
