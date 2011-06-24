package org.twuni.money.exchange.web.model;

import org.twuni.money.exchange.model.Payment;
import org.twuni.money.exchange.web.command.ClaimCommand;

public class ClaimContext extends Context {

	private final ClaimCommand command;
	private Payment payment;

	public ClaimContext( ClaimCommand command ) {
		this.command = command;
	}

	public ClaimCommand getCommand() {
		return command;
	}

	public void setPayment( Payment payment ) {
		this.payment = payment;
	}

	public Payment getPayment() {
		return payment;
	}

}
