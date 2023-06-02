package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.NamedEntity;

import java.util.ArrayList;
import java.util.Objects;

public class Block extends NamedEntity {
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

    public ArrayList<Block> getNeighbors () {
        return neighbors;
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

    public void setNeighbors (ArrayList<Block> blocks) {
        for (Block block : blocks) {
            addNeighbor(block);
        }
    } // close setNeighbors

    public void addNeighbor (Block block) {
        if (!neighbors.contains(block)) {
            neighbors.add(neighbors.size(), block);
        }
    } // close addNeighbor

    public void removeNeigbors (ArrayList<Block> blocks) {
        for (Block block : blocks) {
            removeNeighbor(block);
        }
    } // close removeNeighbors

    public void removeNeighbor (Block block) {
        int index = neighbors.indexOf(block);
        if (index >= 0) {
            neighbors.remove(index);
        }
    } // close removeNeighbor

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
} // end class Block
