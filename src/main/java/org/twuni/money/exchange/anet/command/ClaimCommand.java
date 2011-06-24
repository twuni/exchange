package org.twuni.money.exchange.anet.command;

import java.io.IOException;

import org.twuni.money.exchange.anet.client.AnetClient;

/**
 * This command confirms a payment processed by Authorize.net.
 */
public class ClaimCommand extends Command {

	protected ClaimCommand( AnetClient client, String url ) {
		super( client, url );
	}

	public void execute( String amount, String transactionId, String signature ) throws IOException {
		client.getSignatureValidator( amount, transactionId ).validate( signature );
	}

}
