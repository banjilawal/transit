package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.Location;
import com.lawal.transit.middleware.enums.Direction;

import java.util.ArrayList;

public class Station extends Location {
    private ArrayList<String> busRouteNames;
    private ArrayList<Station> outGoingNeighbors;
    private ArrayList<Station> incomingNeighbors;

    public Station (int id, String name, Block block, Direction curbSide) {
        super(id, name, block, curbSide);
        this.busRouteNames = new ArrayList<>();
        this.incomingNeighbors = new ArrayList<Station>();
        this.outGoingNeighbors = new ArrayList<Station>();
    }

    public void addBusRouteName (String busRouteName) {
        if (!busRouteNames.contains(busRouteName)) {
            busRouteNames.add(busRouteNames.size(), busRouteName);
        }
    } // close addStop

    public void addBusRouteNames (ArrayList<String> busRouteNames) {
        for (String name : busRouteNames) {
            addBusRouteName(name);
        }
    } // close addStops

    @Override
    public boolean equals (Object object) {
        if (object instanceof Station) {
            Station station = (Station) object;
            if (super.equals(station)) {
                        return true;
            }
        }
        return false;
    } // close equals

    public String toString () {
        String string = super.toString()
                + "\n" + printBusRoutes();
        return string;
    } // close toString

    public String printBusRoutes () {
        String string = "[BusRoutes:";
        for (String busRouteName : busRouteNames) {
            string += busRouteName + " ";
        }
        return (string.trim() + "]");
    } // close printBusRoutes
} // end class Station