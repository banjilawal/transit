package com.lawal.transit.station;

import com.lawal.transit.block.BlockTag;

import java.util.*;

public class Stations {

    public static final String ADDITION_ERROR = "The item is already in the list. It cannot be added again";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";

    private Set<Station> stations;

    public Stations () {
        this.stations = new HashSet<>();
    }


    public int size () {
        return stations.size();
    }

    public Set<Station> getStations () {
        return stations;
    }

    public List<Station> getStationsAsList () {
        return new ArrayList<>(stations);
    }

    public Iterator<Station> iterator () {
        return stations.iterator();
    }

    public void add (Station station) {
        stations.add(station);
    }

    public void remove (int stationId) throws Exception {
        Station station = searchById(stationId);
        if (station == null)
            throw new Exception(REMOVAL_ERROR);
        stations.remove(station);
    }

    public Station searchById (int stationId) {
        for (Station station : stations) {
            if (station.getAddress().id() == stationId)
                return station;
        }
        return null;
    }

    public Station searchByName (String stationName) {
        for (Station station : stations) {
            if (station.getAddress().name().equalsIgnoreCase(stationName))
                return station;
        }
        return null;
    }

    public Station filterByBlock (BlockTag blockTag) {
        for (Station station : stations) {
            if (station.getAddress().blockTag().equals(blockTag))
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
}