package com.lawal.transit.blocks;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.roads.interfaces.*;

public record BlockTag(Orientation trafficDirection, RoadIdentifier roadLabel, int id) implements RoadSectionTag { //(int id, RoadIdentifier roadLabel, Orientation trafficDirection) implements RoadSectionTag {
//
//    private final int id;
//    private final RoadIdentifier roadLabel;
//    private final Orientation trafficDirection;
//
//    public BlockTag (Builder builder) { //(int id, RoadIdentifier roadLabel, Orientation trafficDirection) { //Builder builder) {
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
//    public Orientation trafficdirection () {
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

        private Orientation trafficDirection;
        private RoadIdentifier roadLabel;
        private int id;

        public Builder () {}

        public Builder id (int id) {
            this.id = id;
            return this;
        }

        public Builder trafficDirection (Orientation trafficDirection) {
            this.trafficDirection = trafficDirection;
            return this;
        }

        public Builder roadLabel (RoadIdentifier roadLabel) {
            this.roadLabel = roadLabel;
            return this;
        }

        public RoadSectionTag build () {
            return new BlockTag(trafficDirection, roadLabel, id);
        }
    }
}
