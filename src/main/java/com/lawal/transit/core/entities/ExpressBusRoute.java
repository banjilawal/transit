package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.BusRoute;
import com.lawal.transit.core.enums.Direction;
import com.lawal.transit.core.enums.GlobalConstant;

public class ExpressBusRoute extends BusRoute {
    private static final long serialVersionUID = 1L;

    public ExpressBusRoute (int id, String name, Direction outboundDirection ) {
        super(id, name,
            GlobalConstant.TRANSIT_START_TIME,
            GlobalConstant.TRANSIT_END_TIME,
            GlobalConstant.EXPRESS_MINIMUM_INTERARRIVAL_TIME,
            outboundDirection
        );
    } // close constructor

    @Override
    public void setInterArrivalTime (int interArrivalTime) {
        if (interArrivalTime >= GlobalConstant.EXPRESS_MINIMUM_INTERARRIVAL_TIME
                && interArrivalTime < GlobalConstant.EXPRESS_MAXIMUM_INTERARRIVAL_TIME) {
            super.setInterArrivalTime(interArrivalTime);
        }
    } //close setInterArrivalTime

    @Override
    public boolean equals (Object object) {
        if (object instanceof ExpressBusRoute busRoute) return super.equals(busRoute);
        return false;
    } // close equals
} // end class TransitRoute
