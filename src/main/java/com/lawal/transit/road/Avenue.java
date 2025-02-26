package com.lawal.transit.road;

import com.lawal.transit.global.*;
import com.lawal.transit.road.contract.Road;


public final class Avenue implements Road {

    public static final RoadCategory ROAD_CATEGORY = RoadCategory.AVENUE;
    public static final Direction RIGHTWARD_TRAFFIC_DIRECTION = Direction.WEST;
    public static final Direction LEFTWARD_TRAFFIC_DIRECTION = Direction.EAST;

    public static final Direction LEFT_CURB_ORIENTATION = Direction.SOUTH;
    public static final Direction RIGHT_CURB_ORIENTATION = Direction.NORTH;

    public static final int RIGHTWARD_STATION_BASE_NAME = 2000;
    public static final int LEFTWARD_STATION_BASE_NAME = 4000;

    private final int id;
    private final String name;
    private final RoadLabel label;
    private final Lanes leftLanes;
    private final Lanes rightLanes;
    private final Curb leftCurb;
    private final Curb rightCurb;

    public Avenue (RoadLabel label, int leftCurbId, int rightCurbId) {
        this.label = label;
        this.id = label.id();
        this.name = label.name();
        this.leftLanes = new Lanes(LEFTWARD_TRAFFIC_DIRECTION);
        this.rightLanes = new Lanes(RIGHTWARD_TRAFFIC_DIRECTION);
        this.leftCurb = new Curb(leftCurbId, this, Avenue.LEFT_CURB_ORIENTATION);
        this.rightCurb = new Curb(rightCurbId, this, Avenue.RIGHT_CURB_ORIENTATION);
    }

    @Override
    public int getId() { return id; }

    @Override
    public String getName() { return name;}

    @Override
    public RoadLabel label () {
        return label;
    }

    @Override
    public Lanes leftLanes () {
        return leftLanes;
    }

    @Override
    public Lanes righLanes () {
        return rightLanes;
    }

    @Override
    public Curb leftCurb() {
        return leftCurb;
    }
    @Override
    public Curb rightCurb() {
        return rightCurb;
    }

    @Override
    public Lanes getLanesByDirection (Direction travelDirection) {
        if (travelDirection.equals(LEFTWARD_TRAFFIC_DIRECTION))
            return leftLanes;
        if (travelDirection.equals(RIGHTWARD_TRAFFIC_DIRECTION))
            return rightLanes;
        return null;
    }

    @Override
    public Curb getCurbByOrientation (Direction curbOrientation) {
        if (curbOrientation.equals(LEFT_CURB_ORIENTATION))
            return leftCurb;
        if (curbOrientation.equals(RIGHT_CURB_ORIENTATION))
            return rightCurb;
        return null;
    }

    public Curb getCurbByTravelDirection (Direction travelDirection) {
        if (travelDirection.equals(LEFTWARD_TRAFFIC_DIRECTION))
            return leftCurb;
        if (travelDirection.equals(RIGHTWARD_TRAFFIC_DIRECTION))
            return rightCurb;
        return null;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Avenue avenue) {
            return id == avenue.getId() && name.equalsIgnoreCase(avenue.getName());
        }
        return false;
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + "[id:" + id + " name:" + name + "]";
    }
}