package com.lawal.transit.core.concretes;

import com.lawal.transit.core.abstracts.*;
import com.lawal.transit.Orientation;
import com.lawal.transit.core.singletons.*;

import java.util.*;

public class OldAbstractStation extends AbstractLocation {

    private HashMap<Orientation, OldAbstractStation> incomingNeighbors;
    private HashMap<Orientation, OldAbstractStation> outgoingNeighbors;

    private Orientation busOrientation;

    public OldAbstractStation (int id, String name, OldConcreteBlock concreteBlock, Orientation busOrientation) {
        super(id, name, concreteBlock, OldConcreteBlock.borderOrientation(busOrientation));
        this.incomingNeighbors = new HashMap<Orientation, OldAbstractStation>();
        this.outgoingNeighbors = new HashMap<Orientation, OldAbstractStation>();
        this.busOrientation = busOrientation;
        concreteBlock.addStation(OldConcreteBlock.borderOrientation(busOrientation), name);
    }

    public Orientation getBlockBorderOrientation () { return getOrientation(); }

    public Orientation getBusDirection () { return busOrientation; }

    public HashMap<Orientation, OldAbstractStation> getIncomingNeighbors () { return incomingNeighbors; }

    public HashMap<Orientation, OldAbstractStation> getOutgoingNeighbors () { return outgoingNeighbors; }


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

    public void addIncomingNeighbor (OldAbstractStation oldAbstractStation) {
        incomingNeighbors.put(oldAbstractStation.getOrientation(), oldAbstractStation);
    }


    public void addIncomingNeighbor (Orientation orientation, OldAbstractStation oldAbstractStation) { incomingNeighbors.put(orientation, oldAbstractStation); }

    public void addOutGoingNeighbor (OldAbstractStation oldAbstractStation) {
        outgoingNeighbors.put(oldAbstractStation.getOrientation(), oldAbstractStation);
    }

    public void addOutgoingNeighbor (Orientation orientation, OldAbstractStation oldAbstractStation) { outgoingNeighbors.put(orientation, oldAbstractStation); }


    @Override
    public boolean equals (Object object) {
        if (object instanceof OldAbstractStation oldAbstractStation) {
            return super.equals(oldAbstractStation);
        }
        return false;
    } // close equals

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), busOrientation);
    }

    public OldConcreteBlock getAdjacentOutgoingBlock () {
        return null;
    }

    public OldConcreteBlock getAdjacentIncomingBlock () {
        return null;
    }

    public void setOutgoingNeighbors () {
        OldConcreteBlock concreteBlock = null;
        OldAbstractStation oldAbstractStation = null;

        switch (busOrientation) {
            case NORTH:
                if (getBlock().getNorthernStation() != null) addOutgoingNeighbor(Orientation.NORTHEAST, getBlock().getNorthernStation());
                concreteBlock = getBlock().getWesternNeighbor();
                if (concreteBlock != null) {
                    oldAbstractStation = concreteBlock.getSouthernStation();
                    if (oldAbstractStation != null) {
                        addOutgoingNeighbor(Orientation.SOUTHWEST, oldAbstractStation);
                    }
                }
                concreteBlock = getBlock().getNorthernNeighbor();
                if (concreteBlock != null) {
                    oldAbstractStation = concreteBlock.getWesternStation();
                    if (oldAbstractStation != null) addOutgoingNeighbor(Orientation.NORTH, oldAbstractStation);
                }
                break;
            case EAST:
                if (getBlock().getEasternStation() != null) addOutgoingNeighbor(Orientation.SOUTHEAST, getBlock().getEasternStation());
                concreteBlock = getBlock().getNorthernNeighbor();
                if (concreteBlock != null) {
                    oldAbstractStation = concreteBlock.getWesternStation();
                    if (oldAbstractStation != null) addOutgoingNeighbor(Orientation.NORTHWEST, oldAbstractStation);
                }
                concreteBlock = getBlock().getEasternNeighbor();
                if (concreteBlock != null) {
                    oldAbstractStation = concreteBlock.getNorthernStation();
                    if (oldAbstractStation != null) addOutgoingNeighbor(Orientation.EAST, oldAbstractStation);
                }
                break;
            case SOUTH:
                if (getBlock().getSouthernStation() != null) addOutgoingNeighbor(Orientation.SOUTHWEST, getBlock().getSouthernStation());
                concreteBlock = getBlock().getEasternNeighbor();
                if (concreteBlock != null) {
                    oldAbstractStation = concreteBlock.getNorthernStation();
                    if (oldAbstractStation != null) addOutgoingNeighbor(Orientation.NORTHEAST, oldAbstractStation);
                }
                concreteBlock = getBlock().getSouthernNeighbor();
                if (concreteBlock != null) {
                    oldAbstractStation = concreteBlock.getEasternStation();
                    if (oldAbstractStation != null) addOutgoingNeighbor(Orientation.SOUTH, oldAbstractStation);
                }
                break;
            case WEST:
                if (getBlock().getWesternStation() != null) addOutgoingNeighbor(Orientation.NORTHWEST, getBlock().getWesternStation());
                concreteBlock = getBlock().getSouthernNeighbor();
                if (concreteBlock != null) {
                    oldAbstractStation = concreteBlock.getEasternStation();
                    if (oldAbstractStation != null) addOutgoingNeighbor(Orientation.SOUTHEAST, oldAbstractStation);
                }
                concreteBlock = getBlock().getWesternNeighbor();
                if (concreteBlock != null) {
                    oldAbstractStation = concreteBlock.getSouthernStation();
                    if (oldAbstractStation != null) addOutgoingNeighbor(Orientation.WEST, oldAbstractStation);
                }
                break;
            default:
                System.out.println(getName() + " Could not set outgoing oldAbstractStation neighbor for " + busOrientation.abbreviation()) ;
                break;
        }
    } //


    public void setIncomingNeighbors () {
        OldConcreteBlock concreteBlock = null;
        OldAbstractStation oldAbstractStation = null;

        switch (busOrientation) {
            case NORTH:
                if (getBlock().getSouthernStation() != null) addIncomingNeighbor(Orientation.SOUTHEAST, getBlock().getSouthernStation());
                concreteBlock = getBlock().getWesternNeighbor();
                if (concreteBlock != null) {
                    oldAbstractStation = concreteBlock.getNorthernStation();
                    if (oldAbstractStation != null) addIncomingNeighbor(Orientation.NORTHWEST, oldAbstractStation);
                }
                concreteBlock = getBlock().getSouthernNeighbor();
                if (concreteBlock != null) {
                    oldAbstractStation = concreteBlock.getWesternStation();
                    if (oldAbstractStation != null) addIncomingNeighbor(Orientation.SOUTH, oldAbstractStation);
                }
                break;
            case EAST:
                if (getBlock().getWesternStation() != null) addIncomingNeighbor(Orientation.SOUTHWEST, getBlock().getWesternStation());
                concreteBlock = getBlock().getNorthernNeighbor();
                if (concreteBlock != null) {
                    oldAbstractStation = concreteBlock.getEasternStation();
                    if (oldAbstractStation != null) addIncomingNeighbor(Orientation.NORTHEAST, oldAbstractStation);
                }
                concreteBlock = getBlock().getWesternNeighbor();
                if (concreteBlock != null) {
                    oldAbstractStation = concreteBlock.getNorthernStation();
                    if (oldAbstractStation != null) addIncomingNeighbor(Orientation.WEST, oldAbstractStation);
                }
                break;
            case SOUTH:
                if (getBlock().getNorthernStation() != null) addIncomingNeighbor(Orientation.NORTHWEST, getBlock().getNorthernStation());
                concreteBlock = getBlock().getEasternNeighbor();
                if (concreteBlock != null) {
                    oldAbstractStation = concreteBlock.getSouthernStation();
                    if (oldAbstractStation != null) addIncomingNeighbor(Orientation.SOUTHEAST, oldAbstractStation);
                }
                concreteBlock = getBlock().getNorthernNeighbor();
                if (concreteBlock != null) {
                    oldAbstractStation = concreteBlock.getEasternStation();
                    if (oldAbstractStation != null) addIncomingNeighbor(Orientation.NORTH, oldAbstractStation);
                }
                break;
            case WEST:
                if (getBlock().getEasternStation() != null) addIncomingNeighbor(Orientation.NORTHEAST, getBlock().getEasternStation());
                concreteBlock = getBlock().getSouthernNeighbor();
                if (concreteBlock != null) {
                   oldAbstractStation = concreteBlock.getWesternStation();
                   if (oldAbstractStation != null) addIncomingNeighbor(Orientation.SOUTHWEST, oldAbstractStation);
                }
                concreteBlock = getBlock().getEasternNeighbor();
                if (concreteBlock != null) {
                    oldAbstractStation = concreteBlock.getSouthernStation();
                    if (oldAbstractStation != null) addIncomingNeighbor(Orientation.EAST, oldAbstractStation);
                }
                break;
            default:
                System.out.println(getName() +  " Could not set incoming oldAbstractStation neighbor for " + busOrientation.abbreviation());
                break;
        }
    } //

    public ArrayList<OldAbstractStation> getIncomingBlockStations () {
        OldConcreteBlock concreteBlock = null;
        OldAbstractStation oldAbstractStation = null;
        ArrayList<OldAbstractStation> neighbors = new ArrayList<OldAbstractStation>();

        switch (busOrientation) {
            case NORTH:
                concreteBlock = getBlock().getWesternNeighbor();
                if (concreteBlock != null && concreteBlock.getNorthernStation() != null) neighbors.add(neighbors.size(), concreteBlock.getNorthernStation());
                concreteBlock = getBlock().getSouthWesternNeighbor();
                if (concreteBlock != null && concreteBlock.getNorthernStation() != null) neighbors.add(neighbors.size(), concreteBlock.getNorthernStation());
                break;
            case EAST:
                concreteBlock = getBlock().getNorthernNeighbor();
                if (concreteBlock != null) {
                    oldAbstractStation = concreteBlock.getWesternStation();
                    if (oldAbstractStation != null) neighbors.add(neighbors.size(), oldAbstractStation);
                    oldAbstractStation = concreteBlock.getEasternStation();
                    if (oldAbstractStation != null) neighbors.add(neighbors.size(), oldAbstractStation);
                }
//                concreteBlock.getEasternStation() != null) neighbors.add(neighbors.size(), concreteBlock.getEasternStation());
//                concreteBlock = getBlock().getEasternNeighbor();
//                if (concreteBlock != null && concreteBlock.getWesternStation() != null) neighbors.add(neighbors.size(), concreteBlock.getWesternStation());
                break;
            case SOUTH:
                concreteBlock = getBlock().getEasternNeighbor();
                if (concreteBlock != null && concreteBlock.getSouthernStation() != null) neighbors.add(neighbors.size(), concreteBlock.getSouthernStation());
                concreteBlock = getBlock().getSouthWesternNeighbor();
                break;
            case WEST:
                concreteBlock = getBlock().getSouthernNeighbor();
                if (concreteBlock != null && concreteBlock.getNorthernStation() != null) neighbors.add(neighbors.size(), concreteBlock.getNorthernStation());
                break;
            default:
                System.out.println("Could not set concreteBlock neighbor");
                break;
        }
        return neighbors;
    } //

    public OldAbstractStation getAdjacentIncomingStation () {
        switch (busOrientation) {
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

    public OldAbstractStation getAdjacentOutgoingStation () {
        switch (busOrientation) {
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
//        OldAbstractStation adjacentIncoming = getIncomingBlockStation();
        String string =  "id:" + getId() + " " + getName() + getOrientation().abbreviation() // + super.toString()
            + printIncomingNeighbors()
            + printOutgoingNeighbors()
            + printBusRoutes();
//                + " " + busOrientation.print() + " bound"
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
            string.append(busRoute.getName()).append(busOrientation.abbreviation()).append(" ");
        }
        return (string.toString().trim() + "]");
    } // close printBusRoutes

    public String printIncomingNeighbors () { return  "[Incoming Neighbors-> " + printMap(incomingNeighbors) + "]"; }
    public String printOutgoingNeighbors () { return  "[Outgoing Neighbors-> " + printMap(outgoingNeighbors) + "]"; }

    private String printMap (HashMap<Orientation, OldAbstractStation> map) {
        StringBuilder builder = new StringBuilder();
        for (HashMap.Entry<Orientation, OldAbstractStation> entry : map.entrySet()) {
            Orientation orientation  = entry.getKey();
            OldAbstractStation oldAbstractStation = entry.getValue();
            builder.append(oldAbstractStation.getName()).append(orientation.abbreviation()).append(" ");
        }
        return (String) builder.toString().trim();
    } // close printNeigbors
} // end class OldAbstractStation