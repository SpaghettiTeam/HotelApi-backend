package com.spaghettiteam.hotelapi.exception;

public class RoomAlreadyExistException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Room already existing!";
    }
}
