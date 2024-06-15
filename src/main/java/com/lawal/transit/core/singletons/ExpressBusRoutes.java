package com.lawal.transit.core.singletons;

import com.lawal.transit.*;
import com.lawal.transit.core.concretes.*;
import com.lawal.transit.core.visitors.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.*;

public enum ExpressBusRoutes {
    INSTANCE;
    private final ArrayList<ExpressBusRoute> routes = new ArrayList<>();


    public int size() { return routes.size(); }

    public ArrayList<ExpressBusRoute> getRoutes () {
        return routes;
    }

    public void add (ExpressBusRoute busRoute) {
        if (routes.contains(busRoute)) {
            throw new IllegalArgumentException("An bus route named " + busRoute.getName() + " already exists add cannot add another");
        }
        routes.add(routes.size(), busRoute);
    }

    public boolean add (String name, Orientation orientation) {
        if (search(name) == null)
            return routes.add(new ExpressBusRoute(ExpressBusRouteIdGenerator.INSTANCE.nextId(), name, orientation));
        return true;
    }

    public ExpressBusRoute search (int id) {
        for (ExpressBusRoute route : routes) {
            if (route.getId() == id)
                return route;
        }
        return null;
    }

    public ExpressBusRoute search (String name) {
        for (ExpressBusRoute route : routes) {
            if (route.getName().equalsIgnoreCase(name))
                return route;
        }
        return null;
    }

    public Iterator<ExpressBusRoute> iterator () {
        return routes.iterator();
    }

    public ArrayList<ExpressBusRoute> filter (Predicate<ExpressBusRoute> predicate) {
        ArrayList<ExpressBusRoute> matches = new ArrayList<>();
        for (ExpressBusRoute route : routes) {
            if (predicate.test(route) && !matches.contains(route)) {
                matches.add(matches.size(), route);
            }
        }
        return matches;
    }

    @Override
    public String toString () {
        String string = "Regular Bus Routes:\n";
        for (ExpressBusRoute route : routes) {
            string += route.toString() + "\n";
        }
        return string;
    }
} // end enum ExpressBusRoutes
