package com.lawal.transit.roads;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.roads.interfaces.*;
import com.lawal.transit.stations.interfaces.*;

public final class Frontage implements Curbsideable {


    private final Orientation trafficDirection;
    private final RoadIdentifier roadLabel;
    private final Stationables stations;
    private final RoadSectionals blocks;

    private Frontage (Builder builder) {
        this.trafficDirection = builder.trafficDirection;
        this.roadLabel = builder.roadLabel;
        this.stations = builder.stations;
        this.blocks = builder.blocks;
    }

    @Override
    public Orientation trafficDirection () {
        return trafficDirection;
    }

    @Override
    public RoadIdentifier roadLabel () {
        return roadLabel;
    }

    @Override
    public RoadSectionals blocks () {
        return blocks;
    }

    @Override
    public Stationables stations () {
        return stations;
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + " " + trafficDirection.abbreviation()
            + "\n" + blocks.toString() + "\n" + stations.toString();
    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {
        private Orientation trafficDirection;
        private RoadIdentifier roadLabel;
        private RoadSectionals blocks;
        private Stationables stations;

        public Builder () {}

        public Builder trafficDirection (Orientation trafficDirection) {
            this.trafficDirection = trafficDirection;
            return this;
        }

        public Builder roadLabel (RoadIdentifier roadLabel) {
            this.roadLabel = roadLabel;
            return this;
        }

        public Builder blocks (RoadSectionals blocks) {
            this.blocks = blocks;
            return this;
        }

        public Builder stations (Stationables stations) {
            this.stations = stations;
            return this;
        }

        public Curbsideable build () {
            return new Frontage(this);
        }
    }
}
