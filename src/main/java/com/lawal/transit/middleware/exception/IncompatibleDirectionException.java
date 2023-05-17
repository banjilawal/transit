package com.lawal.transit.middleware.exception;

public class IncompatibleDirectionException extends Exception {
    public static String PREFIX = " IncompatibleDirectionException";
    public IncompatibleDirectionException () {
        this(PREFIX);
    }

    public IncompatibleDirectionException (String errorMessage) {
        super(errorMessage);
    }
} // end exception IncompatibleDirectionException
