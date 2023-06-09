package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.enums.Direction;

import java.util.Objects;

public abstract class Road extends DuplexPath {
    private Direction curb;
    private Direction oppositeCurb;

    public Road(int id, String name, SimplexPath forwardPath) {
        super(id, name, forwardPath);
        this.curb = Direction.NONE;
        this.oppositeCurb = Direction.NONE;
    }

    public SimplexPath getLane () {
        return getPath();
    } // close getLane

    public SimplexPath getOppositeLane () {
        return getReversePath();
    } // close getOppositeLane

    public Direction getCurb () { return curb; }
    public Direction getOppositeCurb () { return oppositeCurb; }

    public void setCurb () {
        switch (getPath().getDirection()) {
            case NORTH:
                this.curb = Direction.WEST;
                break;
            case EAST:
                this.curb = Direction.NORTH;
                break;
            case SOUTH:
                this.curb = Direction.EAST;
                break;
            case WEST:
                this.curb = Direction.SOUTH;
                break;
        }
        setOppositeCurb ();
    } // close setCurb

    public void setOppositeCurb () {
        this.oppositeCurb = curb.oppositeDirection();
    } // close setOppositeCurb

    @Override
    public boolean equals(Object object) {
        if (object instanceof  Road) {
            Road road = (Road) object;
            if (super.equals(road)) {
                return true;
            }
        }
        return false;
    } // close equals

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    } // close hashCode

    @Override
    public String toString () {
        String string = getClass().getSimpleName()
                + " id:" + getId()
                + " name:" + getName();
        return string;
    } // close toString
    @Override
    public String fullString () { return toString(); }

//    public ArrayList<String> getStations () {
//        return Stations.INSTANCE.filter(this);
//    } // close getStations
} // end class Road
