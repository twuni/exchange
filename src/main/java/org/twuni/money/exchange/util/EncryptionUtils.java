package org.twuni.money.exchange.util;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtils {

	public static String getEncryptedHexString( String message, String secret, String algorithm ) throws NoSuchAlgorithmException, InvalidKeyException {
		SecretKey key = new SecretKeySpec( secret.getBytes(), algorithm );
		Mac mac = Mac.getInstance( algorithm );
		mac.init( key );
		return new BigInteger( mac.doFinal( message.toString().getBytes() ) ).toString( 16 );
	}

}
