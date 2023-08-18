package com.lawal.transit.core.populator;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.entities.*;
import com.lawal.transit.core.enums.GlobalConstant;
import com.lawal.transit.core.interfaces.NameAcceptor;
import com.lawal.transit.core.interfaces.NumberAcceptor;
import com.lawal.transit.core.interfaces.Populator;
import com.lawal.transit.core.singletons.*;
import com.lawal.transit.core.visitors.NameGenerator;
import com.lawal.transit.core.visitors.SerialNumberGenerator;

import java.util.Iterator;
import java.util.function.Predicate;

public enum RegularBusRoutePopulator implements Populator, NumberAcceptor, NameAcceptor {
    INSTANCE;
    private int routeId;
    private String routeName;

    @Override
    public void populate() {
        processAvenues();
        processStreets();
    } //

    private void processAvenues () {
        for (Avenue avenue : Avenues.INSTANCE.getBagContents()) {
            RegularBusRoute busRoute = new RegularBusRoute(
                SerialNumberGenerator.INSTANCE.assignNumber(this),
                NameGenerator.INSTANCE.assignName(this),
                GlobalConstant.AVENUE_ROUTE_OUTBOUND_DIRECTION
            );
            addStations(busRoute, avenue);
            RegularBusRoutes.INSTANCE.add(busRoute);
//            RegularBusRoute busRoute = new RegularBusRoute(SerialNumberGenerator.INSTANCE.assignNumber(this), NameGenerator.INSTANCE.assignName(this));
//            Predicate<Station> predicate = (station) -> station.getRoad().equals(avenue);
//            Iterator<Station> iterator = Stations.INSTANCE.getBag().search(predicate);
//            while (iterator.hasNext()) {
//                Station station = iterator.next();
//                busRoute.addStation(station);
//                station.addBusRouteName(busRoute.getName());
//            }
//            RegularBusRoutes.INSTANCE.add(busRoute);
        }
    } // close

    private void processStreets () {
        for (Street street : Streets.INSTANCE.getBagContents()) {
            RegularBusRoute busRoute = new RegularBusRoute(
                    SerialNumberGenerator.INSTANCE.assignNumber(this),
                    NameGenerator.INSTANCE.assignName(this),
                    GlobalConstant.AVENUE_ROUTE_OUTBOUND_DIRECTION
            );
            addStations(busRoute, street);
            RegularBusRoutes.INSTANCE.add(busRoute);
//            Predicate<Station> predicate = (station) -> station.getRoad().equals(street);
//            Iterator<Station> iterator = Stations.INSTANCE.getBag().search(predicate);
//            while (iterator.hasNext()) {
//                Station station = iterator.next();
//                busRoute.addStation(station);
//                station.addBusRouteName(busRoute.getName());
//            }
//            RegularBusRoutes.INSTANCE.add(busRoute);
        }
    } // close

    private void addStations (RegularBusRoute busRoute, Road road) {
        Predicate<Station> predicate = (station) -> station.getRoad().equals(road);
        Iterator<Station> iterator = Stations.INSTANCE.getBag().search(predicate);
        while (iterator.hasNext()) {
            Station station = iterator.next();
            busRoute.addStation(station);
            station.addBusRouteName(busRoute.getName());
        }
    }
//
//    @Override
//    public void populate () {
//        populateStreetRoutes();
//        populateAvenueRoutes();
//    } // close populate
//
//    private void populateStreetRoutes () {
//        while (Streets.INSTANCE.iterator().hasNext()) {
//            Street street = Streets.INSTANCE.iterator().next();
//            routeId = acceptNumber();
//            routeName = acceptName();
//            RegularBusRoute busRoute = new RegularBusRoute(routeId, routeName);
//            busRoute.addRoad(street);
//            processRoads(busRoute);
//            RegularBusRoutes.INSTANCE.routes.add(busRoute);
//        }
//    } // close populateStreetRoutes
//
//    private void populateAvenueRoutes () {
//        while (Avenues.INSTANCE.iterator().hasNext()) {
//            Avenue avenue = Avenues.INSTANCE.iterator().next();
//            routeId = acceptNumber();
//            routeName = acceptName();
//            RegularBusRoute busRoute = new RegularBusRoute(routeId, routeName);
//            busRoute.addRoad(avenue);
//            processRoads(busRoute);
//            RegularBusRoutes.INSTANCE.routes.add(busRoute);
//        }
//    } // close populateAvenueRoutes
//
//    public void processRoads (RegularBusRoute busRoute) {
//        while (busRoute.getRoads().hasNext()) {
//            Road road = busRoute.getRoads().next();
//            addStations(busRoute, road);
//        }
//    } // close proccessRoads
//
//    private void addStations (RegularBusRoute busRoute, Road road) {
//        Predicate<Station> predicate = (station) -> station.getRoad().equals(road);
//        while (Stations.INSTANCE.stations.search(predicate).hasNext()) {
//            Station station = Stations.INSTANCE.stations.search(predicate).next();
//            busRoute.addStation(station);
//            station.addBusRouteName(busRoute.getName());
//        }
//    } // close addStations

    @Override
    public String acceptName () {
        return NameGenerator.INSTANCE.assignName(this);
    } // close acceptName

    @Override
    public int acceptNumber () {
        return SerialNumberGenerator.INSTANCE.assignNumber(this);
    } // close acceptNumber
} // end class TransitRoutePopulator
