package org.twuni.money.exchange.view.context.paypal;

import org.twuni.money.exchange.command.paypal.BuyCommand;
import org.twuni.money.exchange.view.context.ViewContext;

public class BuyContext extends ViewContext {

	private final BuyCommand command;

	public BuyContext( BuyCommand command ) {
		this.command = command;
	}

	public BuyCommand getCommand() {
		return command;
	}

}
