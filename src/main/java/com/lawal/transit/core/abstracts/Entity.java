package com.lawal.transit.core.abstracts;

public abstract class Entity {
    public Entity () {
    }
    public String toString () {
        return this.getClass().getSimpleName();
    } // close toString

    public String generateErrorMessage (String method, String info, int line, String exceptionName) {
        return  getClass().getSimpleName() + "." + method + " " + line + " " + exceptionName + ": " + info;
    } // close generateErrorMessage
} // end class Entity
