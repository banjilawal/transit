package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.abstracts.AvenueBuilding;
import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.entities.Block;
import com.lawal.transit.middleware.interfaces.BagWrapper;

import java.util.Iterator;

public enum AvenueBuildings implements BagWrapper<AvenueBuilding> {
    INSTANCE;
    private final Bag<AvenueBuilding> bag = new Bag<AvenueBuilding>();

    public int size () { return bag.size(); }

    public Bag<AvenueBuilding> getBag() {
        return bag;
    } // close getBag

    public boolean add (AvenueBuilding avenueBuilding) {
        return bag.add(avenueBuilding);
    }

    public boolean remove (AvenueBuilding avenueBuilding) {
        return bag.remove(avenueBuilding.getId());
    }

    public Block getBlock (int blockId) {
        return (Block) Blocks.INSTANCE.getBag().search(blockId);
    } // close getBlock

    public Iterator<AvenueBuilding> iterator () {
        return bag.iterator();
    }

    public String toString () {
        return "AvenueBuilding" + " " + bag.toString();
    }

    public String fullString () {
        return toString();
    }
} // end class AvenueBuildings
