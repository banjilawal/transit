package com.lawal.transit.core.singletons;

import com.lawal.transit.core.collections.Bag;
import com.lawal.transit.core.entities.ExpressBusRoute;
import com.lawal.transit.core.interfaces.BagWrapper;

import java.util.Iterator;

public enum ExpressBusRoutes {
    INSTANCE;
    public final Bag<ExpressBusRoute> routes = new Bag<ExpressBusRoute>();

    public Bag<ExpressBusRoute> getExpressBusRoutes() {
        return routes;
    }
} // end enum ExpressBusRoutes
