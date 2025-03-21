package com.lawal.transit.infrastructure.curb.exception;

public class NullCurbException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public static final String MESSAGE = "Curb cannot be null";

    public NullCurbException (String message) {
        super(message);
    }
}