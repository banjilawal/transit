package com.lawal.transit.catalog;


import com.lawal.transit.roadEntity.Avenues;
import lombok.Getter;

@Getter
public enum AvenueCatalog {
    INSTANCE;

    private final Avenues catalog;

    AvenueCatalog () {
        catalog = new Avenues();
    }
}