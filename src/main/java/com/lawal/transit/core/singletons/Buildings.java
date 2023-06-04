package com.lawal.transit.core.singletons;

import com.lawal.transit.core.collections.Bag;
import com.lawal.transit.core.entities.Building;

public enum Buildings {
    INSTANCE;
    public final Bag<Building> buildings = new Bag<Building>();

    public Bag<Building> getBuildings () {
        return buildings;
    }

//    public Iterator<Building> search (Predicate<Building> predicate) {
//        ArrayList<Building> buildings = new ArrayList<Building>();
//        for (Building building : bag.getContents()) {
//            if (predicate.test(building)) {
//                buildings.add(buildings.size(), building);
//            }
//        }
//        return buildings.iterator();
//    } // close search
//
//    public Building search (String buildingName, Road road, Direction buildCurbSide) {
//        for (Building building : bag.getContents()) {
//            if (building.getRoad().equals(road) && building.getCurbSide().compareTo(buildCurbSide) == 0) {
//                if (building.getName().equalsIgnoreCase(buildingName)) {
//                    return building;
//                }
//            }
//        }
//        return null;
//    } // close search
} // end class Buildings
