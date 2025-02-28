package com.lawal.transit.traveler;

import com.lawal.transit.address.model.Address;

import java.time.*;

public class RouteRequest implements RoutingQuery {

    private final int travelerId;
    private final Address source;
    private final Address destination;
    private final LocalDateTime timestamp;

    public RouteRequest (int travelerId, Position curentPosition, Address destination) {
        this.travelerId = travelerId;
        this.source = curentPosition.address();
        this.destination = destination;
        this.timestamp = curentPosition.time();
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
    public Address getSource () {
        return source;
    }

    @Override
    public Address getDestination () {
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