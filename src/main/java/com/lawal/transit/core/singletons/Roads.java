package com.lawal.transit.core.singletons;

import com.lawal.transit.core.abstracts.AbstractRoad;

import java.util.ArrayList;
import java.util.Iterator;

public enum Roads {
    INSTANCE;
    private ArrayList<AbstractRoad> abstractRoads = new ArrayList<>();


    public int size () {
        return abstractRoads.size();
    }


    public ArrayList<AbstractRoad> getRoads () {
        return abstractRoads;
    }


    public void add (AbstractRoad abstractRoad) {
        if (!abstractRoads.contains(abstractRoad)) {
            abstractRoads.add(abstractRoad);
        }
    }


    public Iterator<AbstractRoad> iterator () {
        return abstractRoads.iterator();
    }


    public AbstractRoad search (String roadName) {
        AbstractRoad abstractRoad = Avenues.INSTANCE.search(roadName);
        if (abstractRoad == null) {
            abstractRoad = Streets.INSTANCE.search(roadName);
        }
        return abstractRoad;
    }


    public String toString () {
        return "Roads\n-------\n" + Avenues.INSTANCE.toString() + "\n" + Streets.INSTANCE.toString();
    }
} // end class Roads
