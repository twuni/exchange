package org.twuni.money.exchange.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.authorize.sim.Fingerprint;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

public class AuthorizeDotNetPaymentClient extends PaymentClient {

	private final SecureRandom random = new SecureRandom();
	private final String loginId;
	private final String transactionKey;
	private final String transactionProcessorUrl;
	private final String transactionValidatorUrl;

	public AuthorizeDotNetPaymentClient( HttpClient client, String loginId, String transactionKey, String transactionProcessorUrl, String transactionValidatorUrl ) {
		super( client );
		this.loginId = loginId;
		this.transactionKey = transactionKey;
		this.transactionProcessorUrl = transactionProcessorUrl;
		this.transactionValidatorUrl = transactionValidatorUrl;
	}

	public void pay( String accountNumber, String expirationDate, float amount, String notes ) throws ClientProtocolException, IOException {

		// String transactionValidatorUrl = "https://money.twuni.org/exchange/claim";
		// String transactionProcessorUrl = "https://test.authorize.net/gateway/transact.dll";

		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put( "x_card_num", accountNumber );
		parameters.put( "x_exp_date", expirationDate );
		parameters.put( "x_amount", Float.toString( amount ) );
		parameters.put( "notes", notes );

		addGlobalParameters( parameters );
		addFingerprint( parameters, amount );

		post( transactionProcessorUrl, parameters );

	}

	private void post( String url, Map<String, String> parameters ) throws UnsupportedEncodingException, IOException, ClientProtocolException {
		HttpPost post = new HttpPost( url );
		post.setEntity( new UrlEncodedFormEntity( toNameValuePairs( parameters ) ) );
		client.execute( post );
	}

	private void addGlobalParameters( Map<String, String> parameters ) {
		parameters.put( "x_version", "3.1" );
		parameters.put( "x_method", "CC" );
		parameters.put( "x_type", "AUTH_CAPTURE" );
		parameters.put( "x_test_request", "FALSE" );
		parameters.put( "x_login", loginId );
		parameters.put( "x_relay_url", transactionValidatorUrl );
		parameters.put( "x_invoice_num", Long.toString( random.nextLong() ) );
	}

	private void addFingerprint( Map<String, String> parameters, float amount ) {

		Fingerprint fingerprint = Fingerprint.createFingerprint( loginId, transactionKey, random.nextLong(), Float.toString( amount ) );

		parameters.put( "x_fp_sequence", Long.toString( fingerprint.getSequence() ) );
		parameters.put( "x_fp_timestamp", Long.toString( fingerprint.getTimeStamp() ) );
		parameters.put( "x_fp_hash", fingerprint.getFingerprintHash() );

	}

	private List<NameValuePair> toNameValuePairs( Map<String, String> parameters ) {
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		for( String key : parameters.keySet() ) {
			pairs.add( new BasicNameValuePair( key, parameters.get( key ) ) );
		}
		return pairs;
	}

}
