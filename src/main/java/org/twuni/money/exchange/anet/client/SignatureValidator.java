package org.twuni.money.exchange.anet.client;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.twuni.money.exchange.exception.ValidationException;
import org.twuni.money.exchange.util.Validator;

public class SignatureValidator implements Validator<String> {

	private final String loginId;
	private final String secret;
	private final float amount;
	private final String transactionId;

	public SignatureValidator( String loginId, String secret, float amount, String transactionId ) {
		this.loginId = loginId;
		this.secret = secret;
		this.amount = amount;
		this.transactionId = transactionId;
	}

	@Override
	public void validate( final String signature ) {

		try {

			MessageDigest digest = MessageDigest.getInstance( "MD5" );

			digest.update( new StringBuilder().append( secret ).append( loginId ).append( transactionId ).append( amount ).toString().getBytes() );

			if( !String.format( "%32s", new BigInteger( 1, digest.digest() ).toString( 16 ).toUpperCase() ).replaceAll( " ", "0" ).equals( signature ) ) {
				throw new ValidationException();
			}

		} catch( NoSuchAlgorithmException exception ) {

			throw new ValidationException( exception );

		}

	}

}
