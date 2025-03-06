package com.lawal.transit.global;

public enum RoadCategory {
    AVENUE,
    STREET;

    public String print() {
        return this.toString().substring(0, 1).toUpperCase() + this.toString().substring(1).toLowerCase();
    }

    public String abbreviation () {
        String abbreviation = "";
        switch (this) {
            case AVENUE:
                return "Ave";
            case STREET:
                return "St";
            default:
                System.out.println("Direction line 68: Direction abbreviation not set");
        }
        return "";
    }
}