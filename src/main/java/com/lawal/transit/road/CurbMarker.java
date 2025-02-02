package com.lawal.transit.road;

import com.lawal.transit.global.Direction;

public record CurbMarker(RoadLabel roadLabel, Direction travelDirection) {

    @Override
    public String toString() {
        return  travelDirection.toString() + " Curb " + roadLabel.name() + " " + roadLabel.category().abbreviation();
    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {
        private RoadLabel roadLabel;
        private Direction trafficDirection;


        public Builder roadLabel (RoadLabel roadLabel) {
            this.roadLabel = roadLabel;
            return this;
        }

        public Builder trafficDirection (Direction trafficDirection) {
            this.trafficDirection = trafficDirection;
            return this;
        }

        public CurbMarker build () {
            return new CurbMarker(roadLabel, trafficDirection);
        }
    }
}