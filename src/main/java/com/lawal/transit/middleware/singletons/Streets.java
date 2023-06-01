package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.entities.Street;

import java.util.Iterator;
import java.util.function.Predicate;

public enum Streets {
    INSTANCE;
    public final Bag<Street> bag = new Bag<Street>();

    public Bag<Street> getBag() {
        return bag;
    } // close getBag

//    private Predicate<Street> predicate = null;
//
//    public int size () { return bag.size(); }
//
//
//    public void add (Street street) {
//        bag.add(street);
//    }
//
//    public boolean remove (Street street) {
//        return bag.remove(street.getName());
//    }
//
//    public Iterator<Street> iterator () {
//        return bag.iterator();
//    }


//    public String fullString () {
//        return "Street" + " " + bag.fullString();
//    }

} // end class Streets
