package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.abstracts.Road;

public enum Roads {
    INSTANCE;

    public Road search (String roadName) {
        Road road = Avenues.INSTANCE.getBag().search(roadName);
        if (road == null) {
            road = Streets.INSTANCE.getBag().search(roadName);
        }
        return road;
    } // close search

    public String toString () {
        return "\t\t\tRoads\n\t\t--------------\n"
                + Avenues.INSTANCE.getBag().toString()
                + "\n" + Streets.INSTANCE.getBag().toString();
    } //close toString
} // end class Roads
