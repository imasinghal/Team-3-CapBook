package com.cg.capbook.exceptions;

public class ProfileNotFoundException extends Exception{

	public ProfileNotFoundException() {
		super();
	}

	public ProfileNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProfileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProfileNotFoundException(String message) {
		super(message);
	}

	public ProfileNotFoundException(Throwable cause) {
		super(cause);
	}

}
