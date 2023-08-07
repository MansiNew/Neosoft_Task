package com.neo.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
private String message;
private int statusCode;
private LocalDateTime timeStamp=LocalDateTime.now();
private String trace;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public int getStatusCode() {
	return statusCode;
}
public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}
public LocalDateTime getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(LocalDateTime timeStamp) {
	this.timeStamp = timeStamp;
}
public String getTrace() {
	return trace;
}
public void setTrace(String trace) {
	this.trace = trace;
}
public ErrorResponse(String message, int statusCode, LocalDateTime timeStamp, String trace) {
	super();
	this.message = message;
	this.statusCode = statusCode;
	this.timeStamp = timeStamp;
	this.trace = trace;
}




}
