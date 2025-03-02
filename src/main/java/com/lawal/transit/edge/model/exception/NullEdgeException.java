package com.lawal.transit.edge.model.exception;

public class NullEdgeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Edge cannot be null";

    public NullEdgeException (String message) {
        super(message);
    }
}