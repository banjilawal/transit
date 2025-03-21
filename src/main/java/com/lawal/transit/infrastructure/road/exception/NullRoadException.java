package com.lawal.transit.infrastructure.road.exception;

public class NullRoadException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Road cannot be null";
    public NullRoadException (String message) {
        super(message);
    }
}