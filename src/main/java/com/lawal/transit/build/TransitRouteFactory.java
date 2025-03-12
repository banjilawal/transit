package com.lawal.transit.build;

import com.lawal.transit.catalog.DepartureCatalog;
import com.lawal.transit.catalog.RoadCatalog;
import com.lawal.transit.catalog.TransitRouteCatalog;
import com.lawal.transit.catalog.StationCatalog;
import com.lawal.transit.global.Constant;
import com.lawal.transit.global.NameGenerator;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.route.model.Departure;
import com.lawal.transit.route.model.TransitRoute;
import com.lawal.transit.station.model.Station;

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
            TransitRoute transitRoute = new TransitRoute(
                routeId.incrementAndGet(),
                randomName(),
                Constant.TRANSIT_OPENING_TIME,
                Constant.TRANSIT_CLOSING_TIME,
                randomInterarrivalTime()
            );
            addDepartures(transitRoute, road);
            TransitRouteCatalog.INSTANCE.addRoute(transitRoute);
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
    
    public void addDepartures(TransitRoute transitRoute, Road road) {
        List<Station> stations = StationCatalog.INSTANCE.filterByRoad(road);

        if (transitRoute == null) {
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

                Departure departure = new Departure(stopId.incrementAndGet(), departureTime, transitRoute, station);
                DepartureCatalog.INSTANCE.addDeparture(departure);
                departureTime = departureTime.plusMinutes(transitRoute.getInterArrivalTime());
                counter++;
            }
            departureTime = departureTime.plusMinutes(transitRoute.getInterArrivalTime());
        }
    }
}