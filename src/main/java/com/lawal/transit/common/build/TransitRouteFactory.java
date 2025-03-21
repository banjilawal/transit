package com.lawal.transit.common.build;

import com.lawal.transit.infrastructure.catalog.DepartureCatalog;
import com.lawal.transit.infrastructure.catalog.RoadCatalog;
import com.lawal.transit.infrastructure.catalog.TransitRouteCatalog;
import com.lawal.transit.infrastructure.catalog.StationCatalog;
import com.lawal.transit.common.Constant;
import com.lawal.transit.common.NameGenerator;
import com.lawal.transit.infrastructure.road.Road;
import com.lawal.transit.infrastructure.schedule.Departure;
import com.lawal.transit.infrastructure.schedule.Route;
import com.lawal.transit.infrastructure.station.Station;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public enum TransitRouteFactory {

    INSTANCE;

    private final static int MINIMUM_INTERARRIVAL_TIME = 8;
    private final static int MAXIMUM_INTERARRIVAL_TIME = 45;
    private final static AtomicLong routeId = new AtomicLong(0);
    private final static AtomicLong stopId = new AtomicLong(0);

    private static final Random random = new Random();

    public void run() {
        for (Road road : RoadCatalog.INSTANCE.getCatalog()) {
            Route route = new Route(
                routeId.incrementAndGet(),
                randomName(),
                Constant.TRANSIT_OPENING_TIME,
                Constant.TRANSIT_CLOSING_TIME,
                randomInterarrivalTime()
            );
            addDepartures(route, road);
            TransitRouteCatalog.INSTANCE.addRoute(route);
        }
    }

    private String randomName() {
        String name = NameGenerator.INSTANCE.randomRouteName();

        while (TransitRouteCatalog.INSTANCE.findByName(name) != null) {
            name = NameGenerator.INSTANCE.randomRouteName();
        }
        return name;
    }

    public Integer randomInterarrivalTime() {
        return new Random().nextInt(MINIMUM_INTERARRIVAL_TIME, MAXIMUM_INTERARRIVAL_TIME);
    }
    
    public void addDepartures(Route route, Road road) {
        List<Station> stations = StationCatalog.INSTANCE.filterByRoad(road);

        if (route == null) {
            System.out.println("Cannot add departures to a null route");
            return;
        }

        if (road == null) {
            System.out.println("Cannot add departures to a null road");
            return;
        }

        if (stations.isEmpty()) {
            System.out.println("TransitRouteFactory.addDepartures(): There's no road stations on " + road.getName());
            return;
        }

        LocalTime departureTime = Constant.TRANSIT_OPENING_TIME;
        int counter = 1;
        while (!departureTime.isBefore(Constant.TRANSIT_CLOSING_TIME)) {
            for (Station station : stations) {

                Departure departure = new Departure(stopId.incrementAndGet(), departureTime, route, station);
                DepartureCatalog.INSTANCE.addDeparture(departure);
                departureTime = departureTime.plusMinutes(route.getInterArrivalTime());
                counter++;
            }
            departureTime = departureTime.plusMinutes(route.getInterArrivalTime());
        }
    }
}