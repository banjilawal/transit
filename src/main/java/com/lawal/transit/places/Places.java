package com.lawal.transit.places;

import com.lawal.transit.places.interfaces.*;

import java.util.*;

public class Places implements Placeables, Iterable<Placeable> {

    public static final String ADDITION_ERROR = "The item is already in the list. It cannot be added again";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";
    private final ArrayList<Placeable> places;

    public Places () {
        this.places = new ArrayList<>();
    }

    @Override
    public int size () {
        return places.size();
    }

    public ArrayList<Placeable> getList () { return places; }

    @Override
    public Iterator<Placeable> iterator () {
        return places.iterator();
    }//  new PlaceableIterator();}

    @Override
    public void add (Placeable placeable) throws Exception {
        if (search(placeable.key().id()) != null)
            throw new Exception("Add place failure: id already in use.");
        if (search(placeable.key().name()) != null)
            throw new Exception("Add place failure: name already in use.");
        places.add(places.size(), placeable);
    }

    @Override
    public void remove (int placeId) throws Exception {
        Placeable place = search(placeId);
        if (place == null)
            throw new Exception("Remove place failure: no place exists with the id.");
        places.remove(places.indexOf(place));
    }

    @Override
    public Placeable search (int placeId) {
        for (Placeable place : places) {
            if (place.key().id() == placeId)
                return place;
        }
        return null;
    }

    @Override
    public Placeable search (String placeName) {
        for (Placeable place : places) {
            if (place.key().name().equalsIgnoreCase(placeName))
                return place;
        }
        return null;
    }

    @Override
    public String toString () {
        int itemCount = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(Placeable place : places) {
            stringBuilder.append(place.key().name()).append(" ");
        }
        return stringBuilder.toString();
    }
}