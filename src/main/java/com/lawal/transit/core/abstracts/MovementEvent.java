package com.lawal.transit.core.abstracts;

import java.time.LocalTime;
import java.util.Objects;

public abstract class MovementEvent extends NamedEntity {

    private LocalTime eventTime;

    public MovementEvent (int id, String name) {
        this(id, name, LocalTime.now());
    }

    public MovementEvent (int id, String name, LocalTime eventTime) {
        super(id, name);
        this.eventTime = eventTime;
    }

    public LocalTime getEventTime () { return eventTime; }

    public void setEventTime (LocalTime eventTime) { this.eventTime = eventTime; }

    @Override
    public boolean equals (Object object) {
        if (object instanceof  MovementEvent event) {
            return super.equals(event)  && eventTime == getEventTime();
        }
        return false;
    } //

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), eventTime);
    }

    @Override
    public String toString () { return super.toString(); }// + " " + eventTime.toString(); }
} // end class MovementEvent
