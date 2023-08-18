package com.lawal.transit.core.abstracts;

import java.time.LocalTime;

public abstract class Arrival extends MovementEvent {

    public Arrival(int id, String name, String destinationName, LocalTime arrivalTime) {
        super(id, name, destinationName, arrivalTime);
    }

    public String getDestinationName () { return getLocationName(); }
    public LocalTime getArrivalTime () { return getEventTime(); }

    public void setDestinationName (String destinationName) { setLocationName(destinationName); }

    public void setArrivalTime (LocalTime arrivalTime) { setEventTime(arrivalTime); }

    @Override
    public boolean equals (Object object) {
        if (object instanceof  Arrival arrival) return super.equals(arrival);
        return false;
    } //

    @Override
    public int hashCode() { return super.hashCode(); }

    @Override
    public String toString () {
        return super.toString() + " origin:" + getDestinationName() + " departure time:" + getArrivalTime();
    }
} // end class DepartureEvent
