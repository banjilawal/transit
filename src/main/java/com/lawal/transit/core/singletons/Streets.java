package com.lawal.transit.core.singletons;

import com.lawal.transit.core.concretes.*;
import com.lawal.transit.core.visitors.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.*;

public enum Streets {
    INSTANCE;
    private final ArrayList<ConcreteStreet> concreteStreets = new ArrayList<>();

    public int size () {
        return concreteStreets.size();
    }


    public ArrayList<ConcreteStreet> getStreets () {
        return concreteStreets;
    }


    public void add (ConcreteStreet concreteStreet) {
        if (concreteStreets.contains(concreteStreet)) {
            throw new IllegalArgumentException("An avenue named " + concreteStreet.getName() + " already exists add cannot add another");
        }
        concreteStreets.add(concreteStreets.size(), concreteStreet);
    }

    public boolean add (String name) {
        if (search(name) == null)
            return concreteStreets.add(new ConcreteStreet(StreetIdGenerator.INSTANCE.nextId(), name));
        return true;
    }


    public ConcreteStreet search (int id) {
        for (ConcreteStreet concreteStreet : concreteStreets) {
            if (concreteStreet.getId() == id)
                return concreteStreet;
        }
        return null;
    }


    public ConcreteStreet search (String name) {
        for (ConcreteStreet concreteStreet : concreteStreets) {
            if (concreteStreet.getName().equalsIgnoreCase(name))
                return concreteStreet;
        }
        return null;
    }


    public Iterator<ConcreteStreet> iterator () {
        return concreteStreets.iterator();
    }


    public ArrayList<ConcreteStreet> filter (Predicate<ConcreteStreet> predicate) {
        ArrayList<ConcreteStreet> matches = new ArrayList<>();
        for (ConcreteStreet concreteStreet : concreteStreets) {
            if (predicate.test(concreteStreet) && !matches.contains(concreteStreet)) {
                matches.add(matches.size(), concreteStreet);
            }
        }
        return matches;
    }

    @Override
    public String toString () {
        String string = "Streets:\n";
        for (ConcreteStreet concreteStreet : concreteStreets) {
            string += concreteStreet.toString() + "\n";
        }
        return string;
    }
} // end class Streets
