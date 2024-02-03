package com.lawal.transit.core.singletons;

import com.lawal.transit.core.abstracts.Road;

import java.util.ArrayList;
import java.util.Iterator;

public enum Roads {
    INSTANCE;
    private ArrayList<Road> roads = new ArrayList<>();


    public int size () {
        return roads.size();
    }


    public ArrayList<Road> getRoads () {
        return roads;
    }


    public void add (Road road) {
        if (!roads.contains(road)) {
            roads.add(road);
        }
    }


    public Iterator<Road> iterator () {
        return roads.iterator();
    }


    public Road search (String roadName) {
        Road road = Avenues.INSTANCE.search(roadName);
        if (road == null) {
            road = Streets.INSTANCE.search(roadName);
        }
        return road;
    }


    public String toString () {
        return "Roads\n-------\n" + Avenues.INSTANCE.toString() + "\n" + Streets.INSTANCE.toString();
    }
} // end class Roads
