package com.spaghettiteam.hotelapi.exception;

public class ReservationNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Reservation not existing!";
    }
}
