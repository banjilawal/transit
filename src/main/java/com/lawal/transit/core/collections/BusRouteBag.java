package com.lawal.transit.core.collections;
/*
import com.lawal.transit.middleware.abstracts.TransitRoute;

import java.util.ArrayList;
import java.util.Iterator;

public class BusRouteBag {
    private static int serialNumber = 1;
    private ArrayList<TransitRoute> transitRoutes;

    public BusRouteBag () {
        transitRoutes = new ArrayList<TransitRoute>();
    } // close constructor

    public boolean contains (TransitRoute transitRoute) {
        return transitRoutes.contains(transitRoute);
    } // close contains

    public TransitRoute search (TransitRoute target) {
        for (Iterator<TransitRoute> iterator = transitRoutes.iterator(); iterator.hasNext();) {
            TransitRoute transitRoute = (TransitRoute) iterator.next();
            if (transitRoute.equals(target)) {
                return transitRoute;
            }
        }
        return null;
    } // close search

    public TransitRoute search (int id) {
        for (Iterator<TransitRoute> iterator = transitRoutes.iterator(); iterator.hasNext();) {
            TransitRoute transitRoute = (TransitRoute) iterator.next();
            if (transitRoute.getId() == id) {
                return transitRoute;
            }
        }
        return null;
    } // close search

    public TransitRoute search (String name) {
        for (Iterator<TransitRoute> iterator = transitRoutes.iterator(); iterator.hasNext();) {
            TransitRoute transitRoute = (TransitRoute) iterator.next();
            if (transitRoute.getName().equalsIgnoreCase(name)) {
                return transitRoute;
            }
        }
        return null;
    } // close search

    public boolean add (TransitRoute transitRoute) {
        if (transitRoutes.contains(transitRoute)) {
            return false;
        }
        return transitRoutes.add(transitRoute);
    } // close addBusLine

    public boolean remove (int id) {
        TransitRoute transitRoute = search(id);
        if (transitRoute == null) {
            return false;
        }
        return transitRoutes.remove(transitRoute);
    } // close removeBusLine

    public boolean remove (String name) {
        TransitRoute transitRoute = search(name);
        if (transitRoute == null) {
            return false;
        }
        return transitRoutes.remove(transitRoute);
    } // close removeBusLine

    public Iterator<TransitRoute> iterator () {
        return transitRoutes.iterator();
    } // close iterator

    public int size () {
        return transitRoutes.size();
    } // close getTotal

    @Override
    public String toString () {
        String string = "Bus Routes\n---------------";

        for (Iterator<TransitRoute> iterator = transitRoutes.iterator(); iterator.hasNext();) {
            TransitRoute transitRoute = (TransitRoute) iterator.next();
            string += "\n" + transitRoute.toString();
        }
        return string;
    } // close to String

    public static int nextSerialNumber () {
        return serialNumber++;
    } // close nextSerialNumber

} // end class BusRouteBag
*/