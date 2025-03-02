package com.lawal.transit.street.model.exception;

public class NullStreetException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Street is null";

    public NullStreetException (String message) {
        super(message);
    }
}