package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.abstracts.Station;
import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.entities.Street;

public enum Roads {
    INSTANCE;
    public Avenues avenues = Avenues.INSTANCE;
    public Streets streets = Streets.INSTANCE;

    public Road search (String roadName) {
        Road road = (Road) avenues.getBag().search(roadName);
        if (road == null) {
            road = (Road) streets.getBag().search(roadName);
        }
        return road;
    } // close search

    public String toString () {
        return "\t\t\tRoads\n\t\t--------------\n" + avenues.toString() + "\n" + streets.toString();
    }
    public String fullString () {
        return toString();
    }
} // end class Roads
