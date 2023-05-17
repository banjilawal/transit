package com.lawal.transit.middleware.exception;

public class DirectionConflictException extends Exception {
    public static String PREFIX = "DirectionConflictException";
    public DirectionConflictException () {
        this(PREFIX);
    } // close default constructor

    public DirectionConflictException (String errorMessage) {
        super(errorMessage);
    }
} // end exception DirectionConflictException
