package org.twuni.money.exchange.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.twuni.money.common.SimpleToken;
import org.twuni.money.common.Token;

@Entity( name = "token" )
public class TokenEntity extends SimpleToken {

	public TokenEntity() {
	}

	public TokenEntity( Token token ) {
		super( token );
	}

	@Id
	@Override
	public String getId() {
		return super.getId();
	}

	@Override
	public String getSecret() {
		return super.getSecret();
	}

	@Override
	public int getValue() {
		return super.getValue();
	}

	@Override
	public String getTreasury() {
		return super.getTreasury();
	}

}
