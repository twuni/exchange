package org.twuni.money.exchange.repository;

import org.twuni.money.common.Token;
import org.twuni.money.exchange.model.TokenEntity;

@org.springframework.stereotype.Repository
public class TokenRepository extends HibernateTokenRepository {

	@Override
	public void delete( Token token ) {
		super.delete( new TokenEntity( token ) );
	}

	@Override
	public void save( Token token ) {
		super.save( new TokenEntity( token ) );
	}

}
