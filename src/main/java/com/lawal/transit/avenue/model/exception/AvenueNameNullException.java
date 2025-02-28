package com.lawal.transit.avenue.model.exception;

public class AvenueNameNullException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Avenue Name is null";
    public AvenueNameNullException (String message) {
        super(message);
    }
}