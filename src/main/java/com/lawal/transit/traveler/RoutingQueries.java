package com.lawal.transit.traveler;

public interface RoutingQueries {

    public RoutingQuery dequeue ();
    public void enqueue (RoutingQuery requestable);
}
