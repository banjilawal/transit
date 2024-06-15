package com.lawal.transit.core.singletons;

import com.lawal.transit.*;
import com.lawal.transit.core.abstracts.*;
import com.lawal.transit.core.concretes.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.*;

public enum Buildings {
    INSTANCE;
    ArrayList<AbstractBuilding> abstractBuildings = new ArrayList<>();


    public ArrayList<AbstractBuilding> getBuildings () {
        return abstractBuildings;
    }


    public void add (AbstractBuilding abstractBuilding) {
        if (abstractBuildings.contains(abstractBuilding)) {
            throw new IllegalArgumentException("AbstractBuilding " + abstractBuilding.getName()
                + " already exists add cannot add another");
        }
        abstractBuildings.add(abstractBuildings.size(), abstractBuilding);
    }


    public AbstractBuilding search (int id) {
        for (AbstractBuilding abstractBuilding : abstractBuildings) {
            if (abstractBuilding.getId() == id) {
                return abstractBuilding;
            }
        }
        return null;
    }


    public AbstractBuilding search (String name, AbstractRoad abstractRoad, Orientation orientation) {
        for (AbstractBuilding abstractBuilding : abstractBuildings) {
            if (abstractBuilding.getName().equalsIgnoreCase(name)
                && abstractBuilding.getRoad().equals(abstractRoad)
                && abstractBuilding.getOrientation().equals(orientation)
            ) {
                return abstractBuilding;
            }
        }
        return null;
    }

    public Iterator<AbstractBuilding> iterator () {
        return abstractBuildings.iterator();
    }


    public ArrayList<AbstractBuilding> filter (Predicate<AbstractBuilding> predicate) {
        ArrayList<AbstractBuilding> matches = new ArrayList<>();
        for (AbstractBuilding abstractBuilding : abstractBuildings) {
            if ((predicate.test(abstractBuilding) && !matches.contains(abstractBuilding))) {
                matches.add(matches.size(), abstractBuilding);
            }
        }
        return matches;
    }


    @Override
    public String toString () {
        String string = "Buildings\n------------\n";
        for (AbstractBuilding abstractBuilding : abstractBuildings) {
            string += abstractBuilding.toString() + "\n";
        }
        return string;
    }
} // end class Buildings
