package com.lawal.transit.core.singletons;

import com.lawal.transit.core.concretes.*;
import com.lawal.transit.core.concretes.ConcreteAvenue;
import com.lawal.transit.core.visitors.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public enum Intersections {
    INSTANCE;
    private final ArrayList<Intersection> intersections = new ArrayList<>();


    public int size () {
        return intersections.size();
    }


    public ArrayList<Intersection> getIntersections () {
        return intersections;
    }

    public void add (Intersection intersection) {
        if (intersections.contains(intersection)) {
            throw new IllegalArgumentException("Intersection " + intersection.getName() + " already exists add cannot add another");
        }
        intersections.add(intersections.size(), intersection);
    }

    public boolean add (ConcreteAvenue concreteAvenue, ConcreteStreet concreteStreet) {
        if (search(concreteAvenue, concreteStreet) == null)
            return intersections.add(new Intersection(IntersectionIdGenerator.INSTANCE.nextId(), concreteAvenue, concreteStreet));
        return true;
    }


    public Intersection search (int id) {
        for (Intersection intersection : intersections) {
            if (intersection.getId() == id)
                return intersection;
        }
        return null;
    }


    public Intersection search (ConcreteAvenue concreteAvenue, ConcreteStreet concreteStreet) {
        for (Intersection intersection : intersections) {
            if (intersection.getAvenue().equals(concreteAvenue) && intersection.getStreet().equals(concreteStreet))
                return intersection;
        }
        return null;
    }


    public Iterator<Intersection> iterator () {
        return intersections.iterator();
    }


    public ArrayList<Intersection> filter (Predicate<Intersection> predicate) {
        ArrayList matches = new ArrayList<>();
        for (Intersection intersection : intersections) {
            if (predicate.test(intersection) && !matches.contains(intersection))
                matches.add(matches.size(), intersection);
        }
        return matches;
    }


    @Override
    public String toString () {
        String string = "Intersections\n------------------\n";
        for (Intersection intersection : intersections) {
            string += intersection.toString() + "\n";
        }
        return string;
    }
} // end class Intersection
