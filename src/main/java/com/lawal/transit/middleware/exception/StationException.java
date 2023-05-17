package com.lawal.transit.middleware.exception;

public class StationException extends Exception {
    public static String PREFIX = "StationException";
    public StationException () {
        this(PREFIX);
    }
    public StationException (String errorMessage) {
        super(errorMessage);
    } // close constructor
} // end exception StationException
