package com.lawal.transit.core.concretes;

import com.lawal.transit.core.abstracts.*;
import com.lawal.transit.core.enums.Direction;
import com.lawal.transit.core.singletons.*;

import java.util.*;

public class Station extends Location {

    private HashMap<Direction, Station> incomingNeighbors;
    private HashMap<Direction, Station> outgoingNeighbors;

    private Direction busDirection;

    public Station (int id, String name, Block block, Direction busDirection) {
        super(id, name, block, Block.borderOrientation(busDirection));
        this.incomingNeighbors = new HashMap<Direction, Station>();
        this.outgoingNeighbors = new HashMap<Direction, Station>();
        this.busDirection = busDirection;
        block.addStation(Block.borderOrientation(busDirection), name);
    }

    public Direction getBlockBorderOrientation () { return getOrientation(); }

    public Direction getBusDirection () { return busDirection; }

    public HashMap<Direction, Station> getIncomingNeighbors () { return incomingNeighbors; }

    public HashMap<Direction, Station> getOutgoingNeighbors () { return outgoingNeighbors; }


    public ArrayList<BusRoute> getBusRoutes () {
        ArrayList<BusRoute> matches = new ArrayList<>();

        for (RegularBusRoute route : RegularBusRoutes.INSTANCE.getRoutes()) {
            if (route.getSchedule().containsValue(this) && !matches.contains(route))
                matches.add(matches.size(), route);
        }

        for (ExpressBusRoute route : ExpressBusRoutes.INSTANCE.getRoutes()) {
            if (route.getSchedule().containsValue(this) && !matches.contains(route))
                matches.add(matches.size(), route);
        }
        return matches;
    }

    public void addIncomingNeighbor (Station station) {
        incomingNeighbors.put(station.getOrientation(), station);
    }


    public void addIncomingNeighbor (Direction orientation,  Station station) { incomingNeighbors.put(orientation,  station); }

    public void addOutGoingNeighbor (Station station) {
        outgoingNeighbors.put(station.getOrientation(), station);
    }

    public void addOutgoingNeighbor (Direction orientation, Station station) { outgoingNeighbors.put(orientation, station); }


    @Override
    public boolean equals (Object object) {
        if (object instanceof Station station) {
            return super.equals(station);
        }
        return false;
    } // close equals

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), busDirection);
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
                break;
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
                break;
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
                break;
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
                break;
            default:
                System.out.println(getName() + " Could not set outgoing station neighbor for " + busDirection.abbreviation()) ;
                break;
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
                break;
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
                break;
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
                break;
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
                break;
            default:
                System.out.println(getName() +  " Could not set incoming station neighbor for " + busDirection.abbreviation());
                break;
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
                break;
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
                break;
            case SOUTH:
                block = getBlock().getEasternNeighbor();
                if (block != null && block.getSouthernStation() != null) neighbors.add(neighbors.size(), block.getSouthernStation());
                block = getBlock().getSouthWesternNeighbor();
                break;
            case WEST:
                block = getBlock().getSouthernNeighbor();
                if (block != null && block.getNorthernStation() != null) neighbors.add(neighbors.size(), block.getNorthernStation());
                break;
            default:
                System.out.println("Could not set block neighbor");
                break;
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
                System.out.println(getName() + " Could not find adjacent incoming station returning null");
                return null;
        }
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
                System.out.println(getName() + " Could not find adjacent outgoing station returning null");
                return null;
        }
    } //


    @Override
    public String toString () {
//        Station adjacentIncoming = getIncomingBlockStation();
        String string =  "id:" + getId() + " " + getName() + getOrientation().abbreviation() // + super.toString()
            + printIncomingNeighbors()
            + printOutgoingNeighbors()
            + printBusRoutes();
//                + " " + busDirection.print() + " bound"
//            + " " + getOrientation().abbreviation()
//            + " " + getRoad().toString()
//            + " " + printIncomingNeighbors();
//        if (adjacentIncoming != null) {
//            string += " " + adjacentIncoming.getName() + adjacentIncoming.getOrientation().abbreviation();
//        }
        return string;
//            + " " + printOutgoingNeighbors()
//            + " " + printBusRoutes();
    } // close toString

    public String printBusRoutes () {
        StringBuilder string = new StringBuilder("[BusRoutes:");
        for (BusRoute busRoute : getBusRoutes()) {
            string.append(busRoute.getName()).append(busDirection.abbreviation()).append(" ");
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