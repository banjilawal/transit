package com.lawal.transit.core.singletons;

import com.lawal.transit.core.containers.Bag;
import com.lawal.transit.core.entities.ExpressBusRoute;
import com.lawal.transit.core.interfaces.BagWrapper;

import java.util.ArrayList;
import java.util.Iterator;

public enum ExpressBusRoutes implements BagWrapper<ExpressBusRoute> {
    INSTANCE;
    private final Bag<ExpressBusRoute> routes = new Bag<ExpressBusRoute>();

    @Override
    public int size() {
        return routes.size();
    }

    @Override
    public void add(ExpressBusRoute expressBusRoute) {
        routes.add(expressBusRoute);
    }

    @Override
    public void remove(ExpressBusRoute expressBusRoute) {
        routes.remove(expressBusRoute);
    }

    @Override
    public Bag<ExpressBusRoute> getBag() {
        return routes;
    }

    @Override
    public Iterator<ExpressBusRoute> iterator() {
        return routes.iterator();
    }

    @Override
    public ArrayList<ExpressBusRoute> getBagContents() {
        return routes.getContents();
    }

    public ArrayList<String> getRoutNames () {
        ArrayList<String> names = new ArrayList<String>();
        for (ExpressBusRoute route : routes.getContents()) {
            names.add(names.size(), route.getName());
        }
        return names;
    } //
} // end enum ExpressBusRoutes
