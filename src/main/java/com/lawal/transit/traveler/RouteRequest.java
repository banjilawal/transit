package com.lawal.transit.traveler;

import com.lawal.transit.globals.*;
import com.lawal.transit.search.*;

import java.time.*;

public class RouteRequest implements RoutingQuery {

    private final int travelerId;
    private final FormattedAddress source;
    private final FormattedAddress destination;
    private final LocalDateTime timestamp;

    public RouteRequest (int travelerId, Positionable location, FormattedAddress destination) {
        this.travelerId = travelerId;
        this.source = location.address();
        this.destination = destination;
        this.timestamp = location.time();
    }

    @Override
    public int getTravelerId () {
        return travelerId;
    }

    @Override
    public LocalDateTime getTimestamp () {
        return timestamp;
    }

    @Override
    public FormattedAddress getSource () {
        return source;
    }

    @Override
    public FormattedAddress getDestination () {
        return destination;
    }

    @Override
    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof RoutingQuery query)
            return travelerId == query.getTravelerId() && timestamp.equals(query.getTimestamp())
                && source.equals(query.getSource()) && destination.equals(query.getDestination());
        return false;
    }

    @Override
    public int hashCode () {
        int primeNumber = 199;
        int multiplicand = 37;
        primeNumber = primeNumber * multiplicand + travelerId;
        primeNumber = primeNumber * multiplicand + timestamp.hashCode();
        primeNumber = primeNumber * multiplicand + source.hashCode();
        primeNumber = primeNumber * multiplicand + destination.hashCode();
        return primeNumber;
    }

    public String toString () {
        return getClass().getSimpleName() + " timestamp:" + timestamp + " travelerId:" + travelerId
            + " source:" + source.toString() + " destination:" + destination;
    }
}
