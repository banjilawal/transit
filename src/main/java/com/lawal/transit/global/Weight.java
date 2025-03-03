package com.lawal.transit.global;

import lombok.Data;

@Data
public class Weight {

    public static final String SET_WEIGHT_VALUE_ERROR = "Value to a negative number";
    private int distance;
    private int travelTime;
    private int waitingTime;
    private int heuristic;

    public Weight (int distance) {
        this.distance = distance;
        this.travelTime = 0;
        this.waitingTime = 0;
        this.heuristic = distance;
    }
}