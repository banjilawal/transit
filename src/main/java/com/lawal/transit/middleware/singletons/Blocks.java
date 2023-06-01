package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.entities.Block;
import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.entities.Street;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public enum Blocks {
    INSTANCE;
    public final Bag<Block> bag = new Bag<Block>();

    public Bag<Block> getBag() {
        return bag;
    }
//
//    public int size () { return bag.size(); }
//
//    public void add (Block block) {
//        bag.add(block);
//    }
//
//    public boolean remove (Block block) {
//        return bag.remove(block.getId());
//    }
//
//    public Iterator<Block> iterator () {
//        return bag.iterator();
//    }

//    public String fullString () {
//        return bag.fullString();
//    }


//     public  <Block> Iterator<Block> filterBlocks (Predicate<Block> predicate) {
//        return new FilteredIterator<>(getBag().iterator(), predicate);
//    } // close filter

    public Iterator<Block> search (Predicate<Block> predicate) {
        ArrayList<Block> blocks = new ArrayList<Block>();
        for (Block block : bag.getBag()) {
            if (predicate.test(block)) {
                blocks.add(blocks.size(), block);
            }
        }
        return blocks.iterator();
    } // close search

    public Block search (Avenue westAvenue, Street northStreet, Avenue eastAvenue, Street southStreet) {
        for (Block block : bag.getBag()) {
            if (avenuesMatch(block, westAvenue, eastAvenue) && streetsMatch(block, northStreet, southStreet)) {
                return block;
            }
        }
        return null;
    } // close search

    private boolean avenuesMatch (Block block, Avenue westAvenue, Avenue eastAvenue) {
        return (block.getWestAvenue().equals(westAvenue) && block.getEastAvenue().equals(eastAvenue));
    } // close avenuesMatch

    private boolean streetsMatch (Block block, Street northStreet, Street southStreet) {
        return (block.getNorthStreet().equals(northStreet) && block.getSouthStreet().equals(southStreet));
    } // close streetsMatch
} // end class BLocks
