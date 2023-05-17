package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.abstracts.StreetStation;
import com.lawal.transit.middleware.abstracts.StreetStation;
import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.entities.Block;
import com.lawal.transit.middleware.interfaces.BagWrapper;

import java.util.Iterator;

public enum StreetStations implements BagWrapper<StreetStation> {
    INSTANCE;
    private final Bag<StreetStation> bag = new Bag<StreetStation>();

    public int size () { return bag.size(); }

    public Bag<StreetStation> getBag() {
        return bag;
    } // close getBag

    public boolean add (StreetStation streetStation) {
        return bag.add(streetStation);
    }

    public boolean remove (StreetStation streetStation) {
        return bag.remove(streetStation.getId());
    }

    public Block getBlock (int blockId) {
        return (Block) Blocks.INSTANCE.getBag().search(blockId);
    } // close getBlock

    public Iterator<StreetStation> iterator () {
        return bag.iterator();
    }

    public String toString () {
        return "StreetStation" + " " + bag.toString();
    }

    public String fullString () {
        return toString();
    }
} // end class StreetStations
