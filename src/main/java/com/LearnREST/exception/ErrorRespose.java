package com.LearnREST.exception;

public class ErrorRespose {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorRespose(String message) {
		super();
		this.message = message;
	}
	
	
	
}
