package com.lawal.transit.address.model.exception;

public class NullAddressException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Address cannot be null";
    public NullAddressException (String message) {
        super(message);
    }
}