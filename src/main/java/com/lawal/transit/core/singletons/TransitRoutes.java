package com.lawal.transit.core.singletons;

public enum TransitRoutes {
    INSTANCE;
    public RegularBusRoutes regularBusRoutes = RegularBusRoutes.INSTANCE;
    public ExpressBusRoutes expressBusRoutes = ExpressBusRoutes.INSTANCE;

    public String toString () {
        return "\t\t\tTransitRoutes\n\t\t--------------\n" + regularBusRoutes.getRegularBusRoutes().toString()
                + "\n" + expressBusRoutes.getExpressBusRoutes().toString();
    }
    public String fullString () {
        return toString();
    }
} // end class Roads
