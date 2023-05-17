package com.lawal.transit.middleware.enums;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST,
    NONE;

    public String print() {
        String string = this.toString().substring(0, 1).toUpperCase()
                + this.toString().substring(1).toLowerCase();
        return string;
    }

    public Direction oppositeDirection () {
        Direction opposite = NONE;
        switch (this) {
            case NORTH:
                opposite = SOUTH;
                break;
            case EAST:
                opposite = WEST;
                break;
            case SOUTH:
                opposite = NORTH;
                break;
            case WEST:
                opposite = EAST;
            default:
                System.out.println("Direction line 31: oppositeDirection not set");
        }
        return opposite;
    } // close oppositeDirection

    public String abbreviation () {
        String abbreviation = "";
        switch (this) {
            case NORTH:
                abbreviation = "N";
                break;
            case EAST:
                abbreviation = "E";
            case SOUTH:
                abbreviation = "S";
                break;
            case WEST:
                abbreviation = "W";
                break;
            default:
                abbreviation = "Direction line 68: Direction abbreviation not set";
        }
        return abbreviation;
    } // close abbreviation
} // end enum Direction
