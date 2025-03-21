package com.lawal.transit.common.exception;

public class NullDirectionException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Name cannot be null";

    public NullDirectionException (String message) {
        super(message);
    }
}