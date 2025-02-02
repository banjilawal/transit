package com.lawal.transit.road.creators;


import com.lawal.transit.block.Block;
import com.lawal.transit.block.BlockPopulator;
import com.lawal.transit.block.BlockTag;
import com.lawal.transit.block.Blocks;

import com.lawal.transit.catalog.BlockCatalog;
import com.lawal.transit.catalog.StationCatalog;
import com.lawal.transit.global.*;
import com.lawal.transit.road.*;
import com.lawal.transit.road.interfaces.Road;
import com.lawal.transit.station.Station;
import com.lawal.transit.station.Stations;
import com.lawal.transit.station.StationsCreator;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class PopulateCurb {

    static AtomicInteger blockId = new AtomicInteger(0);
    static AtomicInteger stationId = new AtomicInteger(0);

//    private int addressName;
//    private int numberOfBlocks;
//    private int numberOfAddresses;
//    private int startingPlaceName;
//    private int addressInterval;
//
//    private RoadLabel roadLabel;
//    private BlockPopulator blockPopulator;
//    private StationsCreator stationsCreator;
//    private Direction trafficDirection;
//    private Blocks targetBlocks;

//    public PopulateCurb () {}
////
//    public RoadLabel getRoadLabel () {
//        return roadLabel;
//    }
//
//    public Direction getTrafficDirection () {
//        return trafficDirection;
//    }
//
//    public int getNumberOfBlocks () {
//        return numberOfBlocks;
//    }
//
//    public int getNumberOfAddresses () {
//        return numberOfAddresses;
//    }
//
//    public int getStartingPlaceName () {
//        return startingPlaceName;
//    }
//
//    public int getAddressName () {
//        return addressName;
//    }
//
//    public int getAddressInterval () {
//        return addressInterval;
//    }
//
//
//    public PopulateCurb roadLabel (RoadLabel roadLabel) {
//        this.roadLabel = roadLabel;
//        return this;
//    }
//
//    public PopulateCurb trafficDirection (Direction trafficDirection) {
//        this.trafficDirection = trafficDirection;
//        return this;
//    }
//
//    public PopulateCurb numberOfBlocks (int numberOfBlocks) {
//        this.numberOfBlocks = numberOfBlocks;
//        return this;
//    }
//
//    public PopulateCurb placesPerBlock (int placesPerBlock) {
//        this.numberOfAddresses = placesPerBlock;
//        return this;
//    }
//
//    public PopulateCurb startingPlaceName (int startingPlaceName) {
//        this.startingPlaceName = startingPlaceName;
//        this.addressName = startingPlaceName;
//        return this;
//    }
//
//    public PopulateCurb placeNameInterval (int nameInfixIncrement) {
//        this.addressInterval = nameInfixIncrement;
//        return this;
//    }
//
//    public static Curb create (Road road, Direction curbOrientation, int numberOfBlocks, int numberOfAddresses, int startingPlaceName, int addressInterval) {
//        Curb curb = new Curb (curbId.incrementAndGet(),road, new CurbMarker(road.label(), curbOrientation), curbOrientation);
//        createBlocks(curb);
//    }
//
//    public Curb getProduct () throws Exception {
//        targetBlocks = new Blocks();
//        CurbMarker curbMarker = new CurbMarker(roadLabel, trafficDirection);
//        blockPopulator = new BlockPopulator()
//            .curbsideMarker(curbMarker)
//            .numberOfPlaces(numberOfAddresses)
//            .startingPlaceName(startingPlaceName)
//            .placeNameInterval(addressInterval);
//        stationsCreator = new StationsCreator();
//        Blocks blocks = createBlocks();
//        Stations stations = createStations();
//        return new Curb.Builder().marker(curbMarker).blocks(blocks).stations(stations).build();
//    }

    public static void createBlocks (Curb curb, int numberOfBlocks, int addressInterval, int numberOfAddresses, int startingAddressName) {
        int addressName = startingAddressName;
        for (int index = 0; index < numberOfBlocks; index++) {
            String blockName = (curb.getBlocks().size() + 1) * Constant.MULTIPLICATION_FACTOR + " block";
            Block block = new Block(blockId.incrementAndGet(), blockName, curb);
            addressName = BlockPopulator.populateBlock(block, addressName, addressInterval, numberOfAddresses);
            curb.getBlocks().add(block);
            BlockCatalog.INSTANCE.getCatalog().getList().add(block);
        }
    }

    public static void createStations (Curb curb, int percentStationDensity) {
        for (Block block : curb.getBlocks()) {
            if (new Random().nextInt(101) <= percentStationDensity) {
                Address address = new Address(stationId.incrementAndGet(), NameGenerator.INSTANCE.stationName(curb.getOrientation()), block, block.getTag());
                Station station = new Station(address, block);
                curb.getStations().add(station);
                StationCatalog.INSTANCE.getCatalog().add(station);
            }
        }
    }
//    private Stations createStations () throws Exception {
//        return stationsCreator.targetBlocks(targetBlocks).getProduct();
//    }

//    private boolean assignedStation () {
//        Random random = new Random();
//        return random.nextInt(101) > stationDensityThreshold();
//    }
//
//    private int stationDensityThreshold () {
//        Random random = new Random();
//        return random.nextInt(Constant.STATION_DENSITY_PERCENTAGE_FLOOR, Constant.STATION_DENSITY_PERCENTAGE_CEILING) + 1;
//    }

//    private boolean assignedStation () {
//        Random thresholdRandomizer= new Random();
//        Random outcomeRandomizer = new Random();
//        int threshold = thresholdRandomizer.nextInt(
//            Constant.STATION_DENSITY_PERCENTAGE_FLOOR,
//            Constant.STATION_DENSITY_PERCENTAGE_CEILING
//        ) + 1;
//        int outcome = outcomeRandomizer.nextInt(101);
//        if (outcome > threshold) {
//            System.out.println(IdGenerator.INSTANCE.stationCount() + " " + outcome + " " + threshold);
//        } ;
//        return (outcome > threshold);
//    }
}