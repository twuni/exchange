package org.twuni.money.exchange.web.model;

import org.twuni.money.exchange.web.command.BuyCommand;

public class BuyContext extends Context {

	private final BuyCommand command;
	private float amount;

	public BuyContext( BuyCommand command ) {
		this.command = command;
	}

	public BuyCommand getCommand() {
		return command;
	}

	public void setAmount( float amount ) {
		this.amount = amount;
	}

	public float getAmount() {
		return amount;
	}

}
