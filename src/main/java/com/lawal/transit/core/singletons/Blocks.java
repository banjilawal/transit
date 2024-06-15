package com.lawal.transit.core.singletons;

import com.lawal.transit.core.concretes.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public enum Blocks {
    INSTANCE;
    private final ArrayList<OldConcreteBlock> concreteBlocks = new ArrayList<>();


    public int size () {
        return concreteBlocks.size();
    }



    public ArrayList<OldConcreteBlock> getBlocks () {
        return concreteBlocks;
    }


    public void add (OldConcreteBlock concreteBlock) {
        if (concreteBlocks.contains(concreteBlock)) {
            throw new IllegalArgumentException("OldConcreteBlock " + concreteBlock.getName()
                + " already exists add cannot add another");
        }
        concreteBlocks.add(concreteBlocks.size(), concreteBlock);
    }


    public OldConcreteBlock search (int id) {
        for (OldConcreteBlock concreteBlock : concreteBlocks) {
            if (concreteBlock.getId() == id) {
                return concreteBlock;
            }
        }
        return null;
    }


    public OldConcreteBlock search (String name) {
        for (OldConcreteBlock concreteBlock : concreteBlocks) {
            if (concreteBlock.getName().equalsIgnoreCase(name)) {
                return concreteBlock;
            }
        }
        return null;
    }


    public OldConcreteBlock search (ConcreteAvenue westConcreteAvenue, ConcreteStreet northConcreteStreet, ConcreteAvenue eastConcreteAvenue, ConcreteStreet southConcreteStreet) {
        for (OldConcreteBlock concreteBlock : concreteBlocks) {
            if (avenuesMatch(concreteBlock, westConcreteAvenue, eastConcreteAvenue)
                && streetsMatch(concreteBlock, northConcreteStreet, southConcreteStreet)) {
                return concreteBlock;
            }
        }
        return null;
    }


    public Iterator<OldConcreteBlock> iterator () {
        return concreteBlocks.iterator();
    }


    public ArrayList<OldConcreteBlock> filter (Predicate<OldConcreteBlock> predicate) {
        ArrayList<OldConcreteBlock> matches = new ArrayList<OldConcreteBlock>();
        for (OldConcreteBlock concreteBlock : concreteBlocks) {
            if ((predicate.test(concreteBlock) && !matches.contains(concreteBlock))) {
                matches.add(matches.size(), concreteBlock);
            }
        }
        return matches;
    }


    private boolean avenuesMatch (OldConcreteBlock concreteBlock, ConcreteAvenue westConcreteAvenue, ConcreteAvenue eastConcreteAvenue) {
        return (concreteBlock.getWesternAvenue().equals(westConcreteAvenue) && concreteBlock.getEasternAvenue().equals(eastConcreteAvenue));
    } // close avenuesMatch


    private boolean streetsMatch (OldConcreteBlock concreteBlock, ConcreteStreet northConcreteStreet, ConcreteStreet southConcreteStreet) {
        return (concreteBlock.getNorthernStreet().equals(northConcreteStreet) && concreteBlock.getSouthernStreet().equals(southConcreteStreet));
    } // close streetsMatch


    @Override
    public String toString () {
        String string = "Blocks\n------------\n";
        for (OldConcreteBlock concreteBlock : concreteBlocks) {
//            if (concreteBlock.getId() > 1000) System.out.println("\t concreteBlock.getName()");
            string += concreteBlock.toString() + "\n";
        }
        return string;
    }
} // end class Blocks
