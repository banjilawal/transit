package com.lawal.transit.catalog;


import com.lawal.transit.avenue.model.Avenue;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum AvenueCatalog {
    INSTANCE;

    private final List<Avenue> catalog;

    AvenueCatalog () {
        catalog = new ArrayList<>();
    }
}