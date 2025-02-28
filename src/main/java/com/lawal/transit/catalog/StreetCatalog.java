package com.lawal.transit.catalog;


import com.lawal.transit.roadEntity.Streets;
import lombok.Getter;

@Getter
public enum StreetCatalog {
    INSTANCE;

    private final Streets catalog;

    StreetCatalog () {
        catalog = new Streets();
    }
}