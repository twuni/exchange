package org.twuni.money.exchange.web.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Context {

	public static final String NAME = "context";

	private final Map<String, String> errors = new HashMap<String, String>();

	public Map<String, String> getErrors() {
		return errors;
	}

}
