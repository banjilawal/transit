package com.lawal.transit.infrastructure.schedule.exception;

public class NullRouteException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Route cannot be null";

    public NullRouteException (String message) {
        super(message);
    }
}