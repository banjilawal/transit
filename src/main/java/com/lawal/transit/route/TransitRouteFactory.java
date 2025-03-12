//package com.lawal.transit.route;
//
//import com.lawal.transit.catalog.DepartureCatalog;
//import com.lawal.transit.catalog.RoadCatalog;
//import com.lawal.transit.catalog.TransitRouteCatalog;
//import com.lawal.transit.catalog.StationCatalog;
//import com.lawal.transit.global.Constant;
//import com.lawal.transit.global.NameGenerator;
//import com.lawal.transit.road.model.Road;
//import com.lawal.transit.route.model.Departure;
//import com.lawal.transit.route.model.TransitRoute;
//import com.lawal.transit.station.model.Station;
//
//import java.time.LocalTime;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.atomic.AtomicLong;
//
//public class TransitRouteFactory {
//
//    private static int MINIMUM_INTERARRIVAL_TIME = 8;
//    private static int MAXIMUM_INTERARRIVAL_TIME = 45;
//    private static AtomicLong routeId = new AtomicLong(0);
//    private static AtomicLong stopId = new AtomicLong(0);
//
//    private static final Random random = new Random();
//
//    public static String randomName() {
//        String name = NameGenerator.INSTANCE.randomRouteName();
//
//        while (TransitRouteCatalog.INSTANCE.findByName(name) != null) {
//            name = NameGenerator.INSTANCE.randomRouteName();
//        }
//        return name;
//    }
//
//
//    public static Integer randomInterarrivalTime() {
//        return new Random().nextInt(MINIMUM_INTERARRIVAL_TIME, MAXIMUM_INTERARRIVAL_TIME);
//    }
//
//    public static void populate() {
//        for (Road road : RoadCatalog.INSTANCE.getCatalog()) {
////            System.out.println("TransitRouteFactory.populate():" + road);
//            TransitRoute transitRoute = new TransitRoute(
//                routeId.incrementAndGet(),
//                randomName(),
//                Constant.TRANSIT_OPENING_TIME,
//                Constant.TRANSIT_CLOSING_TIME,
//                randomInterarrivalTime()
//            );
////            System.out.println("TransitRouteFactory.populate() invoking populateStops:" + transitRoute + " " + road);
//            populateStops(transitRoute, road);
//        }
//    }
//
//    public static void populateStops(TransitRoute transitRoute, Road road) {
//        List<Station> stations = StationCatalog.INSTANCE.filterByRoad(road);
////        System.out.println("TransitRouteFactory.populateStops() total stations:" + stations.size());
//        if (stations.isEmpty()) {
//            System.out.println("TransitRouteFactory.populate(): There's no road stations");
//            return;
//        }
//
//        LocalTime departureTime = Constant.TRANSIT_OPENING_TIME;
////        System.out.println("TransitRouteFactory.populateStops() starting time:" + departureTime);
//        int counter = 1;
//        while (!departureTime.isBefore(Constant.TRANSIT_CLOSING_TIME.plusMinutes(120))) {
//            for (Station station : stations) {
////                System.out.println("TransitRouteFactory.populateStops():" + station);
//                if (departureTime.isBefore(Constant.TRANSIT_CLOSING_TIME)) break;
////                System.out.println("TransitRouteFactory.populateStops():" + station);
//                Departure departure = new Departure(stopId.incrementAndGet(), departureTime, transitRoute, station);
////                transitRoute.getDepartures().add(departure);
////                station.getDepartures().add(departure);
//
//                TransitRouteCatalog.INSTANCE.addRoute(transitRoute);
////                System.out.println(counter + " TransitRouteFactory.populateStops():" + departure);
//                DepartureCatalog.INSTANCE.addDeparture(departure);
//                departureTime = departureTime.plusMinutes(transitRoute.getInterArrivalTime());
//                counter++;
//            }
////            System.out.println("TransitRouteFactory.populateStops():" + departureTime);
//            departureTime = departureTime.plusMinutes(transitRoute.getInterArrivalTime());
//        }
//    }
//}