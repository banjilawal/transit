package com.lawal.transit.roads.creators;


import com.lawal.transit.blocks.Blocks;
import com.lawal.transit.blocks.interfaces.RoadSectional;
import com.lawal.transit.blocks.interfaces.RoadSectionals;

import com.lawal.transit.globals.*;
import com.lawal.transit.roads.*;
import com.lawal.transit.roads.interfaces.CurbsideMarking;
import com.lawal.transit.roads.interfaces.Curbsideable;
import com.lawal.transit.roads.interfaces.RoadIdentifier;
import com.lawal.transit.stations.Stations;
import com.lawal.transit.stations.StationsCreator;

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
    private ArrayList<RoadSectional> targetBlocks;

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
        RoadSectionals blocks = createBlocks();
        Stations stations = createStations();
        return new Curbside.Builder().key(curbsideMarker).blocks(blocks).stations(stations).build();
    }

    private RoadSectionals createBlocks () throws Exception {
        RoadSectionals blocks = new Blocks();
        for (int index = 0; index < numberOfBlocks; index++) {
            RoadSectional block = blockCreator.startingPlaceName(placeName).blockId(index + 1).createBlock();
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