package com.lawal.transit.core.concretes;

import com.lawal.transit.core.abstracts.*;
import com.lawal.transit.core.abstracts.AbstractLocation;

import java.time.LocalTime;

public class Arrival extends MovementEvent {
    private AbstractLocation destination;

    public Arrival (int id, AbstractLocation destination) {
        this(id, destination, LocalTime.now());
    }

    public Arrival (int id, AbstractLocation destination, LocalTime eventTime) {
        super(id, (destination.getName() + id), eventTime);
        this.destination = destination;
    }

    public AbstractLocation getDestination () { return destination; }

    public LocalTime getArrivalTime () { return getEventTime(); }

    public void setDestination (AbstractLocation destination) { this.destination = destination; }

    public void setArrivalTime (LocalTime arrivalTime) { setEventTime(arrivalTime); }

    @Override
    public boolean equals (Object object) {
        if (object instanceof  Arrival arrival) return super.equals(arrival) && destination.equals(arrival.getDestination());
        return false;
    } //

    @Override
    public int hashCode() { return super.hashCode(); }

    @Override
    public String toString () {
        return super.toString() + " " + destination.getName() + " arrival time:" + getArrivalTime();
    }
} // end class DepartureEvent
