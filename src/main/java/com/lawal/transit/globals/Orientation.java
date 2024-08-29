package com.lawal.transit.globals;

public enum Orientation {
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
        return this.toString().substring(0, 1).toUpperCase() + this.toString().substring(1).toLowerCase();
    }

    public Orientation leftTurnDirection () {
        switch (this) {
            case NORTH:
                return WEST;
            case NORTHEAST:
                return NORTHWEST;
            case EAST:
                return NORTH;
            case SOUTHEAST:
                return NORTHEAST;
            case SOUTH:
                return EAST;
            case SOUTHWEST:
                return SOUTHEAST;
            case WEST:
                return SOUTH;
            case NORTHWEST:
                return SOUTHWEST;
            default:
                System.out.println("Orientation line 31: oppositeDirection not set");
        }
        return NONE;
    }

    public Orientation rightTurnDirection () {
        switch (this) {
            case NORTH:
                return EAST;
            case NORTHEAST:
                return SOUTHEAST;
            case EAST:
                return SOUTH;
            case SOUTHEAST:
                return SOUTHWEST;
            case SOUTH:
                return WEST;
            case SOUTHWEST:
                return NORTHWEST;
            case WEST:
                return NORTH;
            case NORTHWEST:
                return NORTHEAST;
            default:
                System.out.println("Orientation line 31: oppositeDirection not set");
        }
        return NONE;
    }


    public Orientation oppositeDirection () {
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
                System.out.println("Orientation line 31: oppositeDirection not set");
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
                System.out.println("Orientation line 68: Orientation abbreviation not set");
        }
        return "";
    } // close abbreviation
} // end enum Orientation
