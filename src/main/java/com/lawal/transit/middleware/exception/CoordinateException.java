package com.lawal.transit.middleware.exception;

public class CoordinateException extends Exception {
    public static String PREFIX = "CoordinateException";
    public CoordinateException () {
        this(PREFIX);
    } // close default constructor

    public CoordinateException (String errorMessage) {
        super(errorMessage);
    }
} // end class CoordinateException
