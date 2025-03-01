package com.lawal.transit.station;

import com.lawal.transit.block.model.Block;
import com.lawal.transit.global.Direction;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.station.model.Station;

import java.util.*;

public class Stations {

    public static final String ADDITION_ERROR = "The item is already in the list. It cannot be added again";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";

    private final List<Station> stations;

    public Stations () {
        this.stations = new ArrayList<>();
    }

    public int size () {
        return stations.size();
    }

    public boolean isEmpty () { return stations.isEmpty(); }

    public List<Station> getStations () {
        return stations;
    }

    public Iterator<Station> iterator () {
        return stations.iterator();
    }

    public void add (Station station) {
        if (stations.contains(station) || station == null) return;
        stations.add(station);
    }

    public void remove (Long id) {
        Station station = findById(id);
        if (station != null) stations.remove(station);
    }

    public Station findById (Long id) {
        for (Station station : stations) {
            if (station.getId().equals(id)) return station;
        }
        return null;
    }

    public Station findByName (String name) {
        for (Station station : stations) {
            if (station.getName().equalsIgnoreCase(name)) return station;
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
            if (station.getBlock().getCurb().getRoad().equals(road))
                matches.add(station);
        }
        return matches;
    }

    public Stations filterByRoadTravelDirection (Road road, Direction orientation) {
        Stations matches = new Stations();
        for (Station station : stations) {
            Road stationRoad = station.getBlock().getCurb().getRoad();
            if (stationRoad.equals(road) && station.getBlock().getCurb().getOrientation() == orientation) matches.add(station);
        }
        return matches;
    }


    public Station nextStation (int currentStationId) {
        Station previousStation = null;
        for (Station station : stations) {
            if (previousStation != null && previousStation.getId() == currentStationId) return station;
            previousStation = station;
        }
        return null;
    }
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