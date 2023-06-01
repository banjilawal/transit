package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.entities.Block;
import com.lawal.transit.middleware.entities.Station;
import com.lawal.transit.middleware.interfaces.BagWrapper;

import java.util.Iterator;

public enum Stations implements BagWrapper<Station> {
    INSTANCE;
    private final Bag<Station> bag = new Bag<Station>();

    public int size () { return bag.size(); }

    public Bag<Station> getBag() {
        return bag;
    } // close getBag

    public void add (Station station) {
        if (!bag.contains(station)) {
            bag.add(size(), station);
        }
    }

    public boolean remove (Station station) {
        return bag.remove(station.getId());
    }

    public Block getBlock (int blockId) {
        return (Block) Blocks.INSTANCE.getBag().search(blockId);
    } // close getBlock

    public Iterator<Station> iterator () {
        return bag.iterator();
    }

    public String toString () {
        return "Station" + " " + bag.toString();
    }
//
//    public String fullString () {
//        return toString();
//    }
} // end class AvenueStations
