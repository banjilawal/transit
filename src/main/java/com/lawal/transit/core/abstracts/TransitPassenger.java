package com.lawal.transit.core.abstracts;

public abstract class TransitPassenger extends Traveler {

    private Location destinati
    public TransitPassenger(int id, String name, Departure departure) {
        super(id, name, departure);
    }

    public TransitPassenger(int id, String name, Departure departure, Arrival arrival) {
        super(id, name, departure, arrival);
    }
} // end class TransitPassenger
