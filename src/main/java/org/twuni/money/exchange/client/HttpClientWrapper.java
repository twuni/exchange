package org.twuni.money.exchange.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;

public class HttpClientWrapper {

	private final HttpClient client;

	public HttpClientWrapper( HttpClient client ) {
		this.client = client;
	}

	public String post( String url, List<NameValuePair> parameters ) throws UnsupportedEncodingException, IOException, ClientProtocolException {
		HttpPost post = new HttpPost( url );
		post.setEntity( new UrlEncodedFormEntity( parameters ) );
		return client.execute( post, new BasicResponseHandler() );
	}

}
