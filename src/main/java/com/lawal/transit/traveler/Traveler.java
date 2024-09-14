//package com.lawal.transit.traveler;
//
//import com.lawal.transit.places.*;
//import com.lawal.transit.globals.*;
//import com.lawal.transit.graph.*;
//import com.lawal.transit.addressing.*;
//import com.lawal.transit.stations.interfaces.*;
//import com.lawal.transit.transport.interfaces.*;
//
//import java.time.*;
//
//public class Traveler implements UtilizeVehicle, Walking, RoutingClient, Traveling {
//
//    private final int travelerId;
//    private final FormattedAddress source;
//    private final FormattedAddress destination;
//    private Positionable currentLocation;
//    private StationableGraph route;
//
//    public Traveler (int travelerId, FormattedAddress source, FormattedAddress destination, LocalDateTime startTime) {
//        this.travelerId = travelerId;
//        this.source = source;
//        this.destination = destination;
//        this.currentLocation = new Position(source, startTime);
//        this.route = new StationMap();
//    }
//
//    @Override
//    public int getTravelerId () {
//        return travelerId;
//    }
//
//    public FormattedAddress getSource () {
//        return source;
//    }
//
//    public FormattedAddress getDestination () {
//        return destination;
//    }
//
//    @Override
//    public Positionable getCurrentLocation () {
//        return currentLocation;
//    }
//
//    @Override
//    public void setCurrentLocation (Positionable location) {
//        this.currentLocation = location;
//    }
//
//    @Override
//    public void embark (Vehicle vehicle, Vertex station) {
//
//    }
//
//    @Override
//    public void disembark (Vehicle vehicle) {
//    }
//
//    @Override
//    public void sendRoutingQuery (Dispatching dispatcher) {
//        dispatcher.receiveQuery(new RouteRequest(travelerId, currentLocation, destination));
//    }
//
//    @Override
//    public void receiveRoute (RoutingAnswer answer) {
//        this.route = answer.getRoute();
//    }
//
//    @Override
//    public void walkTo (Vertex station) {
//
//    }
//
//    @Override
//    public void walkTo (Addressable addressable) {
//
//    }
//
//    public StationableGraph getRoute () {
//        return route;
//    }
//}