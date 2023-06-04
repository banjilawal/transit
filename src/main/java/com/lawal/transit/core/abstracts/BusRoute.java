package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.entities.RegularBusRoute;

import java.time.LocalTime;

public abstract class BusRoute extends TransitRoute {
    public BusRoute (int id, String name, LocalTime startTime, LocalTime endTime, int interArrivalTime) {
        super(id, name, startTime, endTime, interArrivalTime);
    } // close constructor

    @Override
    public boolean equals (Object object) {
        if (object instanceof BusRoute) {
            BusRoute busRoute = (BusRoute) object;
            if (super.equals(busRoute)) {
                return true;
            }
        }
        return false;
    } // close equals
} // end class
