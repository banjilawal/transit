package com.lawal.transit.infrastructure.bus.exception;

public class NullDepartureException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Departure cannot be null";

    public NullDepartureException (String message) {
        super(message);
    }
}