package com.lawal.transit.core.abstracts;

public abstract class AnonymousEntity {
    public AnonymousEntity () {
    }

    public String toString () {
        return this.getClass().getSimpleName();
    }

    public String generateErrorMessage (String method, String info, int line, String exceptionName) {
        return  getClass().getSimpleName() + "." + method + " " + line + " " + exceptionName + ": " + info;
    }
} // end class AnonymousEntity
