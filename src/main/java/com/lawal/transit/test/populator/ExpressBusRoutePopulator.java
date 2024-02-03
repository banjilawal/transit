package com.lawal.transit.test.populator;

import com.lawal.transit.core.interfaces.NameAcceptor;
import com.lawal.transit.core.interfaces.NumberAcceptor;
import com.lawal.transit.core.interfaces.Populator;
import com.lawal.transit.core.visitors.NameGenerator;
import com.lawal.transit.core.visitors.SerialNumberGenerator;

public enum ExpressBusRoutePopulator implements Populator, NumberAcceptor, NameAcceptor {
    INSTANCE;
    private int routeId;
    private String routeName;
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
//            ExpressBusRoute busRoute = new ExpressBusRoute(routeId, routeName);
//            busRoute.addRoad(street);
//            processRoads(busRoute);
//            ExpressBusRoutes.INSTANCE.routes.add(busRoute);
//        }
//    } // close populateStreetRoutes
//
//    private void populateAvenueRoutes () {
//        while (Avenues.INSTANCE.iterator().hasNext()) {
//            Avenue avenue = Avenues.INSTANCE.iterator().next();
//            routeId = acceptNumber();
//            routeName = acceptName();
//            ExpressBusRoute busRoute = new ExpressBusRoute(routeId, routeName);
//            busRoute.addRoad(avenue);
//            processRoads(busRoute);
//            ExpressBusRoutes.INSTANCE.routes.add(busRoute);
//        }
//    } // close populateAvenueRoutes
//
//    public void processRoads (ExpressBusRoute busRoute) {
//        while (busRoute.getRoads().hasNext()) {
//            Road road = busRoute.getRoads().next();
//            addStations(busRoute, road);
//        }
//    } // close proccessRoads
//
//    private void addStations (ExpressBusRoute busRoute, Road road) {
//        Predicate<Station> predicate = (station) -> station.getRoad().equals(road);
//        while (Stations.INSTANCE.stations.search(predicate = (station) -> station.getRoad().equals(road)).hasNext()) {
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

    @Override
    public void populate() {

    }
} // end class TransitRoutePopulator
