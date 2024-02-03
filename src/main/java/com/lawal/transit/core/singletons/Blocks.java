package com.lawal.transit.core.singletons;

import com.lawal.transit.core.concretes.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public enum Blocks {
    INSTANCE;
    private final ArrayList<Block> blocks = new ArrayList<>();


    public int size () {
        return blocks.size();
    }



    public ArrayList<Block> getBlocks () {
        return blocks;
    }


    public void add (Block block) {
        if (blocks.contains(block)) {
            throw new IllegalArgumentException("Block " + block.getName()
                + " already exists add cannot add another");
        }
        blocks.add(blocks.size(), block);
    }


    public Block search (int id) {
        for (Block block : blocks) {
            if (block.getId() == id) {
                return block;
            }
        }
        return null;
    }


    public Block search (String name) {
        for (Block block : blocks) {
            if (block.getName().equalsIgnoreCase(name)) {
                return block;
            }
        }
        return null;
    }


    public Block search (Avenue westAvenue, Street northStreet, Avenue eastAvenue, Street southStreet) {
        for (Block block : blocks) {
            if (avenuesMatch(block, westAvenue, eastAvenue)
                && streetsMatch(block, northStreet, southStreet)) {
                return block;
            }
        }
        return null;
    }


    public Iterator<Block> iterator () {
        return blocks.iterator();
    }


    public ArrayList<Block> filter (Predicate<Block> predicate) {
        ArrayList<Block> matches = new ArrayList<Block>();
        for (Block block : blocks) {
            if ((predicate.test(block) && !matches.contains(block))) {
                matches.add(matches.size(), block);
            }
        }
        return matches;
    }


    private boolean avenuesMatch (Block block, Avenue westAvenue, Avenue eastAvenue) {
        return (block.getWesternAvenue().equals(westAvenue) && block.getEasternAvenue().equals(eastAvenue));
    } // close avenuesMatch


    private boolean streetsMatch (Block block, Street northStreet, Street southStreet) {
        return (block.getNorthernStreet().equals(northStreet) && block.getSouthernStreet().equals(southStreet));
    } // close streetsMatch


    @Override
    public String toString () {
        String string = "Blocks\n------------\n";
        for (Block block : blocks) {
//            if (block.getId() > 1000) System.out.println("\t block.getName()");
            string += block.toString() + "\n";
        }
        return string;
    }
} // end class Blocks
