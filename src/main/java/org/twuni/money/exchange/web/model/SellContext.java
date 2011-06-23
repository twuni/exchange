package org.twuni.money.exchange.web.model;

import org.twuni.money.common.Token;
import org.twuni.money.exchange.web.command.SellCommand;

public class SellContext extends Context {

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
