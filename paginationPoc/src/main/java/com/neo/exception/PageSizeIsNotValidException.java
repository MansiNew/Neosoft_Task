package com.neo.exception;

public class PageSizeIsNotValidException extends Exception {
private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public PageSizeIsNotValidException(String message) {
	super();
	this.message = message;
}

}
