package com.lawal.transit.curb.model.exception;

public class CurbAvenueMismatchException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Mismatch between Leftward curb orientation and Avenue";
    public CurbAvenueMismatchException (String message) {
        super(message);
    }
}