package com.lawal.transit.middleware.exception;

public class IdentifiableEntityException extends Exception {

    public static String PREFIX = "IdentifiableEntityException";
    public IdentifiableEntityException () {
        this(PREFIX);
    } // close default constructor
    public IdentifiableEntityException (String errorMessage) {
        super(errorMessage);
    } // close constructor
} // end exception IdentifiableEntityException
