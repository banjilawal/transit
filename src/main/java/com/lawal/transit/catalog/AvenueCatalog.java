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

    public List<Avenue> getCatalog() { return List.copyOf(catalog); }

    public void addAvenue (Avenue avenue) {
        if (avenue == null) return;
        if (catalog.contains(avenue)) return;
        catalog.add(avenue);
    }

    public Avenue findById(Long id) {
        if (id == null) return null;

        for (Avenue avenue : catalog) {
            if (avenue.getId().equals(id)) {
                return avenue;
            }
        }
        return null;
    }

    public Avenue findByName(String name) {
        if (name == null) return null;
        for (Avenue avenue : catalog) {
            if (avenue.getName().equalsIgnoreCase(name)) return avenue;
        }
        return null;
    }
}