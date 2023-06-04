package com.lawal.transit.core.exception;

public class IdentifiableEntityNameException extends Exception {

    public static String prefix = "IdentifiableEntityNameException";
    public IdentifiableEntityNameException () {
        this(prefix);
        //this ("IdentifiableEntityNameException");
    } // close default constructor
    public IdentifiableEntityNameException (String errorMessage) {
        super(errorMessage);
    } // close constructor
} // end class IdentifiableEntityNameException
