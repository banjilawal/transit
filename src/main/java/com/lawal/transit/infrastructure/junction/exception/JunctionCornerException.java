package com.lawal.transit.infrastructure.junction.exception;

public class JunctionCornerException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "JunctionCorner cannot be null";

    public JunctionCornerException (String message) {
        super(message);
    }
}