package com.lawal.transit.stations;

import com.lawal.transit.blocks.interfaces.RoadSectionTag;

import java.util.*;

public class Stations {

    public static final String ADDITION_ERROR = "The item is already in the list. It cannot be added again";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";

    private ArrayList<Station> stations;

    public Stations () {
        this.stations = new ArrayList<>();
    }


    public int size () {
        return stations.size();
    }

    public ArrayList<Station> getStations () {
        return stations;
    }

    public Iterator<Station> iterator () {
        return stations.iterator();
    }

    public void add (Station station) throws Exception {
        if (stations.contains(station))
            throw new Exception(ADDITION_ERROR);
        stations.add(stations.size(), station);;
    }

    public void remove (int stationId) throws Exception {
        Station station = search(stationId);
        if (station == null)
            throw new Exception(REMOVAL_ERROR);
        stations.remove(stations.indexOf(station));
    }

    public Station search (int stationId) {
        for (Station station : stations) {
            if (station.getKey().id() == stationId)
                return station;
        }
        return null;
    }

    public Station search (String stationName) {
        for (Station station : stations) {
            if (station.getKey().name().equalsIgnoreCase(stationName))
                return station;
        }
        return null;
    }

    public Station search (RoadSectionTag blockTag) {
        for (Station station : stations) {
            if (station.getKey().blockTag().equals(blockTag))
                return station;
        }
        return null;
    }


//    public Vertex next (int currentStationId) {
//        int currentIndex = stations.indexOf(search(currentStationId));
//        if (currentIndex >= 0 || currentIndex < stations.size() - 1)
//            return stations.get(currentIndex++);
//        return null;
//    }
//
//    @Override
//    public Vertex previous (int currentStationId) {
//        int currentIndex = stations.indexOf(search(currentStationId));
//        if (currentIndex > 1 || currentIndex < stations.size())
//            return stations.get(currentIndex - 1);
//        return null;
//    }

    @Override
    public String toString () {
        StringBuilder stringBuilder = new StringBuilder();
        for(Station station: stations) {
            stringBuilder.append(station.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
//
//    private class StationableIterator implements  Iterator<Vertex> {
//        private final Iterator<Vertex> iterator = stations.iterator();
//
//        @Override
//        public boolean hasNext () {
//            return iterator.hasNext();
//        }
//
//        @Override
//        public Vertex next () {
//            return iterator().next();
//        }
//    }
}