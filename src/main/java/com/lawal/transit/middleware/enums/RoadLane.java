package com.lawal.transit.middleware.enums;

public enum RoadLane {
    WEST_AVENUE,
    EAST_AVENUE,
    NORTH_STREET,
    SOUTH_STREET,
    NONE;

    public String print () {
        String string = this.toString().substring(0, 1).toUpperCase()
                + this.toString().substring(1).toLowerCase();
        return string;
    }
} // end enum Direction
