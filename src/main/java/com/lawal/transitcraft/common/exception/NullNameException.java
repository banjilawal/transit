package com.lawal.transitcraft.common.exception;

public class NullNameException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Name cannot be null";

    public NullNameException (String message) {
        super(message);
    }
}