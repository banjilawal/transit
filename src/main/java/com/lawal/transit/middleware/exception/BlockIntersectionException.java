package com.lawal.transit.middleware.exception;

public class BlockIntersectionException extends Exception {

    public static String PREFIX = "BlockIntersectionException";
    public BlockIntersectionException () {
        this(PREFIX);
    } // close default constructor
    public BlockIntersectionException (String errorMessage) {
        super(errorMessage);
    } // close constructor
} // end class BlockIntersectionException
