package com.lawal.transit.infrastructure.curb.exception;

public class CurbOrientationException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Curb orientation cannot be null or empty";

    public CurbOrientationException (String message) {
        super(message);
    }
}