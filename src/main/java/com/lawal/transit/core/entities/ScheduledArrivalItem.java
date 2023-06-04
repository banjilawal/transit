package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.ArrivalItem;

import java.time.LocalTime;
import java.util.Objects;

public class ScheduledArrivalItem extends ArrivalItem {
    private LocalTime scheduledArrival;

    public ScheduledArrivalItem (int id, String transitRouteType, String transitRouteName, String stationName, LocalTime scheduledArrival) {
        super(id, transitRouteType, transitRouteName, stationName);
        this.scheduledArrival = scheduledArrival;
    }

    public LocalTime getScheduledArrival () {
        return scheduledArrival;
    }
    public void setScheduledArrival (LocalTime scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof ScheduledArrivalItem) {
            ScheduledArrivalItem scheduledArrivalItem = (ScheduledArrivalItem) object;
            if (super.equals(scheduledArrivalItem)) {
                if (scheduledArrival.compareTo(scheduledArrivalItem.getScheduledArrival()) == 0) {
                    return true;
                }
            }
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), scheduledArrival);
    } // close hashCode

    @Override
    public String toString () {
        String string = super.toString() + " Scheduled Arrival:" + scheduledArrival.toString();
        return string;
    } // close toString
} // end class ScheduledArrivalItem
