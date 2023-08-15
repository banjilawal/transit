package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.Location;
import com.lawal.transit.core.enums.Direction;

import java.util.*;

public class Station extends Location {

    private ArrayList<String> busRouteNames;
    private HashMap<Direction, Station> incomingNeighbors;
    private HashMap<Direction, Station> outgoingNeighbors;

    private Direction busDirection;

    public Station (int id, String name, Block block, Direction busDirection) {
        super(id, name, block, Block.borderOrientation(busDirection));
        this.busRouteNames = new ArrayList<>();
        this.incomingNeighbors = new HashMap<Direction, Station>();
        this.outgoingNeighbors = new HashMap<Direction, Station>();
        this.busDirection = busDirection;
        block.addStation(Block.borderOrientation(busDirection), name);
    }

    public Direction getBlockBorderOrientation () { return getOrientation(); }

    public Direction getBusDirection () { return busDirection; }

    public HashMap<Direction, Station> getIncomingNeighbors () { return incomingNeighbors; }

    public HashMap<Direction, Station> getOutgoingNeighbors () { return outgoingNeighbors; }

    public ArrayList<String> getBusRouteNames () { return busRouteNames; }


    public void addIncomigNeighbor (Station station) {
        incomingNeighbors.put(station.getOrientation(), station);
    }

    public void addIncomingNeighbor (Direction orientation,  Station station) { incomingNeighbors.put(orientation,  station); }

    public void addOutGoingNeighbor (Station station) {
        outgoingNeighbors.put(station.getOrientation(), station);
    }

    public void addOutgoingNeighbor (Direction orientation, Station station) { outgoingNeighbors.put(orientation, station); }

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

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), busRouteNames, incomingNeighbors, outgoingNeighbors, busDirection);
    }

    public Block getAdjacentOutgoingBlock () {
        return null;
    }

    public Block getAdjacentIncomingBlock () {
        return null;
    }

    public void setOutgoingNeighbors () {
        Block block = null;
        Station station = null;

        switch (busDirection) {
            case NORTH:
                if (getBlock().getNorthernStation() != null) addOutgoingNeighbor(Direction.NORTHEAST, getBlock().getNorthernStation());
                block = getBlock().getWesternNeighbor();
                if (block != null) {
                    station = block.getSouthernStation();
                    if (station != null) {
                        addOutgoingNeighbor(Direction.SOUTHWEST, station);
                    }
                }
                block = getBlock().getNorthernNeighbor();
                if (block != null) {
                    station = block.getWesternStation();
                    if (station != null) addOutgoingNeighbor(Direction.NORTH, station);
                }
            case EAST:
                if (getBlock().getEasternStation() != null) addOutgoingNeighbor(Direction.SOUTHEAST, getBlock().getEasternStation());
                block = getBlock().getNorthernNeighbor();
                if (block != null) {
                    station = block.getWesternStation();
                    if (station != null) addOutgoingNeighbor(Direction.NORTHWEST, station );
                }
                block = getBlock().getEasternNeighbor();
                if (block != null) {
                    station = block.getNorthernStation();
                    if (station != null) addOutgoingNeighbor(Direction.EAST, station );
                }
            case SOUTH:
                if (getBlock().getSouthernStation() != null) addOutgoingNeighbor(Direction.SOUTHWEST, getBlock().getSouthernStation());
                block = getBlock().getEasternNeighbor();
                if (block != null) {
                    station = block.getNorthernStation();
                    if (station != null) addOutgoingNeighbor(Direction.NORTHEAST, station);
                }
                block = getBlock().getSouthernNeighbor();
                if (block != null) {
                    station = block.getEasternStation();
                    if (station != null) addOutgoingNeighbor(Direction.SOUTH, station);
                }
            case WEST:
                if (getBlock().getWesternStation() != null) addOutgoingNeighbor(Direction.NORTHWEST, getBlock().getWesternStation());
                block = getBlock().getSouthernNeighbor();
                if (block != null) {
                    station = block.getEasternStation();
                    if (station != null) addOutgoingNeighbor(Direction.SOUTHEAST, station);
                }
                block = getBlock().getWesternNeighbor();
                if (block != null) {
                    station = block.getSouthernStation();
                    if (station != null) addOutgoingNeighbor(Direction.WEST, station);
                }
            default:
                System.out.println("Could not set block neighbor");
        }
    } //


    public void setIncomingNeighbors () {
        Block block = null;
        Station station = null;

        switch (busDirection) {
            case NORTH:
                if (getBlock().getSouthernStation() != null) addIncomingNeighbor(Direction.SOUTHEAST, getBlock().getSouthernStation());
                block = getBlock().getWesternNeighbor();
                if (block != null) {
                    station = block.getNorthernStation();
                    if (station != null) addIncomingNeighbor(Direction.NORTHWEST,station);
                }
                block = getBlock().getSouthernNeighbor();
                if (block != null) {
                    station = block.getWesternStation();
                    if (station != null) addIncomingNeighbor(Direction.SOUTH, station);
                }
            case EAST:
                if (getBlock().getWesternStation() != null) addIncomingNeighbor(Direction.SOUTHWEST, getBlock().getWesternStation());
                block = getBlock().getNorthernNeighbor();
                if (block != null) {
                    station = block.getEasternStation();
                    if (station != null) addIncomingNeighbor(Direction.NORTHEAST, station);
                }
                block = getBlock().getWesternNeighbor();
                if (block != null) {
                    station = block.getNorthernStation();
                    if (station != null) addIncomingNeighbor(Direction.WEST, station);
                }
            case SOUTH:
                if (getBlock().getNorthernStation() != null) addIncomingNeighbor(Direction.NORTHWEST, getBlock().getNorthernStation());
                block = getBlock().getEasternNeighbor();
                if (block != null) {
                    station = block.getSouthernStation();
                    if (station != null) addIncomingNeighbor(Direction.SOUTHEAST, station);
                }
                block = getBlock().getNorthernNeighbor();
                if (block != null) {
                    station = block.getEasternStation();
                    if (station != null) addIncomingNeighbor(Direction.NORTH, station);
                }
            case WEST:
                if (getBlock().getEasternStation() != null) addIncomingNeighbor(Direction.NORTHEAST, getBlock().getEasternStation());
                block = getBlock().getSouthernNeighbor();
                if (block != null) {
                   station = block.getWesternStation();
                   if (station != null) addIncomingNeighbor(Direction.SOUTHWEST, station);
                }
                block = getBlock().getEasternNeighbor();
                if (block != null) {
                    station = block.getSouthernStation();
                    if (station != null) addIncomingNeighbor(Direction.EAST, station);
                }
            default:
                System.out.println("Could not set block neighbor");
        }
    } //

    public ArrayList<Station> getIncomingBlockStations () {
        Block block = null;
        Station station = null;
        ArrayList<Station> neighbors = new ArrayList<Station>();

        switch (busDirection) {
            case NORTH:
                block = getBlock().getWesternNeighbor();
                if (block != null && block.getNorthernStation() != null) neighbors.add(neighbors.size(), block.getNorthernStation());
                block = getBlock().getSouthWesternNeighbor();
                if (block != null && block.getNorthernStation() != null) neighbors.add(neighbors.size(), block.getNorthernStation());
            case EAST:
                block = getBlock().getNorthernNeighbor();
                if (block != null) {
                    station = block.getWesternStation();
                    if (station != null) neighbors.add(neighbors.size(), station);
                    station = block.getEasternStation();
                    if (station != null) neighbors.add(neighbors.size(), station);
                }
//                block.getEasternStation() != null) neighbors.add(neighbors.size(), block.getEasternStation());
//                block = getBlock().getEasternNeighbor();
//                if (block != null && block.getWesternStation() != null) neighbors.add(neighbors.size(), block.getWesternStation());
            case SOUTH:
                block = getBlock().getEasternNeighbor();
                if (block != null && block.getSouthernStation() != null) neighbors.add(neighbors.size(), block.getSouthernStation());
                block = getBlock().getSouthWesternNeighbor();
            case WEST:
                block = getBlock().getSouthernNeighbor();
                if (block != null && block.getNorthernStation() != null) neighbors.add(neighbors.size(), block.getNorthernStation());
            default:
                System.out.println("Could not set block neighbor");
        }
        return neighbors;
    } //

    public Station getAdjacentIncomingStation () {
        switch (busDirection) {
            case NORTH:
                return getBlock().getSouthernStation();
            case EAST:
                return getBlock().getWesternStation();
            case SOUTH:
                return getBlock().getNorthernStation();
            case WEST:
                return getBlock().getEasternStation();
            default:
                System.out.println("Could not set block neighbor");
        }
        return null;
    } //

    public Station getAdjacentOutgoingStation () {
        switch (busDirection) {
            case NORTH:
                return getBlock().getSouthernStation();
            case EAST:
                return getBlock().getWesternStation();
            case SOUTH:
                return getBlock().getNorthernStation();
            case WEST:
                return getBlock().getEasternStation();
            default:
                System.out.println("Could not set block neighbor");
        }
        return null;
    } //


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
//        Station adjacentIncoming = getIncomingBlockStation();
        String string =  getName() + getOrientation().abbreviation() // + super.toString()
//                + " " + busDirection.print() + " bound"
//            + " " + getOrientation().abbreviation()
//            + " " + getRoad().toString()
            + " " + printIncomingNeighbors();
//        if (adjacentIncoming != null) {
//            string += " " + adjacentIncoming.getName() + adjacentIncoming.getOrientation().abbreviation();
//        }
        return string;
//            + " " + printOutgoingNeighbors()
//            + " " + printBusRoutes();
    } // close toString

    public String printBusRoutes () {
        StringBuilder string = new StringBuilder("[BusRoutes:");
        for (String busRouteName : busRouteNames) {
            string.append(busRouteName).append(" ");
        }
        return (string.toString().trim() + "]");
    } // close printBusRoutes

    public String printIncomingNeighbors () { return  "[Incoming Neighbors-> " + printMap(incomingNeighbors) + "]"; }
    public String printOutgoingNeighbors () { return  "[Outgoing Neighbors-> " + printMap(outgoingNeighbors) + "]"; }

    private String printMap (HashMap<Direction, Station> map) {
        StringBuilder builder = new StringBuilder();
        for (HashMap.Entry<Direction, Station> entry : map.entrySet()) {
            Direction orientation  = entry.getKey();
            Station station = entry.getValue();
            builder.append(station.getName()).append(orientation.abbreviation()).append(" ");
        }
        return (String) builder.toString().trim();
    } // close printNeigbors
} // end class Station