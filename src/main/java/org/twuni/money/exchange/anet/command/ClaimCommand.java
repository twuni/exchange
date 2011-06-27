package org.twuni.money.exchange.anet.command;

import org.twuni.money.exchange.anet.client.AnetClient;

public class ClaimCommand extends Command {

	public ClaimCommand( AnetClient client ) {
		super( client, "" );
	}

	public void execute( double amount, String transactionId, String signature ) {
		client.getSignatureValidator( amount, transactionId ).validate( signature );
	}

}
