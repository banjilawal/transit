package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.Location;
import com.lawal.transit.core.enums.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Station extends Location {

    private ArrayList<String> busRouteNames;
    private HashMap<Integer, Station> incomingNeighbors;
    private HashMap<Integer, Station> outgoingNeighbors;

    private Direction busDirection;

    public Station (int id, String name, Block block, Direction busDirection) {
        super(id, name, block, Block.borderOrientation(busDirection));
        this.busRouteNames = new ArrayList<>();
        this.incomingNeighbors = new HashMap<Integer, Station>();
        this.outgoingNeighbors = new HashMap<Integer, Station>();
        this.busDirection = busDirection;
        block.addStation(Block.borderOrientation(busDirection), name);
    }

    public Direction getBlockBorderOrientation () { return getOrientation(); }

    public Direction getBusDirection () { return busDirection; }

    public HashMap<Integer, Station> getIncomingNeighbors () { return incomingNeighbors; }

    public HashMap<Integer, Station> getOutgoingNeighbors () { return outgoingNeighbors; }

    public ArrayList<String> getBusRouteNames () { return busRouteNames; }

    public ArrayList<RoadTraversal> getIncomingDirections () {
        return null;
    }


    public void addIncomigNeighbor (Station station) {
        incomingNeighbors.put(station.getId(), station);
    }

    public void addOutGoingNeighbor (Station station) {
        outgoingNeighbors.put(station.getId(), station);
    }

    public void addBusRouteNames (ArrayList<String> busRouteNames) {
        for (String name : busRouteNames) {
            addBusRouteName(name);
        }
    } // close setBusRouteNames

    public void addBusRouteName (String busRouteName) {
        if (!busRouteNames.contains(busRouteName)) {
            busRouteNames.add(busRouteNames.size(), busRouteName);
        }
    } // close addBusRouteName

    @Override
    public boolean equals (Object object) {
        if (object instanceof Station station) {
            return super.equals(station) && sameRoutes(station);
        }
        return false;
    } // close equals

    public boolean sameRoutes (Station station) {
        if (busRouteNames.size() != station.getBusRouteNames().size()) return false;

        if (busRouteNames.size() == station.getBusRouteNames().size()) {
            for (String name : busRouteNames) {
                if (!station.getBusRouteNames().contains(name)) return false;
            }
        }
        return true;
    } // close sameRoutes

    @Override
    public String toString () {
        return super.toString()
                + " " + busDirection.print() + " bound"
//            + " " + getOrientation().abbreviation()
//            + " " + getRoad().toString()
            + " " + printIncomingNeighbors()
            + " " + printOutgoingNeighbors()
            + " " + printBusRoutes();
    } // close toString

    public String printBusRoutes () {
        StringBuilder string = new StringBuilder("[BusRoutes:");
        for (String busRouteName : busRouteNames) {
            string.append(busRouteName).append(" ");
        }
        return (string.toString().trim() + "]");
    } // close printBusRoutes

    public String printIncomingNeighbors () { return  "[Incoming Neighbors-> " + printHashMap(incomingNeighbors) + "]"; }
    public String printOutgoingNeighbors () { return  "[Outgoing Neighbors-> " + printHashMap(outgoingNeighbors) + "]"; }

    private String printHashMap (HashMap<Integer, Station> map) {
        StringBuilder builder = new StringBuilder();
        for (HashMap.Entry<Integer, Station> entry : map.entrySet()) {
            Integer stationId = entry.getKey();
            Station station = entry.getValue();
            builder.append(stationId).append(" ").append(station.getName()).append(station.getOrientation().abbreviation()).append(" ");
        }
        return (String) builder.toString().trim();
    } // close printNeigbors
} // end class Station