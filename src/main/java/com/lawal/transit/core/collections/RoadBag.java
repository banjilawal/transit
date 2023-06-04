package com.lawal.transit.core.collections;

import com.lawal.transit.core.abstracts.Road;

import java.util.ArrayList;
import java.util.Iterator;

public class RoadBag {
    private static int serialNumber = 1;
    private final ArrayList<Road> arteries;

    public RoadBag () {
        this.arteries = new ArrayList<Road>();
    } // close constructor

    public Road search (int id) {
        for (Iterator<Road> iterator = arteries.iterator(); iterator.hasNext();) {
            Road road = iterator.next();
            if (road.getId() == id) {
                return road;
            }
        }
        return null;
    } // close search

    public Road search (String name) {
        for (Iterator<Road> iterator = arteries.iterator(); iterator.hasNext();) {
            Road road = iterator.next();
            if (road.getName().equalsIgnoreCase(name)) {
                return road;
            }
        }
        return null;
    } // close search

    public boolean remove (int id) {
        Road road = search(id);
        if (road == null) {
            return false;
        }
        else return arteries.remove(road);
    } // close removeRoad

    public boolean remove (String name) {
        Road road = search(name);
        if (road == null) {
            return false;
        }
        else return arteries.remove(road);
    } // close removeRoad

    public boolean add (Road road) {
        if (arteries.contains(road)) {
            return false;
        }
        return arteries.add(road);
    } // close addRoad

    public Iterator<Road> iterator () {
        return arteries.iterator();
    } // close iterator

    public int size () {
        return arteries.size();
    } // close getRoadTotal

    @Override
    public String toString () {
        String string = "Arteries\n-----";
        for (Road road : arteries) {
            string += "\n" + road.toString();
        }
        return string;
    } // close toString

    public static int nextSerialNumber () {
        return serialNumber++;
    } // close nextSerialNumber
} // end class RoadBag
