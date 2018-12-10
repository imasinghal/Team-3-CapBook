package com.cg.capbook.exceptions;

public class PostNotFoundException extends Exception {

	public PostNotFoundException() {
		super();
	}

	public PostNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PostNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PostNotFoundException(String message) {
		super(message);
	}

	public PostNotFoundException(Throwable cause) {
		super(cause);
	}

}
