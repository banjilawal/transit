package com.lawal.transit.core.singletons;

import com.lawal.transit.core.collections.Bag;
import com.lawal.transit.core.entities.GlobalConstant;
import com.lawal.transit.core.entities.Street;
import com.lawal.transit.core.interfaces.BagWrapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public enum Streets implements BagWrapper<Street> {
    INSTANCE;
    private final Bag<Street> streets = new Bag<Street>();

    @Override
    public int size () { return streets.size(); }

    @Override
    public Bag<Street> getBag () {
        return streets;
    }

    @Override
    public ArrayList<Street> getBagContents () { return streets.getContents(); }

    @Override
    public void add (Street street) { streets.add(street); }

    @Override
    public void remove (Street street) { streets.remove(street); }

    @Override
    public Iterator<Street> iterator () { return streets.iterator(); }

//    public Iterator<Street> iterator () {
////        ArrayList<Street> results = new ArrayList<Street>();
////        for (Street street : streets.getContents()) {
////            if (street.getId() != GlobalConstant.START_BORDER_ID && street.getId() != GlobalConstant.END_BORDER_ID) {
////                System.out.println("valid street name:" + street.getName() + " valid id:" + street.getId());
////                results.add(results.size(), street);
////            }
////        }
////        return results.iterator();
//        Predicate<Street> predicate = (street) -> street.getId() != GlobalConstant.END_BORDER_ID
//                && street.getId() != GlobalConstant.START_BORDER_ID;
//        return streets.search(predicate);
//    } // close iterator
} // end class Streets
