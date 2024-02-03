package com.lawal.transit.core.singletons;

import com.lawal.transit.core.abstracts.*;
import com.lawal.transit.core.concretes.*;
import com.lawal.transit.core.enums.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.*;

public enum Buildings {
    INSTANCE;
    ArrayList<Building> buildings = new ArrayList<>();


    public ArrayList<Building> getBuildings () {
        return buildings;
    }


    public void add (Building building) {
        if (buildings.contains(building)) {
            throw new IllegalArgumentException("Building " + building.getName()
                + " already exists add cannot add another");
        }
        buildings.add(buildings.size(), building);
    }


    public Building search (int id) {
        for (Building building : buildings) {
            if (building.getId() == id) {
                return building;
            }
        }
        return null;
    }


    public Building search (String name, Road road, Direction orientation) {
        for (Building building : buildings) {
            if (building.getName().equalsIgnoreCase(name)
                && building.getRoad().equals(road)
                && building.getOrientation().equals(orientation)
            ) {
                return building;
            }
        }
        return null;
    }

    public Iterator<Building> iterator () {
        return buildings.iterator();
    }


    public ArrayList<Building> filter (Predicate<Building> predicate) {
        ArrayList<Building> matches = new ArrayList<>();
        for (Building building : buildings) {
            if ((predicate.test(building) && !matches.contains(building))) {
                matches.add(matches.size(), building);
            }
        }
        return matches;
    }


    @Override
    public String toString () {
        String string = "Buildings\n------------\n";
        for (Building building : buildings) {
            string += building.toString() + "\n";
        }
        return string;
    }
} // end class Buildings
