package com.lawal.transitcraft.infrastructure.bus.exception;

public class NullRouteException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "BusRoute cannot be null";

    public NullRouteException (String message) {
        super(message);
    }
}