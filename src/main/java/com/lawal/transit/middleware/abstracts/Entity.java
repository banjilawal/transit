package com.lawal.transit.middleware.abstracts;

import com.lawal.transit.middleware.exception.IdentifiableEntityException;

public abstract class Entity {
    public Entity () {
    }
    public String toString () {
        return this.getClass().getSimpleName();
    } // close toString

    public String generateErrorMessage (String method, String info, int line, String exceptionName) {
        String string = getClass().getSimpleName()
                + "." + method + " " + line + " " + exceptionName + ": " + info;
        return string;
    } // close generateErrorMessage
} // end class Entity
