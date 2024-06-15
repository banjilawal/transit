package com.lawal.transit.core.concretes;

import com.lawal.transit.core.abstracts.BusRoute;
import com.lawal.transit.Orientation;
import com.lawal.transit.core.global.Constant;

public class ExpressBusRoute extends BusRoute {

    private static final long serialVersionUID = 1L;


    public ExpressBusRoute (int id, String name, Orientation outboundOrientation) {
        super(id, name, outboundOrientation, Constant.EXPRESS_MINIMUM_INTERARRIVAL_TIME);
    }
} // end class ExpressBusRoute
