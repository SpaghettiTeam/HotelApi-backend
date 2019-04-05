package com.spaghettiteam.hotelapi.exception;

public class UserNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "User not found!";
    }
}
