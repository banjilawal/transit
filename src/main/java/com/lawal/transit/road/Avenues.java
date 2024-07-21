package com.lawal.transit.road;

import java.util.*;

public class Avenues {

    private final ArrayList<Avenue> avenues;

    public Avenues () {
        this.avenues = new ArrayList<>();
    }

    public int numberOfRoads () {
        return avenues.size();
    }

    public ArrayList<Avenue> getAvenues () {
        return avenues;
    }


    public Iterator<Avenue> iterator () {
        return avenues.iterator();
    }


    public void add (Avenue avenue) throws Exception {
//        if (!(road instanceof Avenue)) {
//            throw new Exception("You should only add an Avenue to the avenues collection");
//        }
//        Avenue avenue = (Avenue) road;
        if (avenues.contains(avenue)) {
            throw new Exception(avenue.toString() + " is already in the collection");
        }
        avenues.add(avenues.size(), avenue);
    }


    public Avenue search (RoadIdentifiable identifier) {
        for(Avenue avenue : avenues) {
            if (avenue.getIdentifier().equals(identifier))
                return avenue;
        }
        return null;
    }


    public void remove (RoadIdentifiable identifier) throws Exception {
        int index = avenues.indexOf(search(identifier));
        if (index < 0) {
            throw new Exception("NO road with identifier:" + identifier.toString() + " was found. Removal attempt unsuccessful");
        }
        avenues.remove(index);
    }
}
