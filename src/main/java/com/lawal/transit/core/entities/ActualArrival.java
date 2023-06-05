package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.DestinationName;

import java.time.LocalTime;
import java.util.Objects;

public class ActualArrival extends DestinationName {
    private LocalTime time;

    public ActualArrival (int id, Station station, LocalTime time) {
        super(id, station);
        this.time = time;
    } // close constructor

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
        if (object instanceof ActualArrival) {
            ActualArrival actualArrivalItem = (ActualArrival) object;
            if (super.equals(actualArrivalItem)) {
                if (time.compareTo(actualArrivalItem.getTime()) == 0 ) {
                    return true;
                }
            }
        }
        return  false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), time);
    } // close hashCode

    @Override
    public String toString () {
        return super.toString() + " Arrival:" + time.toString();
    } // close toString
} // end class TransitArrivalItem
