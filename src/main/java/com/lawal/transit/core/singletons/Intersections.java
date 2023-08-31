package com.lawal.transit.core.singletons;

import com.lawal.transit.core.containers.Bag;
import com.lawal.transit.core.entities.Avenue;
import com.lawal.transit.core.entities.Intersection;
import com.lawal.transit.core.entities.Street;
import com.lawal.transit.core.interfaces.BagWrapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public enum Intersections implements BagWrapper<Intersection> {
    INSTANCE;
    private final Bag<Intersection> intersections = new Bag<Intersection>();

    @Override
    public int size () { return intersections.size(); }

    @Override
    public Bag<Intersection> getBag () {
        return intersections;
    }

    @Override
    public ArrayList<Intersection> getBagContents () { return intersections.getContents(); }

    @Override
    public Iterator<Intersection> iterator () { return intersections.getContents().iterator(); }

    @Override
    public void add (Intersection intersection) { intersections.add(intersection); }

    @Override
    public void remove (Intersection intersection) { intersections.remove(intersection); }

    public Iterator<Intersection> filterByAvenue (Avenue avenue) {
        ArrayList<Intersection> matches = new ArrayList<Intersection>();
        Predicate<Intersection> predicate = intersection -> intersection.getAvenue().equals(avenue);
        for (Intersection intersection : Intersections.INSTANCE.intersections.getContents()) {
            if ((predicate.test(intersection) && !matches.contains(intersection))) {
                matches.add(matches.size(), intersection);
            }
        }
        return matches.iterator();
    } // close filterByAvenue

    public Iterator<Intersection> filterByStreet (Street street) {
        ArrayList<Intersection> matches = new ArrayList<Intersection>();
        Predicate<Intersection> predicate = intersection -> intersection.getStreet().equals(street);
        for (Intersection intersection : Intersections.INSTANCE.intersections.getContents()) {
            if ((predicate.test(intersection) && !matches.contains(intersection))) {
                matches.add(matches.size(), intersection);
            }
        }
        return matches.iterator();
    } // close filterByAvenue

    @Override
    public String toString () {
        String string = "\n";
        if (iterator().hasNext()) {
            string += iterator().next().toString() + "\n";
        }
        return string;
    }

    public String print () { return intersections.toString(); }
} // end class BLocks
