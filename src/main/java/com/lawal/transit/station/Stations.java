package com.lawal.transit.station;

import com.lawal.transit.block.Block;
import com.lawal.transit.global.Direction;
import com.lawal.transit.road.contract.Road;

import java.util.*;

public class Stations {

    public static final String ADDITION_ERROR = "The item is already in the list. It cannot be added again";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";

    private final Set<Station> stations;

    public Stations () {
        this.stations = new HashSet<>();
    }

    public int size () {
        return stations.size();
    }

    public boolean isEmpty () { return stations.isEmpty(); }

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

    public void remove (int id) {
        Station station = findById(id);
        if (station != null) stations.remove(station);
    }

    public Station findById (int id) {
        for (Station station : stations) {
            if (station.getAddress().id() == id) return station;
        }
        return null;
    }

    public Station findByName (String name) {
        for (Station station : stations) {
            if (station.getAddress().name().equalsIgnoreCase(name)) return station;
        }
        return null;
    }

    public Station findByBlock (Block block) {
        for (Station station : stations) {
            if (station.getBlock().equals(block)) return station;
        }
        return null;
    }

    public Stations filterByRoad (Road road) {
        Stations matches = new Stations();
        for (Station station : stations) {
            if (station.getAddress().blockTag().curbMarker().roadLabel().equals(road.label()))
                matches.add(station);
        }
        return matches;
    }

    public Stations filterByRoadTravelDirection (Road road, Direction travelDirection) {
        Stations matches = new Stations();
        for (Station station : stations) {
            if (station.getAddress().blockTag().curbMarker().roadLabel().equals(road.label()) &&
                station.getAddress().blockTag().curbMarker().travelDirection().equals(travelDirection))
                matches.add(station);
        }
        return matches;
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
        int count = 0;
        for(Station station: stations) {
            stringBuilder.append(count + 1).append(" ").append(station.toString()).append("\n");
            count++;
        }
        return stringBuilder.toString();
    }
}