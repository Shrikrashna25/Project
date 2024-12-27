package com.testingshastra.exceptions;

public class InvalidBrowserNameException extends RuntimeException{

	String browserName;
	public InvalidBrowserNameException(String browserName) {
		this.browserName = browserName;
	}
	
	@Override
	public String getMessage() {
		return "Invalid browser name: "+browserName;
	}
}
