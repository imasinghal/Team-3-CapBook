package com.cg.capbook.exceptions;

public class CapBookServicesDownException extends Exception {

	public CapBookServicesDownException() {
		super();
	}

	public CapBookServicesDownException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CapBookServicesDownException(String message, Throwable cause) {
		super(message, cause);
	}

	public CapBookServicesDownException(String message) {
		super(message);
	}

	public CapBookServicesDownException(Throwable cause) {
		super(cause);
	}

}
