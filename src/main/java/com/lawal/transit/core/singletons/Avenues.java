package com.lawal.transit.core.singletons;

import com.lawal.transit.core.concretes.Avenue;
import com.lawal.transit.core.visitors.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.*;

public enum Avenues  {
    INSTANCE;
    private final ArrayList<Avenue> avenues = new ArrayList<>();


    public int size () { return avenues.size(); }


    public ArrayList<Avenue> getAvenues () {
        return avenues;
    }


    public void add (Avenue avenue) {
        if (avenues.contains(avenue)) {
            throw new IllegalArgumentException("An avenue named " + avenue.getName() + " already exists add cannot add another");
        }
        avenues.add(avenues.size(), avenue);
    }

    public boolean add (String name) {
        if (search(name) == null)
            return avenues.add(new Avenue(AvenueIdGenerator.INSTANCE.nextId(), name));
        return true;
    }


    public Avenue search (int id) {
        for (Avenue avenue : avenues) {
            if (avenue.getId() == id)
                return avenue;
        }
        return null;
    }


    public Avenue search (String name) {
        for (Avenue avenue : avenues) {
            if (avenue.getName().equalsIgnoreCase(name))
                return avenue;
        }
        return null;
    }


    public Iterator<Avenue> iterator () {
        return avenues.iterator();
    }


    public ArrayList<Avenue> filter (Predicate<Avenue> predicate) {
        ArrayList<Avenue> matches = new ArrayList<>();
        for (Avenue avenue : avenues) {
            if (predicate.test(avenue) && !matches.contains(avenue)) {
                matches.add(matches.size(), avenue);
            }
        }
        return matches;
    }

    @Override
    public String toString () {
        String string = "Avenues:\n";
        for (Avenue avenue : avenues) {
            string += avenue.toString() + "\n";
        }
        return string;
    }
} // end class Avenues
