package com.lawal.transit.catalogs;


import com.lawal.transit.roads.Avenues;
import lombok.Getter;

@Getter
public enum AvenueCatalog {
    INSTANCE;

    private final Avenues catalog;

    AvenueCatalog () {
        catalog = new Avenues();
    }
}