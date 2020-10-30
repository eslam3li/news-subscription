package com.news.subscription.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class TaskRestGlobalExceptionHandler {
	
	//@ExceptionHandler
	public ResponseEntity<TaskErrorResponse> handleException(TaskNotFoundException taskNotFoundException) {

		TaskErrorResponse errorResponse = new TaskErrorResponse();

		errorResponse.setMessage(taskNotFoundException.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<TaskErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

	//@ExceptionHandler
	public ResponseEntity<TaskErrorResponse> handleException(Exception exc) {

		TaskErrorResponse error = new TaskErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
