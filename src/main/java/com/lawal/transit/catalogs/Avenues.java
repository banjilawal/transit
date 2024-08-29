package com.lawal.transit.catalogs;

import com.lawal.transit.blocks.*;
import com.lawal.transit.roads.*;

import java.util.*;

public enum Avenues {
    INSTANCE;

    private final ArrayList<Avenue> avenues;

    Avenues () {
        this.avenues = new ArrayList<>();
    }

    public int size () {
        return avenues.size();
    }

    public ArrayList<Avenue> get () {
        return avenues;
    }

    public Iterator<Avenue> iterator () {
        return avenues.iterator();
    }

    public Avenue search (int roadId) {
        for(Avenue avenue : avenues) {
            if (avenue.label().id() == roadId)
                return avenue;
        }
        return null;
    }

    public Avenue search (String roadName) {
        for(Avenue avenue : avenues) {
            if (avenue.label().name().equalsIgnoreCase(roadName))
                return avenue;
        }
        return null;
    }

    public void add (Avenue avenue) throws Exception {
        if (avenues.contains(avenue)) {
            throw new Exception(avenue.toString() + " is already in the collection");
        }
        avenues.add(avenues.size(), avenue);
    }

    public void remove (int roadId) throws Exception {
        int index = avenues.indexOf(search(roadId));
        if (index < 0) {
            throw new Exception("NO roads with id:" + roadId + " was found. Removal attempt unsuccessful");
        }
        avenues.remove(index);
    }

    public Avenue next (int currentId) {
        int currentIndex = avenues.indexOf(search(currentId));
        if (currentIndex >= 0 || currentIndex < avenues.size() - 1)
            return avenues.get(currentIndex + 1);
        return null;
    }

    public Avenue previous (int currentId) {
        int currentIndex = avenues.indexOf(search(currentId));
        if (currentIndex > 1 || currentIndex < avenues.size())
            return avenues.get(currentIndex - 1);
        return null;
    }
}
