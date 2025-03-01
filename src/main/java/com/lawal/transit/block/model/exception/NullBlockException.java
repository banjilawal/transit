package com.lawal.transit.block.model.exception;

public class NullBlockException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Block cannot be null";
    public NullBlockException (String message) {
        super(message);
    }
}