package com.lawal.transit.middleware.drivers;
/*
import com.lawal.transit.middleware.abstracts.TransitRoute;
import com.lawal.transit.middleware.abstracts.Item;
import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.entities.*;
import com.lawal.transit.middleware.populate.PopulateSingletons;
import com.lawal.transit.middleware.singletons.*;

import java.util.Iterator;

public class PopulateSingletonDriver {

    public static void main (String[] args) {
        PopulateSingletons.populate();

        //System.out.println(RegularBusRoutes.getInstance().getBusRoutes().toString());
        //System.out.println(Addresses.getInstance().toString());

        TransitRoute transitRoute = RegularBusRoutes.getInstance().search(1);
        System.out.println(transitRoute.toString());

        for (Iterator<Item> iterator = transitRoute.stopIterator(); iterator.hasNext();) {
            Station station = (Station) iterator.next();
            System.out.println(station.toString());
        }
        transitRoute.getStops().sort();

        Road road = (Road) Arteries.getInstance().search(3);
        Addresses.getInstance().getAddresses().sort();
        for (Iterator<Item> iterator = Addresses.getInstance().iterator(); iterator.hasNext();) {
            Address address = (Address) iterator.next();

            if (address.getArtery().equals(road)) {
                System.out.println(address.toString());
            }
        }
        //System.out.println(Stations.getInstance().toString());
        //System.out.println(Stations.getInstance().getTotal());
       // System.out.println(Arteries.getInstance().toString());

        //System.out.println(Addresses.getInstance().toString());
        //System.out.println(StationPaths.getInstance().toString());
       // System.out.println(StationPaths.getInstance().getStations().toString());
    }// close main


} // end class PopulateSingletonDriver
 */