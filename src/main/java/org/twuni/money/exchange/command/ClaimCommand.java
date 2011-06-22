package org.twuni.money.exchange.command;

import org.twuni.money.exchange.model.Payment;

public class ClaimCommand {

	private Payment transaction;

	public void setTransaction( Payment transaction ) {
		this.transaction = transaction;
	}

	public Payment getPayment() {
		return transaction;
	}

}
