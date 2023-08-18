package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.RouteSchedule;
import com.lawal.transit.core.abstracts.TransitRoute;

public class RegularSchedule extends RouteSchedule {

    public RegularSchedule(int id, RegularBusRoute busRoute) {
        super(id, busRoute);
    }

    @Override
    public TransitRoute getRoute () { return null; }

    @Override
    public boolean equals (Object object) {
        if (object instanceof  RegularSchedule routeSchedule) {
            return super.equals(routeSchedule);
        }
        return false;
    }
} // end class RegularSchedule
