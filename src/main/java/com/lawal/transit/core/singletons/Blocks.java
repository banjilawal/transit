package com.lawal.transit.core.singletons;

import com.lawal.transit.core.entities.Avenue;
import com.lawal.transit.core.entities.Block;
import com.lawal.transit.core.collections.Bag;
import com.lawal.transit.core.entities.Street;
import com.lawal.transit.core.interfaces.BagWrapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public enum Blocks implements BagWrapper<Block> {
    INSTANCE;
    private final Bag<Block> blocks = new Bag<Block>();

    @Override
    public int size () { return blocks.size(); }

    @Override
    public Bag<Block> getBag () {
        return blocks;
    }

    @Override
    public ArrayList<Block> getBagContents () { return blocks.getContents(); }

    @Override
    public void add (Block block) { blocks.add(block); }

    @Override
    public void remove (Block block) { blocks.remove(block); }

    @Override
    public Iterator<Block> iterator () { return blocks.iterator(); }


//     public  <Block> Iterator<Block> filterBlocks (Predicate<Block> predicate) {
//        return new FilteredIterator<>(getBag().iterator(), predicate);
//    } // close filter

//    public Iterator<Block> search (Predicate<Block> predicate) {
//        ArrayList<Block> blocks = new ArrayList<Block>();
//        for (Block block : this.blocks.getContents()) {
//            if (predicate.test(block)) {
//                blocks.add(blocks.size(), block);
//            }
//        }
//        return blocks.iterator();
//    } // close search

//    public Iterator<Block> iterator () {
//        Predicate<Block> predicate = (block) -> !block.getWesternAvenue().equals(block.getEasternAvenue());
//        return blocks.search(predicate);
//    }

//    @Override
//    public Iterator<Block> iterator () {
//        ArrayList<Block> results = new ArrayList<Block>();
//        for (Block block : blocks.getContents()) {
//            if (block.getId() < 10) {
//                if (!results.contains(block)) {
//                    System.out.println(block.getName() + " matched");
//                    results.add(results.size(), block);
//                }
//            }
//        }
//        return results.iterator();
//    }

    public Block search (Avenue westAvenue, Street northStreet, Avenue eastAvenue, Street southStreet) {
        for (Block block : blocks.getContents()) {
            if (avenuesMatch(block, westAvenue, eastAvenue) && streetsMatch(block, northStreet, southStreet)) {
                return block;
            }
        }
        return null;
    } // close search


    public Iterator<Block> filterByAvenue (Avenue avenue) {
        ArrayList<Block> matches = new ArrayList<Block>();
        Predicate<Block> predicate = block -> block.getWesternAvenue().equals(avenue)
                || block.getEasternAvenue().equals(avenue);
        for (Block block : Blocks.INSTANCE.blocks.getContents()) {
            if ((predicate.test(block) && !matches.contains(block))) {
                matches.add(matches.size(), block);
            }
        }
        return matches.iterator();
    } // close filterByAvenue

    public Iterator<Block> filterByStreet (Street street) {
        ArrayList<Block> matches = new ArrayList<Block>();
        Predicate<Block> predicate = block -> block.getNorthernStreet().equals(street)
                || block.getSouthernStreet().equals(street);
        for (Block block : Blocks.INSTANCE.blocks.getContents()) {
            if (predicate.test(block) && !matches.contains(block)) {
                matches.add(matches.size(), block);
            }
        }
        return matches.iterator();
    } // close filterByAvenue

    private boolean avenuesMatch (Block block, Avenue westAvenue, Avenue eastAvenue) {
        return (block.getWesternAvenue().equals(westAvenue) && block.getEasternAvenue().equals(eastAvenue));
    } // close avenuesMatch

    private boolean streetsMatch (Block block, Street northStreet, Street southStreet) {
        return (block.getNorthernStreet().equals(northStreet) && block.getSouthernStreet().equals(southStreet));
    } // close streetsMatch

    @Override
    public String toString () {
        String string = "\n";
        if (iterator().hasNext()) {
            Block block = iterator().next();
//            if (block.getId() > 1000) System.out.println("\t block.getName()");
            string += block.toString() + "\n";
        }
        return string;
    }

    public String print () { return blocks.toString(); }
} // end class BLocks
