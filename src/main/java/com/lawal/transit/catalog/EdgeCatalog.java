package com.lawal.transit.catalog;

import com.lawal.transit.edge.model.Edge;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum EdgeCatalog {
    INSTANCE;

    private final List<Edge> catalog;

    EdgeCatalog () { catalog = new ArrayList<>(); }
}