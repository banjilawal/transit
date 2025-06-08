package com.lawal.transitcraft.infrastructure.street.exception;

public class NullStreetException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Street is null";

    public NullStreetException (String message) {
        super(message);
    }
}