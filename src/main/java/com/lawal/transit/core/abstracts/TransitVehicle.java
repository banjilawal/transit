package com.lawal.transit.core.abstracts;

import java.util.Objects;

public abstract class TransitVehicle extends Traveler {
    private int capacity;
    public TransitVehicle(int id, String name, Departure departure, int capacity) {
        super(id, name, departure);
        this.capacity = capacity;
    }

    public TransitVehicle(int id, String name, Departure departure, Arrival arrival, int capacity) {
        super(id, name, departure, arrival);
        this.capacity = capacity;
    }
} // end class TransitVehicle
