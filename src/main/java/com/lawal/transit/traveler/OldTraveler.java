package com.lawal.transit.traveler;

//
//public final class Traveler implements Journey {
//
//    private final FormattedAddress destination;
//    private StationableGraph transitRoute;
//    private Positionable location;
//    private final int id;
//
//    public Traveler (int id, LocalDateTime startTime, FormattedAddress source, FormattedAddress destination) {
//        this.id = id;
//        this.destination = destination;
//        this.location = new Position(source, startTime);
//        this.transitRoute = new StationMap();
//    }
//
//    @Override
//    public Positionable getLocation () {
//        return location;
//    }
//
//    @Override
//    public FormattedAddress getDestination () {
//        return destination;
//    }
//
//    @Override
//    public void setLocation (Positionable location) {
//        this.location = location;
//    }
//
//    @Override
//    public void receiveRoute (RoutingAnswer response) {
//        this.transitRoute = response.getRoute();
//    }
//
//    @Override
//    public void requestRoute (Dispatching dispatcher) {
//        dispatcher.getRequest(new RouteRequest(randomInt(), id, location, destination, LocalDateTime.now()));
//    }
//
//    private int randomInt () { return (int)  (Math.random() * Integer.MAX_VALUE - 1) + 1;}
//}
