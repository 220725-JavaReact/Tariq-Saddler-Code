package com.revature.pointsapp.exceptions;

public class InvalidPointException extends RuntimeException {
	public InvalidPointException(String message) {
		super(message);
	}
}