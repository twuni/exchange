package org.twuni.money.exchange.web.command;

public class ClaimCommand {

	private double amount;
	private String transactionId;
	private String signature;

	public ClaimCommand() {
	}

	public ClaimCommand( double amount, String transactionId, String signature ) {
		this.amount = amount;
		this.transactionId = transactionId;
		this.signature = signature;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount( double amount ) {
		this.amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId( String transactionId ) {
		this.transactionId = transactionId;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature( String signature ) {
		this.signature = signature;
	}

}
