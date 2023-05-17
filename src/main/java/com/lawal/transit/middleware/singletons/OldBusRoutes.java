package com.lawal.transit.middleware.singletons;

/*
import com.lawal.transit.middleware.abstracts.TransitRoute;
import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.abstracts.Item;

import java.util.Iterator;

public class RegularBusRoutes {
    private static final long serialVersionUID = 1L;
    private Bag<TransitRoute> busRoutes = new Bag<TransitRoute>();
    private static RegularBusRoutes singleton = null;
    private static int serialNumber = 1;

    private RegularBusRoutes () {
        super();
    } // close constructor

    public static RegularBusRoutes getInstance() {
        if (singleton == null) {
            singleton = new RegularBusRoutes();
        }
        return singleton;
    } // close getInstance

    public Bag<TransitRoute> getBusRoutes () {
        return busRoutes;
    }

    public boolean add (TransitRoute transitRoute) {
        return this.busRoutes.add(transitRoute);
    } // close add

    public boolean remove (TransitRoute transitRouteId) {
        return this.busRoutes.remove(transitRouteId);
    } // close add

    public TransitRoute search (int busRouteId) {
        return (TransitRoute) this.busRoutes.search(busRouteId);
    } // close search

    public TransitRoute search (String busRouteName) {
        return (TransitRoute) this.busRoutes.search(busRouteName);
    } // close search

    public String printSummary () {
        String string = "Bus Routes\n---------------";

        for (Iterator<Item> iterator = busRoutes.iterator(); iterator.hasNext();) {
            TransitRoute transitRoute = (TransitRoute) iterator.next();
            string += "\n" + transitRoute.print();
        }
        return string;
    } // close printSummary

    @Override
    public String toString () {
        String string = "Bus Routes\n---------------";

        for (Iterator<Item> iterator = busRoutes.iterator(); iterator.hasNext();) {
            TransitRoute transitRoute = (TransitRoute) iterator.next();
            string += "\n" + transitRoute.toString();
        }
        return string;
    } // close to String

    public Iterator<Item> iterator () {
        return busRoutes.iterator();
    } // close iterator

    public static int nextSerialNumber () {
        return serialNumber++;
    } // close nextSerialNumber
} // end class RegularBusRoutes
*/