package com.cg.capbook.exceptions;

public class NotificationNotFoundException extends Exception{

	public NotificationNotFoundException() {
		super();
	}

	public NotificationNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NotificationNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotificationNotFoundException(String message) {
		super(message);
	}

	public NotificationNotFoundException(Throwable cause) {
		super(cause);
	}

}
