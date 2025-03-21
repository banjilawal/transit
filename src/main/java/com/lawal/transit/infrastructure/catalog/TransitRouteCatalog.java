package com.lawal.transit.infrastructure.catalog;

import com.lawal.transit.infrastructure.road.Road;
import com.lawal.transit.infrastructure.schedule.Route;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum TransitRouteCatalog {
    INSTANCE;

    private final List<Route> catalog;

    TransitRouteCatalog () {
        catalog = new ArrayList<>();
    }

    public List<Route> getCatalog() { return List.copyOf(catalog); }

    public int size() { return catalog.size(); }

    public void addRoute (Route route) {
        if (route == null) return;
        if (catalog.contains(route)) return;
        catalog.add(route);
    }

    public Route findById(Long id) {
        if (id == null) return null;

        for (Route route : catalog) {
            if (route.getId().equals(id)) return route;
        }
        return null;
    }

    public Route findByName(String name) {
        if (name == null) return null;

        for (Route route : catalog) {
            if (route.getName().equalsIgnoreCase(name)) return route;
        }
        return null;
    }

    public List<Route> filterByRoad(Road road){
        List<Route> matches = new ArrayList<>();

        if (road == null) return matches;
        for (Route route : catalog) {
            if (!route.filterByRoad(road).isEmpty() && !matches.contains(route)) matches.add(route);
        }
        return List.copyOf(matches);
    }
}