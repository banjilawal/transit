package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.interfaces.BagWrapper;

import java.util.Iterator;

public enum Avenues {
    INSTANCE;
    public final Bag<Avenue> bag = new Bag<Avenue>();

    public Bag<Avenue> getBag() {
        return bag;
    }
} // end class Avenues
