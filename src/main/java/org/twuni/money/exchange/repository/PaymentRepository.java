package org.twuni.money.exchange.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.twuni.money.common.Repository;
import org.twuni.money.exchange.model.Payment;

@org.springframework.stereotype.Repository
public class PaymentRepository implements Repository<String, Payment> {

	private final Logger log = LoggerFactory.getLogger( getClass() );

	@Override
	public void delete( Payment payment ) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Payment findById( String id ) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Payment> list() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Payment> list( int limit ) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void save( Payment payment ) {
		log.info( String.format( "Transaction [%s] produced token [%s] of value %s.", payment.getTransactionId(), payment.getToken().getId(), Integer.toString( payment.getToken().getValue() ) ) );
	}

}
