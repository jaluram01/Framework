package com.qa.environment;

/**
 * Project Environment related information
 * @author jalu.ram
 *
 */
public enum Environment {
	PROD("https://jqueryui.com/");
	
	private String url;
	
	private Environment (String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
