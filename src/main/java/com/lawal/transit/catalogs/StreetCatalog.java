package com.lawal.transit.catalogs;


import com.lawal.transit.roads.Avenues;
import com.lawal.transit.roads.Streets;
import lombok.Getter;

@Getter
public enum StreetCatalog {
    INSTANCE;

    private final Streets catalog;

    StreetCatalog () {
        catalog = new Streets();
    }
}