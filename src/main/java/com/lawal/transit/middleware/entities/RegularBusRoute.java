package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.TransitRoute;
import com.lawal.transit.middleware.enums.TransitRouteCategory;

public class RegularBusRoute extends TransitRoute {

    public RegularBusRoute (int id, String name) {
        super(id, name, DEFAULT_START_TIME, DEFAULT_END_TIME, MINIMUM_INTERARRIVAL_TIME, TransitRouteCategory.REGULAR);
    }

    public void setInterArrivalTime (int interArrivalTime) {
        if (interArrivalTime >= MINIMUM_INTERARRIVAL_TIME && interArrivalTime < MAXIMUM_INTERARRIVAL_TIME) {
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