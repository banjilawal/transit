package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.concretes.Arrival;
import com.lawal.transit.core.concretes.AbstractBuilding;
import com.lawal.transit.core.concretes.Departure;

import java.util.Objects;

public abstract class Person extends Traveler {

    private AbstractBuilding destination;

    public Person(int id, String name, AbstractLocation currentAbstractLocation, AbstractBuilding destination) {
       this(id, name, currentAbstractLocation, destination, new Departure(id, currentAbstractLocation), null);
    }

    public Person(int id, String name, AbstractLocation currentAbstractLocation, AbstractBuilding destination, Departure departure, Arrival arrival) {
        super(id, name, currentAbstractLocation, departure, arrival);
        this.destination = destination;
    }

    public AbstractBuilding getDestination () { return destination; }

    public void setDestination (AbstractBuilding destination) { this.destination = destination; }

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
