package com.lawal.transit.route.model.exception;

public class NullTransitStopException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "TransitStop cannot be null";

    public NullTransitStopException (String message) {
        super(message);
    }
}