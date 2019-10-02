package com.spaghettiteam.hotelapi.exception;

public class RoomNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
	    String a = "aa";
        return "Room not found!";
    }
}
