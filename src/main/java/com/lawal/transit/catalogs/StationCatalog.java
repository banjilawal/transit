package com.lawal.transit.catalogs;

import com.lawal.transit.stations.Stations;
import lombok.Getter;

@Getter
public enum StationCatalog {
    INSTANCE;

    private final Stations catalog;

    StationCatalog () {
        catalog = new Stations();
    }
}