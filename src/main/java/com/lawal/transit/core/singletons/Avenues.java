package com.lawal.transit.core.singletons;

import com.lawal.transit.core.concretes.ConcreteAvenue;
import com.lawal.transit.core.visitors.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.*;

public enum Avenues  {
    INSTANCE;
    private final ArrayList<ConcreteAvenue> concreteAvenues = new ArrayList<>();


    public int size () { return concreteAvenues.size(); }


    public ArrayList<ConcreteAvenue> getAvenues () {
        return concreteAvenues;
    }


    public void add (ConcreteAvenue concreteAvenue) {
        if (concreteAvenues.contains(concreteAvenue)) {
            throw new IllegalArgumentException("An concreteAvenue named " + concreteAvenue.getName() + " already exists add cannot add another");
        }
        concreteAvenues.add(concreteAvenues.size(), concreteAvenue);
    }

    public boolean add (String name) {
        if (search(name) == null)
            return concreteAvenues.add(new ConcreteAvenue(AvenueIdGenerator.INSTANCE.nextId(), name));
        return true;
    }


    public ConcreteAvenue search (int id) {
        for (ConcreteAvenue concreteAvenue : concreteAvenues) {
            if (concreteAvenue.getId() == id)
                return concreteAvenue;
        }
        return null;
    }


    public ConcreteAvenue search (String name) {
        for (ConcreteAvenue concreteAvenue : concreteAvenues) {
            if (concreteAvenue.getName().equalsIgnoreCase(name))
                return concreteAvenue;
        }
        return null;
    }


    public Iterator<ConcreteAvenue> iterator () {
        return concreteAvenues.iterator();
    }


    public ArrayList<ConcreteAvenue> filter (Predicate<ConcreteAvenue> predicate) {
        ArrayList<ConcreteAvenue> matches = new ArrayList<>();
        for (ConcreteAvenue concreteAvenue : concreteAvenues) {
            if (predicate.test(concreteAvenue) && !matches.contains(concreteAvenue)) {
                matches.add(matches.size(), concreteAvenue);
            }
        }
        return matches;
    }

    @Override
    public String toString () {
        String string = "Avenues:\n";
        for (ConcreteAvenue concreteAvenue : concreteAvenues) {
            string += concreteAvenue.toString() + "\n";
        }
        return string;
    }
} // end class Avenues
