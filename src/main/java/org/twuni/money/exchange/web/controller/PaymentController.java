package org.twuni.money.exchange.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.twuni.money.common.Bank;
import org.twuni.money.common.Repository;
import org.twuni.money.common.SimpleToken;
import org.twuni.money.common.Token;
import org.twuni.money.common.Treasury;
import org.twuni.money.common.TreasuryClient;
import org.twuni.money.exchange.Application;
import org.twuni.money.exchange.client.PaymentClient;
import org.twuni.money.exchange.exception.PaymentException;
import org.twuni.money.exchange.model.Payment;
import org.twuni.money.exchange.util.Validator;
import org.twuni.money.exchange.web.command.BuyCommand;
import org.twuni.money.exchange.web.command.ClaimCommand;
import org.twuni.money.exchange.web.command.SellCommand;
import org.twuni.money.exchange.web.model.ClaimContext;
import org.twuni.money.exchange.web.model.Context;
import org.twuni.money.exchange.web.model.SellContext;

import com.google.gson.Gson;

@Controller
public class PaymentController {

	private final Logger log = LoggerFactory.getLogger( getClass() );

	@Autowired
	private Application application;

	@Autowired
	private HttpClient httpClient;

	@Autowired
	private PaymentClient paymentClient;

	@Autowired
	private Repository<String, Token> tokenRepository;

	@Autowired
	private Repository<String, Payment> paymentRepository;

	@Autowired
	private Validator<String> treasuryValidator;

	@RequestMapping( value = "/*", method = RequestMethod.GET )
	public String showForm() {
		return "form";
	}

	@RequestMapping( value = "/buy", method = RequestMethod.POST )
	public void buy( @ModelAttribute BuyCommand command, HttpServletResponse response ) throws IOException {
		float amountDue = fromTokenValue( command.getAmount() );
		response.sendRedirect( paymentClient.getPaymentUrl( amountDue ) );
	}

	@RequestMapping( value = "/claim", method = RequestMethod.POST )
	public ModelAndView claim( @ModelAttribute ClaimCommand command ) {

		Treasury treasury = new TreasuryClient( httpClient, application.getPreferredTreasury() );
		Bank bank = new Bank( tokenRepository, treasury );

		ClaimContext context = new ClaimContext( command );

		Payment payment = command.getPayment();

		paymentClient.validate( payment );

		float paymentAmount = payment.getAmount();
		int amount = toTokenValue( paymentAmount );
		payment.setToken( bank.withdraw( amount ) );

		paymentRepository.save( payment );

		return new ModelAndView( "claim", Context.NAME, context );

	}

	@RequestMapping( value = "/sell", method = RequestMethod.POST )
	public ModelAndView sell( @ModelAttribute SellCommand command ) {

		SellContext context = new SellContext( command );

		try {

			Token token = new Gson().fromJson( command.getToken(), SimpleToken.class );

			treasuryValidator.validate( token.getTreasury() );

			Treasury treasury = new TreasuryClient( httpClient, token.getTreasury() );
			float paymentAmount = fromTokenValue( treasury.getValue( token ) );

			if( paymentAmount <= 0 ) {
				throw new IllegalArgumentException( "The token has expired." );
			}

			Token [] result = treasury.split( token, 1 ).toArray( new Token [0] );

			try {
				paymentClient.pay( command.getUsername(), paymentAmount );
			} catch( PaymentException exception ) {
				context.setToken( treasury.merge( result[0], result[1] ) );
				throw exception;
			}

		} catch( Exception exception ) {
			context.getErrors().put( "token", exception.getMessage() );
		}

		return new ModelAndView( "sell", Context.NAME, context );

	}

	private float fromTokenValue( int tokenValue ) {
		return tokenValue * paymentClient.getExchangeRate();
	}

	private int toTokenValue( float paymentAmount ) {
		return Float.valueOf( paymentAmount / paymentClient.getExchangeRate() ).intValue();
	}

	public void setHttpClient( HttpClient httpClient ) {
		this.httpClient = httpClient;
	}

	public void setPaymentClient( PaymentClient paymentClient ) {
		this.paymentClient = paymentClient;
	}

	public void setTokenRepository( Repository<String, Token> tokenRepository ) {
		this.tokenRepository = tokenRepository;
	}

	public void setTransactionRepository( Repository<String, Payment> transactionRepository ) {
		this.paymentRepository = transactionRepository;
	}

	public void setTreasuryValidator( Validator<String> treasuryValidator ) {
		this.treasuryValidator = treasuryValidator;
	}

}
