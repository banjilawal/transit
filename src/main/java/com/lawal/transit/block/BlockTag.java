package com.lawal.transit.block;

import com.lawal.transit.road.interfaces.*;

public record BlockTag(int id, CurbsideMarking curbsideMarker)  {

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

        public BlockTag build () {
            return new BlockTag(id, curbsideMarker);
        }
    }
}