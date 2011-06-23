package org.twuni.money.exchange.client.anet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;

public class AnetPaymentClient {

	private final AnetClient client;
	private final String url;

	public AnetPaymentClient( AnetClient client, String url ) {
		this.client = client;
		this.url = url;
	}

	public void pay( String accountNumber, String expirationDate, float amount, String relayUrl, long invoiceNumber, String notes ) throws ClientProtocolException, IOException {

		List<NameValuePair> parameters = new ArrayList<NameValuePair>();

		parameters.addAll( Arrays.asList( new NameValuePair [] {
		    AnetParameter.ACCOUNT_NUMBER.toNameValuePair( accountNumber ),
		    AnetParameter.EXPIRATION_DATE.toNameValuePair( expirationDate ),
		    AnetParameter.AMOUNT.toNameValuePair( amount ),
		    AnetParameter.RELAY_URL.toNameValuePair( relayUrl ),
		    AnetParameter.INVOICE_NUMBER.toNameValuePair( invoiceNumber ),
		    AnetParameter.NOTES.toNameValuePair( notes )
		} ) );

		parameters.addAll( client.getFingerprint( amount ) );

		client.post( url, parameters );

	}

}
