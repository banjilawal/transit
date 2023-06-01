package com.lawal.transit.middleware.interfaces;

import java.util.Iterator;

public interface BagWrapper<T> {
    int size();
    void add (T t);
    boolean remove (T t);
    Iterator<T> iterator ();
    String toString ();
//    String fullString ();
} // end interface BagWrapper
