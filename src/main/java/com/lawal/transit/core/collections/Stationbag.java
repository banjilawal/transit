package com.lawal.transit.core.collections;
/*
import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.entities.Station;

import java.util.ArrayList;
import java.util.Iterator;

public class Stationbag {
    private static int serialNumber = 1;
    private ArrayList<Station> stations;

    public Stationbag () {
    } // close StationBag

    public Station search (int id) {
        for (Iterator<Station> iterator = stations.iterator(); iterator.hasNext();) {
            Station station = (Station) iterator.next();
            if (station.getId() == id) {
                return station;
            }
        }
        return null;
    } // close search

    public Station search (String name) {
        for (Iterator<Station> iterator = stations.iterator(); iterator.hasNext();) {
            Station station = (Station) iterator.next();
            if (station.getName().equalsIgnoreCase(name)) {
                return station;
            }
        }
        return null;
    } // close search

    public Station search (Road road, Road crossRoad) {
        for (Iterator<Station> iterator = stations.iterator(); iterator.hasNext();) {
            Station station = (Station) iterator.next();
            if (station.getArtery().equals(road) && station.getCrossRoad().equals(crossRoad)) {
                return station;
            }
        }
        return null;
    } // close search

    public boolean add (Station station) {
        if (stations.contains(station)) {
            return false;
        }
        return stations.add(station);
    } // close addStation

    public boolean remove (int id) {
        Station station = search(id);
        if (station == null) {
            return false;
        }
        return stations.remove(station);
    } // close removeStation

    public boolean remove (String name) {
        Station station = search(name);
        if (station == null) {
            return false;
        }
        return stations.remove(station);
    } // close removeStation

    public Iterator<Station> iterator () {
        return stations.iterator();
    } // close iterator

    public int size () {
        return stations.size();
    } // close getTotal

    @Override
    public String toString () {
        String string = "Stations\n--------";
        for (Iterator<Station> iterator = stations.iterator(); iterator.hasNext();) {
            Station station = (Station) iterator.next();
            string += "\n" + station.toString();
        }
        return string;
    } // close toString

    public static int nextSerialNumber () {
        return serialNumber++;
    } // close nextSerialNumber;
} // end class StationBag
*/