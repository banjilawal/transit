package com.lawal.transit.middleware.abstracts;

import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.entities.Block;
import com.lawal.transit.middleware.entities.Street;
import com.lawal.transit.middleware.enums.Direction;
import com.lawal.transit.middleware.interfaces.Locatable;

import java.util.Objects;

public abstract class Location extends NamedEntity implements Locatable {
    private Block block;
    private Road road;
    private Direction curbSide;

    public Location(int id, String name, Block block, Direction curbSide) {
        super(id, name);
        this.block = block;
        this.curbSide = curbSide;
        setRoad(curbSide);
    }

    public Block getBlock () {
        return block;
    } // close getBlock

    @Override
    public Road getRoad () {
        return road;
    }

    public Direction getCurbSide () {
        return curbSide;
    } //

    public void setBlock (Block block) {
        this.block = block;
    }

    public void setCurbSide (Direction curbSide) {
        this.curbSide = curbSide;
        setRoad(curbSide);
    }

    @Override
    public void setRoad (Direction curbSide) {
        switch (curbSide) {
            case NORTH:
                this.road = (Street) block.getNorthStreet();
                break;
            case EAST:
                this.road = (Avenue) block.getEastAvenue();
                break;
            case SOUTH:
                this.road = (Street) block.getSouthStreet();
                break;
            case WEST:
                this.road = (Avenue) block.getWestAvenue();
                break;
        }
    } // close setBlockLocation


    @Override
    public SimplexPath getRoadLane () {
        SimplexPath lane = null;
        switch (curbSide) {
            case NORTH:
                lane =  ((Street) block.getNorthStreet()).getLane();
                break;
            case EAST:
                lane = ((Avenue) block.getEastAvenue()).getLane();
                break;
            case SOUTH:
                lane = ((Street) block.getSouthStreet()).getLane();
                break;
            case WEST:
                lane = ((Avenue) block.getWestAvenue()).getLane();
                break;
        }
        return lane;
    } // close getRoadLane

    @Override
    public boolean equals (Object object) {
        if (object instanceof Location) {
            Location location = (Location) object;
            if (super.equals(location)) {
                if (block.equals(location.getBlock()) && road.equals(location.getRoad())) {
                    if (curbSide.equals(location.getCurbSide())) {
                        return true;
                    }
                }
            }
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), block, road, curbSide);
    }

    @Override
    public String toString () {
        String string = super.toString()
                + " " + road.getName()
                + " " + road.getClass().getSimpleName()
                + " " + curbSide.print();
        return string;
    } // close toString
} // end class Location
