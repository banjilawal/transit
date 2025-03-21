package com.lawal.transit.infrastructure.catalog;

import com.lawal.transit.infrastructure.avenue.Avenue;
import com.lawal.transit.infrastructure.road.Road;
import com.lawal.transit.infrastructure.street.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public enum RoadCatalog {
    INSTANCE;

    private final List<Road> catalog;

    RoadCatalog () { catalog = new ArrayList<>(); }

    public List<Road> getCatalog() { return List.copyOf(catalog); }

    public void addRoad (Road road) {
        if (road == null) return;
        if (catalog.contains(road)) return;
        catalog.add(road);
    }

    public Road findById(Long id) {
        if (id == null) return null;
        for (Road road : catalog) {
            if (road.getId().equals(id)) return road;
        }
        return null;
    }

    public Road findByAvenue(Avenue avenue) {
        for (Road road : catalog) {
            if (road.getAvenue().equals(avenue)) { return road; }
        }
        return null;
    }

    public Road findByStreet(Street street) {
        for (Road road : catalog) {
            if (road.getStreet().equals(street)) return road;
        }
        return null;
    }
}