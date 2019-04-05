package com.spaghettiteam.hotelapi.exception;

public class UserAlreadyExistException extends RuntimeException{

    @Override
    public String getMessage() {
        return "User already existing!";
    }
}
