package org.twuni.money.exchange.anet.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.twuni.money.exchange.client.HttpClientWrapper;
import org.twuni.money.exchange.util.EncryptionUtils;
import org.twuni.money.exchange.util.Validator;

/**
 * This convenient wrapper handles communications logic with Authorize.net that is common to all
 * requests and responses from this application.
 */
public class AnetClient {

	private static final float API_VERSION = 3.1f;
	private static final String TYPE = "AUTH_CAPTURE";
	private static final String METHOD = "CC";

	private final SecureRandom random = new SecureRandom();
	private final HttpClientWrapper http;
	private final String loginId;
	private final String transactionKey;
	private final String secret;
	private final boolean testMode;

	public AnetClient( HttpClient client, String loginId, String transactionKey, String secret, boolean testMode ) {
		this.http = new HttpClientWrapper( client );
		this.loginId = loginId;
		this.transactionKey = transactionKey;
		this.secret = secret;
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

		long sequence = random.nextInt( 10000 ) * 1000 + random.nextInt( 1000 );
		long timestamp = System.currentTimeMillis() / 1000;
		String signature = null;

		StringBuilder message = new StringBuilder();

		message.append( loginId ).append( "^" );
		message.append( sequence ).append( "^" );
		message.append( timestamp ).append( "^" );
		message.append( amount ).append( "^" );

		try {

			signature = EncryptionUtils.getEncryptedHexString( message.toString(), transactionKey, "HmacMD5" );

		} catch( Exception exception ) {
			throw new RuntimeException( exception );
		}

		return Arrays.asList( new NameValuePair [] {
		    AnetParameter.FINGERPRINT_SEQUENCE.toNameValuePair( sequence ),
		    AnetParameter.FINGERPRINT_TIMESTAMP.toNameValuePair( timestamp ),
		    AnetParameter.FINGERPRINT_HASH.toNameValuePair( signature )
		} );

	}

	public String post( String url, List<NameValuePair> parameters ) throws UnsupportedEncodingException, ClientProtocolException, IOException {
		parameters.addAll( getGlobalParameters() );
		return http.post( url, parameters );
	}

	public Validator<String> getSignatureValidator( float amount, String transactionId ) {
		return new SignatureValidator( loginId, secret, amount, transactionId );
	}

}
