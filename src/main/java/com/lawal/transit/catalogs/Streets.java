package com.lawal.transit.catalogs;

import com.lawal.transit.roads.*;

import java.util.*;

public enum Streets  {
    INSTANCE;
    private final ArrayList<Street> streets;

    private Streets () {
        this.streets = new ArrayList<>();
    }

    public int size () {
        return streets.size();
    }

    public ArrayList<Street> get () {
        return streets;
    }

    public Iterator<Street> iterator () {
        return streets.iterator();
    }

    public Street search (int streetId) {
        for(Street street: streets) {
            if (street.label().id() == streetId)
                return street;
        }
        return null;
    }

    public Street search (String streetName) {
        for(Street street: streets) {
            if (street.label().name().equalsIgnoreCase(streetName))
                return street;
        }
        return null;
    }

    public void add (Street street) throws Exception {
        if (streets.contains(street)) {
            throw new Exception(street.toString() + " is already in the collection");
        }
        streets.add(streets.size(), street);
    }

    public void remove (int streetId) throws Exception {
        int index = streets.indexOf(search(streetId));
        if (index < 0) {
            throw new Exception("NO roads with id:" + streetId + " was found. Removal attempt unsuccessful");
        }
        streets.remove(index);
    }

    public Street next (int currentId) {
        int currentIndex = streets.indexOf(search(currentId));
        if (currentIndex >= 0 || currentIndex < streets.size() - 1)
            return streets.get(currentIndex + 1);
        return null;
    }

    public Street previous (int currentId) {
        int currentIndex = streets.indexOf(search(currentId));
        if (currentIndex > 1 || currentIndex < streets.size())
            return streets.get(currentIndex - 1);
        return null;
    }
}
