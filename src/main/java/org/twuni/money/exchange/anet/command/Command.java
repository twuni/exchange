package org.twuni.money.exchange.anet.command;

import java.io.IOException;
import java.util.List;

import org.apache.http.NameValuePair;
import org.twuni.money.exchange.anet.client.AnetClient;

abstract class Command {

	protected final AnetClient client;

	private final String url;

	protected Command( AnetClient client, String url ) {
		this.client = client;
		this.url = url;
	}

	protected String execute( List<NameValuePair> parameters ) throws IOException {
		return client.post( url, parameters );
	}

	protected String execute( List<NameValuePair> parameters, float amount ) throws IOException {
		parameters.addAll( client.getFingerprint( amount ) );
		return execute( parameters );
	}

}
