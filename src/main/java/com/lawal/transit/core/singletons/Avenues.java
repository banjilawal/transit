package com.lawal.transit.core.singletons;

import com.lawal.transit.core.collections.Bag;
import com.lawal.transit.core.entities.Avenue;
import com.lawal.transit.core.interfaces.BagWrapper;

import java.util.ArrayList;
import java.util.Iterator;

public enum Avenues implements BagWrapper<Avenue> {
    INSTANCE;
    private final Bag<Avenue> avenues = new Bag<Avenue>();

    @Override
    public int size () { return avenues.size(); }

    @Override
    public Bag<Avenue> getBag () {
        return avenues;
    }

    @Override
    public ArrayList<Avenue> getBagContents () { return avenues.getContents(); }

    @Override
    public void add (Avenue avenue) { avenues.add(avenue); }

    @Override
    public void remove (Avenue avenue) { avenues.remove(avenue); }

    @Override
    public Iterator<Avenue> iterator () { return avenues.iterator(); }

//    @Override
//    public Iterator<Avenue> iterator () {
////        ArrayList<Avenue> results = new ArrayList<Avenue>();
////        for (Avenue avenue : avenues.getContents()) {
////            if (avenue.getId() != GlobalConstant.END_BORDER_ID && avenue.getId() != GlobalConstant.START_BORDER_ID) {
////                System.out.println("valid ave: " + avenue.getName() + " valid id:" + avenue.getId());
////                results.add(results.size(), avenue);
////            }
////        }
////        return results.iterator();
//        Predicate<Avenue> predicate = (avenue) -> avenue.getId() != GlobalConstant.END_BORDER_ID
//                && avenue.getId() != GlobalConstant.START_BORDER_ID;
//        return avenues.search(predicate);
//    }
} // end class Avenues
