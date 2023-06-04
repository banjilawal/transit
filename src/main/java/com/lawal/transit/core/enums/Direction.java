package com.lawal.transit.core.enums;

public enum Direction {
    NORTH,
    NORTHEAST,
    EAST,
    SOUTHEAST,
    SOUTH,
    SOUTHWEST,
    WEST,
    NORTHWEST,
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
            case NORTHEAST:
                opposite = SOUTHWEST;
                break;
            case EAST:
                opposite = WEST;
                break;
            case SOUTHEAST:
                opposite = NORTHWEST;
                break;
            case SOUTH:
                opposite = NORTH;
                break;
            case SOUTHWEST:
                opposite = NORTHEAST;
                break;
            case WEST:
                opposite = EAST;
            case NORTHWEST:
                opposite = SOUTHEAST;
                break;
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
            case NORTHEAST:
                abbreviation = "NE";
                break;
            case EAST:
                abbreviation = "E";
            case SOUTHEAST:
                abbreviation = "SE";
            case SOUTH:
                abbreviation = "S";
                break;
            case SOUTHWEST:
                abbreviation = "SW";
                break;
            case WEST:
                abbreviation = "W";
                break;
            case NORTHWEST:
                abbreviation = "NW";
                break;
            default:
                abbreviation = "Direction line 68: Direction abbreviation not set";
        }
        return abbreviation;
    } // close abbreviation
} // end enum Direction
