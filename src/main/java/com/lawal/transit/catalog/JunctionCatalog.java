package com.lawal.transit.catalog;


import com.lawal.transit.junction.Junctions;
import lombok.Getter;


@Getter
public enum JunctionCatalog {
    INSTANCE;

    private final Junctions catalog;

    JunctionCatalog () {
        catalog = new Junctions();
    }
}