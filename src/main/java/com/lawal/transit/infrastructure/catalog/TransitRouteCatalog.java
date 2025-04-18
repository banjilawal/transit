package com.lawal.transit.infrastructure.catalog;

import com.lawal.transit.infrastructure.bus.BusRoute;
import com.lawal.transit.infrastructure.road.Road;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum TransitRouteCatalog {
    INSTANCE;

    private final List<BusRoute> catalog;

    TransitRouteCatalog () {
        catalog = new ArrayList<>();
    }

    public List<BusRoute> getCatalog() { return List.copyOf(catalog); }

    public int size() { return catalog.size(); }

    public void addRoute (BusRoute busRoute) {
        if (busRoute == null) return;
        if (catalog.contains(busRoute)) return;
        catalog.add(busRoute);
    }

    public BusRoute findById(Long id) {
        if (id == null) return null;

        for (BusRoute busRoute : catalog) {
            if (busRoute.getId().equals(id)) return busRoute;
        }
        return null;
    }

    public BusRoute findByName(String name) {
        if (name == null) return null;

        for (BusRoute busRoute : catalog) {
            if (busRoute.getName().equalsIgnoreCase(name)) return busRoute;
        }
        return null;
    }

    public List<BusRoute> filterByRoad(Road road){
        List<BusRoute> matches = new ArrayList<>();

        if (road == null) return matches;
        for (BusRoute busRoute : catalog) {
            if (!busRoute.filterByRoad(road).isEmpty() && !matches.contains(busRoute)) matches.add(busRoute);
        }
        return List.copyOf(matches);
    }
}