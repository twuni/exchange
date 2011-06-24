package org.twuni.money.exchange.exception;

public class PaymentException extends RuntimeException {

	public PaymentException() {
	}

	public PaymentException( String message ) {
		super( message );
	}

	public PaymentException( Throwable throwable ) {
		super( throwable );
	}

}
