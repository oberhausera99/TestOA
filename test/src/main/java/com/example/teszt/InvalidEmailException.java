package com.example.teszt;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class InvalidEmailException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidEmailException(String message) {
		super(message);
	}
	
	public InvalidEmailException(String message, Throwable throwable) {
		super(message, throwable);
	}
}