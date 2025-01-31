package com.lawal.transit.road;

import com.lawal.transit.global.Direction;
import com.lawal.transit.road.interfaces.CurbsideMarking;
import com.lawal.transit.road.interfaces.RoadIdentifier;

public record CurbsideMark(RoadIdentifier roadLabel, Direction travelDirection) implements CurbsideMarking {

    @Override
    public String toString() {
        return  travelDirection.toString() + " Curb " + roadLabel.name() + " " + roadLabel.category().abbreviation();
    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {
        private RoadIdentifier roadLabel;
        private Direction trafficDirection;


        public Builder roadLabel (RoadIdentifier roadLabel) {
            this.roadLabel = roadLabel;
            return this;
        }

        public Builder trafficDirection (Direction trafficDirection) {
            this.trafficDirection = trafficDirection;
            return this;
        }

        public CurbsideMarking build () {
            return new CurbsideMark(roadLabel, trafficDirection);
        }
    }
}