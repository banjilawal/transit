package com.lawal.transit.core.abstracts;

import java.time.LocalTime;
import java.util.Objects;

public abstract class MovementEvent extends NamedEntity {
    private String locationName;
    private LocalTime eventTime;


    public MovementEvent(int id, String name, String locationName,  LocalTime eventTime) {
        super(id, name);
        this.locationName = locationName;
        this.eventTime = eventTime;
    }

    public abstract Location getLocation ();
    public abstract void setLocation (String locationName);
    public String getLocationName () { return locationName; }
    public LocalTime getEventTime () { return eventTime; }

    public void setLocationName (String locationName) { this.locationName = locationName; }

    public void setEventTime (LocalTime eventTime) { this.eventTime = eventTime; }

    @Override
    public boolean equals (Object object) {
        if (object instanceof  MovementEvent event) {
            return super.equals(event) && locationName.equalsIgnoreCase(event.getLocationName()) && eventTime == getEventTime();
        }
        return false;
    } //

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), locationName, eventTime); }
} // end class MovementEvent
