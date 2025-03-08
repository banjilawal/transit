package com.lawal.transit.catalog;


import com.lawal.transit.road.model.Road;
import com.lawal.transit.route.model.TransitRoute;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum RouteCatalog {
    INSTANCE;

    private final List<TransitRoute> catalog;

    RouteCatalog () {
        catalog = new ArrayList<>();
    }

    public List<TransitRoute> getCatalog() { return List.copyOf(catalog); }

    public void addRoute (TransitRoute transitRoute) {
        if (transitRoute == null) return;
        if (catalog.contains(transitRoute)) return;
        catalog.add(transitRoute);
    }

    public TransitRoute findById(Long id) {
        if (id == null) return null;

        for (TransitRoute transitRoute : catalog) {
            if (transitRoute.getId().equals(id)) return transitRoute;
        }
        return null;
    }

    public TransitRoute findByName(String name) {
        if (name == null) return null;

        for (TransitRoute transitRoute : catalog) {
            if (transitRoute.getName().equalsIgnoreCase(name)) return transitRoute;
        }
        return null;
    }

    public List<TransitRoute> filterByRoad(Road road){
        List<TransitRoute> matches = new ArrayList<>();

        if (road == null) return matches;
        for (TransitRoute route : catalog) {
            if (!route.filterByRoad(road).isEmpty() && !matches.contains(route)) matches.add(route);
        }
        return List.copyOf(matches);
    }
}