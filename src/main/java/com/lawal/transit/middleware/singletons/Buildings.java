package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.entities.Building;
import com.lawal.transit.middleware.enums.Direction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public enum Buildings {
    INSTANCE;
    public final Bag<Building> bag = new Bag<>();

    public Bag<Building> getBag() {
        return bag;
    }

    public Iterator<Building> search (Predicate<Building> predicate) {
        ArrayList<Building> buildings = new ArrayList<Building>();
        for (Building building : bag.getBag()) {
            if (predicate.test(building)) {
                buildings.add(buildings.size(), building);
            }
        }
        return buildings.iterator();
    } // close search

    public Building search (String buildingName, Road road, Direction buildCurbSide) {
        for (Building building : bag.getBag()) {
            if (building.getRoad().equals(road) && building.getCurbSide().compareTo(buildCurbSide) == 0) {
                if (building.getName().equalsIgnoreCase(buildingName)) {
                    return building;
                }
            }
        }
        return null;
    } // close search
} // end class Buildings
