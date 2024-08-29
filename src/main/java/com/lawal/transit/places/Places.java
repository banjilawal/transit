package com.lawal.transit.places;

import com.lawal.transit.places.interfaces.*;

import java.util.*;

public class Places implements Placeables, Iterable<Placeable> {

    public static final String ADDITION_ERROR = "The item is already in the list. It cannot be added again";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";
    private final List<Placeable> places;

    public Places () {
        this.places = new ArrayList<>();
    }

    @Override
    public int size () {
        return places.size();
    }

    @Override
    public Iterator<Placeable> iterator () {
        return new PlaceableIterator();
    }

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
        StringBuilder stringBuilder = new StringBuilder();
        for(Placeable place : places) {
            stringBuilder.append(place.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    private class PlaceableIterator implements Iterator<Placeable> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < places.size();
        }

        public boolean hasPrevious () {
            int previousCursor = cursor - 1;
            return previousCursor > 0 && previousCursor < places.size() - 1;
        }

        @Override
        public Placeable next () {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return places.get(cursor++);
        }

        public Placeable previous () {
            if (!hasPrevious())
                throw new NoSuchElementException();
            return places.get(cursor--);
        }

        @Override
        public void remove () {
            throw new UnsupportedOperationException();
        }
    }
}
