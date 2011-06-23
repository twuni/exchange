package org.twuni.money.exchange.web.model;

import org.twuni.money.common.Token;
import org.twuni.money.exchange.web.command.ClaimCommand;

public class ClaimContext extends Context {

	private final ClaimCommand command;
	private Token token;

	public ClaimContext( ClaimCommand command ) {
		this.command = command;
	}

	public ClaimCommand getCommand() {
		return command;
	}

	public void setToken( Token token ) {
		this.token = token;
	}

	public Token getToken() {
		return token;
	}

}
