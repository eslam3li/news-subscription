package com.news.subscription.exception;

public class TaskNotFoundException extends RuntimeException {

	public TaskNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public TaskNotFoundException(String message) {
		super(message);

	}

	public TaskNotFoundException(Throwable cause) {
		super(cause);

	}

}
