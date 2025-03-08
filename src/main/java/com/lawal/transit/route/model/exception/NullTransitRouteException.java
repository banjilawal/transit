package com.lawal.transit.route.model.exception;

public class NullTransitRouteException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "TransitRoute cannot be null";

    public NullTransitRouteException (String message) {
        super(message);
    }
}