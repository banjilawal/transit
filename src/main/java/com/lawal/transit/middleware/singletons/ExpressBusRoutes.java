package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.entities.ExpressBusRoute;
import com.lawal.transit.middleware.entities.RegularBusRoute;
import com.lawal.transit.middleware.interfaces.BagWrapper;

import java.util.Iterator;

public enum ExpressBusRoutes implements BagWrapper<ExpressBusRoute> {
    INSTANCE;
    private final Bag<ExpressBusRoute> bag = new Bag<>();

    public int size () { return bag.size(); }

    public Bag<ExpressBusRoute> getBag() {
        return bag;
    }

    public void add (ExpressBusRoute expressBusRoute) {
        bag.add(expressBusRoute);
    }

    public boolean remove (ExpressBusRoute expressBusRoute) {
        return bag.remove(expressBusRoute.getId());
    }

    public Iterator<ExpressBusRoute> iterator () {
        return bag.iterator();
    }

    public String toString () {
        return "ExpressBusRoute" + " " + bag.toString();
    }

    public String fullString () {
        return toString();
    }
} // end enum ExpressBusRoutes
