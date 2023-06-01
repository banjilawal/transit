package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.abstracts.TransitRoute;
import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.entities.RegularBusRoute;
import com.lawal.transit.middleware.interfaces.BagWrapper;

import java.util.Iterator;

public enum RegularBusRoutes implements BagWrapper<RegularBusRoute> {
    INSTANCE;
    private final Bag<RegularBusRoute> bag = new Bag<>();

    public int size () { return bag.size(); }

    public Bag<RegularBusRoute> getBag() {
        return bag;
    }

    public void add (RegularBusRoute regularBusRoute) {
        bag.add(regularBusRoute);
    }

    public boolean remove (RegularBusRoute regularBusRoute) {
        return bag.remove(regularBusRoute.getId());
    }

    public Iterator<RegularBusRoute> iterator () {
        return bag.iterator();
    }

    public String toString () {
        return "RegularBusRoute" + " " + bag.toString();
    }

    public String fullString () {
        return toString();
    }
} // end enum RegularBusRoutes
