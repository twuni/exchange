package org.twuni.money.exchange.view.context.paypal;

import org.twuni.money.common.Token;
import org.twuni.money.exchange.command.paypal.ClaimCommand;
import org.twuni.money.exchange.view.context.ViewContext;

public class ClaimContext extends ViewContext {

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
