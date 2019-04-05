package com.spaghettiteam.hotelapi.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
    }

    public UserNotFoundException(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return "User not found!";
    }
}
