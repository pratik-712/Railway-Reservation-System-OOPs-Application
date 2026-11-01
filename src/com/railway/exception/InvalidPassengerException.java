package com.railway.exception;

public class InvalidPassengerException extends BookingException {

    public InvalidPassengerException(String message) {
        super(message);
    }
}