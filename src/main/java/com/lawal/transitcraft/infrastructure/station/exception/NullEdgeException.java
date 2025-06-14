package com.lawal.transitcraft.infrastructure.station.exception;

public class NullEdgeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "StationEdge cannot be null";

    public NullEdgeException (String message) {
        super(message);
    }
}