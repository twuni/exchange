package org.twuni.money.exchange.anet.client;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 * An enumeration of all known relevant Authorize.net request parameters.
 */
public enum AnetParameter {

	VERSION( "x_version" ),
	METHOD( "x_method" ),
	TYPE( "x_type" ),
	TEST( "x_test_request" ),
	LOGIN( "x_login" ),
	FINGERPRINT_SEQUENCE( "x_fp_sequence" ),
	FINGERPRINT_TIMESTAMP( "x_fp_timestamp" ),
	FINGERPRINT_HASH( "x_fp_hash" ),
	ACCOUNT_NUMBER( "x_card_num" ),
	EXPIRATION_DATE( "x_exp_date" ),
	AMOUNT( "x_amount" ),
	RELAY_URL( "x_relay_url" ),
	INVOICE_NUMBER( "x_invoice_num" ),
	NOTES( "notes" );

	private final String key;

	private AnetParameter( String key ) {
		this.key = key;
	}

	public NameValuePair toNameValuePair( String value ) {
		return new BasicNameValuePair( key, value );
	}

	public NameValuePair toNameValuePair( double value ) {
		return toNameValuePair( Double.toString( value ) );
	}

	public NameValuePair toNameValuePair( long value ) {
		return toNameValuePair( Long.toString( value ) );
	}

	public NameValuePair toNameValuePair( boolean value ) {
		return toNameValuePair( Boolean.toString( value ).toUpperCase() );
	}

}
