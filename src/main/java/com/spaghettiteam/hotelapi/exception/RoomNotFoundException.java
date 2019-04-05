package com.spaghettiteam.hotelapi.exception;

public class RoomNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Room not found!";
    }
}
