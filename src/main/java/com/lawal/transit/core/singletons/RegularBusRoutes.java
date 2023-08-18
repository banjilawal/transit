package com.lawal.transit.core.singletons;

import com.lawal.transit.core.collections.Bag;
import com.lawal.transit.core.entities.RegularBusRoute;
import com.lawal.transit.core.interfaces.BagWrapper;

import java.util.ArrayList;
import java.util.Iterator;

public enum RegularBusRoutes implements BagWrapper<RegularBusRoute> {
    INSTANCE;
    private Bag<RegularBusRoute> routes = new Bag<RegularBusRoute>();

    @Override
    public int size() { return routes.size(); }

    @Override
    public void add(RegularBusRoute busRoute) { routes.add(busRoute); }

    @Override
    public void remove(RegularBusRoute busRoute) { routes.remove(busRoute);}

    @Override
    public Bag<RegularBusRoute> getBag() {
        return routes;
    }

    @Override
    public Iterator<RegularBusRoute> iterator() {
        return routes.iterator();
    }

    @Override
    public ArrayList<RegularBusRoute> getBagContents() {
        return routes.getContents();
    }

    public ArrayList<String> getRoutNames () {
        ArrayList<String> names = new ArrayList<String>();
        for (RegularBusRoute route : routes.getContents()) {
            names.add(names.size(), route.getName());
        }
        return names;
    } //
} // end enum RegularBusRoutes