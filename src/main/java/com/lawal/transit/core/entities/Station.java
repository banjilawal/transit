package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.Location;
import com.lawal.transit.core.enums.Direction;
import com.lawal.transit.core.interfaces.DiGraphable;
import com.lawal.transit.core.interfaces.Graphable;

import java.util.ArrayList;
import java.util.Iterator;

public class Station extends Location implements DiGraphable<Station> {
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

    public Iterator<Station> getIncomingNeighbors () {
        return incomingNeighbors.iterator();
    } // close getIncomingNeighbors

    public void addIncomingNeighbors (ArrayList<Station> neighbors) {
        for (Station neighbor : neighbors) {
            addIncomingNeighbor(neighbor);
        }
    } // close addIncomingNeighbors

    public void addIncomingNeighbor (Station neighbor) {
        if (!incomingNeighbors.contains(neighbor)) {
            incomingNeighbors.add(incomingNeighbors.size(), neighbor);
        }
    } // close addIncomingNeighbor

    public void removeIncomingNeighbors (ArrayList<Station> neighbors) {
        for (Station neighbor : neighbors) {
            removeIncomingNeighbor(neighbor);
        }
    } // close removeIncomingNeighbors

    public void removeIncomingNeighbor (Station neighbor) {
        int index = incomingNeighbors.indexOf(neighbor);
        if (index >= 0) {
            incomingNeighbors.remove(index);
        }
    } // close removeIncomingNeighbor

    public Iterator<Station> getOutgoingNeighbors () {
        return outgoingNeighbors.iterator();
    } // close getIncomingNeighbors

    public void addOutgoingNeighbors (ArrayList<Station> neighbors) {
        for (Station neighbor : neighbors) {
            addOutgoingNeighbor(neighbor);
        }
    } // close addIncomingNeighbors

    public void addOutgoingNeighbor (Station neighbor) {
        if (!outgoingNeighbors.contains(neighbor)) {
            outgoingNeighbors.add(incomingNeighbors.size(), neighbor);
        }
    } // close addIncomingNeighbor

    public void removeOutgoingNeighbors (ArrayList<Station> neighbors) {
        for (Station neighbor : neighbors) {
            removeOutgoingNeighbor(neighbor);
        }
    } // close removeIncomingNeighbors

    public void removeOutgoingNeighbor (Station neighbor) {
        int index = outgoingNeighbors.indexOf(neighbor);
        if (index >= 0) {
            outgoingNeighbors.remove(index);
        }
    } // close removeIncomingNeighbor

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
    } // close printNeigbors

    public String printBusRoutes () {
        String string = "[BusRoutes:";
        for (String busRouteName : busRouteNames) {
            string += busRouteName + " ";
        }
        return (string.trim() + "]");
    } // close printBusRoutes
} // end class Station