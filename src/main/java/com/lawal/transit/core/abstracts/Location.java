package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.entities.Block;
import com.lawal.transit.core.enums.Direction;

import java.util.Objects;

public abstract class Location extends NamedEntity {

    private enum State { KEEP, PURGED }
    private Block block;
    private Road road;
    private State state;
    private Direction orientation;

    public Location(int id, String name, Block block, Direction orientation) {
        super(id, name);
        this.state = State.KEEP;
        this.block = block;
        this.orientation = orientation;
        this.road = block.getBorderRoad(orientation);
    }

    public State getState () { return state; }

    public Block getBlock () {
        return block;
    } // close getBlock

    public Road getRoad () { return block.getBorderRoad(orientation); }

    public Direction getOrientation () { return orientation; }

    public void setState (State state) { this.state = state; }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Location location)
            return super.equals(location) && block.equals(location.getBlock()) && orientation.equals(location.getOrientation());
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), block, road, orientation);
    }

    @Override
    public String toString () {
        return super.toString()
            + " " + road.toString()
            + " " + orientation.abbreviation()
            + " blockId:" + block.getId();
    } // close toString
} // end class Location
