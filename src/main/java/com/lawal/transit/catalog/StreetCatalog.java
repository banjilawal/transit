package com.lawal.transit.catalog;


import com.lawal.transit.street.model.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum StreetCatalog {
    INSTANCE;

    private final List<Street> catalog;

    StreetCatalog () {
        catalog = new ArrayList<>();
    }
}