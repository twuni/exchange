package org.twuni.money.exchange.util;

import java.util.Arrays;
import java.util.List;

import org.twuni.money.exchange.exception.ValidationException;

public class StringArrayValidator implements Validator<String> {

	private final List<String> values;

	public StringArrayValidator( String [] values ) {
		this.values = Arrays.asList( values );
	}

	@Override
	public void validate( String value ) {
		if( !values.contains( value ) ) {
			throw new ValidationException();
		}
	}
	
}
