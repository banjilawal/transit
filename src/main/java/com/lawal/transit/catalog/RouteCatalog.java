package com.lawal.transit.catalog;


import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.route.model.TransitRoute;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum RouteCatalog {
    INSTANCE;

    private final List<TransitRoute> catalog;

    RouteCatalog () {
        catalog = new ArrayList<>();
    }

    public TransitRoute findById(Long id) {
        if (id == null) return null;

        for (TransitRoute transitRoute : catalog) {
            if (transitRoute.getId().equals(id)) {
                return transitRoute;
            }
        }
        return null;
    }
}