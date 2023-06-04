package com.lawal.transit.core.singletons;

import com.lawal.transit.core.collections.Bag;
import com.lawal.transit.core.entities.RegularBusRoute;
import com.lawal.transit.core.interfaces.BagWrapper;

import java.util.Iterator;

public enum RegularBusRoutes  {
    INSTANCE;
    public Bag<RegularBusRoute> routes = new Bag<RegularBusRoute>();

    public Bag<RegularBusRoute> getRegularBusRoutes() {
        return routes;
    }
} // end enum RegularBusRoutes