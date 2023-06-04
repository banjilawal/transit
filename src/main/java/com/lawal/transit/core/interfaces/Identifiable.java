package com.lawal.transit.core.interfaces;

public interface Identifiable<T, String> {
    T getId ();
    String getName ();
    void setId (T t);
    void setName (String name);
} // end interface Identifiable
