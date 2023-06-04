package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.ArrivalItem;

import java.time.LocalTime;
import java.util.Objects;

public class ActualArrivalItem extends ArrivalItem {
    private LocalTime actualArrival;

    public ActualArrivalItem (int id, String transitRouteType, String transitRouteName, String stationName, LocalTime actualArrival) {
        super(id, transitRouteType, transitRouteName, stationName);
        this.actualArrival = actualArrival;
    } // close constructor

    public LocalTime getActualArrival () {
        return actualArrival;
    }

    public void setActualArrival(LocalTime actualArrival) {
        this.actualArrival = actualArrival;
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof ActualArrivalItem) {
            ActualArrivalItem actualArrivalItem = (ActualArrivalItem) object;
            if (super.equals(actualArrivalItem)) {
                if (actualArrival.compareTo(actualArrivalItem.getActualArrival()) == 0 ) {
                    return true;
                }
            }
        }
        return  false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), actualArrival);
    } // close hashCode

    @Override
    public String toString () {
        return super.toString() + " Arrival:" + actualArrival.toString();
    } // close toString
} // end class TransitArrivalItem
