package com.lawal.transitcraft.infrastructure.block.exception;

public class NullBlockListException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "A null BlockList cannot be passed be passed to a method";

    public NullBlockListException (String message) {
        super(message);
    }
}