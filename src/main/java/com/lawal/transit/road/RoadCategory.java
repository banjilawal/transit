package com.lawal.transit.road;

import com.lawal.transit.global.*;

public enum RoadCategory {

    AVENUE,
    STREET;

    public static boolean isAvenue (Direction trafficDirection) {
        return trafficDirection.equals(Avenue.RIGHTWARD_TRAFFIC_DIRECTION) ||
            trafficDirection.equals(Avenue.LEFTWARD_TRAFFIC_DIRECTION);
    }

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