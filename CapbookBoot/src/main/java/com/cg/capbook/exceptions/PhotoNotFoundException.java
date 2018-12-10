package com.cg.capbook.exceptions;

public class PhotoNotFoundException extends Exception{

	public PhotoNotFoundException() {
		super();
	}

	public PhotoNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PhotoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PhotoNotFoundException(String message) {
		super(message);
	}

	public PhotoNotFoundException(Throwable cause) {
		super(cause);
	}

}
