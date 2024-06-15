package com.lawal.transit.locations;

import com.lawal.transit.addresses.interfaces.*;
import com.lawal.transit.graph.interfaces.*;

import java.util.*;

public class Stations implements VertexCollection<Station> {
    public static final String ADDITION_ERROR = "The item is already in the list. It cannot be added again";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";
    private final ArrayList<Station> stations;

    private Stations () {
        this.stations = new ArrayList<>();
    }

    public int getOrder () {
        return stations.size();
    }

    public Iterator<Station> iterator () {
        return stations.iterator();
    }

    @Override
    public Station search (Addressable addressable) {
        for (Station station: stations) {
            if (station.getAddress().equals(addressable))
                return station;
        }
        return null;
    }

    @Override
    public void add (Station station) throws Exception {
        if (stations.contains(station))
            throw new Exception(ADDITION_ERROR);
        stations.add(stations.size(), station);;
    }

    @Override
    public void remove (Station station) throws Exception {
        int index = stations.indexOf(station);
        if (index < 0)
            throw new Exception(REMOVAL_ERROR);
        stations.remove(index);
    }

}
