package com.lawal.transit.creation;

import com.lawal.transit.globals.Orientation;
import com.lawal.transit.roads.Carriageway;
import com.lawal.transit.roads.CurbsideKey;
import com.lawal.transit.roads.Street;
import com.lawal.transit.roads.interfaces.Curbsideable;

/**
 * @param requirements private int stationInterval;    private int stationCursor;    private final RoadIdentifier label;
 */
public record StreetCreator(RoadParameters requirements) {
//
//    public static final int PLACE_NAME_INCREMENT = 2;
//    public static final int PLACE_MULTIPLICATION_FACTOR = 1000;
//    public static final int STATION_MULTIPLICATION_FACTOR = 100;
//    public static final int LEFT_FRONTAGE_STARTING_INDEX = 1;
//    public static final int RIGHT_FRONTAGE_STARTING_INDEX = 0;
//        this.label = new RoadLabel.Builder()
//            .id(requirements.roadId())
//            .name(requirements.roadName())
//            .category(RoadCategory.AVENUE)
//            .build();
//
//    public AvenueCreator stationInterval (int stationInterval) {
//        this.stationInterval = stationInterval;
//        return this;
//    }

    public Street create() throws Exception {
        return new Street.Builder()
            .label(requirements.roadLabel())
            .leftCarriageway(new Carriageway(Street.LEFTWARD_TRAFFIC_DIRECTION))
            .rightCarriageway(new Carriageway(Street.RIGHTWARD_TRAFFIC_DIRECTION))
//                .leftCurb(new Curbside.Builder().key(new CurbsideKey(requirements.roadLabel(), Avenue.LEFTWARD_TRAFFIC_DIRECTION)).blocks(new Blocks()).stations(new Stations()).build())
//                .rightCurb(new Curbside.Builder().key(new CurbsideKey(requirements.roadLabel(), Avenue.RIGHTWARD_TRAFFIC_DIRECTION)).blocks(new Blocks()).stations(new Stations()).build())
            .leftCurb(curbside(requirements.addressingSet().leftwardPlaceName(), requirements.addressingSet().leftwardStationName(), Street.LEFTWARD_TRAFFIC_DIRECTION))
            .rightCurb(curbside(requirements.addressingSet().rightwardPlaceName(), requirements.addressingSet().rightwardStationName(), Street.RIGHTWARD_TRAFFIC_DIRECTION))
            .build();
    }

    private Curbsideable curbside(int startingPlaceName, int startingStationName, Orientation trafficDirection) throws Exception {
        CurbsideCreator creator = new CurbsideCreator.Builder()
            .startingPlaceName(startingPlaceName)
            .addressInterval(requirements.addressInterval())
            .totalBlocks(requirements.blocksPerFrontage())
            .blockSize(requirements.placesPerBlock())
            .startingStationName(startingStationName)
            .stationInterval(requirements().stationInterval())
            .marker(new CurbsideKey(requirements.roadLabel(), trafficDirection))
            .build();
        return creator.create();
    }
}