package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.abstracts.AvenueStation;
import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.entities.Block;
import com.lawal.transit.middleware.interfaces.BagWrapper;

import java.util.Iterator;

public enum AvenueStations implements BagWrapper<AvenueStation> {
    INSTANCE;
    private final Bag<AvenueStation> bag = new Bag<AvenueStation>();

    public int size () { return bag.size(); }

    public Bag<AvenueStation> getBag() {
        return bag;
    } // close getBag

    public boolean add (AvenueStation avenueStation) {
        return bag.add(avenueStation);
    }

    public boolean remove (AvenueStation avenueStation) {
        return bag.remove(avenueStation.getId());
    }

    public Block getBlock (int blockId) {
        return (Block) Blocks.INSTANCE.getBag().search(blockId);
    } // close getBlock

    public Iterator<AvenueStation> iterator () {
        return bag.iterator();
    }

    public String toString () {
        return "AvenueStation" + " " + bag.toString();
    }

    public String fullString () {
        return toString();
    }
} // end class AvenueStations
