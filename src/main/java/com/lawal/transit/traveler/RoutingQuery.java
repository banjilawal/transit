package com.lawal.transit.traveler;

import com.lawal.transit.global.Address;

import java.time.*;

public interface RoutingQuery {
    public int getTravelerId ();
    public LocalDateTime getTimestamp ();
    public Address getSource ();
    public Address getDestination ();
}