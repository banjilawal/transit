package com.lawal.transit.curb;

public class CurbOrientationException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "OldCurb orientation cannot be null or empty";
    public CurbOrientationException (String message) {
        super(message);
    }
}