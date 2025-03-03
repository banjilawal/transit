package com.lawal.transit.catalog;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.street.model.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public enum RoadCatalog {
    INSTANCE;

    private final List<Road> catalog;

    RoadCatalog () { catalog = new ArrayList<>(); }

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