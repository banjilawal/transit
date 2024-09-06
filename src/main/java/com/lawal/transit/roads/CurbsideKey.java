package com.lawal.transit.roads;

import com.lawal.transit.globals.Orientation;
import com.lawal.transit.roads.interfaces.CurbsideMarker;
import com.lawal.transit.roads.interfaces.RoadIdentifier;

public record CurbsideKey(RoadIdentifier roadLabel, Orientation trafficDirection) implements CurbsideMarker {

    @Override
    public String toString() {
        return  trafficDirection.toString() + " Curb " + roadLabel.name() + " " + roadLabel.category().abbreviation();
    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {

        private RoadIdentifier roadLabel;
        private Orientation trafficDirection;

        public Builder roadLabel (RoadIdentifier roadLabel) {
            this.roadLabel = roadLabel;
            return this;
        }

        public Builder trafficDirection (Orientation trafficDirection) {
            this.trafficDirection = trafficDirection;
            return this;
        }

        public CurbsideMarker build () {
            return new CurbsideKey(roadLabel, trafficDirection);
        }
    }
}