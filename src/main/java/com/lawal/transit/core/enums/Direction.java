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
        switch (this) {
            case NORTH:
                return SOUTH;
            case NORTHEAST:
                return SOUTHWEST;
            case EAST:
                return WEST;
            case SOUTHEAST:
                return NORTHWEST;
            case SOUTH:
                return NORTH;
            case SOUTHWEST:
                return NORTHEAST;
            case WEST:
                return EAST;
            case NORTHWEST:
                return SOUTHEAST;
            default:
                System.out.println("Direction line 31: oppositeDirection not set");
        }
        return NONE;
    } // close oppositeDirection

    public String abbreviation () {
        String abbreviation = "";
        switch (this) {
            case NORTH:
                return "N";
            case NORTHEAST:
                return "NE";
            case EAST:
                return "E";
            case SOUTHEAST:
                return "SE";
            case SOUTH:
                return "S";
            case SOUTHWEST:
                return "SW";
            case WEST:
                return "W";
            case NORTHWEST:
                return "NW";
            default:
                System.out.println("Direction line 68: Direction abbreviation not set");
        }
        return "";
    } // close abbreviation
} // end enum Direction
