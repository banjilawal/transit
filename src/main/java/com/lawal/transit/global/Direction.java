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

    public int number() {
        return switch (this) {
            case NORTH, NORTHEAST -> 1000;
            case EAST, SOUTHEAST -> 2000;
            case SOUTH, SOUTHWEST -> 3000;
            case WEST, NORTHWEST -> 4000;
            default -> {
                System.out.println("Something went wrong");
                yield -1;
            }
        };
    }

    public int toDegrees() {
        return switch (this) {
            case NORTH -> 360;
            case NORTHEAST -> 45;
            case EAST -> 90;
            case SOUTHEAST -> 135;
            case SOUTH -> 180;
            case SOUTHWEST -> 225;
            case WEST -> 270;
            case NORTHWEST -> 315;
            default -> {
                System.out.println("Direction line 59: toDegrees not set");
                yield -1;
            }
        };
    }

    public Direction fromDegrees(int degrees) {
        return switch (degrees) {
            case 0, 360 -> NORTH;
            case 45 -> NORTHEAST;
            case 90 -> EAST;
            case 135 -> SOUTHEAST;
            case 180 -> SOUTH;
            case 225 -> SOUTHWEST;
            case 270 -> WEST;
            case 315 -> NORTHWEST;
            default -> {
                System.out.println("Direction line 79: toDegrees not set");
                yield NONE;
            }
        };
    }

    public Direction leftTurnFrom() {
        return switch (this) {
            case NORTH -> this.fromDegrees(360 - 90);
            case NORTHEAST -> this.fromDegrees(360 - 45);
            case EAST -> this.fromDegrees(360);
            case SOUTHEAST -> this.fromDegrees(135 - 90);
            case SOUTH -> this.fromDegrees(180 - 90);
            case SOUTHWEST -> this.fromDegrees(225 - 90);
            case WEST -> this.fromDegrees(270 - 90);
            case NORTHWEST -> this.fromDegrees(315 - 90);
            default -> {
                System.out.println("Direction line 31: oppositeDirection not set");
                yield NONE;
            }
        };
    }

    public Direction rightTurnFrom() {
        return switch (this) {
            case NORTH -> this.fromDegrees(90);
            case NORTHEAST -> this.fromDegrees(45 + 90);
            case EAST -> this.fromDegrees(90 + 90);
            case SOUTHEAST -> this.fromDegrees(135 + 90);
            case SOUTH -> this.fromDegrees(180 + 90);
            case SOUTHWEST -> this.fromDegrees(225 + 90);
            case WEST -> this.fromDegrees(360);
            case NORTHWEST -> this.fromDegrees(315 - 270);
            default -> {
                System.out.println("Direction line 31: oppositeDirection not set");
                yield NONE;
            }
        };
    }

    public Direction reverseTo() {
        return switch (this) {
            case NORTH -> this.fromDegrees(360 - 135);
            case NORTHEAST -> SOUTHEAST; //this.fromDegrees(45 + 135);
            case EAST -> this.fromDegrees(90 + 135);
            case SOUTHEAST -> NORTHEAST; //this.fromDegrees(135 - 135);
            case SOUTH -> this.fromDegrees(180 - 135);
            case SOUTHWEST -> NORTHWEST; //this.fromDegrees(225 - 135);
            case WEST -> this.fromDegrees(270 - 135);
            case NORTHWEST -> SOUTHWEST; //this.fromDegrees(315 - 135);
            default -> {
                System.out.println("Direction line 31: oppositeDirection not set");
                yield NONE;
            }
        };
    }

    public Direction forwardTo() {
        return switch (this) {
            case NORTH -> this.fromDegrees(360 - 135);
            case NORTHEAST -> NORTHWEST;
            case EAST -> EAST;
            case SOUTHEAST -> SOUTHWEST;
            case SOUTH -> SOUTH;
            case SOUTHWEST -> SOUTHEAST;
            case WEST -> WEST;
            case NORTHWEST -> NORTHEAST;
            default -> {
                System.out.println("Direction line 31: oppositeDirection not set");
                yield NONE;
            }
        };
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


    public Direction oppositeDirection() {
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
    }

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