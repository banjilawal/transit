package com.lawal.transit.test.populator;

import com.lawal.transit.core.concretes.*;
import com.lawal.transit.core.global.Constant;
import com.lawal.transit.core.interfaces.NameAcceptor;
import com.lawal.transit.core.interfaces.NumberAcceptor;
import com.lawal.transit.core.interfaces.Populator;
import com.lawal.transit.core.singletons.*;
import com.lawal.transit.core.visitors.*;

import java.util.*;
import java.util.function.Predicate;

public enum RegularBusRoutePopulator implements Populator, NumberAcceptor, NameAcceptor {
    INSTANCE;

    @Override
    public void populate() {
        processAvenues();
        processStreets();
    }


    private void processAvenues () {
        for (Avenue avenue : Avenues.INSTANCE.getAvenues()) {
            RegularBusRoute busRoute = new RegularBusRoute(
                RegularBusRouteIdGenerator.INSTANCE.nextId(),
                NameGenerator.INSTANCE.assignName(this),
                Constant.AVENUE_ROUTE_OUTBOUND_DIRECTION
            );
            Predicate<Station> predicate = (station) -> station.getRoad().equals(avenue);
            ArrayList<Station> stations = Stations.INSTANCE.filter(predicate);
//            System.out.println(stations.size() + " stations");
            busRoute.setSchedule(stations);
            RegularBusRoutes.INSTANCE.add(busRoute);
        }
    }

    private void processStreets () {
        for (Street street : Streets.INSTANCE.getStreets()) {
            RegularBusRoute busRoute = new RegularBusRoute(
                    RegularBusRouteIdGenerator.INSTANCE.nextId(),
                    NameGenerator.INSTANCE.assignName(this),
                    Constant.AVENUE_ROUTE_OUTBOUND_DIRECTION
            );
            Predicate<Station> predicate = (station) -> station.getRoad().equals(street);
            ArrayList<Station> stations = Stations.INSTANCE.filter(predicate);
            busRoute.setSchedule(stations);
            RegularBusRoutes.INSTANCE.add(busRoute);
        }
    }

    @Override
    public String acceptName () {
        return NameGenerator.INSTANCE.assignName(this);
    } // close acceptName

    @Override
    public int acceptNumber () {
        return SerialNumberGenerator.INSTANCE.assignNumber(this);
    } // close acceptNumber
} // end class TransitRoutePopulator
