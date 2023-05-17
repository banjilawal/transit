package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.interfaces.BagWrapper;

import java.util.Iterator;

public enum Avenues implements BagWrapper<Avenue> {
    INSTANCE;
    private final Bag<Avenue> bag = new Bag<Avenue>();

    public int size () { return bag.size(); }

    public Bag<Avenue> getBag() {
        return bag;
    }

    public boolean add (Avenue avenue) {
        return bag.add(avenue);
    }

    public boolean remove (Avenue avenue) {
        return bag.remove(avenue.getName());
    }

    public Iterator<Avenue> iterator () {
        return bag.iterator();
    }

    public String toString () {
        return "Avenue" + " " + bag.toString();
    }

    public String fullString () {
        return "Avenue" + " " + bag.fullString();
    }
} // end class Roads
