package com.lawal.transit.traveler;

import com.lawal.transit.addressing.*;

import java.time.*;

public interface RoutingQuery {
    public int getTravelerId ();
    public LocalDateTime getTimestamp ();
    public FormattedAddress getSource ();
    public FormattedAddress getDestination ();
}