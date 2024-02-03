package com.lawal.transit.core.singletons;

import com.lawal.transit.core.concretes.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.*;

public enum Stations {
    INSTANCE;
    private final ArrayList<Station> stations = new ArrayList<>();

    public int size () {
        return stations.size();
    }

    public ArrayList<Station> getStations () {
        return stations;
    }

    public void add (Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("Block " + station.getName()
                + " already exists add cannot add another");
        }
        stations.add(stations.size(), station);
    }

    public Station search (int id) {
        for (Station station : stations) {
            if (station.getId() == id) {
                return station;
            }
        }
        return null;
    }

    public Station search (String name) {
        for (Station station : stations) {
            if (station.getName().equalsIgnoreCase(name)) {
                return station;
            }
        }
        return null;
    }

    public Iterator<Station> iterator () {
        return stations.iterator();
    }

    public ArrayList<Station> filter (Predicate<Station> predicate) {
        ArrayList<Station> matches = new ArrayList<>();
        for (Station station : stations) {
            if ((predicate.test(station) && !matches.contains(station))) {
//                System.out.println(station.getName() + " matches");
                matches.add(matches.size(), station);
            }
        }
        return matches;
    }


    @Override
    public String toString () {
        String string = "Stations\n------------\n";
        for (Station station : stations) {
            string += station.toString() + "\n";
        }
        return string;
    }
} // end class Stations
