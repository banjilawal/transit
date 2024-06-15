package com.lawal.transit.core.concretes;

import com.lawal.transit.core.abstracts.*;
import com.lawal.transit.Orientation;
import com.lawal.transit.core.global.Constant;

public class RegularBusRoute extends BusRoute {

    public RegularBusRoute (int id, String name, Orientation outboundOrientation) {
        super(id, name, outboundOrientation, Constant.REGULAR_MINIMUM_INTERARRIVAL_TIME);
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof RegularBusRoute busRoute) {
            return super.equals(busRoute);
        }
        return false;
    }
} // end class RegularBusRoute