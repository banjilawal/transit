package com.lawal.transit.creation;

import com.lawal.transit.catalogs.*;
import com.lawal.transit.places.*;
import com.lawal.transit.blocks.*;
import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.places.interfaces.*;
import com.lawal.transit.roads.*;
import com.lawal.transit.roads.interfaces.*;
import com.lawal.transit.stations.*;
import com.lawal.transit.stations.interfaces.*;

import java.util.*;

public final class AvenueCreator implements Creator {

    public static final int PLACE_NAME_INCREMENT = 2;
    public static final int PLACE_MULTIPLICATION_FACTOR = 1000;
    public static final int STATION_MULTIPLICATION_FACTOR = 100;
    public static final int LEFT_FRONTAGE_STARTING_INDEX = 1;
    public static final int RIGHT_FRONTAGE_STARTING_INDEX = 0;
    private int numberOfLeftFrontageBlocks;
    private int numberOfRightFrontageBlocks;
    private int stationInterval;
    private int placesPerBlock;
    private int avenueId;
    private int placeCursor;
    private int stationCursor;
    String avenueName;
    private RoadIdentifier label;
    private Avenue avenue;
    private ArrayList<RoadSectionTag> blockTags;

    public AvenueCreator () {}

    public AvenueCreator avenueId (int avenueId) {
        this.avenueId = avenueId;
        return this;
    }

    public AvenueCreator avenueName (String avenueName) {
        this.avenueName = avenueName;
        return this;
    }

    public AvenueCreator label (RoadIdentifier label) {
        this.label = label;
        return this;
    }

    public AvenueCreator stationInterval (int stationInterval) {
        this.stationInterval = stationInterval;
        return this;
    }

    public AvenueCreator placesPerBlock (int placesPerBlock) {
        this.placesPerBlock = placesPerBlock;
        return this;
    }

    public AvenueCreator numberOfLeftFrontageBlocks (int numberOfLeftFrontageBlocks) {
        this.numberOfLeftFrontageBlocks = numberOfLeftFrontageBlocks;
        return this;
    }

    public AvenueCreator numberOfRightFrontageBlocks (int numberOfRightFrontageBlocks) {
        this.numberOfRightFrontageBlocks = numberOfRightFrontageBlocks;
        return this;
    }

    public Avenue getProduct () {
        return avenue;
    }

    @Override
    public void create () throws Exception {
        this.label = new RoadLabel.Builder().id(avenueId).name(avenueName).category(RoadCategory.AVENUE).build();
        this.avenue = new Avenue.Builder()
            .label(label)
            .leftCarriageway(new Carriageway(Avenue.LEFTWARD_TRAFFIC_DIRECTION))
            .rightCarriageway(new Carriageway(Avenue.RIGHTWARD_TRAFFIC_DIRECTION))
            .leftFrontage(getLeftFrontage())
            .rightFrontage(getRightFrontage())
            .build();
    }


    private Curbsideable getRightFrontage () throws Exception {
        this.placeCursor = RIGHT_FRONTAGE_STARTING_INDEX;
        this.stationCursor = RIGHT_FRONTAGE_STARTING_INDEX;
        return getFrontage(
            Avenue.RIGHTWARD_TRAFFIC_DIRECTION,
            numberOfRightFrontageBlocks
        );
    }

    private Curbsideable getLeftFrontage () throws Exception {
        this.placeCursor = LEFT_FRONTAGE_STARTING_INDEX;
        this.stationCursor = LEFT_FRONTAGE_STARTING_INDEX;
        return getFrontage(Avenue.LEFTWARD_TRAFFIC_DIRECTION, numberOfLeftFrontageBlocks);
    }

    private Curbsideable getFrontage (
        Orientation trafficDirection,
        int numberOfBlocks
    ) throws Exception {
        Curbsideable frontage = new Frontage.Builder()
            .trafficDirection(trafficDirection)
            .roadLabel(label)
            .blocks(getBlocks(trafficDirection, numberOfBlocks))
            .stations(getStations())
            .build();
        return null;
    }


    private RoadSectionals getBlocks (Orientation trafficDirection, int numberOfBlocks) throws Exception {
        RoadSectionals blocks = new Blocks();
        this.blockTags = new ArrayList<>();
        for (int counter = 0; counter < numberOfBlocks; counter++) {
            RoadSectionTag blockTag = new BlockTag.Builder().id(counter + 1).trafficDirection(trafficDirection).build();
            blocks.addBlock(new Block.Builder().tag(blockTag).places(getPlaces(blockTag)).build());
            blockTags.add(blockTags.size(),blockTag);
        }
        return blocks;
    }

    private Placeables getPlaces (RoadSectionTag blockTag) throws Exception {
        Placeables places = new Places();
        for (int index = 0; index < placesPerBlock; index++) {
            LocationKey key = new Key.Builder()
                .id(IdGenerator.INSTANCE.nextPlaceId())
                .blockTag(blockTag)
                .name(avenueId * PLACE_MULTIPLICATION_FACTOR + placeCursor + "")
                .build();
            places.add(new Place.Builder().key(key).build());
            placeCursor =+ PLACE_NAME_INCREMENT;
        }
        return places;
    }

    private Stationables getStations () throws Exception {
        Stationables stations = new Stations();
        for (RoadSectionTag blockTag : blockTags) {
            if (blockTag.id() % stationInterval != 0) {
                stations.add(getStation(blockTag));
            }
        }
        return stations;
    }

    public Stationable getStation (RoadSectionTag blockTag) {
        LocationKey key = new Key.Builder()
            .id(IdGenerator.INSTANCE.nextStationID())
            .blockTag(blockTag)
            .name("MT-" + avenueId * STATION_MULTIPLICATION_FACTOR + stationCursor)
            .build();
        stationCursor++;
        return new Station.Builder().key(key).incomingEdges(new Edges()).outgoingEdges(new Edges()).build();
    }

//    public void processEdges (Stationables stations) {
//        Iterator<Stationable> iterator = stations.iterator();
//        while (iterator.hasNext()) {
//            Stationable station = iterator.next();
//            Stationable nextStation = stations.next(station.key().id());
//            if (nextStation != null) {
//
//            }
//        }
//    }
}
