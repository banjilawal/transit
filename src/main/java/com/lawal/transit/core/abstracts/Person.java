package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.concretes.Arrival;
import com.lawal.transit.core.concretes.Building;
import com.lawal.transit.core.concretes.Departure;

import java.util.Objects;

public abstract class Person extends Traveler {

    private Building destination;

    public Person(int id, String name, Location currentLocation, Building destination) {
       this(id, name, currentLocation, destination, new Departure(id, currentLocation), null);
    }

    public Person(int id, String name, Location currentLocation, Building destination, Departure departure, Arrival arrival) {
        super(id, name, currentLocation, departure, arrival);
        this.destination = destination;
    }

    public Building getDestination () { return destination; }

    public void setDestination (Building destination) { this.destination = destination; }

    public abstract void embark (Vehicle vehicle);
    public abstract void disembark ();

    @Override
    public boolean equals (Object object) {
        if (object instanceof Person person) {
            return super.equals(person) && destination.equals(person.getDestination());
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), destination);
    }

    @Override
    public String toString () {
        return super.toString() + " destination:" + destination.getName();
    }
} // end class Person
