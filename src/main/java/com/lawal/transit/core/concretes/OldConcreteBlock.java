package com.lawal.transit.core.concretes;

import com.lawal.transit.core.abstracts.*;
import com.lawal.transit.core.abstracts.NamedEntity;
import com.lawal.transit.Orientation;
import com.lawal.transit.core.singletons.Stations;

import java.util.*;

public class OldConcreteBlock extends NamedEntity {
    private HashMap<Orientation, OldConcreteBlock> neighbors;
    private final HashMap<Orientation, AbstractRoad> borders;
    private final HashMap<Orientation, Intersection> corners;
    private final HashMap<Orientation, String> stations;

    public OldConcreteBlock (int id, String name, Intersection northWestCorner, Intersection northEastCorner, Intersection southEastCorner, Intersection southWestCorner) {
        super(id, name);
        this.neighbors = new HashMap<Orientation, OldConcreteBlock>();
        this.stations = new HashMap<Orientation, String>();

        this.corners = new HashMap<Orientation, Intersection>();
        corners.put(Orientation.NORTHWEST, northWestCorner);
        corners.put(Orientation.NORTHEAST, northEastCorner);
        corners.put(Orientation.SOUTHEAST, southEastCorner);
        corners.put(Orientation.SOUTHWEST, southWestCorner);

        this.borders = new HashMap<Orientation, AbstractRoad>();
        borders.put(Orientation.WEST, corners.get(Orientation.NORTHWEST).getAvenue());
        borders.put(Orientation.NORTH, corners.get(Orientation.NORTHWEST).getStreet());
        borders.put(Orientation.EAST, corners.get(Orientation.NORTHEAST).getAvenue());
        borders.put(Orientation.SOUTH, corners.get(Orientation.SOUTHWEST).getStreet());
    } // close constructor

    public Intersection getNorthWestCorner () { return corners.get(Orientation.NORTHWEST); }

    public Intersection getNorthEastCorner () { return corners.get(Orientation.NORTHEAST); }

    public Intersection getSouthEastCorner () { return corners.get(Orientation.SOUTHEAST); }

    public Intersection getSouthWestCorner () { return corners.get(Orientation.SOUTHWEST); }

    public ConcreteAvenue getWesternAvenue() { return (ConcreteAvenue) borders.get(Orientation.WEST);}

    public ConcreteAvenue getEasternAvenue() { return (ConcreteAvenue)  borders.get(Orientation.EAST); }

    public ConcreteStreet getNorthernStreet() { return (ConcreteStreet) borders.get(Orientation.NORTH); }

    public ConcreteStreet getSouthernStreet() { return (ConcreteStreet) borders.get(Orientation.SOUTH); }

    public OldConcreteBlock getNorthernNeighbor () { return neighbors.get(Orientation.NORTH); }

    public OldConcreteBlock getNorthEasternNeighbor () { return neighbors.get(Orientation.NORTHEAST); }

    public OldConcreteBlock getEasternNeighbor () { return neighbors.get(Orientation.EAST); }

    public OldConcreteBlock getSouthEasternNeighbor () { return neighbors.get(Orientation.SOUTHEAST); }

    public OldConcreteBlock getSouthernNeighbor () { return neighbors.get(Orientation.SOUTH); }

    public OldConcreteBlock getSouthWesternNeighbor () { return neighbors.get(Orientation.SOUTHWEST); }

    public OldConcreteBlock getWesternNeighbor () { return neighbors.get(Orientation.WEST); }

    public OldConcreteBlock getNorthWesternNeighbor () { return neighbors.get(Orientation.NORTHWEST); }

    public OldAbstractStation getNorthernStation () { return getStation(Orientation.NORTH); }

    public OldAbstractStation getEasternStation () { return getStation(Orientation.EAST); }

    public OldAbstractStation getSouthernStation () { return getStation(Orientation.SOUTH); }

    public OldAbstractStation getWesternStation () { return getStation(Orientation.WEST); }
    public HashMap<Orientation, String> getStations () { return stations; }
    public HashMap<Orientation, Intersection> getCorners () { return corners; }

    public HashMap<Orientation, AbstractRoad> getBorders () { return borders; }

    public HashMap<Orientation, OldConcreteBlock> getNeighbors () { return neighbors; }

    public OldAbstractStation getStation (Orientation borderOrientation) {
        switch (borderOrientation) {
            case NORTH:
                return Stations.INSTANCE.search(stations.get(Orientation.NORTH));
            case EAST:
                return Stations.INSTANCE.search(stations.get(Orientation.EAST));
            case SOUTH:
                return Stations.INSTANCE.search(stations.get(Orientation.SOUTH));
            case WEST:
                return Stations.INSTANCE.search(stations.get(Orientation.WEST));
            default:
                System.out.println(getName() + " does not have a " + borderOrientation.abbreviation() + " station returning null");
                return null;
        }
    } //

    public AbstractRoad getBorderRoad (Orientation borderOrientation) {
        switch (borderOrientation) {
            case NORTH:
                return borders.get(Orientation.NORTH);
            case EAST:
                return borders.get(Orientation.EAST);
            case SOUTH:
                return borders.get(Orientation.SOUTH);
            case WEST:
                return borders.get(Orientation.WEST);
            default:
                System.out.println(getName() + " does not have a " + borderOrientation.abbreviation() + " border rodad returning null");
                return null;
        }
    } //

    public void addNeighbor (Orientation orientation, OldConcreteBlock concreteBlock) {
        switch (orientation) {
            case NORTH:
                neighbors.put(Orientation.NORTH, concreteBlock);
                break;
            case NORTHEAST:
                neighbors.put(Orientation.NORTHEAST, concreteBlock);
                break;
            case EAST:
                neighbors.put(Orientation.EAST, concreteBlock);
                break;
            case SOUTHEAST:
                neighbors.put(Orientation.SOUTHEAST, concreteBlock);
                break;
            case SOUTH:
                neighbors.put(Orientation.SOUTH, concreteBlock);
                break;
            case SOUTHWEST:
                neighbors.put(Orientation.SOUTHWEST, concreteBlock);
                break;
            case WEST:
                neighbors.put(Orientation.WEST, concreteBlock);
            case NORTHWEST:
                neighbors.put(Orientation.NORTHWEST, concreteBlock);
                break;
            default:
                System.out.println(getName() + " Could not set " + concreteBlock.getName() + " as " + orientation.abbreviation() + " neighboring concreteBlock");
                break;
        }
    } //

    public void addStation (Orientation orientation, OldAbstractStation oldAbstractStation) {
        addStation(orientation, oldAbstractStation.getName());
    } //

    public void addStation (Orientation orientation, String stationName) {
        switch (orientation) {
            case NORTH:
                stations.put(Orientation.NORTH, stationName);
                break;
            case EAST:
                stations.put(Orientation.EAST, stationName);
                break;
            case SOUTH:
                stations.put(Orientation.SOUTH, stationName);
                break;
            case WEST:
                stations.put(Orientation.WEST, stationName);
                break;
            default:
                System.out.println(getName() + " Could not set " + stationName + " as " + orientation.abbreviation() + " station");
                break;
        }
    } //

    public void removeNeighbor (Orientation orientation, OldConcreteBlock neighbor) {
        neighbors.remove(orientation, neighbor);
    } // close removeNeighbor

    @Override
    public boolean equals (Object object) {
        if (object instanceof OldConcreteBlock concreteBlock) return super.equals(concreteBlock) && sameCorners(concreteBlock);
        return false;
    } // close equals

    @Override
    public int hashCode () { return Objects.hash(super.hashCode(), corners); }


    @Override
    public String toString () {
        return super.toString()
            + " " + printCorners()
            + " " + printBorders()
            + " " + printNeighbors()
            + " " + printStations(); // ;
//        return super.toString() + " " + corners.toString() + " " + printNeighbors() + " " + borders.toString();
    } // close toString
//    @Override
//    public String toString () {
//        return super.toString() + " " + printCorners() + " " + printBorders() + " " + printNeighbors(); // ;
//       return super.toString() + " " + corners.toString() + " " + printNeighbors() + " " + borders.toString();
//    } // close toString

    public String printBorders () {
        StringBuilder builder = new StringBuilder("[");
        borders.forEach(((direction, borderRoad) -> builder.append(direction.abbreviation()).append(":").append(borderRoad.toString()).append(", ")));
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        return builder.toString() + "]";
    } //

    public String printStations () {
        StringBuilder builder = new StringBuilder("[");
        stations.forEach(((direction, stationName) -> builder.append(stationName).append(direction.abbreviation()).append(", ")));
//        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        return builder.toString() + "]";
    } //

    public String printCorners () {
        StringBuilder builder = new StringBuilder("[");
        corners.forEach(((direction, intersection) -> builder.append(printCorner(direction)).append(" ")));
        return builder.toString().trim() + "]";
    } //

    public String printNeighbors () {
        StringBuilder builder = new StringBuilder("[" + getName() + "_Neighbors->");
        neighbors.forEach(((direction, block) -> builder.append(printNeighbor(direction)).append(" ")));
        return (String) builder.toString().trim() + "]";
    } // close printNeigbors

    private String printNeighbor (Orientation orientation) { return orientation.abbreviation() + ":" + neighbors.get(orientation).getName(); }

    private String printCorner (Orientation orientation) { return orientation.abbreviation() + ":" + corners.get(orientation).getName(); }

    private String printMap (HashMap<Orientation, NamedEntity> map) {
        StringBuilder builder = new StringBuilder();
        map.forEach(((direction, ne) -> builder.append(ne.getName()).append(direction.abbreviation()).append(" ")));
        return builder.toString().trim();
    }


    private boolean sameCorners (OldConcreteBlock concreteBlock) {
        return (getNorthWestCorner().equals(concreteBlock.getNorthWestCorner())
            && getNorthEastCorner().equals(concreteBlock.getNorthEastCorner())
            && getSouthEastCorner().equals(concreteBlock.getSouthEastCorner())
            && getSouthWestCorner().equals(concreteBlock.getSouthWestCorner())
        );
    } //

    public static Orientation borderOrientation (Orientation travelOrientation) {
        switch (travelOrientation) {
            case NORTH:
                return Orientation.WEST;
            case EAST:
                return Orientation.NORTH;
            case SOUTH:
                return Orientation.EAST;
            case WEST:
                return Orientation.SOUTH;
            default:
                break;
        }
        return Orientation.NONE;
    }
} // end class OldConcreteBlock
