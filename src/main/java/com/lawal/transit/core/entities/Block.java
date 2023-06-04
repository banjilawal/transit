package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.NamedEntity;
import com.lawal.transit.core.interfaces.Graphable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Block extends NamedEntity implements Graphable<Block> {
    private Avenue westAvenue;
    private Avenue eastAvenue;
    private Street northStreet;
    private Street southStreet;
    private ArrayList<Block> neighbors;

    public Block (int id, String name, Avenue westAvenue, Avenue eastAvenue, Street northStreet, Street southStreet) {
        super(id, name);
        this.westAvenue = westAvenue;
        this.eastAvenue = eastAvenue;
        this.northStreet = northStreet;
        this.southStreet = southStreet;
        this.neighbors = new ArrayList<Block>();
    } // close constructor

    public Avenue getWestAvenue () {
        return westAvenue;
    }

    public Avenue getEastAvenue () {
        return eastAvenue;
    }

    public Street getNorthStreet () {
        return northStreet;
    }

    public Street getSouthStreet () {
        return southStreet;
    }

    public void setWestAvenue (Avenue westAvenue) {
        this.westAvenue = westAvenue;
    }

    public void setEastAvenue (Avenue eastAvenue) {
        this.eastAvenue = eastAvenue;
    }

    public void setNorthStreet (Street northStreet) {
        this.northStreet = northStreet;
    }

    public void setSouthStreet (Street southStreet) {
        this.southStreet = southStreet;
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Block) {
            Block block = (Block) object;
            if (super.equals(block)) {
                if (westAvenue.equals(block.getWestAvenue()) && eastAvenue.equals(block.getEastAvenue())) {
                   if (northStreet.equals(block.getNorthStreet()) && southStreet.equals(block.getSouthStreet())) {
                       return true;
                   }
                }
            }
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), westAvenue, eastAvenue, northStreet, southStreet);
    } // close hashCode

    @Override
    public String toString () {
        String string = super.toString()
                + " north ave:" + westAvenue.getName() + " south ave:" + eastAvenue.getName()
                + " west st:" + northStreet.getName() + " east st:" + southStreet.getName();
        return string;
    } // close toString

    public Iterator<Block> getNeighbors () {
        return neighbors.iterator();
    } // close getNeighbors

    public void addNeighbors (ArrayList<Block> neighbors) {
        for (Block neighbor : neighbors) {
            addNeighbor(neighbor);
        }
    } // close setNeighbors

    public void addNeighbor (Block neighbor) {
        if (!neighbors.contains(neighbor)) {
            neighbors.add(neighbors.size(), neighbor);
        }
    } // close addNeighbor

    public void removeNeighbors (ArrayList<Block> neighbors) {
        for (Block neighbor : neighbors) {
            removeNeighbor(neighbor);
        }
    } // close removeNeighbors

    public void removeNeighbor (Block neighbor) {
        int index = neighbors.indexOf(neighbor);
        if (index >= 0) {
            neighbors.remove(index);
        }
    } // close removeNeighbor
} // end class Block
