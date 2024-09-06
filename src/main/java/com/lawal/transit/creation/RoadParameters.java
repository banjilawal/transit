package com.lawal.transit.creation;

import com.lawal.transit.roads.RoadCategory;
import com.lawal.transit.roads.RoadLabel;
import com.lawal.transit.roads.interfaces.RoadIdentifier;

public record RoadParameters(
        int blocksPerFrontage,
        int placesPerBlock,
        int stationInterval,
        int addressInterval,
        AddressingSet addressingSet,
        RoadIdentifier roadLabel,
        int roadId,
        String roadName,
        RoadCategory roadCategory
){
//
//    public static final int PLACE_NAME_INCREMENT = 2;
//    public static final int PLACE_MULTIPLICATION_FACTOR = 1000;
//    public static final int STATION_MULTIPLICATION_FACTOR = 100;
//    public static final int LEFT_FRONTAGE_STARTING_INDEX = 1;
//    public static final int RIGHT_FRONTAGE_STARTING_INDEX = 0;

//    public RoadIdentifier roadLabel () {
//        return new RoadLabel.Builder().id(roadId).name(roadName).category(roadCategory).build();
//    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "\n"
            + "blocksPerFrontage:" + blocksPerFrontage+ "\n"
            + "placesPerBlock:" + placesPerBlock + "\n"
            + "addressingSet:" + addressingSet.toString() + "\n"
//            + "stationPrefixes:" + stationPrefixes + "\n"
            + "addressInterval:" + addressInterval + "\n"
            + "stationInterval:" + stationInterval + "\n"
            + "roadLabel:" + roadLabel + "\n";
//            + "roadId:" + roadId + "\n"
//            + "roadName:" + roadName + "\n"
//            + "roadCategory:" + roadCategory + "\n";
    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {
        private int blocksPerFrontage;
        private int placesPerBlock;
        private int multiplicationFactor;
        private AddressingSet addressingSet;
        private int addressInterval;
        private int stationInterval;
        private RoadIdentifier roadLabel;
        private int roadId;
        private String roadName;
        private RoadCategory roadCategory;

        public Builder blocksPerFrontage (int blocksPerFrontage) {
            this.blocksPerFrontage = blocksPerFrontage;
            return this;
        }

        public Builder placesPerBlock (int placesPerBlock) {
            this.placesPerBlock = placesPerBlock;
            return this;
        }

        public Builder multiplicationFactor (int multiplicationFactor) {
            this.multiplicationFactor = multiplicationFactor;
            return this;
        }
//
//        public Builder addressingPrefixes (AddressingSet addressingPrefixes) {
//            this.addressingPrefixes = addressingPrefixes;
//            return this;
//        }

        public Builder addressInterval (int addressInterval) {
            this.addressInterval = addressInterval;
            return this;
        }

        public Builder stationInterval (int stationInterval) {
            this.stationInterval = stationInterval;
            return this;
        }
//
        public Builder roadId (int roadId) {
            this.roadId = roadId;
            return this;
        }

        public Builder roadName (String roadName) {
            this.roadName = roadName;
            return this;
        }

        public Builder roadCategory (RoadCategory roadCategory) {
            this.roadCategory = roadCategory;
            return this;
        }

        public Builder addressingSet (AddressingSet addressingSet) {
            this.addressingSet = addressingSet;
            return this;
        }

//        public Builder roadLabel () {
//            RoadIdentifier roadLabel = new RoadLabel.Builder()
//                .id(roadId)
//                .name(roadName)
//                .category(roadCategory)
//                .build();
//            return this;
//        }

        private void setRoadLabel () {
            this.roadLabel = new RoadLabel.Builder().id(roadId).name(roadName).category(roadCategory).build();
        }

//        private void setAddressingPrefixes () {
//            this.addressingPrefixes = new AddressingSet.Builder()
//                .roadLabel(new RoadLabel.Builder().id(roadId).name(roadName).category(roadCategory).build())
//                .multiplicationFactor(multiplicationFactor)
//                .build();
//        }
//
//        public CurbsideCreator.Builder setStationPrefixes (int rightStartingName) {
//            this.stationPrefixes = new AddressingSet(rightStartingName + 1000, rightStartingName);
//        }

        public RoadParameters build () {
            this.roadLabel = new RoadLabel.Builder().id(roadId).name(roadName).category(roadCategory).build();
            return new RoadParameters(
                blocksPerFrontage,
                placesPerBlock,
                addressInterval,
                stationInterval,
                addressingSet,
                roadLabel,
                roadId,
                roadName,
                roadCategory
            );
        }
    }
}