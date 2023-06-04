package com.lawal.transit.core.singletons;
/*
import com.lawal.transit.middleware.abstracts.TransitRoute;

import java.util.ArrayList;
import java.util.Iterator;

public class BusRoutesOld extends EntitySingletonList implements  Iterable<TransitRoute> {
    private static final long serialVersionUID = 1L;
    private ArrayList<TransitRoute> transitRoutes = new ArrayList<TransitRoute>();
    private static BusRoutesOld singleton = null;
    private static int serialNumber = 1;

    private BusRoutesOld () {
        super();
    } // close constructor

    public static BusRoutesOld getInstance() {
        if (singleton == null) {
            singleton = new BusRoutesOld();
        }
        return singleton;
    } // close getInstance

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
        TransitRoute buseLine = search(id);
        if (buseLine == null) {
            return false;
        }
        return transitRoutes.remove(buseLine);
    } // close removeBusLine

    public boolean remove (String name) {
        TransitRoute buseLine = search(name);
        if (buseLine == null) {
            return false;
        }
        return transitRoutes.remove(buseLine);
    } // close removeBusLine

    public Iterator<TransitRoute> iterator () {
        return transitRoutes.iterator();
    } // close iterator

    public int getTotal () {
        return transitRoutes.size();
    } // close getTotal

    @Override
    public String toString () {
        String string = "Bus Routes\n---------------";

        for (Iterator<TransitRoute> iterator = transitRoutes.iterator(); iterator.hasNext();) {
            TransitRoute transitRoute = (TransitRoute) iterator.next();
            string += "\n" + transitRoute.toString();
        }

        //for (TransitRoute TransitRoute : this.list) {
       //     string += "\n" + TransitRoute.toString();
       // }
        return string;
    } // close to String



    public static int nextSerialNumber () {
        return serialNumber++;
    } // close nextSerialNumber
} // end class RegularBusRoutes
*/