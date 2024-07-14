package com.lawal.transit.road;

import com.lawal.transit.*;

public enum RoadCategory {

    AVENUE,
    STREET;

    public String print() {
        return this.toString().substring(0, 1).toUpperCase() + this.toString().substring(1).toLowerCase();
    }

    public String abbreviation () {
        switch (this) {
            case AVENUE -> {
                return "Ave";
            }
            case STREET -> {
                return "St";
            }
        }
        return "";
    }
}
