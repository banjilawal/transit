package com.lawal.transitcraft.infrastructure.junction.exception;

public class NullJunctionListException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "A null JunctionList cannot be passed be passed to a method";

    public NullJunctionListException (String message) {
        super(message);
    }
}