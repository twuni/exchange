package org.twuni.money.exchange.client.anet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;

public class AnetClaimClient {

	private final AnetClient client;
	private final String url;

	public AnetClaimClient( AnetClient client, String url ) {
		this.client = client;
		this.url = url;
	}

	public void claim(/* TODO: Add some parameters. */) throws UnsupportedEncodingException, ClientProtocolException, IOException {

		List<NameValuePair> parameters = new ArrayList<NameValuePair>();

		// TODO: Add some parameters.

		client.post( url, parameters );

	}

}
