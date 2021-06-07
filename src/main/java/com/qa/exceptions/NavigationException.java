/**
 * Copyright (c) Jalu Ram
 * Confidential
 * All Rights Reserved
 */

package com.qa.exceptions;

/**
 * Throw this exception when a GuiObject is unable to bind to DOM
 * 
 * @author Jalu Ram
 *
 */
public class NavigationException extends RuntimeException {
	private static final long serialVersionUID = -6338397732180408157L;

	public NavigationException(String message) {
		super(message);
	}

	public NavigationException(String message, Throwable cause) {
		super(message, cause);
	}

	public NavigationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NavigationException(Throwable cause) {
		super(cause);
	}
}
