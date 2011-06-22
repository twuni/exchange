package org.twuni.money.exchange.client;

import org.apache.http.client.HttpClient;
import org.twuni.money.exchange.model.Payment;
import org.twuni.money.exchange.util.Validator;

public class PaymentClient implements Validator<Payment> {

	protected final HttpClient client;

	public PaymentClient( HttpClient client ) {
		this.client = client;
	}

	@Override
	public void validate( Payment transaction ) {
	}

	public void pay( String username, float amount ) {
	}

	public String getPaymentUrl( float amountDue ) {
		return "https://www.example.com";
	}

	public float getExchangeRate() {
		return 0.01f;
	}

}
