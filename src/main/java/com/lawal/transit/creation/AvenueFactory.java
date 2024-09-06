package com.lawal.transit.creation;

import com.lawal.transit.globals.Constant;
import com.lawal.transit.globals.IdGenerator;
import com.lawal.transit.globals.NameGenerator;
import com.lawal.transit.roads.Avenue;

import java.util.Random;

public record AvenueFactory (int batchSize) {

    private static int currentLeftwardStationName = Avenue.LEFTWARD_STATION_BASE_NAME;
    private static int currentRightwardStationName = Avenue.LEFTWARD_STATION_BASE_NAME;

    public void build () throws Exception {
        for (int index = 0; index < batchSize; index++) {
            Random generator = new Random();
            int roadId = IdGenerator.INSTANCE.nextAvenueId();
            AddressingSet addressingSet = new AddressingSet(
                roadId * Constant.MULTIPLICATION_FACTOR,
                roadId * Constant.MULTIPLICATION_FACTOR + 1,
                currentLeftwardStationName,
                currentRightwardStationName
            );
            RoadParameters roadParameters =  new RoadParameters.Builder()
                .roadId()
                .roadName(NameGenerator.INSTANCE.avenueName())
                .roadCategory(Avenue.ROAD_CATEGORY)
                .blocksPerFrontage(5)
                .placesPerBlock(4)
                .multiplicationFactor(Constant.MULTIPLICATION_FACTOR)
                .stationInterval(generator.nextInt(3) + 1)
                .addressInterval(Constant.ADDRESS_INTERVAL)
                .addressingSet(addressingSet)
                .build();


        }
    }
}