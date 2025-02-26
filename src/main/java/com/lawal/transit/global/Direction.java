package com.lawal.transit.global;

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
        return this.toString().substring(0, 1).toUpperCase() + this.toString().substring(1).toLowerCase();
    }

    public int number () {
        switch (this) {
            case NORTH:
                return 1000;
            case NORTHEAST:
                return 1000;
            case EAST:
                return 2000;
            case SOUTHEAST:
                return 2000;
            case SOUTH:
                return 3000;
            case SOUTHWEST:
                return 3000;
            case WEST:
                return 4000;
            case NORTHWEST:
                return 4000;
            default:
                System.out.println("Something went wrong");
        }
        return -1;
    }

    public Direction leftTurnDirection () {
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
                System.out.println("Direction line 31: oppositeDirection not set");
        }
        return NONE;
    }

    public Direction rightTurnDirection () {
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
                System.out.println("Direction line 31: oppositeDirection not set");
        }
        return NONE;
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

    public String adjective () {

        switch (this) {
            case NORTH:
                return "Northerly";
            case NORTHEAST:
                return "Northeasterly";
            case EAST:
                return "Easterly";
            case SOUTHEAST:
                return "Southeasterly";
            case SOUTH:
                return "Southerly";
            case SOUTHWEST:
                return "Southwesterly";
            case WEST:
                return "Westerly";
            case NORTHWEST:
                return "Northwesterly";
            default:
                System.out.println("Direction line 68: Direction abbreviation not set");
        }
        return "";
    }
}