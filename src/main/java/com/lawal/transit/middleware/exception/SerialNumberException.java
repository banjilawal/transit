package com.lawal.transit.middleware.exception;

public class SerialNumberException extends Exception {

    public static String PREFIX = "SerialNumberException";
    public SerialNumberException () {
        this(PREFIX);
    } // close default constructor
    public SerialNumberException (String errorMessage) {
        super(errorMessage);
    } // close constructor
} // end class BlockIntersectionException
