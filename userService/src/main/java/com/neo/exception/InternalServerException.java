package com.neo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InternalServerException extends Exception {
private String message;

}
