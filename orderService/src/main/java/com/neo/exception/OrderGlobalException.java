package com.neo.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderGlobalException {
	
	
	
	
	@ExceptionHandler(value = {OrderAlreadyExistException.class})
	public ResponseEntity<ErrorResponse> orderAlreadyExistException(OrderAlreadyExistException exception) {
		String trace = OrderAlreadyExistException.class.getName();
		LocalDateTime today = LocalDateTime.now();
		ErrorResponse message = new ErrorResponse( exception.getMessage(), HttpStatus.BAD_REQUEST.value(),today,trace);
		return new ResponseEntity<ErrorResponse>(message,HttpStatus.BAD_REQUEST);
	}
}

