package com.lawal.transit.core.singletons;

import com.lawal.transit.core.collections.Bag;
import com.lawal.transit.core.entities.GlobalConstant;
import com.lawal.transit.core.entities.Street;

import java.util.Iterator;
import java.util.function.Predicate;

public enum Streets {
    INSTANCE;
    public final Bag<Street> streets = new Bag<Street>();

    public Bag<Street> getStreets () {
        return streets;
    } // close getBag

    public Iterator<Street> iterator () {
        Predicate<Street> predicate = (street) -> street.getId() != GlobalConstant.END_BORDER_ID
                && street.getId() != GlobalConstant.START_BORDER_ID;
        return streets.search(predicate);
    } // close iterator
} // end class Streets
