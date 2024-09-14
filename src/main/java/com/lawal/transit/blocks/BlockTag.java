package com.lawal.transit.blocks;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.roads.interfaces.*;

public record BlockTag(int id, CurbsideMarking curbsideMarker) implements RoadSectionTag { //(int id, RoadIdentifier roadLabel, Direction trafficDirection) implements RoadSectionTag {
//
//    private final int id;
//    private final RoadIdentifier roadLabel;
//    private final Direction trafficDirection;
//
//    public BlockTag (Builder builder) { //(int id, RoadIdentifier roadLabel, Direction trafficDirection) { //Builder builder) {
//        this.id = builder.id;
//        this.roadLabel = builder.roadLabel;
//        this.trafficDirection = builder.trafficDirection;
//    }
//
//    @Override
//    public int id () {
//        return id;
//    }
////
//    @Override
//    public Direction trafficdirection () {
//        return trafficDirection;
//    }
//
//    @Override
//    public RoadIdentifier roadLabel () {
//        return roadLabel;
//    }
//
//    @Override
//    public boolean equals (Object object) {
//        if (object == this) return true;
//        if (object == null) return false;
//        if (object instanceof RoadSectionTag sectionLabel)
//            return id == sectionLabel.id()
//                && roadLabel.equals(sectionLabel.roadLabel())
//                && trafficdirection().equals(sectionLabel.trafficdirection());
//        return false;
//    }
//
//    @Override
//    public int hashCode () {
//        return Objects.hash(id, roadLabel, trafficDirection);
//    }
//
//    @Override
//    public String toString () {
//        return getClass().getSimpleName()
//            + " id:" + id + " "
//            + roadLabel.name() +  " " + trafficDirection.abbreviation();
//    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {

        private int id;
        CurbsideMarking curbsideMarker;

        public Builder () {}

        public Builder id (int id) {
            this.id = id;
            return this;
        }

        public Builder curbsideMarker (CurbsideMarking curbsideMarker) {
            this.curbsideMarker = curbsideMarker;
            return this;
        }

        public RoadSectionTag build () {
            return new BlockTag(id, curbsideMarker);
        }
    }
}