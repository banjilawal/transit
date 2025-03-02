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
            case NORTH: return 1000;
            case NORTHEAST: return 1000;
            case EAST: return 2000;
            case SOUTHEAST: return 2000;
            case SOUTH: return 3000;
            case SOUTHWEST: return 3000;
            case WEST: return 4000;
            case NORTHWEST: return 4000;
            default:
                System.out.println("Something went wrong");
                return -1;
        }
    }

    public int toDegrees () {
        switch (this) {
            case NORTH: return 360;
            case NORTHEAST: return 45;
            case EAST: return 90;
            case SOUTHEAST: return 135;
            case SOUTH: return 180;
            case SOUTHWEST: return 225;
            case WEST: return 270;
            case NORTHWEST: return 315;
            default:
                System.out.println("Direction line 59: toDegrees not set");
                return -1;
        }
    }

    public Direction fromDegrees (int degrees) {
        switch (degrees) {
            case 0, 360: return NORTH;
            case 45: return NORTHEAST;
            case 90: return EAST;
            case 135: return SOUTHEAST;
            case 180: return SOUTH;
            case 225: return SOUTHWEST;
            case 270: return WEST;
            case 315: return NORTHWEST;
            default:
                System.out.println("Direction line 79: toDegrees not set");
                return NONE;
        }
    }

    public Direction leftTurnFrom () {
        switch (this) {
            case NORTH: return this.fromDegrees(360 - 90);
            case NORTHEAST: return this.fromDegrees(360 - 45);
            case EAST: return this.fromDegrees(360);
            case SOUTHEAST: return this.fromDegrees(135 - 90);
            case SOUTH: return this.fromDegrees(180 - 90);
            case SOUTHWEST: return this.fromDegrees(225 - 90);
            case WEST: return this.fromDegrees(270 - 90);
            case NORTHWEST: return this.fromDegrees(315 - 90);
            default:
                System.out.println("Direction line 31: oppositeDirection not set");
                return NONE;
        }
    }

    public Direction rightTurnFrom () {
        switch (this) {
            case NORTH: return this.fromDegrees(90);
            case NORTHEAST: return this.fromDegrees(45 + 90);
            case EAST: return this.fromDegrees(90 + 90);
            case SOUTHEAST: return this.fromDegrees(135 + 90);
            case SOUTH: return this.fromDegrees(180 + 90);
            case SOUTHWEST: return this.fromDegrees(225 + 90);
            case WEST: return this.fromDegrees(360);
            case NORTHWEST: return this.fromDegrees(315 - 270);
            default:
                System.out.println("Direction line 31: oppositeDirection not set");
                return NONE;
        }
    }

    public Direction reverseTurnCurbDirection () {
        switch (this) {
            case NORTH: return this.fromDegrees(360 - 135);
            case NORTHEAST: return this.fromDegrees(45 + 135);
            case EAST: return this.fromDegrees(90 + 135);
            case SOUTHEAST: return this.fromDegrees(135 - 135);
            case SOUTH: return this.fromDegrees(180 - 135);
            case SOUTHWEST: return this.fromDegrees(225 - 135);
            case WEST: return this.fromDegrees(270 - 135);
            case NORTHWEST: return this.fromDegrees(315 - 135);
            default:
                System.out.println("Direction line 31: oppositeDirection not set");
                return NONE;
        }
    }

//    public Direction rightTurnDirection () {
//        switch (this) {
//            case NORTH:
//                return EAST;
//            case NORTHEAST:
//                return SOUTHEAST;
//            case EAST:
//                return SOUTH;
//            case SOUTHEAST:
//                return SOUTHWEST;
//            case SOUTH:
//                return WEST;
//            case SOUTHWEST:
//                return NORTHWEST;
//            case WEST:
//                return NORTH;
//            case NORTHWEST:
//                return NORTHEAST;
//            default:
//                System.out.println("Direction line 31: oppositeDirection not set");
//        }
//        return NONE;
//    }


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