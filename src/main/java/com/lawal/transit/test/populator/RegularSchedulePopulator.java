//package com.lawal.transit.test.populator;
//
//import com.lawal.transit.core.concretes.*;
//import com.lawal.transit.core.global.Constant;
//import com.lawal.transit.core.interfaces.Populator;
//import com.lawal.transit.core.singletons.*;
//import com.lawal.transit.core.visitors.SerialNumberGenerator;
//
//import java.time.LocalTime;
//import java.util.Iterator;

//public enum RegularSchedulePopulator implements Populator {
//    INSTANCE;
//    private int routeId;
//    private String routeName;
//
//    @Override
//    public void populate() {
//        for (RegularBusRoute busRoute : RegularBusRoutes.INSTANCE.getBagContents()) {
//            createSchedule(busRoute);
//        };
//    } //
//
//    private void createSchedule (RegularBusRoute busRoute) {
//        RegularSchedule schedule = new RegularSchedule(SerialNumberGenerator.INSTANCE.assignNumber(this), busRoute);
//        busRoute.sortStations();
//        Iterator<Station> iterator = busRoute.getStations();
//
//        LocalTime time = Constant.TRANSIT_START_TIME;
//        while (!time.equals(Constant.TRANSIT_END_TIME)) {
////            while (iterator.hasNext()) {
////                Station station = iterator.next();
////                System.out.println(busRoute.getName() + " " + time.toString() + " " + station.getId() + " " + station.getName() + station.getBusDirection().abbreviation());
////
////            }
//            System.out.println(time.toString() + " " + busRoute.getName());
//            time = time.plusMinutes(Constant.REGULAR_MINIMUM_INTERARRIVAL_TIME);
//        }
//    }
//} // end class TransitRoutePopulator
