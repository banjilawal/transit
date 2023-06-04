package com.lawal.transit.core.enums;

public enum RoadDirection {
    NORTH_SOUTH,
    EAST_WEST,

    NONE;

    public String print() {
        String string = "";
        switch (this) {
            case NORTH_SOUTH:
                string = "North-South";
                break;
            case EAST_WEST:
                string = "East-West";
                break;
            default:
                System.out.println("Direction line 31: oppositeDirection not set");
        }
        return string;
    } // close print

    public RoadDirection oppositeDirection () {
        RoadDirection opposite = NONE;
        switch (this) {
            case NORTH_SOUTH:
                opposite = EAST_WEST;
                break;
            case EAST_WEST:
                opposite = NORTH_SOUTH;
                break;
            default:
                System.out.println("Direction line 31: oppositeDirection not set");
        }
        return opposite;
    } // close oppositeDirection

    public String abbreviation () {
        String abbreviation = "";
        switch (this) {
            case NORTH_SOUTH:
                abbreviation = "N-S";
                break;
            case EAST_WEST:
                abbreviation = "E-W";
            default:
                abbreviation = "Direction line 68: Direction abbreviation not set";
        }
        return abbreviation;
    } // close abbreviation
} // end enum Direction
