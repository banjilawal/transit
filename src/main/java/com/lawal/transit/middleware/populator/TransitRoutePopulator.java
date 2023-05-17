package com.lawal.transit.middleware.populator;

import com.lawal.transit.middleware.abstracts.AvenueStation;
import com.lawal.transit.middleware.abstracts.Station;
import com.lawal.transit.middleware.abstracts.StreetStation;
import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.entities.ExpressBusRoute;
import com.lawal.transit.middleware.entities.RegularBusRoute;
import com.lawal.transit.middleware.entities.Street;
import com.lawal.transit.middleware.interfaces.NameAcceptor;
import com.lawal.transit.middleware.interfaces.NumberAcceptor;
import com.lawal.transit.middleware.singletons.*;
import com.lawal.transit.middleware.visitors.NameGenerator;
import com.lawal.transit.middleware.visitors.SerialNumberGenerator;

import java.util.Iterator;
import java.util.jar.Attributes;

public enum TransitRoutePopulator implements Populator, NumberAcceptor, NameAcceptor {
    INSTANCE;
    private int regularBusRouteTotal;

    private int DEFAULT_REGULAR_ROUTES_TOTAL = 26; // = NameGenerator.INSTANCE.AVENUE_NAMES.length;

    @Override
    public void populate () {
        int borderCount = 2;
        RegularBusRoutes regularBusRoutes = RegularBusRoutes.INSTANCE;
        regularBusRouteTotal = (Streets.INSTANCE.size() - borderCount) * (Avenues.INSTANCE.size() - borderCount);
        populateRegularBusRoutes();
        populateExpressBusRoutes();
        setStationBusRoutes();
    } // close populate

    @Override
    public String acceptName () { return NameGenerator.INSTANCE.assignName(this); }

    @Override
    public int acceptNumber () { return SerialNumberGenerator.INSTANCE.assignNumber(this); }

    private void populateRegularBusRoutes () {
        for (Iterator<Avenue> iterator = Avenues.INSTANCE.iterator(); iterator.hasNext();) {
            Avenue avenue = (Avenue) iterator.next();
            if (avenue.getId() != 100 && avenue.getId() !=  200) {
                System.out.println(avenue.getName());
                System.out.println(avenue.getStations());
                RegularBusRoute regularBusRoute = new RegularBusRoute(acceptNumber(), acceptName());
                regularBusRoute.addRoadName(avenue.getName());
                for (String stationName : avenue.getStations()) {
                    regularBusRoute.addStop(Stations.INSTANCE.search(stationName));
                }
                RegularBusRoutes.INSTANCE.add(regularBusRoute);
            }
        }

        for (Iterator<Street> iterator = Streets.INSTANCE.iterator(); iterator.hasNext();) {
            Street street = (Street) iterator.next();
            if (street.getId() != 100 && street.getId() !=  200) {
                System.out.println(street.getName());
                System.out.println(street.getStations());
                RegularBusRoute regularBusRoute = new RegularBusRoute(acceptNumber(), acceptName());
                regularBusRoute.addRoadName(street.getName());
                for (String stationName : street.getStations()) {
                    regularBusRoute.addStop(Stations.INSTANCE.search(stationName));
                }
                regularBusRoute.setStationNames(street.getStations());
                RegularBusRoutes.INSTANCE.add(regularBusRoute);
            }
        }
    } // close populateRegularBusRoutes

    private void populateExpressBusRoutes () {
        if (regularBusRouteTotal >= DEFAULT_REGULAR_ROUTES_TOTAL) {
            NameGenerator nameGenerator = NameGenerator.INSTANCE;
            for (int index = 0; index < nameGenerator.EXPRESS_BUS_ROUTE_NAMES.length; index++) {
                ExpressBusRoutes.INSTANCE.add(new ExpressBusRoute((index + 1), nameGenerator.EXPRESS_BUS_ROUTE_NAMES[index]));
            }
        }
    } // close populateExpressBusRoutes

    private void setStationBusRoutes () {
        for (Iterator<AvenueStation> avenueStationIterator = AvenueStations.INSTANCE.iterator(); avenueStationIterator.hasNext();) {
            AvenueStation avenueStation = (AvenueStation) avenueStationIterator.next();
            for (Iterator<RegularBusRoute> busRouteIterator = RegularBusRoutes.INSTANCE.iterator(); busRouteIterator.hasNext();) {
                RegularBusRoute regularBusRoute = (RegularBusRoute) busRouteIterator.next();
                if (regularBusRoute.getRoadNames().contains(avenueStation.getBlockRoad().getName())) {
                    avenueStation.addBusRouteName(regularBusRoute.getName());
                }
            }
            for (Iterator<StreetStation> streetStationIterator = StreetStations.INSTANCE.iterator(); streetStationIterator.hasNext();) {
                StreetStation streetStation = (StreetStation) streetStationIterator.next();
                for (Iterator<RegularBusRoute> busRouteIterator = RegularBusRoutes.INSTANCE.iterator(); busRouteIterator.hasNext();) {
                    RegularBusRoute regularBusRoute = (RegularBusRoute) busRouteIterator.next();
                    if (regularBusRoute.getRoadNames().contains(streetStation.getBlockRoad().getName())) {
                        streetStation.addBusRouteName(regularBusRoute.getName());
                    }
                }
            }
        }
    }
} // end class TransitRoutePopulator
