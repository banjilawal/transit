package com.lawal.transit.traveler;

public interface Dispatching {

    public RoutingQueries getQueries ();
    public RoutingAnswers getAnswers ();

    public void receiveQuery (RoutingQuery query);
    public void sendAnswer (RoutingAnswer answer);
    public void forwardQuery (RouteProvider routeProvider, RoutingQuery query);
    public void forwardAnswer (Journey traveler, RoutingAnswer answer);
}
