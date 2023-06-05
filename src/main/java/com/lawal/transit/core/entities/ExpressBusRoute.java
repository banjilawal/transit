package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.BusRoute;

public class ExpressBusRoute extends BusRoute {
    private static final long serialVersionUID = 1L;

    public ExpressBusRoute (int id, String name) {
        super(id, name,
                GlobalConstant.TRANSIT_START_TIME,
                GlobalConstant.TRANSIT_END_TIME,
                GlobalConstant.EXPRESS_MINIMUM_INTERARRIVAL_TIME);
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
      if (object instanceof ExpressBusRoute) {
          ExpressBusRoute expressBusRoute = (ExpressBusRoute) object;
          if (super.equals(expressBusRoute)) {
              return true;
          }
      }
      return false;
    } // close equals
} // end class TransitRoute
