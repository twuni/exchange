package org.twuni.money.exchange.view.context;

import org.twuni.money.exchange.command.BuyCommand;

public class BuyContext extends ViewContext {

	private final BuyCommand command;

	public BuyContext( BuyCommand command ) {
		this.command = command;
	}

	public BuyCommand getCommand() {
		return command;
	}

}
