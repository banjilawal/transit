package com.lawal.transit.catalog;


import com.lawal.transit.road.Curbs;
import lombok.Getter;

@Getter
public enum CurbCatalog {
    INSTANCE;

    private final Curbs catalog;

    CurbCatalog () {
        catalog = new Curbs();
    }
}