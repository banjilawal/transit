package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.enums.Direction;

import java.time.LocalTime;

public abstract class BusRoute extends TransitRoute {
    public BusRoute (int id, String name, LocalTime startTime, LocalTime endTime, int interArrivalTime, Direction outgoing) {
        super(id, name, startTime, endTime, interArrivalTime, outgoing);
    } // close constructor

    @Override
    public boolean equals (Object object) {
        if (object instanceof BusRoute busRoute) return super.equals(busRoute);
        return false;
    } // close equals
} // end class
