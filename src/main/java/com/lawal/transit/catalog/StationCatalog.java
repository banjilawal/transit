package com.lawal.transit.catalog;

import com.lawal.transit.station.Stations;
import lombok.Getter;

@Getter
public enum StationCatalog {
    INSTANCE;

    private final Stations catalog;

    StationCatalog () {
        catalog = new Stations();
    }
}