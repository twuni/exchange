package org.twuni.money.exchange.repository;

import java.util.HashMap;
import java.util.Map;

import org.twuni.money.common.Token;
import org.twuni.money.exchange.model.TokenEntity;

@org.springframework.stereotype.Repository
public class TokenRepository extends HibernateTokenRepository {

	private final Map<String, Token> tokens = new HashMap<String, Token>();

	@Override
	public void delete( Token token ) {
		super.delete( toEntity( token ) );
		tokens.put( token.getId(), null );
	}

	@Override
	public void save( Token token ) {
		super.save( toEntity( token ) );
	}

	private Token toEntity( Token token ) {
		if( !tokens.containsKey( token.getId() ) ) {
			tokens.put( token.getId(), new TokenEntity( token ) );
		}
		return tokens.get( token.getId() );
	}

}
