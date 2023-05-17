package com.lawal.transit.middleware.enums;

public enum RoadCategory {
    STREET,
    AVENUE,
    NONE;

    public String print () {
        String string = this.toString().substring(0, 1).toUpperCase()
                + this.toString().substring(1).toLowerCase();
        return string;
    }

    public RoadCategory opposite () {
    RoadCategory opposite = RoadCategory.NONE;
        switch (this) {
        case STREET:
            opposite = RoadCategory.AVENUE;
            break;
        case AVENUE:
            opposite = RoadCategory.STREET;
            break;
        default:
            System.out.println("RoadCategory line 24: opposite road category not set");
            break;
    }
        return opposite;
} // close opposite

    public String abbreviation () {
        String  abbreviation = "";
        switch (this) {
            case STREET:
               abbreviation = "St";
                break;
            case AVENUE:
                abbreviation = "Ave";
                break;
            default:
                System.out.println("RoadCategory line 40: abbreviation not set");
                break;
        }
        return abbreviation;
    } // close abbreviation
} // end enum RoadCategory
