package com.lawal.transit.stations;

import com.lawal.transit.addressing.LocationKey;
import com.lawal.transit.edges.interfaces.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.stations.interfaces.*;

import java.util.*;

public final class Station implements Stationable {

    private final LocationKey key;
    private final Edgeables incomingEdges;
    private final Edgeables outgoingEdges;

    private Station (Builder builder) {
        this.key = builder.key;
        this.incomingEdges = builder.incomingEdges;
        this.outgoingEdges = builder.outgoingEdges;
    }

    @Override
    public LocationKey key () {
        return key;
    }

    @Override
    public Edgeables incomingEdges () {
        return incomingEdges;
    }

    @Override
    public Edgeables outgoingEdges () {
        return outgoingEdges;
    }

    public void accept (Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object instanceof Stationable stationable)
            return key.equals(stationable.key());
//                && incomingEdges.getDegree() == stationable.getIncomingEdges().getDegree()
//                && outgoingEdges.getDegree() == stationable.getOutgoingEdges().getDegree();
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(key, incomingEdges.getDegree(), outgoingEdges.getDegree());
    }

    @Override
    public String toString () {
        return getClass().getSimpleName()
            + " id:" + key.id()
            + " name:" + key.name()
            + " blockId:" + key.blockTag().id()
            + " inDegree:" + incomingEdges.getDegree()
            + " outDegree:" + outgoingEdges.getDegree()
            +  " " + key.blockTag().curbsideMarker().roadLabel().name()
            + " " + key.blockTag().curbsideMarker().roadLabel().category().abbreviation()
            + " " +key.blockTag().curbsideMarker().trafficDirection().print();
    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {

        private LocationKey key;
        private Edgeables incomingEdges;
        private Edgeables outgoingEdges;

        public Builder () {}

        public Builder key (LocationKey key) {
            this.key = key;
            return this;
        }

        public Builder incomingEdges (Edgeables incomingEdges) {
            this.incomingEdges = incomingEdges;
            return this;
        }

        public Builder outgoingEdges (Edgeables outgoingEdges) {
            this.outgoingEdges = outgoingEdges;
            return this;
        }

        public Stationable build () {
            return new Station(this);
        }
    }
}