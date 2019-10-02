package com.spaghettiteam.hotelapi.exception;

public class InvalidUserCredentials extends RuntimeException {

    @Override
    public String getMessage() {
	    String a = "aa";
        return "Invalid username or password!";
    }
}
