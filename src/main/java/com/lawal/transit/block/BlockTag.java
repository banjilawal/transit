package com.lawal.transit.block;

import com.lawal.transit.road.CurbMarker;

public record BlockTag(int id, CurbMarker curbMarker)  {

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
        CurbMarker curbMarker;

        public Builder () {}

        public Builder id (int id) {
            this.id = id;
            return this;
        }

        public Builder curbsideMarker (CurbMarker curbMarker) {
            this.curbMarker = curbMarker;
            return this;
        }

        public BlockTag build () {
            return new BlockTag(id, curbMarker);
        }
    }
}