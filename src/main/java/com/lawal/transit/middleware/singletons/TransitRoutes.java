package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.entities.RegularBusRoute;

public enum TransitRoutes {
    INSTANCE;
    public RegularBusRoutes regularBusRoutes = RegularBusRoutes.INSTANCE;
    public ExpressBusRoutes expressBusRoutes = ExpressBusRoutes.INSTANCE;

    public String toString () {
        return "\t\t\tTransitRoutes\n\t\t--------------\n" + regularBusRoutes.toString() + "\n" + expressBusRoutes.toString();
    }
    public String fullString () {
        return toString();
    }
} // end class Roads
