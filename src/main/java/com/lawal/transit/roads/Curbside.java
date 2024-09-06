package com.lawal.transit.roads;

import com.lawal.transit.blocks.Blocks;
import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.roads.interfaces.*;
import com.lawal.transit.stations.Stations;
import com.lawal.transit.stations.interfaces.*;

public final class Curbside implements Curbsideable {

    private final CurbsideMarker key;
    private final Stationables stations;
    private final RoadSectionals blocks;

    public Curbside (CurbsideMarker key) {
        this.key = key;
        this.blocks = new Blocks();
        this.stations = new Stations();
    }

    private Curbside(Builder builder) {
        this.key = builder.key;
        this.stations = builder.stations;
        this.blocks = builder.blocks;
    }

    @Override
    public CurbsideMarker key() {
        return key;
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
        return key().toString() + "\n" + blocks.toString() + "\n" + stations.toString();
    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {

        private CurbsideMarker key;
        private RoadSectionals blocks;
        private Stationables stations;

        public Builder () {}

        public Builder key(CurbsideMarker key) {
            this.key = key;
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
            return new Curbside(this);
        }
    }
}