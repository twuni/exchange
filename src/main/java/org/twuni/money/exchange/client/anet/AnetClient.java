package org.twuni.money.exchange.client.anet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

import net.authorize.sim.Fingerprint;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.twuni.money.exchange.client.HttpClientWrapper;

public class AnetClient {

	private static final float API_VERSION = 3.1f;
	private static final String TYPE = "AUTH_CAPTURE";
	private static final String METHOD = "CC";

	private final SecureRandom random = new SecureRandom();
	private final HttpClientWrapper http;
	private final String loginId;
	private final String transactionKey;
	private final boolean testMode;

	public AnetClient( HttpClient http, String loginId, String transactionKey, boolean testMode ) {
		this.http = new HttpClientWrapper( http );
		this.loginId = loginId;
		this.transactionKey = transactionKey;
		this.testMode = testMode;
	}

	private List<NameValuePair> getGlobalParameters() {
		return Arrays.asList( new NameValuePair [] {
		    AnetParameter.VERSION.toNameValuePair( API_VERSION ),
		    AnetParameter.METHOD.toNameValuePair( METHOD ),
		    AnetParameter.TYPE.toNameValuePair( TYPE ),
		    AnetParameter.TEST.toNameValuePair( testMode ),
		    AnetParameter.LOGIN.toNameValuePair( loginId )
		} );
	}

	public List<NameValuePair> getFingerprint( float amount ) {

		Fingerprint fingerprint = Fingerprint.createFingerprint( loginId, transactionKey, random.nextLong(), Float.toString( amount ) );

		return Arrays.asList( new NameValuePair [] {
		    AnetParameter.FINGERPRINT_SEQUENCE.toNameValuePair( fingerprint.getSequence() ),
		    AnetParameter.FINGERPRINT_TIMESTAMP.toNameValuePair( fingerprint.getTimeStamp() ),
		    AnetParameter.FINGERPRINT_HASH.toNameValuePair( fingerprint.getFingerprintHash() )
		} );

	}

	public void post( String url, List<NameValuePair> parameters ) throws UnsupportedEncodingException, ClientProtocolException, IOException {
		parameters.addAll( getGlobalParameters() );
		http.post( url, parameters );
	}

}
