package org.twuni.money.exchange.anet.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.NameValuePair;
import org.twuni.money.exchange.anet.client.AnetClient;
import org.twuni.money.exchange.anet.client.AnetParameter;

/**
 * This command sends a payment to Authorize.net for processing.
 */
public class PayCommand extends Command {

	public PayCommand( AnetClient client, String url ) {
		super( client, url );
	}

	public String execute( String accountNumber, String expirationDate, double amount, String relayUrl, long invoiceNumber, String notes ) throws IOException {

		List<NameValuePair> parameters = new ArrayList<NameValuePair>();

		parameters.addAll( Arrays.asList( new NameValuePair [] {
		    AnetParameter.ACCOUNT_NUMBER.toNameValuePair( accountNumber ),
		    AnetParameter.EXPIRATION_DATE.toNameValuePair( expirationDate ),
		    AnetParameter.AMOUNT.toNameValuePair( amount ),
		    AnetParameter.RELAY_URL.toNameValuePair( relayUrl ),
		    AnetParameter.INVOICE_NUMBER.toNameValuePair( invoiceNumber ),
		    AnetParameter.NOTES.toNameValuePair( notes )
		} ) );

		return execute( parameters, amount );

	}

}
