package com.lawal.transit.infrastructure.house.exception;

public class NullHouseException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "House cannot be null";

    public NullHouseException (String message) {
        super(message);
    }
}