package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.TransitRoute;
import com.lawal.transit.middleware.enums.TransitRouteCategory;

public class ExpressBusRoute extends TransitRoute {
    private static final long serialVersionUID = 1L;

    public static int MINIMUM_EXPRESS_INTERARRIVAL_TIME = 8;
    public static int MAXIMUM_EXPRESS_INTERARRIVAL_TIME = 15;

    public ExpressBusRoute (int id, String name) {
        super(id, name, DEFAULT_START_TIME, DEFAULT_END_TIME, MINIMUM_EXPRESS_INTERARRIVAL_TIME, TransitRouteCategory.EXPRESS);
    }

    public void setInterArrivalTime (int interArrivalTime) {
        if (interArrivalTime >= MINIMUM_EXPRESS_INTERARRIVAL_TIME && interArrivalTime < MAXIMUM_EXPRESS_INTERARRIVAL_TIME) {
            super.setInterArrivalTime(interArrivalTime);
        }
    } //close setInterArrivalTime

    @Override
    public boolean equals (Object object) {
      if (object instanceof ExpressBusRoute) {
          ExpressBusRoute expressBusRoute = (ExpressBusRoute) object;
          if (super.equals(expressBusRoute)) {
              return true;
          }
      }
      return false;
    } // close equals
} // end class TransitRoute
