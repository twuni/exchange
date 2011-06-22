package org.twuni.money.exchange.view.context;

import org.twuni.money.common.Token;
import org.twuni.money.exchange.command.SellCommand;

public class SellContext extends ViewContext {

	private final SellCommand command;
	private Token token;

	public SellContext( SellCommand command ) {
		this.command = command;
	}

	public SellCommand getCommand() {
		return command;
	}

	public void setToken( Token token ) {
		this.token = token;
	}

	public Token getToken() {
		return token;
	}

}
