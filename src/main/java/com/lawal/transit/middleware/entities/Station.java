package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.Location;
import com.lawal.transit.middleware.enums.Direction;

import java.util.ArrayList;

public class Station extends Location {
    private ArrayList<String> busRouteNames;
    private ArrayList<Station> outgoingNeighbors;
    private ArrayList<Station> incomingNeighbors;

    public Station (int id, String name, Block block, Direction curbSide) {
        super(id, name, block, curbSide);
        this.busRouteNames = new ArrayList<>();
        this.incomingNeighbors = new ArrayList<Station>();
        this.outgoingNeighbors = new ArrayList<Station>();
    }

    public ArrayList<String> getBusRouteNames () {
        return busRouteNames;
    }

    public ArrayList<Station> getOutgoingNeighbors () {
        return outgoingNeighbors;
    }

    public ArrayList<Station> getIncomingNeighbors () {
        return incomingNeighbors;
    }

    public void setBusRouteNames (ArrayList<String> busRouteNames) {
        for (String name : busRouteNames) {
            addBusRouteName(name);
        }
    } // close setBusRouteNames

    public void addBusRouteName (String busRouteName) {
        if (!busRouteNames.contains(busRouteName)) {
            busRouteNames.add(busRouteNames.size(), busRouteName);
        }
    } // close addBusRouteName

    public void setIncomingNeighbors (ArrayList<Station> stations) {
        for (Station station : stations) {
            addIncomingNeighbor(station);
        }
    } // close setIncomingNeighbors

    public void addIncomingNeighbor (Station station) {
        if (!incomingNeighbors.contains(station)) {
            incomingNeighbors.add(incomingNeighbors.size(), station);
        }
    } // close addIncomingNeighbor

    public void setOutingNeighbors (ArrayList<Station> stations) {
        for (Station station : stations) {
            addOutgoingNeighbor(station);
        }
    } // close setOutgoingNeighbors

    public void addOutgoingNeighbor (Station station) {
        if (!outgoingNeighbors.contains(station)) {
            outgoingNeighbors.add(outgoingNeighbors.size(), station);
        }
    } // close addOutgoingNeighbor

    public void removeIncomingNeighbors (ArrayList<Station> stations) {
        for (Station station : stations) {
            removeIncomingNeighbor(station);
        }
    } // close removeIncomingNeighbors

    public void removeIncomingNeighbor (Station station) {
        int index = incomingNeighbors.indexOf(station);
        if (index >= 0) {
            incomingNeighbors.remove(index);
        }
    } // close removeIncomingNeighbor

    public void removeOutingNeighbors (ArrayList<Station> stations) {
        for (Station station : stations) {
            removeOutgoingNeighbor(station);
        }
    } // close removeOutgoingNeighbors

    public void removeOutgoingNeighbor (Station station) {
        int index = outgoingNeighbors.indexOf(station);
        if (index >= 0) {
            outgoingNeighbors.remove(index);
        }
    } // close removeOutgoingNeighbor

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

    @Override
    public String toString () {
        String string = super.toString()
                + "\n" + printNeighbors("Incoming Neighbors", incomingNeighbors)
                + "\n" + printNeighbors("Incoming Neighbors", outgoingNeighbors)
                + "\n" + printBusRoutes();
        return string;
    } // close toString

    public String printNeighbors (String description, ArrayList<Station> stations) {
        String string = "[" + description + ":";
        for (Station station : stations) {
            string += station.getName() + " ";
        }
        return (string.trim() + "]");
    } // close printBusRoutes

    public String printBusRoutes () {
        String string = "[BusRoutes:";
        for (String busRouteName : busRouteNames) {
            string += busRouteName + " ";
        }
        return (string.trim() + "]");
    } // close printBusRoutes
} // end class Station