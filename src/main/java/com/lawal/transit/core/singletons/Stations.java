package com.lawal.transit.core.singletons;

import com.lawal.transit.core.concretes.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.*;

public enum Stations {
    INSTANCE;
    private final ArrayList<OldAbstractStation> oldAbstractStations = new ArrayList<>();

    public int size () {
        return oldAbstractStations.size();
    }

    public ArrayList<OldAbstractStation> getStations () {
        return oldAbstractStations;
    }

    public void add (OldAbstractStation oldAbstractStation) {
        if (oldAbstractStations.contains(oldAbstractStation)) {
            throw new IllegalArgumentException("OldConcreteBlock " + oldAbstractStation.getName()
                + " already exists add cannot add another");
        }
        oldAbstractStations.add(oldAbstractStations.size(), oldAbstractStation);
    }

    public OldAbstractStation search (int id) {
        for (OldAbstractStation oldAbstractStation : oldAbstractStations) {
            if (oldAbstractStation.getId() == id) {
                return oldAbstractStation;
            }
        }
        return null;
    }

    public OldAbstractStation search (String name) {
        for (OldAbstractStation oldAbstractStation : oldAbstractStations) {
            if (oldAbstractStation.getName().equalsIgnoreCase(name)) {
                return oldAbstractStation;
            }
        }
        return null;
    }

    public Iterator<OldAbstractStation> iterator () {
        return oldAbstractStations.iterator();
    }

    public ArrayList<OldAbstractStation> filter (Predicate<OldAbstractStation> predicate) {
        ArrayList<OldAbstractStation> matches = new ArrayList<>();
        for (OldAbstractStation oldAbstractStation : oldAbstractStations) {
            if ((predicate.test(oldAbstractStation) && !matches.contains(oldAbstractStation))) {
//                System.out.println(oldAbstractStation.getName() + " matches");
                matches.add(matches.size(), oldAbstractStation);
            }
        }
        return matches;
    }


    @Override
    public String toString () {
        String string = "Vertices\n------------\n";
        for (OldAbstractStation oldAbstractStation : oldAbstractStations) {
            string += oldAbstractStation.toString() + "\n";
        }
        return string;
    }
} // end class Vertices
