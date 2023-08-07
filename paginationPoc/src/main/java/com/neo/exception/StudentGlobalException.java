package com.neo.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentGlobalException {
	
	@ExceptionHandler(value = {StudentAlraedyExistException.class})
	public ResponseEntity<ErrorResponse> studentAlreadyExistException(StudentAlraedyExistException exception) {
		String trace = StudentAlraedyExistException.class.getName();
		LocalDateTime today = LocalDateTime.now();
		ErrorResponse message = new ErrorResponse( exception.getMessage(), HttpStatus.BAD_REQUEST.value(),today,trace);
		return new ResponseEntity<ErrorResponse>(message,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = {StudentNotFoundException.class})
	public ResponseEntity<ErrorResponse> studentNotFoundExistException(StudentNotFoundException exception) {
		// String trace = StudentNotFoundException.class.getName();
		 StringWriter stringWriter = new StringWriter();
		    PrintWriter printWriter = new PrintWriter(stringWriter);
		    exception.printStackTrace(printWriter);
		    String trace = stringWriter.toString();
		
		
		LocalDateTime today = LocalDateTime.now();
		ErrorResponse message = new ErrorResponse( exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),today,trace);
		return new ResponseEntity<ErrorResponse>(message,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {PageSizeIsNotValidException.class})
	public ResponseEntity<ErrorResponse> pageSizeNotValidException(PageSizeIsNotValidException exception) {
		String trace = PageSizeIsNotValidException.class.getName();
		LocalDateTime today = LocalDateTime.now();
		ErrorResponse message = new ErrorResponse( exception.getMessage(), HttpStatus.BAD_REQUEST.value(),today,trace);
		return new ResponseEntity<ErrorResponse>(message,HttpStatus.BAD_REQUEST);
	}
}

