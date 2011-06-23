package org.twuni.money.exchange.client;

import org.twuni.money.exchange.model.Payment;
import org.twuni.money.exchange.util.Validator;

public interface PaymentClient extends Validator<Payment> {

	public void pay( String username, float amount );

	public String getPaymentUrl( float amountDue );

	public float getExchangeRate();

}
