package org.twuni.money.exchange.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.twuni.money.common.Repository;
import org.twuni.money.common.Token;
import org.twuni.money.exchange.model.TokenEntity;

@Transactional
public class HibernateTokenRepository implements Repository<String, Token> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void delete( Token token ) {
		sessionFactory.getCurrentSession().delete( token );
	}

	@Override
	public Token findById( String id ) {
		return (Token) sessionFactory.getCurrentSession().load( TokenEntity.class, id );
	}

	@Override
	public List<Token> list() {
		return list( Integer.MAX_VALUE );
	}

	@SuppressWarnings( "unchecked" )
	@Override
	public List<Token> list( int limit ) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria( TokenEntity.class );

		criteria.addOrder( Order.asc( "value" ) );
		criteria.setMaxResults( limit );

		return (List<Token>) criteria.list();

	}

	@Override
	public void save( Token token ) {
		sessionFactory.getCurrentSession().saveOrUpdate( token );
	}

}
