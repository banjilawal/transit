package com.lawal.transit.stations;


import com.lawal.transit.edges.interfaces.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.roads.*;
import com.lawal.transit.roads.interfaces.*;
import com.lawal.transit.stations.interfaces.*;

import java.util.*;

public final class Station implements Stationable, Visitee {
    private final LocationKey key;
    private final Edgeables incomingEdges;
    private final Edgeables outgoingEdges;
    private final Orientation trafficDirection;

    private Station (Builder builder) {
        this.key = builder.key;
        this.incomingEdges = builder.incomingEdges;
        this.outgoingEdges = builder.outgoingEdges;
        this.trafficDirection = builder.trafficDirection;
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

    @Override
    public Orientation trafficDirection () {
        return trafficDirection;
    }


    public Stationable crossStation (Road road, Laterality laterality) {
        if (road.label().category().equals(this.key.blockTag().roadLabel().category()))
            return null;
        else {
           return null;
        }
    }

    private Orientation leftCrossDirection () {
        switch (trafficDirection) {
            case NORTH:
                return Orientation.WEST;
            case EAST:
                return Orientation.NORTH;

            case SOUTH:
                return Orientation.EAST;
            case WEST:
                return Orientation.SOUTH;
        }
        return null;
    }

    private Orientation rightCrossDirection () {
        switch (trafficDirection) {
            case NORTH:
                return Orientation.EAST;
            case EAST:
                return Orientation.SOUTH;
            case SOUTH:
                return Orientation.WEST;
            case WEST:
                return Orientation.NORTH;
        }
        return null;
    }

    private RoadSectional crossFrontage (Orientation crossDirection, Road road) {
        if (crossDirection.equals(Orientation.NORTH) && road instanceof Avenue avenue) {
            return Avenue.
        }
            case NORTH:
                return road.rightFrontage();
            case EAST:
                return road.leftFrontage();
            case SOUTH:
                return road.leftFrontage();
            case WEST:
                return road.rightFrontage();
        }
        return null;
    }

    @Override
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
        return getClass().getSimpleName() + "key:" + key.toString() + " inDegree:" + incomingEdges.getDegree()
            + " outDegree:" + outgoingEdges.getDegree();
    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {
        private LocationKey key;
        private Edgeables incomingEdges;
        private Edgeables outgoingEdges;
        private Orientation trafficDirection;

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

        public Builder trafficDirection (Orientation trafficDirection) {
            this.trafficDirection = trafficDirection;
            return this;
        }

        public Stationable build () {
            return new Station(this);
        }
    }
}
