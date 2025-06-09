package com.lawal.transitcraft.common.build;

import com.lawal.transitcraft.common.Default;
import com.lawal.transitcraft.infrastructure.catalog.DepartureCatalog;
import com.lawal.transitcraft.infrastructure.catalog.RoadCatalog;
import com.lawal.transitcraft.infrastructure.catalog.BusRouteCatalog;
import com.lawal.transitcraft.infrastructure.catalog.StationCatalog;
import com.lawal.transitcraft.common.NameGenerator;
import com.lawal.transitcraft.infrastructure.road.Road;
import com.lawal.transitcraft.infrastructure.bus.Departure;
import com.lawal.transitcraft.infrastructure.bus.BusRoute;
import com.lawal.transitcraft.infrastructure.station.Station;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public enum BusRouteFactory {

    INSTANCE;

    private final static AtomicLong routeId = new AtomicLong(0);
    private final static AtomicLong stopId = new AtomicLong(0);


    public void run() {
        for (Road road : RoadCatalog.INSTANCE.getCatalog()) {
            BusRoute busRoute = new BusRoute(
                routeId.incrementAndGet(),
                randomName(),
                Default.TRANSIT_OPENING_TIME,
                Default.TRANSIT_CLOSING_TIME,
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
        return new Random().nextInt(
            Default.MINIMUM_INTERARRIVAL_TIME,
            Default.MAXIMUM_INTERARRIVAL_TIME
        );
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

        LocalTime departureTime = Default.TRANSIT_OPENING_TIME;
        int counter = 1;
        while (!departureTime.isBefore(Default.TRANSIT_CLOSING_TIME)) {
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