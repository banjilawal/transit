package com.lawal.transit.catalog;

import com.lawal.transit.road.model.Road;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum RoadCatalog {
    INSTANCE;

    private final List<Road> catalog;

    RoadCatalog () { catalog = new ArrayList<>(); }

    public List<Road> getCatalog() { return catalog; }
}