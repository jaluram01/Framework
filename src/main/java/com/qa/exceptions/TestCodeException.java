package com.qa.exceptions;

/**
 * Exception to represent an error in the test code rather than the product.
 * 
 * @author Jalu Ram
 *
 */

public class TestCodeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TestCodeException(String message) {
		super(message);
	}

	public TestCodeException(String message, Throwable cause) {
		super(message, cause);
	}

	public TestCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TestCodeException(Throwable cause) {
		super(cause);
	}
}
