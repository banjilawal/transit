package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.abstracts.StreetBuilding;
import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.interfaces.BagWrapper;

import java.util.Iterator;

public enum StreetBuildings implements BagWrapper<StreetBuilding> {
    INSTANCE;
    private final Bag<StreetBuilding> bag = new Bag<StreetBuilding>();

    public int size () { return bag.size(); }

    public Bag<StreetBuilding> getBag() {
        return bag;
    } // close getBag

    public boolean add (StreetBuilding streetBuilding) {
        return bag.add(streetBuilding);
    }

    public boolean remove (StreetBuilding streetBuilding) {
        return bag.remove(streetBuilding.getId());
    }

    public Iterator<StreetBuilding> iterator () {
        return bag.iterator();
    }

    public String toString () {
        return "StreetBuilding" + " " + bag.toString();
    }

    public String fullString () {
        return toString();
    }
} // end class StreetBuildings
