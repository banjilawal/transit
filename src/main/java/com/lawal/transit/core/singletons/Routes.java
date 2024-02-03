package com.lawal.transit.core.singletons;

import com.lawal.transit.core.abstracts.*;

import java.util.*;
import java.util.function.*;

public enum Routes {
    INSTANCE;
    public RegularBusRoutes regularBusRoutes = RegularBusRoutes.INSTANCE;
    public ExpressBusRoutes expressBusRoutes = ExpressBusRoutes.INSTANCE;

    public ArrayList<BusRoute> filter (Predicate<BusRoute> predicate) {
        ArrayList<BusRoute> matches = new ArrayList<>();
        return matches;
    }

//    public String toString () {
//        return "\t\t\tTransitRoutes\n\t\t--------------\n" + regularBusRoutes.getRegularBusRoutes().toString()
//                + "\n" + expressBusRoutes.getExpressBusRoutes().toString();
//    } // close toString
} // end class Roads
