package org.twuni.money.exchange.anet.command;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.twuni.money.exchange.anet.client.AnetClient;

abstract class Command {

	private final AnetClient client;
	private final String url;

	protected Command( AnetClient client, String url ) {
		this.client = client;
		this.url = url;
	}

	protected void execute( List<NameValuePair> parameters ) throws UnsupportedEncodingException, ClientProtocolException, IOException {
		client.post( url, parameters );
	}

	protected void execute( List<NameValuePair> parameters, float amount ) throws UnsupportedEncodingException, ClientProtocolException, IOException {
		parameters.addAll( client.getFingerprint( amount ) );
		execute( parameters );
	}

}
