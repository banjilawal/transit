package com.lawal.transit.traveler;

public interface RouteProvider {

    public void receive (RoutingQuery query);
    public RoutingAnswer send ();
}
