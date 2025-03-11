package com.lawal.transit.house.model.exception;

public class NullAddressListException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "A null AddressList cannot be passed be passed to a method";
    public NullAddressListException (String message) {
        super(message);
    }
}