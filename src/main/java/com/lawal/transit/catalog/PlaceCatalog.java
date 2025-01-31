package com.lawal.transit.catalog;


import com.lawal.transit.places.interfaces.Placeable;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
public enum PlaceCatalog {
    INSTANCE;

    private final Set<Placeable> catalog;

    PlaceCatalog () { catalog = new HashSet<>(); }

    public int getSize() { return catalog.size(); }

    public List<Placeable> getPlaces() {
        return new ArrayList<>(catalog);
    }

    public void addPlace(Placeable placeable) {
        catalog.add(placeable);
    }

    public void removePlace(int id) {
       Placeable placeable = findById(id);
       if (placeable != null) catalog.remove(placeable);
    }

    public Placeable findById (int id) {
        for (Placeable placeable : catalog) {
            if (placeable.address().id() == id) return placeable;
        }
        return null;
    }
}