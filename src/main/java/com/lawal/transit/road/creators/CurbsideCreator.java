package com.lawal.transit.road.creators;


import com.lawal.transit.block.Blocks;
import com.lawal.transit.block.interfaces.RoadSegment;
import com.lawal.transit.block.interfaces.RoadSegments;

import com.lawal.transit.catalog.BlockCatalog;
import com.lawal.transit.global.*;
import com.lawal.transit.road.*;
import com.lawal.transit.road.interfaces.CurbsideMarking;
import com.lawal.transit.road.interfaces.Curbsideable;
import com.lawal.transit.road.interfaces.RoadIdentifier;
import com.lawal.transit.station.Stations;
import com.lawal.transit.station.StationsCreator;

import java.util.ArrayList;
import java.util.Random;

public class CurbsideCreator {

    private int placeName;
    private int numberOfBlocks;
    private int placesPerBlock;
    private int startingPlaceName;
    private int placeNameInterval;

    private RoadIdentifier roadLabel;
    private BlockCreator blockCreator;
    private StationsCreator stationsCreator;
    private Direction trafficDirection;
    private ArrayList<RoadSegment> targetBlocks;

    public CurbsideCreator () {}

    public RoadIdentifier getRoadLabel () {
        return roadLabel;
    }

    public Direction getTrafficDirection () {
        return trafficDirection;
    }

    public int getNumberOfBlocks () {
        return numberOfBlocks;
    }

    public int getPlacesPerBlock () {
        return placesPerBlock;
    }

    public int getStartingPlaceName () {
        return startingPlaceName;
    }

    public int getPlaceName () {
        return placeName;
    }

    public int getPlaceNameInterval () {
        return placeNameInterval;
    }


    public CurbsideCreator roadLabel (RoadIdentifier roadLabel) {
        this.roadLabel = roadLabel;
        return this;
    }

    public CurbsideCreator trafficDirection (Direction trafficDirection) {
        this.trafficDirection = trafficDirection;
        return this;
    }

    public CurbsideCreator numberOfBlocks (int numberOfBlocks) {
        this.numberOfBlocks = numberOfBlocks;
        return this;
    }

    public CurbsideCreator placesPerBlock (int placesPerBlock) {
        this.placesPerBlock = placesPerBlock;
        return this;
    }

    public CurbsideCreator startingPlaceName (int startingPlaceName) {
        this.startingPlaceName = startingPlaceName;
        this.placeName = startingPlaceName;
        return this;
    }

    public CurbsideCreator placeNameInterval (int nameInfixIncrement) {
        this.placeNameInterval = nameInfixIncrement;
        return this;
    }

    public Curbsideable getProduct () throws Exception {
        targetBlocks = new ArrayList<>();
        CurbsideMarking curbsideMarker = new CurbsideMark(roadLabel, trafficDirection);
        blockCreator = new BlockCreator()
            .curbsideMarker(curbsideMarker)
            .numberOfPlaces(placesPerBlock)
            .startingPlaceName(startingPlaceName)
            .placeNameInterval(placeNameInterval);
        stationsCreator = new StationsCreator();
        RoadSegments blocks = createBlocks();
        Stations stations = createStations();
        return new Curbside.Builder().key(curbsideMarker).blocks(blocks).stations(stations).build();
    }

    private RoadSegments createBlocks () throws Exception {
        BlockCatalog blockCatalog = BlockCatalog.INSTANCE;
        RoadSegments blocks = new Blocks();
        for (int index = 0; index < numberOfBlocks; index++) {
            RoadSegment block = blockCreator.startingPlaceName(placeName).blockId(index + 1).createBlock();
            blockCatalog.getCatalog().getList().add(block);
            blocks.addBlock(block);
            placeName = blockCreator.getPlaceName();// + placeNameInterval;
            if (assignedStation() && !targetBlocks.contains(block))
                targetBlocks.add(block);
        }
        return blocks;
    }

    private Stations createStations () throws Exception {
        return stationsCreator.targetBlocks(targetBlocks).getProduct();
    }

    private boolean assignedStation () {
        Random random = new Random();
        return random.nextInt(101) > stationDensityThreshold();
    }

    private int stationDensityThreshold () {
        Random random = new Random();
        return random.nextInt(Constant.STATION_DENSITY_PERCENTAGE_FLOOR, Constant.STATION_DENSITY_PERCENTAGE_CEILING) + 1;
    }

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