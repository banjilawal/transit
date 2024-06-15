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
        for (ConcreteAvenue concreteAvenue : Avenues.INSTANCE.getAvenues()) {
            RegularBusRoute busRoute = new RegularBusRoute(
                RegularBusRouteIdGenerator.INSTANCE.nextId(),
                NameGenerator.INSTANCE.assignName(this),
                Constant.avenueRouteOutboundOrientation
            );
            Predicate<OldAbstractStation> predicate = (station) -> station.getRoad().equals(concreteAvenue);
            ArrayList<OldAbstractStation> oldAbstractStations = Stations.INSTANCE.filter(predicate);
//            System.out.println(oldAbstractStations.size() + " oldAbstractStations");
            busRoute.setSchedule(oldAbstractStations);
            RegularBusRoutes.INSTANCE.add(busRoute);
        }
    }

    private void processStreets () {
        for (ConcreteStreet concreteStreet : Streets.INSTANCE.getStreets()) {
            RegularBusRoute busRoute = new RegularBusRoute(
                    RegularBusRouteIdGenerator.INSTANCE.nextId(),
                    NameGenerator.INSTANCE.assignName(this),
                    Constant.avenueRouteOutboundOrientation
            );
            Predicate<OldAbstractStation> predicate = (station) -> station.getRoad().equals(concreteStreet);
            ArrayList<OldAbstractStation> oldAbstractStations = Stations.INSTANCE.filter(predicate);
            busRoute.setSchedule(oldAbstractStations);
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
