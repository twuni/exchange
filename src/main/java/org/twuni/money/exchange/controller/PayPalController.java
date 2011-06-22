package org.twuni.money.exchange.controller;

import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.twuni.money.common.SimpleToken;
import org.twuni.money.common.Token;
import org.twuni.money.common.Treasury;
import org.twuni.money.common.TreasuryClient;
import org.twuni.money.exchange.command.paypal.BuyCommand;
import org.twuni.money.exchange.command.paypal.ClaimCommand;
import org.twuni.money.exchange.command.paypal.SellCommand;
import org.twuni.money.exchange.view.context.paypal.BuyContext;
import org.twuni.money.exchange.view.context.paypal.ClaimContext;
import org.twuni.money.exchange.view.context.paypal.SellContext;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

@Controller
public class PayPalController {

	private final Logger log = LoggerFactory.getLogger( getClass() );

	@RequestMapping( value = "/*", method = RequestMethod.GET )
	public String showForm() {
		log.debug( "showForm" );
		return "form";
	}

	@RequestMapping( value = "/to/paypal", method = RequestMethod.POST )
	public ModelAndView sellToken( @ModelAttribute SellCommand command ) {
		log.debug( String.format( "sellToken: username=[%s], token=[%s]", command.getUsername(), command.getToken() ) );

		SellContext context = new SellContext( command );

		try {

			Token token = new Gson().fromJson( command.getToken(), SimpleToken.class );

			if( !isTreasuryAccepted( token.getTreasury() ) ) {
				throw new IllegalArgumentException( "That token is not accepted by this exchange." );
			}

			Treasury treasury = new TreasuryClient( new DefaultHttpClient(), token.getTreasury() );
			int value = treasury.getValue( token );

			if( value > 0 ) {
				// TODO: Destroy the token.
				// TODO: Issue the PayPal payment.
				// TODO: If payment fails, return a new token worth the same value.
			} else {
				context.getErrors().put( "token", "The token has expired." );
			}
		} catch( IllegalArgumentException exception ) {
			context.getErrors().put( "token", exception.getMessage() );
		} catch( JsonParseException exception ) {
			context.getErrors().put( "token", "The token is not formatted correctly." );
		}

		return new ModelAndView( "paypal.sell", "context", context );

	}

	private boolean isTreasuryAccepted( String treasury ) {
		return "money.twuni.org".equals( treasury );
	}

	@RequestMapping( value = "/from/paypal", method = RequestMethod.POST )
	public ModelAndView buyToken( @ModelAttribute BuyCommand command ) {
		log.debug( String.format( "buyToken: amount=[%s]", Integer.toString( command.getAmount() ) ) );

		BuyContext context = new BuyContext( command );

		// TODO: Build the URL to redirect to PayPal Express Checkout for payment.

		return new ModelAndView( "paypal.buy", "context", context );

	}

	@RequestMapping( value = "/from/paypal/claim", method = RequestMethod.POST )
	public ModelAndView claimToken( @ModelAttribute ClaimCommand command ) {
		log.debug( "claimToken" );

		ClaimContext context = new ClaimContext( command );

		// TODO: Verify the transaction with PayPal.
		// TODO: Create a token with a value equal to the transaction amount.
		// TODO: Store the association between this token and the PayPal transaction.

		return new ModelAndView( "paypal.claim", "context", context );

	}

}
