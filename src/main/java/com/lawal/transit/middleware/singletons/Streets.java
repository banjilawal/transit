package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.entities.Street;

import java.util.Iterator;
import java.util.function.Predicate;

public enum Streets {
    INSTANCE;
    public final Bag<Street> bag = new Bag<Street>();

    public Bag<Street> getBag() {
        return bag;
    } // close getBag
} // end class Streets
