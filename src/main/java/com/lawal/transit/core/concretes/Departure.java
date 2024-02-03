package com.lawal.transit.core.concretes;

import com.lawal.transit.core.abstracts.Location;
import com.lawal.transit.core.abstracts.MovementEvent;

import java.time.LocalTime;

public class Departure extends MovementEvent {

    private Location origin;

    public Departure (int id, Location origin) {
        this(id, origin, LocalTime.now());
    }

    public Departure (int id, Location origin, LocalTime eventTime) {
        super(id, (origin.getName() + id), eventTime);
        this.origin = origin;
    }

    public Location getOrigin () { return origin; }

    public LocalTime getDepartureTime () { return getEventTime(); }

    public void setDepartureTime (LocalTime departureTime) { setEventTime(departureTime); }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Departure departure) return super.equals(departure) && origin.equals(departure.getOrigin());
        return false;
    } //


    @Override
    public String toString () {
        return super.toString() + " " + origin.getName() + " departure time:" + getDepartureTime();
    }
} // end class DepartureEvent
