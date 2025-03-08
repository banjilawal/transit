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

    public Street findById(Long id) {
        if (id == null) return null;

        for (Street street : catalog) {
            if (street.getId().equals(id)) return street;
        }
        return null;
    }

    public Street findByName(String name) {
        if (name == null) return null;

        for (Street street : catalog) {
            if (street.getName().equalsIgnoreCase(name)) return street;
        }
        return null;
    }


}