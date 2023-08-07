package com.neo.exception;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class StudentAlraedyExistException extends RuntimeException {
private String message;



public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public StudentAlraedyExistException(String message) {
	super();
	this.message = message;
}

}
