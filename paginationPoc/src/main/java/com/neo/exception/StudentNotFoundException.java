package com.neo.exception;

public class StudentNotFoundException extends Exception {
private String message;



public StudentNotFoundException(String message) {
	super();
	this.message = message;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

}
