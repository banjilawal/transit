package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.entities.Street;
import com.lawal.transit.middleware.interfaces.BagWrapper;

import java.util.Iterator;
import java.util.function.Predicate;

public enum Streets implements BagWrapper<Street> {
    INSTANCE;
    private final Bag<Street> bag = new Bag<Street>();
    private Predicate<Street> predicate = null;

    public int size () { return bag.size(); }

    public Bag<Street> getBag() {
        return bag;
    } // close getBag

    public boolean add (Street street) {
        return bag.add(street);
    }

    public boolean remove (Street street) {
        return bag.remove(street.getName());
    }

    public Iterator<Street> iterator () {
        return bag.iterator();
    }

    public String toString () {
        return "Street" + " " + bag.toString();
    }

    public String fullString () {
        return "Street" + " " + bag.fullString();
    }

} // end class Streets
