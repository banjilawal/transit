package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.entities.Block;
import com.lawal.transit.core.enums.Direction;

import java.util.Objects;

public abstract class Location extends NamedEntity {

    private enum Mark { KEEP, PURGE; }
    private Block block;
    private Road road;
    private Mark mark;
    private Direction orientation;

    public Location(int id, String name, Block block, Direction orientation) {
        super(id, name);
        this.mark = Mark.KEEP;
        this.block = block;
        this.orientation = orientation;
        this.road = block.getBorderRoad(orientation);
    }

    public Mark getMark () { return mark; }

    public Block getBlock () {
        return block;
    } // close getBlock

    public Road getRoad () { return block.getBorderRoad(orientation); }

    public Direction getOrientation () { return orientation; }

    public void setMark (Mark mark) { this.mark = mark; }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Location location)
            return super.equals(location) && block.equals(location.getBlock())
                && mark.equals(location.getMark()) && orientation.equals(location.getOrientation());
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
