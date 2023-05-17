package com.lawal.transit.middleware.abstracts;

import com.lawal.transit.middleware.enums.Direction;

import java.util.Objects;

public abstract class Location extends NamedEntity {
    private Direction blockSide;
    private Road blockRoad;
    private int blockId;

    public Location(int id, String name, int blockId, Road blockRoad, Direction blockSide) {
        super(id, name);
        this.blockId = blockId;
        this.blockRoad = blockRoad;
        this.blockSide = blockSide;
    }

    public int getBlockId () {
        return blockId;
    }

    public Road getBlockRoad () {
        return blockRoad;
    }

    public Direction getBlockSide () { return blockSide; }


    public void setBlockId (int blockId) {
        this.blockId = blockId;
    }

    public void setBlockRoad (Road blockRoad) {
        this.blockRoad = blockRoad;
    }

    public void setBlockSide (Direction blockSide) { this.blockSide = blockSide; }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Location) {
            Location location = (Location) object;
            if (super.equals(location) && blockRoad.equals(location.getBlockRoad())) {
                if (blockSide.compareTo(location.getBlockSide()) == 0) {
                    return true;
                }
            }
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), blockId, blockRoad, blockSide);
    } // closeHashcode

    public String toString () {
        String string = " id:" + getId()
                + " name:" + getName()
                + " " + blockRoad.getName()
                + " " + blockRoad.getRoadCategory().abbreviation()
                + " " + blockSide.abbreviation()
                + " blockId:" + blockId;
        return string;
    } // close toString
} // end class Location
