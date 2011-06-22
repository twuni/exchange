package org.twuni.money.exchange.client;

import org.apache.http.client.HttpClient;
import org.twuni.money.exchange.model.paypal.Transaction;

public class PayPalClient {

	private final HttpClient client;

	public PayPalClient( HttpClient client ) {
		this.client = client;
	}

	public void verify( Transaction transaction ) {
	}

}
