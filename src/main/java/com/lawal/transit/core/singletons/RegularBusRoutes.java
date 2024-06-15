package com.lawal.transit.core.singletons;

import com.lawal.transit.*;
import com.lawal.transit.core.concretes.*;
import com.lawal.transit.core.visitors.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.*;

public enum RegularBusRoutes {
    INSTANCE;

    private ArrayList<RegularBusRoute> routes = new ArrayList<>();


    public int size() { return routes.size(); }

    public ArrayList<RegularBusRoute> getRoutes () {
        return routes;
    }

    public void add (RegularBusRoute busRoute) {
        if (routes.contains(busRoute)) {
            throw new IllegalArgumentException("An bus route named " + busRoute.getName() + " already exists add cannot add another");
        }
        routes.add(routes.size(), busRoute);
    }

    public boolean add (String name, Orientation orientation) {
        if (search(name) == null)
            return routes.add(new RegularBusRoute(RegularBusRouteIdGenerator.INSTANCE.nextId(), name, orientation));
        return true;
    }

    public RegularBusRoute search (int id) {
        for (RegularBusRoute route : routes) {
            if (route.getId() == id)
                return route;
        }
        return null;
    }

    public RegularBusRoute search (String name) {
        for (RegularBusRoute route : routes) {
            if (route.getName().equalsIgnoreCase(name))
                return route;
        }
        return null;
    }

    public Iterator<RegularBusRoute> iterator () {
        return routes.iterator();
    }

    public ArrayList<RegularBusRoute> filter (Predicate<RegularBusRoute> predicate) {
        ArrayList<RegularBusRoute> matches = new ArrayList<>();
        for (RegularBusRoute route : routes) {
            if (predicate.test(route) && !matches.contains(route)) {
                matches.add(matches.size(), route);
            }
        }
        return matches;
    }

    @Override
    public String toString () {
        String string = "Regular Bus Routes:\n";
        for (RegularBusRoute route : routes) {
            string += route.toString() + "\n";
        }
        return string;
    }
} // end enum RegularBusRoutes