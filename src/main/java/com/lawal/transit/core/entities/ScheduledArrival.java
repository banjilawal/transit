package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.DestinationName;

import java.time.LocalTime;

public class ScheduledArrival extends DestinationName {
    private LocalTime time;

    public ScheduledArrival (int id, Station station, LocalTime time) {
        super(id, station);
        this.time = time;
    }

    @Override
    public LocalTime getTime () {
        return time;
    }

    @Override
    public void setTime (LocalTime time) {
        this.time = time;
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof ScheduledArrival) {
            ScheduledArrival scheduledArrivalItem = (ScheduledArrival) object;
            if (super.equals(scheduledArrivalItem)) {
                if (time.compareTo(scheduledArrivalItem.getTime()) == 0) {
                    return true;
                }
            }
        }
        return false;
    } // close equals

    @Override
    public String toString () {
        return  super.toString() + " Scheduled Arrival:" + time.toString();
    } // close toString
} // end class ScheduledArrivalItem
