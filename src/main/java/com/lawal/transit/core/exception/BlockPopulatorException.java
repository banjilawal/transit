package com.lawal.transit.core.exception;

public class BlockPopulatorException extends Exception {

    public static String PREFIX = "BlockPopulatorException";
    public BlockPopulatorException () {
        this(PREFIX);
    } // close default constructor
    public BlockPopulatorException (String errorMessage) {
        super(errorMessage);
    } // close constructor
} // end class BlockPopulatorException
