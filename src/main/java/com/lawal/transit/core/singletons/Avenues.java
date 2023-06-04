package com.lawal.transit.core.singletons;

import com.lawal.transit.core.collections.Bag;
import com.lawal.transit.core.entities.Avenue;
import com.lawal.transit.core.entities.GlobalConstant;

import java.util.Iterator;
import java.util.function.Predicate;

public enum Avenues {
    INSTANCE;
    public final Bag<Avenue> avenues = new Bag<Avenue>();

    public Bag<Avenue> getAvenues () {
        return avenues;
    }

    public Iterator<Avenue> iterator () {
        Predicate<Avenue> predicate = (avenue) -> avenue.getId() != GlobalConstant.END_BORDER_ID && avenue.getId() != GlobalConstant.START_BORDER_ID;
        return avenues.search(predicate);
    }
} // end class Avenues
