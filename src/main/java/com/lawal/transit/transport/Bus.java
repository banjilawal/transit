//package com.lawal.transit.transport;
//
//import com.lawal.transit.globals.*;
//import com.lawal.transit.search.*;
//import com.lawal.transit.stations.interfaces.*;
//import com.lawal.transit.transport.interfaces.*;
//import com.lawal.transit.traveler.*;
//
//import java.time.*;
//import java.util.*;
//import java.util.concurrent.*;
//
//public class Bus implements Vehicle {
//
//    private final int id;
//    private final int capacity;
//    private TimeTable timeTable;
//    private Trackable location;
//    private List<Traveler> passengers;
//    private final ArrayBlockingQueue<Traveler> exitingQueue;
//    private PassengerQueue boardingQueue;
//
//    public Bus (int id, int capacity, TimeTable timeTable) {
//        this.id = id;
//        this.capacity = capacity;
//        this.timeTable = timeTable;
//        location = new Position(null,null);
//        boardingQueue = new PassengerQueue();
//        exitingQueue = new ArrayBlockingQueue<Traveler>(capacity);
//        passengers = Collections.synchronizedList(new ArrayList<Traveler>());
//    }
//    public int getId () {
//        return id;
//    }
//
//    @Override
//    public int getCapacity () {
//        return capacity;
//    }
//
//    @Override
//    public Trackable getLocation () {
//        return location;
//    }
//
//    @Override
//    public TimeTable getSchedule () {
//        return timeTable;
//    }
//
//    @Override
//    public FormattedAddress getNextStop () {
//        return null;
//    }
//
//    public void disembark (Vertex station) {
//        ArrayList<Integer> indices = new ArrayList<>();
//        for (Traveler passenger: passengers) {
//            if (passenger.getRoute().getNodes().searchByName(station.getAddress().name()) != null) {
//                indices.add(indices.size(), passengers.indexOf(passenger));
//                passenger.setCurrentLocation(new Position(station.getAddress(), LocalDateTime.now()));
//            }
//        }
//
//        for (Integer index : indices) {
//            Traveler traveler = passengers.remove(index.intValue());
//            station.disembark(traveler);
//        }
//    }
//
//
//
////    public void arrive (OldStationable station) throws Exception {
////        for (Traveler rider : riders.getRiders()) {
////            if (rider.getRoute().getVertices().search(station.getAddress()) != null) {
////                int index = riders.getRiders().indexOf(rider);
////                Traveler disembarker = riders.getRiders().remove(index);
////                exitingQueue.enqueue(disembarker);
////            }
////        }
////    }
//
//    @Override
//    public void setLocation (Trackable location) {
//        this.location = location;
//    }
//
//    @Override
//    public void setNextStop (FormattedAddress stop) {
//
//    }
//
//    @Override
//    public void setSchedule (TimeTable timeTable) {
//        this.timeTable = timeTable;
//    }
//
//    public void embark (Traveler traveler) {
//
//    }
//
////    @Override
////    public void embarkPassenger (Embarkation embarkation, Journey traveler) throws Exception {
////        if (passengers.size() > capacity)
////            throw new Exception("Passengers cannot embark the bus is full");
////        embarkation.embark(this, traveler, location);
////    }
//
//    @Override
//    public void disembarkPassenger (Disembarkation disembarkation, Journey traveler) {
//        if
//        disembarkation.disembark(this, traveler, location);
//    }
//
////    @Override
////    public void addPassenger (Embarkation embarker) throws Exception {
////        if (passengers.size() >= capacity)
////            throw new Exception("The bus is full no additional passengers can embark");
////        passengers.add(embarker);
////    }
////
////    @Override
////    public void removePassenger (Embarkation embarker) throws Exception {
////
////    }
//}