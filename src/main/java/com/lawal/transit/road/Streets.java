package com.lawal.transit.road;

import java.util.*;

public class Streets implements RoadCollection {

    private List<Road> streets;

    public Streets () {
        this.streets = new ArrayList<>();
    }
    @Override
    public int numberOfRoads () {
        return streets.size();
    }

    @Override
    public Iterator<Road> iterator () {
        return streets.iterator();
    }

    @Override
    public void add (Road road) throws Exception {
        if (!(road instanceof Street)) {
            throw new Exception("You should only add a Strreet instance to the streets collection");
        }
        Street street = (Street) road;
        if (streets.contains(street)) {
            throw new Exception(street.toString() + " is already in the collection");
        }
        streets.add(streets.size(), street);
    }

    @Override
    public Road search (RoadIdentifiable identifier) {
        for(Road road : streets) {
            if (road.getIdentifier().equals(identifier))
                return road;
        }
        return null;
    }

    @Override
    public void remove (RoadIdentifiable identifier) throws Exception {
        int index = streets.indexOf(search(identifier));
        if (index < 0) {
            throw new Exception("NO road with identifier:" + identifier.toString() + " was found. Removal attempt unsuccessful");
        }
        streets.remove(index);
    }
}
