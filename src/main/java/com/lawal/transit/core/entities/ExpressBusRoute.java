package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.BusRoute;
import com.lawal.transit.core.abstracts.TransitRoute;
import com.lawal.transit.core.enums.TransitRouteCategory;

public class ExpressBusRoute extends BusRoute {
    private static final long serialVersionUID = 1L;

//    public static int EXPRESS_MINIMUM_INTERARRIVAL_TIME = 8;
//    public static int EXPRESS_MAXIMUM_INTERARRIVAL_TIME = 15;

    public ExpressBusRoute (int id, String name) {
        super(id, name, DEFAULT_START_TIME, DEFAULT_END_TIME, GlobalConstant.EXPRESS_MINIMUM_INTERARRIVAL_TIME); //, TransitRouteCategory.EXPRESS);
    }

    @Override
    public void setInterArrivalTime (int interArrivalTime) {
        if (interArrivalTime >= GlobalConstant.EXPRESS_MINIMUM_INTERARRIVAL_TIME
                && interArrivalTime < GlobalConstant.EXPRESS_MAXIMUM_INTERARRIVAL_TIME) {
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
