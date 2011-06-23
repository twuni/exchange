package org.twuni.money.exchange.web.model;

import org.twuni.money.exchange.web.command.BuyCommand;

public class BuyContext extends Context {

	private final BuyCommand command;

	public BuyContext( BuyCommand command ) {
		this.command = command;
	}

	public BuyCommand getCommand() {
		return command;
	}

}
