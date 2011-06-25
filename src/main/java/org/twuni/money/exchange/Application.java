package org.twuni.money.exchange;

public class Application {

	private String baseUrl;

	public void setBaseUrl( String baseUrl ) {
		this.baseUrl = baseUrl;
	}

	public String getUrl( String uri ) {
		return baseUrl + uri;
	}

}
