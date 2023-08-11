package com.neo.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalException {
	
	@ExceptionHandler(value = {InternalServerException.class})
	public ResponseEntity<ErrorResponse> internalServerException(InternalServerException exception) {
		String trace = InternalServerException.class.getName();
		LocalDateTime today = LocalDateTime.now();
		ErrorResponse message = new ErrorResponse( exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),today,trace);
		return new ResponseEntity<ErrorResponse>(message,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

