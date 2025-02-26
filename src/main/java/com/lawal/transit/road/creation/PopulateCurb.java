package com.lawal.transit.road.creation;


import com.lawal.transit.address.Address;
import com.lawal.transit.block.Block;
import com.lawal.transit.block.BlockPopulator;

import com.lawal.transit.catalog.BlockCatalog;
import com.lawal.transit.catalog.StationCatalog;
import com.lawal.transit.global.*;
import com.lawal.transit.road.*;
import com.lawal.transit.station.Station;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class PopulateCurb {

    static AtomicInteger blockId = new AtomicInteger(0);
    static AtomicInteger stationId = new AtomicInteger(0);

    public static void createBlocks (Curb curb, int numberOfBlocks, int addressInterval, int numberOfAddresses, int startingAddressName) {
        int addressName = startingAddressName;
        for (int index = 0; index < numberOfBlocks; index++) {
            String blockName = "Block-" + (curb.getBlocks().size() + 1) * Constant.MULTIPLICATION_FACTOR;
            Block block = new Block(blockId.incrementAndGet(), blockName, curb);
            addressName = BlockPopulator.populateBlock(block, addressName, addressInterval, numberOfAddresses);
            curb.getBlocks().add(block);
            BlockCatalog.INSTANCE.getCatalog().getList().add(block);
        }
    }

    public static void createStations (Curb curb, int percentStationDensity) {
        for (Block block : curb.getBlocks()) {
            if (new Random().nextInt(101) <= percentStationDensity) {
                Address address = new Address(stationId.incrementAndGet(), NameGenerator.INSTANCE.stationName(curb.getOrientation()), block);
                Station station = new Station(address, block);
                curb.getStations().add(station);
                StationCatalog.INSTANCE.getCatalog().add(station);
            }
        }
    }
}