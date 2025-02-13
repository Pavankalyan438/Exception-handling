package com.example.Exception_Training.exception;

public class NoSuchCricketerException extends RuntimeException {
	private String message;

	public NoSuchCricketerException() {
		// TODO Auto-generated constructor stub
	}

	public NoSuchCricketerException(String message) {
		super(message);
		this.message = message;
	}

}
