package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.entities.Block;
import com.lawal.transit.middleware.entities.Station;
import com.lawal.transit.middleware.interfaces.BagWrapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public enum Stations {
    INSTANCE;
    public final Bag<Station> bag = new Bag<Station>();

    public Bag<Station> getBag() {
        return bag;
    } // close getBag

    public Iterator<Station> search (Predicate<Station> predicate) {
        ArrayList<Station> stations = new ArrayList<Station>();
        for (Station station : bag.getBag()) {
            if (predicate.test(station)) {
                stations.add(stations.size(), station);
            }
        }
        return stations.iterator();
    } // close search
} // end class Stations
