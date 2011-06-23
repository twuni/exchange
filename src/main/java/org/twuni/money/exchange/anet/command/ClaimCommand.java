package org.twuni.money.exchange.anet.command;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.twuni.money.exchange.anet.client.AnetClient;

/**
 * This command confirms a payment processed by Authorize.net.
 */
public class ClaimCommand extends Command {

	protected ClaimCommand( AnetClient client, String url ) {
		super( client, url );
	}

	public void execute(/* TODO: Add some parameters. */) throws UnsupportedEncodingException, ClientProtocolException, IOException {

		List<NameValuePair> parameters = new ArrayList<NameValuePair>();

		// TODO: Add some parameters.

		execute( parameters );

	}

}
