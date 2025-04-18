package com.lawal.transit.infrastructure.catalog;


import com.lawal.transit.infrastructure.street.Street;
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

    public List<Street> getCatalog() { return List.copyOf(catalog); }

    public int size() { return catalog.size(); }

    public void addStreet (Street street) {
        if (street == null) return;
        if (catalog.contains(street)) return;
        catalog.add(street);
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