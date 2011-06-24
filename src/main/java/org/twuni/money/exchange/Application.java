package org.twuni.money.exchange;

public class Application {

	private String baseUrl;
	private String preferredTreasury;

	public void setPreferredTreasury( String preferredTreasury ) {
		this.preferredTreasury = preferredTreasury;
	}

	public String getPreferredTreasury() {
		return preferredTreasury;
	}

	public void setBaseUrl( String baseUrl ) {
		this.baseUrl = baseUrl;
	}

	public String getUrl( String uri ) {
		return baseUrl + uri;
	}

}
