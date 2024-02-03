package com.lawal.transit.core.singletons;

import com.lawal.transit.core.concretes.*;
import com.lawal.transit.core.visitors.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.*;

public enum Streets {
    INSTANCE;
    private final ArrayList<Street> streets = new ArrayList<>();

    public int size () {
        return streets.size();
    }


    public ArrayList<Street> getStreets () {
        return streets;
    }


    public void add (Street street) {
        if (streets.contains(street)) {
            throw new IllegalArgumentException("An avenue named " + street.getName() + " already exists add cannot add another");
        }
        streets.add(streets.size(), street);
    }

    public boolean add (String name) {
        if (search(name) == null)
            return streets.add(new Street(StreetIdGenerator.INSTANCE.nextId(), name));
        return true;
    }


    public Street search (int id) {
        for (Street street : streets) {
            if (street.getId() == id)
                return street;
        }
        return null;
    }


    public Street search (String name) {
        for (Street street : streets) {
            if (street.getName().equalsIgnoreCase(name))
                return street;
        }
        return null;
    }


    public Iterator<Street> iterator () {
        return streets.iterator();
    }


    public ArrayList<Street> filter (Predicate<Street> predicate) {
        ArrayList<Street> matches = new ArrayList<>();
        for (Street street : streets) {
            if (predicate.test(street) && !matches.contains(street)) {
                matches.add(matches.size(), street);
            }
        }
        return matches;
    }

    @Override
    public String toString () {
        String string = "Streets:\n";
        for (Street street : streets) {
            string += street.toString() + "\n";
        }
        return string;
    }
} // end class Streets
