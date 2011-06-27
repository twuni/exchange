package org.twuni.money.exchange.exception;

public class ValidationException extends IllegalArgumentException {

	public ValidationException() {
	}
	
	public ValidationException( String message ) {
		super( message );
	}

	public ValidationException( Throwable throwable ) {
		super( throwable );
	}

}
