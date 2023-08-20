package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.entities.Building;

public abstract class Person extends Traveler {

    private Building destination;
    public Person(int id, String name, Location currentLocation, Building destination, Departure departure) {
        super(id, name, currentLocation, departure);
        this.destination = destination;
    }

    public Person(int id, String name, Location currentLocation, Building destination, Departure departure, Arrival arrival) {
        super(id, name, currentLocation, departure, arrival);
        this.destination = destination;
    }

    public Building getDestination () { return destination; }
    public void setDestination (Building destination) { this.destination = destination; }

} // end class Person
