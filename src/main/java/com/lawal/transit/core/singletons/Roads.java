package com.lawal.transit.core.singletons;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.collections.Bag;
import com.lawal.transit.core.entities.Avenue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public enum Roads {
    INSTANCE;
    public Bag<Road> roads = new Bag<Road>();

    public Bag<Road> getRoads () {
        return roads;
    }

    public Road search (String roadName) {
        Road road = Avenues.INSTANCE.getAvenues().search(roadName);
        if (road == null) {
            road = Streets.INSTANCE.getStreets().search(roadName);
        }
        return road;
    } // close search

    public Iterator<Road> iterator (Predicate<Road> predicate) {
        return roads.search(predicate);
    } // close iterator

    public ArrayList<ArrayList<Road>> roadPairs () {
        Roads roads = Roads.INSTANCE;
        ArrayList<ArrayList<Road>> roadPairs = new ArrayList<ArrayList<Road>>();
        Avenue avenue;
        int index = 0;
        while (index < (roads.roads.size() - 1)) {
            ArrayList<Road> roadPair = new ArrayList<Road>();
            roadPair.add(roadPair.size(), roads.getRoads().get(index));
            roadPair.add(roadPair.size(), roads.getRoads().get(index+1));
            roadPairs.add(roadPairs.size(), roadPair);
            index++;
        }
        return roadPairs;
    } // close roadPairs

    public String toString () {
        return "\t\t\tRoads\n\t\t--------------\n"
                + Avenues.INSTANCE.getAvenues().toString()
                + "\n" + Streets.INSTANCE.getStreets().toString();
    } //close toString
} // end class Roads
