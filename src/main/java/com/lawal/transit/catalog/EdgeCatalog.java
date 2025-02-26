package com.lawal.transit.catalog;

import com.lawal.transit.graph.Edges;
import lombok.Getter;

@Getter
public enum EdgeCatalog {
    INSTANCE;

    private final Edges catalog;

    EdgeCatalog () { catalog = new Edges(); }
}