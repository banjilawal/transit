package com.lawal.transit.creation;

import com.lawal.transit.roads.RoadCategory;
import com.lawal.transit.roads.interfaces.RoadIdentifier;

public final class RoadParameters {

    public static final int PLACE_NAME_INCREMENT = 2;
    public static final int PLACE_MULTIPLICATION_FACTOR = 1000;
    public static final int STATION_MULTIPLICATION_FACTOR = 100;
    public static final int LEFT_FRONTAGE_STARTING_INDEX = 1;
    public static final int RIGHT_FRONTAGE_STARTING_INDEX = 0;
    private final int numberOfLeftFrontageBlocks;
    private final int numberOfRightFrontageBlocks;
    private final int stationInterval;
    private final int placesPerBlock;
    private final int roadId;
    private final int placeCursor;
    private final int stationCursor;
    private final String roadName;
    private final RoadCategory roadCategory;

    public RoadParameters(int numberOfLeftFrontageBlocks, int numberOfRightFrontageBlocks, int stationInterval, int placesPerBlock, int roadId, int placeCursor, int stationCursor, String roadName, RoadCategory roadCategory) {
        this.numberOfLeftFrontageBlocks = numberOfLeftFrontageBlocks;
        this.numberOfRightFrontageBlocks = numberOfRightFrontageBlocks;
        this.stationInterval = stationInterval;
        this.placesPerBlock = placesPerBlock;
        this.roadId = roadId;
        this.placeCursor = placeCursor;
        this.stationCursor = stationCursor;
        this.roadName = roadName;
        this.roadCategory = roadCategory;
    }

    public int getNumberOfLeftFrontageBlocks() {
        return numberOfLeftFrontageBlocks;
    }

    public int getNumberOfRightFrontageBlocks() {
        return numberOfRightFrontageBlocks;
    }

    public int getStationInterval() {
        return stationInterval;
    }

    public int getPlacesPerBlock() {
        return placesPerBlock;
    }

    public int getRoadId() {
        return roadId;
    }

    public int getPlaceCursor() {
        return placeCursor;
    }

    public int getStationCursor() {
        return stationCursor;
    }

    public String getRoadName() {
        return roadName;
    }

    public RoadCategory getRoadCategory() {
        return roadCategory;
    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {
        private int numberOfLeftFrontageBlocks;
        private int numberOfRightFrontageBlocks;
        private int stationInterval;
        private int placesPerBlock;
        private int roadId;
        private int placeCursor;
        private int stationCursor;
        private String roadName;
        private RoadCategory roadCategory;

        public Builder build () { return this; }
    }
}
