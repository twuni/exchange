package org.twuni.money.exchange.repository;

import java.util.List;

import org.twuni.money.common.Repository;
import org.twuni.money.common.Token;

@org.springframework.stereotype.Repository
public class TokenRepository implements Repository<String, Token> {

	@Override
	public void delete( Token token ) {
	}

	@Override
	public Token findById( String id ) {
		return null;
	}

	@Override
	public List<Token> list() {
		return null;
	}

	@Override
	public List<Token> list( int limit ) {
		return null;
	}

	@Override
	public void save( Token token ) {
	}

}
