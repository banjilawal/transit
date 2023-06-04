package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.BusRoute;
import com.lawal.transit.core.abstracts.TransitRoute;
import com.lawal.transit.core.enums.TransitRouteCategory;

public class RegularBusRoute extends BusRoute {

    public RegularBusRoute (int id, String name) {
        super(id, name, GlobalConstant.TRANSIT_START_TIME, GlobalConstant.TRANSIT_END_TIME,
                GlobalConstant.REGULAR_MINIMUM_INTERARRIVAL_TIME); //, TransitRouteCategory.REGULAR);
    }

    @Override
    public void setInterArrivalTime (int interArrivalTime) {
        if (interArrivalTime >= GlobalConstant.REGULAR_MINIMUM_INTERARRIVAL_TIME
                && interArrivalTime < GlobalConstant.REGULAR_MAXIMUM_INTERARRIVAL_TIME) {
            super.setInterArrivalTime(interArrivalTime);
        }
    } //close setInterArrivalTime

    @Override
    public boolean equals (Object object) {
        if (object instanceof RegularBusRoute) {
            RegularBusRoute regularBusRoute = (RegularBusRoute) object;
            if (super.equals(regularBusRoute)) {
                return true;
            }
        }
        return false;
    } // close equals
} // end class RegularBusRoute