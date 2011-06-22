package org.twuni.money.exchange.view.context.paypal;

import org.twuni.money.exchange.command.paypal.SellCommand;
import org.twuni.money.exchange.view.context.ViewContext;

public class SellContext extends ViewContext {

	private final SellCommand command;

	public SellContext( SellCommand command ) {
		this.command = command;
	}

	public SellCommand getCommand() {
		return command;
	}

}
