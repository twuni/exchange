package org.twuni.money.exchange.view.context;

import java.util.HashMap;
import java.util.Map;

public abstract class ViewContext {

	public static final String NAME = "context";

	private final Map<String, String> errors = new HashMap<String, String>();

	public Map<String, String> getErrors() {
		return errors;
	}

}
