package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.NamedEntity;
import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.enums.Direction;
import com.lawal.transit.core.interfaces.Graphable;

import java.util.*;

public class Block extends NamedEntity { //implements Graphable<Block> {
    private HashMap<Direction, Block> neighbors;
    private final HashMap<Direction, Road> borders;
    private final HashMap<Direction, Intersection> corners;

    public Block (int id, String name, Intersection northWestCorner, Intersection northEastCorner, Intersection southEastCorner, Intersection southWestCorner) {
        super(id, name);
        this.neighbors = new HashMap<Direction, Block>();

        this.corners = new HashMap<Direction, Intersection>();
        corners.put(Direction.NORTHWEST, northWestCorner);
        corners.put(Direction.NORTHEAST, northEastCorner);
        corners.put(Direction.SOUTHEAST, southEastCorner);
        corners.put(Direction.SOUTHWEST, southWestCorner);

        this.borders = new HashMap<Direction, Road>();
        borders.put(Direction.WEST, corners.get(Direction.NORTHWEST).getAvenue());
        borders.put(Direction.NORTH, corners.get(Direction.NORTHWEST).getStreet());
        borders.put(Direction.EAST, corners.get(Direction.NORTHEAST).getAvenue());
        borders.put(Direction.SOUTH, corners.get(Direction.SOUTHWEST).getStreet());
    } // close constructor

    public Intersection getNorthWestCorner () { return corners.get(Direction.NORTHWEST); }

    public Intersection getNorthEastCorner () { return corners.get(Direction.NORTHEAST); }

    public Intersection getSouthEastCorner () { return corners.get(Direction.SOUTHEAST); }

    public Intersection getSouthWestCorner () { return corners.get(Direction.SOUTHWEST); }

    public Avenue getWesternAvenue() { return (Avenue) borders.get(Direction.WEST);}

    public Avenue getEasternAvenue() { return (Avenue)  borders.get(Direction.EAST); }

    public Street getNorthernStreet() { return (Street) borders.get(Direction.NORTH); }

    public Street getSouthernStreet() { return (Street) borders.get(Direction.SOUTH); }

    public Block getNorthernNeighbor () { return neighbors.get(Direction.NORTH); }

    public Block getNorthEasternNeighbor () { return neighbors.get(Direction.NORTHEAST); }

    public Block getEasternNeighbor () { return neighbors.get(Direction.EAST); }

    public Block getSouthEasternNeighbor () { return neighbors.get(Direction.SOUTHEAST); }

    public Block getSouthernNeighbor () { return neighbors.get(Direction.SOUTH); }

    public Block getSouthWesternNeighbor () { return neighbors.get(Direction.SOUTHWEST); }

    public Block getWesternNeighbor () { return neighbors.get(Direction.WEST); }

    public HashMap<Direction, Intersection> getCorners () { return corners; }

    public HashMap<Direction, Road> getBorders () { return borders; }

    public HashMap<Direction, Block> getNeighbors () { return neighbors; }

    public Road getBorderRoad (Direction borderOrientation) {
        switch (borderOrientation) {
            case NORTH:
                return borders.get(Direction.NORTH);
            case EAST:
                return borders.get(Direction.EAST);
            case SOUTH:
                return borders.get(Direction.SOUTH);
            case WEST:
                return borders.get(Direction.WEST);
            default:
                System.out.println("Could not set block neighbor");
        }
        return null;
    }

    public void addNeighbor (Direction direction, Block block) {
        switch (direction) {
            case NORTH:
                neighbors.put(Direction.NORTH, block);
                break;
            case NORTHEAST:
                neighbors.put(Direction.NORTHEAST, block);
                break;
            case EAST:
                neighbors.put(Direction.EAST, block);
                break;
            case SOUTHEAST:
                neighbors.put(Direction.SOUTHEAST, block);
                break;
            case SOUTH:
                neighbors.put(Direction.SOUTH, block);
                break;
            case SOUTHWEST:
                neighbors.put(Direction.SOUTHWEST, block);
                break;
            case WEST:
                neighbors.put(Direction.WEST, block);
            case NORTHWEST:
                neighbors.put(Direction.NORTHWEST, block);
                break;
            default:
                System.out.println("Could not set block neighbor");
        }
    } //


    public void removeNeighbor (Direction orientation, Block neighbor) {
        neighbors.remove(orientation, neighbor);
    } // close removeNeighbor

    @Override
    public boolean equals (Object object) {
        if (object instanceof Block block) return super.equals(block) && sameCorners(block);
        return false;
    } // close equals

    @Override
    public int hashCode () { return Objects.hash(super.hashCode(), corners); }

    @Override
    public String toString () {
        return super.toString() + " " + printCorners() + " " + printBorders() + " " + printNeighbors(); // ;
//        return super.toString() + " " + corners.toString() + " " + printNeighbors() + " " + borders.toString();
    } // close toString

    public String printBorders () {
        StringBuilder builder = new StringBuilder("[");
        borders.forEach(((direction, borderRoad) -> builder.append(direction.abbreviation()).append(":").append(borderRoad.toString()).append(", ")));
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        return builder.toString() + "]";
    }

    public String printCorners () {
        StringBuilder builder = new StringBuilder("[");
        corners.forEach(((direction, intersection) -> builder.append(printCorner(direction)).append(" ")));
        return builder.toString().trim() + "]";
    }

    public String printNeighbors () {
        StringBuilder builder = new StringBuilder("[" + getName() + "_Neighbors->");
        neighbors.forEach(((direction, block) -> builder.append(printNeighbor(direction)).append(" ")));
        return (String) builder.toString().trim() + "]";
    } // close printNeigbors

    private String printNeighbor (Direction orientation) { return orientation.abbreviation() + ":" + neighbors.get(orientation).getName(); }

    private String printCorner (Direction orientation) { return orientation.abbreviation() + ":" + corners.get(orientation).getName(); }


    private boolean sameCorners (Block block) {
        return (getNorthWestCorner().equals(block.getNorthWestCorner())
            && getNorthEastCorner().equals(block.getNorthEastCorner())
            && getSouthEastCorner().equals(block.getSouthEastCorner())
            && getSouthWestCorner().equals(block.getSouthWestCorner())
        );
    }

    public static Direction borderOrientation (Direction travelDirection) {
        switch (travelDirection) {
            case NORTH:
                return Direction.WEST;
            case EAST:
                return Direction.NORTH;
            case SOUTH:
                return Direction.EAST;
            case WEST:
                return Direction.SOUTH;
            default:
                break;
        }
        return Direction.NONE;
    }
} // end class Block
