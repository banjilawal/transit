package com.lawal.transit.house.model.exception;

public class NullAddressException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "House cannot be null";
    public NullAddressException (String message) {
        super(message);
    }
}