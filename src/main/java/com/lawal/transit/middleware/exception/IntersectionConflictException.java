package com.lawal.transit.middleware.exception;

public class IntersectionConflictException extends Exception {

    public static String PREFIX = "IntersectionConflictException";
    public IntersectionConflictException () {
        this(IntersectionConflictException.PREFIX);
    } // close default constructor
    public IntersectionConflictException (String errorMessage) {
        super(errorMessage);
    } // close constructor
} // end exception IntersectionConflictException
