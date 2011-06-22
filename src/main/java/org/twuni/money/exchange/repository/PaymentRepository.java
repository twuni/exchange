package org.twuni.money.exchange.repository;

import java.util.List;

import org.twuni.money.common.Repository;
import org.twuni.money.exchange.model.Payment;

@org.springframework.stereotype.Repository
public class PaymentRepository implements Repository<String, Payment> {

	@Override
	public void delete( Payment payment ) {
	}

	@Override
	public Payment findById( String id ) {
		return null;
	}

	@Override
	public List<Payment> list() {
		return null;
	}

	@Override
	public List<Payment> list( int limit ) {
		return null;
	}

	@Override
	public void save( Payment payment ) {
	}

}
