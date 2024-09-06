package com.lawal.transit.stations;

import com.lawal.transit.stations.interfaces.*;

import java.util.*;

public class Stations implements Stationables, Iterable<Stationable> {

    public static final String ADDITION_ERROR = "The item is already in the list. It cannot be added again";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";

    private ArrayList<Stationable> stations;

    public Stations () {
        this.stations = new ArrayList<>();
    }

    @Override
    public int size () {
        return stations.size();
    }

    public ArrayList<Stationable> get () {
        return stations;
    }

    @Override
    public Iterator<Stationable> iterator () {
        return stations.iterator();
    }

    @Override
    public void add (Stationable stationable) throws Exception {
        if (stations.contains(stationable))
            throw new Exception(ADDITION_ERROR);
        stations.add(stations.size(), stationable);;
    }


    @Override
    public void remove (int stationId) throws Exception {
        Stationable stationable = search(stationId);
        if (stationable == null)
            throw new Exception(REMOVAL_ERROR);
        stations.remove(stations.indexOf(stationable));
    }

    @Override
    public Stationable search (int stationId) {
        for (Stationable stationable : stations) {
            if (stationable.key().id() == stationId)
                return stationable;
        }
        return null;
    }

    @Override
    public Stationable search (String stationName) {
        for (Stationable stationable : stations) {
            if (stationable.key().name().equalsIgnoreCase(stationName))
                return stationable;
        }
        return null;
    }


    public Stationable next (int currentStationId) {
        int currentIndex = stations.indexOf(search(currentStationId));
        if (currentIndex >= 0 || currentIndex < stations.size() - 1)
            return stations.get(currentIndex++);
        return null;
    }

    @Override
    public Stationable previous (int currentStationId) {
        int currentIndex = stations.indexOf(search(currentStationId));
        if (currentIndex > 1 || currentIndex < stations.size())
            return stations.get(currentIndex - 1);
        return null;
    }

    @Override
    public String toString () {
        StringBuilder stringBuilder = new StringBuilder();
        for(Stationable station: stations) {
            stringBuilder.append(station.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    private class StationableIterator implements  Iterator<Stationable> {
        private final Iterator<Stationable> iterator = stations.iterator();

        @Override
        public boolean hasNext () {
            return iterator.hasNext();
        }

        @Override
        public Stationable next () {
            return iterator().next();
        }
    }
}