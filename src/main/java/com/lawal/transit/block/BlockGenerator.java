package com.lawal.transit.block;

import com.lawal.transit.block.model.Block;
import com.lawal.transit.catalog.AvenueCatalog;
import com.lawal.transit.catalog.BlockCatalog;
import com.lawal.transit.catalog.CurbCatalog;
import com.lawal.transit.catalog.StationCatalog;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.global.Constant;
import com.lawal.transit.global.NameGenerator;
import com.lawal.transit.SystemBuilder;
import com.lawal.transit.station.model.Station;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class BlockGenerator {

    static AtomicLong blockId = new AtomicLong(0);
    static AtomicLong stationId = new AtomicLong(0);

    public static void generateBlocks () {
        for (Curb curb : CurbCatalog.INSTANCE.getCatalog()) {
            createBlocks(curb, AvenueCatalog.INSTANCE.getCatalog().size());
            createStations(curb, SystemBuilder.STATION_DENSITY);
        }
    }

    public static void createBlocks (Curb curb, int numberOfBlocks) { //}, int addressInterval, int numberOfAddresses, int startingAddressName) {
//        int addressName = startingAddressName;
        for (int index = 0; index < numberOfBlocks; index++) {
            String blockName = "Block-" + (curb.getBlocks().size() + 1) * Constant.MULTIPLICATION_FACTOR;
            Block block = new Block(blockId.incrementAndGet(), blockName, curb);
//            Block block = new Block(blockId.incrementAndGet(), blockName, curb, null);
//            addressName = BlockPopulator.populateBlock(block, addressName, addressInterval, numberOfAddresses);
//            curb.getBlocks().add(block);
            BlockCatalog.INSTANCE.getCatalog().add(block);
        }
    }

    public static void createStations (Curb curb, int percentStationDensity) {
        for (Block block : curb.getBlocks()) {
            if (new Random().nextInt(101) <= percentStationDensity) {
                Station station = new Station(stationId.incrementAndGet(), NameGenerator.INSTANCE.stationName(curb.getOrientation()), block);
                StationCatalog.INSTANCE.getCatalog().add(station);
            }
        }
    }
}