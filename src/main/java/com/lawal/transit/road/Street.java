package com.lawal.transit.road;

import com.lawal.transit.global.*;
import com.lawal.transit.road.contract.Road;

public final class Street implements Road {

    public static final RoadCategory ROAD_CATEGORY = RoadCategory.STREET;
    public static final Direction RIGHTWARD_TRAFFIC_DIRECTION = Direction.SOUTH;
    public static final Direction LEFTWARD_TRAFFIC_DIRECTION = Direction.NORTH;

    public static final Direction LEFT_CURB_ORIENTATION = Direction.WEST;
    public static final Direction RIGHT_CURB_ORIENTATION = Direction.EAST;

    public static final int RIGHTWARD_STATION_BASE_NAME = 1000;
    public static final int LEFTWARD_STATION_BASE_NAME = 3000;

    private final int id;
    private final String name;
    private final RoadLabel label;
    private final Curb leftCurb;
    private final Curb rightCurb;
    private final Lanes leftLanes;
    private final Lanes rightLanes;

    public Street (RoadLabel label, int leftCurbId, int rightCurbId) {
        this.label = label;
        this.id = label.id();
        this.name = label.name();
        this.leftLanes = new Lanes(LEFTWARD_TRAFFIC_DIRECTION);
        this.rightLanes = new Lanes(RIGHTWARD_TRAFFIC_DIRECTION);
        this.leftCurb = new Curb(leftCurbId, this, LEFT_CURB_ORIENTATION);
        this.rightCurb = new Curb(rightCurbId, this, RIGHT_CURB_ORIENTATION);
    }

    @Override
    public int getId() { return id; }

    @Override
    public String getName() { return name;}

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
        if (travelDirection.equals(LEFTWARD_TRAFFIC_DIRECTION)) return leftLanes;
        if (travelDirection.equals(RIGHTWARD_TRAFFIC_DIRECTION)) return rightLanes;
        return null;
    }

    @Override
    public Curb getCurbByOrientation (Direction curbOrientation) {
        if (curbOrientation.equals(LEFT_CURB_ORIENTATION)) return leftCurb;
        if (curbOrientation.equals(RIGHT_CURB_ORIENTATION)) return rightCurb;
//        System.out.println("STREEET line 78: No Street curb has the orientation" + curbOrientation.print());
        return null;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Street street) {
           return id == street.getId() && name.equalsIgnoreCase(street.getName());
        }
        return false;
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + "[id:"  + id + " name:" + name  + "]";
    }
}