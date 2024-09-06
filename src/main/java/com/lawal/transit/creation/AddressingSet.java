package com.lawal.transit.creation;

import com.lawal.transit.roads.interfaces.RoadIdentifier;

public record AddressingSet(int rightwardPlaceName, int leftwardPlaceName, int rightwardStationName, int leftwardStationName) {

    public static final int RIGHT_FRONTAGE_STARTING_INDEX = 0;
    public static final int LEFT_FRONTAGE_STARTING_INDEX = 1;

    @Override
    public String toString() {
        return "rightward place name:" + rightwardPlaceName + "\n"
            + "leftward place name:" + leftwardPlaceName + "\n"
            + "rightward station name:" + rightwardStationName + "\n"
            + "leftward station name:" + leftwardStationName;
    }

//    public static Builder builder () {
//        return new Builder ();
//    }
//    public static class Builder {
//        private RoadIdentifier roadLabel;
//        private int multiplicationFactor;
//
//        public Builder roadLabel (RoadIdentifier roadLabel) {
//            this.roadLabel = roadLabel;
//            return this;
//        }
//
//        public Builder multiplicationFactor (int multiplicationFactor) {
//            this.multiplicationFactor = multiplicationFactor;
//            return this;
//        }
//
//        public AddressingSet build () {
//            return new AddressingSet(
//                roadLabel.id() * multiplicationFactor + AddressingSet.RIGHT_FRONTAGE_STARTING_INDEX,
//                roadLabel.id() * multiplicationFactor + AddressingSet.LEFT_FRONTAGE_STARTING_INDEX,
//
//
//            );
//        }
//    }

}