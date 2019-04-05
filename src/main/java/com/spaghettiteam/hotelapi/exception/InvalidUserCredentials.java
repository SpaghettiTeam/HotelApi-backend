package com.spaghettiteam.hotelapi.exception;

public class InvalidUserCredentials extends RuntimeException {

    @Override
    public String getMessage() {
        return "Invalid username or password!";
    }
}
