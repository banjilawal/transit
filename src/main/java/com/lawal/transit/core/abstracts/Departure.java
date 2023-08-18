package com.lawal.transit.core.abstracts;

import java.time.LocalTime;

public abstract class Departure extends MovementEvent {

    public Departure(int id, String name, String originName, LocalTime departureTime) {
        super(id, name, originName, departureTime);
    }

    public String getOriginName() { return getLocationName(); }
    public LocalTime getDepartureTime () { return getEventTime(); }

    public void setOriginName (String originName) { setLocationName(originName); }

    public void setDepartureTime (LocalTime departureTime) { setEventTime(departureTime); }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Departure departure) return super.equals(departure);
        return false;
    } //

    @Override
    public int hashCode() { return super.hashCode(); }

    @Override
    public String toString () {
        return super.toString() + " origin:" + getOriginName() + " departure time:" + getDepartureTime();
    }
} // end class DepartureEvent
