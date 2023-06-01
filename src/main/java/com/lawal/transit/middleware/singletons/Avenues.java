package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.interfaces.BagWrapper;

import java.util.Iterator;

public enum Avenues {
    INSTANCE;
    public final Bag<Avenue> bag = new Bag<Avenue>();

    public Bag<Avenue> getBag() {
        return bag;
    }

//    public int size () { return bag.size(); }
//    public Iterator<Avenue> iterator () {
//        return bag.iterator();
//    }
//
//    public void add (Avenue avenue) {
//        bag.add(size(), avenue);
//    }
//
//    public boolean remove (Avenue avenue) {
//        return bag.remove(avenue.getName());
//    }


//    public String fullString () {
//        return "Avenue" + " " + bag.fullString();
//    }
} // end class Avenues
