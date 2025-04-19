package com.lawal.transit.common.build;

import com.lawal.transit.infrastructure.catalog.DepartureCatalog;
import com.lawal.transit.infrastructure.catalog.RoadCatalog;
import com.lawal.transit.infrastructure.catalog.BusRouteCatalog;
import com.lawal.transit.infrastructure.catalog.StationCatalog;
import com.lawal.transit.common.Constant;
import com.lawal.transit.common.NameGenerator;
import com.lawal.transit.infrastructure.road.Road;
import com.lawal.transit.infrastructure.bus.Departure;
import com.lawal.transit.infrastructure.bus.BusRoute;
import com.lawal.transit.infrastructure.station.Station;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public enum BusRouteFactory {

    INSTANCE;

    private final static int MINIMUM_INTERARRIVAL_TIME = 8;
    private final static int MAXIMUM_INTERARRIVAL_TIME = 45;
    private final static AtomicLong routeId = new AtomicLong(0);
    private final static AtomicLong stopId = new AtomicLong(0);

    private static final Random random = new Random();

    public void run() {
        for (Road road : RoadCatalog.INSTANCE.getCatalog()) {
            BusRoute busRoute = new BusRoute(
                routeId.incrementAndGet(),
                randomName(),
                Constant.TRANSIT_OPENING_TIME,
                Constant.TRANSIT_CLOSING_TIME,
                randomInterarrivalTime()
            );
            addDepartures(busRoute, road);
            BusRouteCatalog.INSTANCE.addRoute(busRoute);
        }
    }

    private String randomName() {
        String name = NameGenerator.INSTANCE.randomRouteName();

        while (BusRouteCatalog.INSTANCE.findByName(name) != null) {
            name = NameGenerator.INSTANCE.randomRouteName();
        }
        return name;
    }

    public Integer randomInterarrivalTime() {
        return new Random().nextInt(MINIMUM_INTERARRIVAL_TIME, MAXIMUM_INTERARRIVAL_TIME);
    }
    
    public void addDepartures(BusRoute busRoute, Road road) {
        List<Station> stations = StationCatalog.INSTANCE.filterByRoad(road);

        if (busRoute == null) {
            System.out.println("Cannot add departures to a null busRoute");
            return;
        }

        if (road == null) {
            System.out.println("Cannot add departures to a null road");
            return;
        }

        if (stations.isEmpty()) {
            System.out.println("BusRouteFactory.addDepartures(): There's no road stations on " + road.getName());
            return;
        }

        LocalTime departureTime = Constant.TRANSIT_OPENING_TIME;
        int counter = 1;
        while (!departureTime.isBefore(Constant.TRANSIT_CLOSING_TIME)) {
            for (Station station : stations) {

                Departure departure = new Departure(stopId.incrementAndGet(), departureTime, busRoute, station);
                DepartureCatalog.INSTANCE.addDeparture(departure);
                departureTime = departureTime.plusMinutes(busRoute.getInterval());
                counter++;
            }
            departureTime = departureTime.plusMinutes(busRoute.getInterval());
        }
    }
}