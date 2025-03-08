package com.lawal.transit.route;

import com.lawal.transit.catalog.DepartureCatalog;
import com.lawal.transit.catalog.RoadCatalog;
import com.lawal.transit.catalog.RouteCatalog;
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

public class TransitRouteFactory {

    private static int MINIMUM_INTERARRIVAL_TIME = 8;
    private static int MAXIMUM_INTERARRIVAL_TIME = 45;
    private static AtomicLong routeId = new AtomicLong(0);
    private static AtomicLong stopId = new AtomicLong(0);

    private static final Random random = new Random();

    public static String randomName() {
        String name = NameGenerator.INSTANCE.randomRouteName();

        while (RouteCatalog.INSTANCE.findByName(name) != null) {
            name = NameGenerator.INSTANCE.randomRouteName();
        }
        return name;
    }


    public static Integer randomInterarrivalTime() {
        return random.nextInt(MINIMUM_INTERARRIVAL_TIME, MAXIMUM_INTERARRIVAL_TIME - MINIMUM_INTERARRIVAL_TIME) + 1;
    }

    public static void populate() {
        for (Road road : RoadCatalog.INSTANCE.getCatalog()) {
            TransitRoute transitRoute = new TransitRoute(
                routeId.incrementAndGet(),
                randomName(), 
                Constant.TRANSIT_OPENING_TIME,
                Constant.TRANSIT_CLOSING_TIME,
                randomInterarrivalTime()
            );
            populateStops(transitRoute, road);
            RouteCatalog.INSTANCE.getCatalog().add(transitRoute);
        }
    }
    
    public static void populateStops(TransitRoute transitRoute, Road road) {
        List<Station> stations = StationCatalog.INSTANCE.filterByRoad(road);

        LocalTime departureTime = Constant.TRANSIT_OPENING_TIME;
        while (departureTime.isBefore(Constant.TRANSIT_CLOSING_TIME)) {
            for (Station station : stations) {
                Departure departure = new Departure(stopId.incrementAndGet(), departureTime, transitRoute, station);
                System.out.println("departure:" + departure);
                DepartureCatalog.INSTANCE.getCatalog().add(departure);
                departureTime = departureTime.plusMinutes(transitRoute.getInterArrivalTime());
            }
            System.out.println("departure:" + departureTime);
            departureTime = departureTime.plusMinutes(transitRoute.getInterArrivalTime());
        }
    }
}