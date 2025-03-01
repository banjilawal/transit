package com.lawal.transit.junction.model.exception;

public class NullJunctionException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Junction cannot be null";
    public NullJunctionException (String message) {
        super(message);
    }
}