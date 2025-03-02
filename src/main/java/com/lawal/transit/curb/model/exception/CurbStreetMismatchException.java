package com.lawal.transit.curb.model.exception;

public class CurbStreetMismatchException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Mismatch between Leftward curb orientation and Street";
    public CurbStreetMismatchException (String message) {
        super(message);
    }
}