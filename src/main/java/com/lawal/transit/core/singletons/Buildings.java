package com.lawal.transit.core.singletons;

import com.lawal.transit.core.containers.Bag;
import com.lawal.transit.core.entities.Building;
import com.lawal.transit.core.interfaces.BagWrapper;

import java.util.ArrayList;
import java.util.Iterator;

public enum Buildings implements BagWrapper<Building> {
    INSTANCE;
    public final Bag<Building> buildings = new Bag<Building>();

   private Bag<Building> getBuildings () {
        return buildings;
    }

    @Override
    public int size() {
        return buildings.size();
    }

    @Override
    public void add(Building building) {
       buildings.add(building);
    }

    @Override
    public void remove(Building building) {
       buildings.remove(building);
    }

    @Override
    public Bag<Building> getBag() {
        return buildings;
    }

    @Override
    public Iterator<Building> iterator() {
        return buildings.iterator();
    }

    @Override
    public ArrayList<Building> getBagContents() {
        return  buildings.getContents();
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
