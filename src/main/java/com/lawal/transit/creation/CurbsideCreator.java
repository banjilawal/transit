package com.lawal.transit.creation;

import com.lawal.transit.addressing.Key;
import com.lawal.transit.addressing.LocationKey;
import com.lawal.transit.blocks.BlockTag;
import com.lawal.transit.blocks.Blocks;
import com.lawal.transit.blocks.interfaces.RoadSectionTag;
import com.lawal.transit.blocks.interfaces.RoadSectionals;
import com.lawal.transit.edges.Edges;
import com.lawal.transit.globals.IdGenerator;
import com.lawal.transit.roads.Curbside;
import com.lawal.transit.roads.interfaces.CurbsideMarker;
import com.lawal.transit.roads.interfaces.Curbsideable;
import com.lawal.transit.stations.Station;
import com.lawal.transit.stations.Stations;
import com.lawal.transit.stations.interfaces.Stationables;

public class CurbsideCreator {

    private final CurbsideMarker marker;
    private final int totalBlocks;
    private final int blockSize;
    private final int startingPlaceName;
    private int startingStationName;
    private int currentPlaceName;
    private int currentStationName;
    private final int addressInterval;
    private int stationInterval;
    private Stationables stations;

    private CurbsideCreator(Builder builder) {
        this.marker = builder.marker;
        this.totalBlocks = builder.totalBlocks;
        this.blockSize = builder.blockSize;
        this.startingPlaceName = builder.startingPlaceName;
        this.startingStationName = builder.startingStationName;
        currentPlaceName = startingPlaceName;
        currentStationName = startingStationName;
        this.addressInterval = builder.addressInterval;
        this.stationInterval = builder.stationInterval;

        System.out.println("currentStationName:" + currentStationName + " startingPlaceName:" + startingPlaceName);
        System.out.println("The station interval is " + stationInterval + "\nbuilder\'s station interval:" + builder.stationInterval);
        this.stations = new Stations();
        if (stationInterval < 1)
            stationInterval = 1;
    }

    public CurbsideMarker getMarker() {
        return marker;
    }

    public int getTotalBlocks() {
        return totalBlocks;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public int getAddressInterval() {
        return addressInterval;
    }

    public int getStartingPlaceName() {
        return startingPlaceName;
    }

    public int getCurrentPlaceName() {
        return currentPlaceName;
    }

    public  int getStartingStationName () {
        return startingStationName;
    }

    public int getCurrentStationName() {
        return currentStationName;
    }

    public int getStationInterval() {
        return stationInterval;
    }

    public Curbsideable create () throws Exception {
        return new Curbside.Builder().key(marker).blocks(createBlocks()).stations(stations).build();
    }

    public RoadSectionals createBlocks () throws Exception {
        RoadSectionals blocks = new Blocks();
        for (int i = 0; i < totalBlocks; i++) {
            RoadSectionTag blockTag = new BlockTag.Builder().id(i + 1).curbsideMarker(marker).build();
            BlockCreator blockCreator = new BlockCreator.Builder()
                .size(blockSize)
                .blockTag(blockTag)
                .addressInterval(addressInterval)
                .startingAddressNumber(currentPlaceName)
                .build();
            blocks.addBlock(blockCreator.createBlock());
            currentPlaceName = blockCreator.getEndingAddressNumber();
            if (blockTag.id() % stationInterval == 0) {
                LocationKey stationKey = new Key.Builder()
                    .id(IdGenerator.INSTANCE.nextStationID())
                    .name("MT-" + currentStationName)
                    .blockTag(blockTag)
                    .build();
                stations.add(new Station.Builder().key(stationKey).incomingEdges(new Edges()).outgoingEdges(new Edges()).build());
//                System.out.println("block id:" + blockTag.id() + " remainder:" + remainder);
//                addStation(blockTag, currentStationName);
                currentStationName++;
            }
        }
        return blocks;
    }

//    public void addStation (RoadSectionTag blockTag, int currentStationName) throws Exception {
//        System.out.println("starting station name: " + startingStationName);
//        System.out.println("current station name: " + currentStationName);
//        LocationKey key = new Key.Builder()
//            .id(IdGenerator.INSTANCE.nextStationID())
//            .name("MT-" + currentStationName)
//            .blockTag(blockTag).build();
//        Stationable station = new Station.Builder().key(key).incomingEdges(new Edges()).outgoingEdges(new Edges()).build();
//        System.out.println("station:" + station.toString());
//        stations.add(station);
//        currentPlaceName = currentStationName + 1;
//    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {

        private CurbsideMarker marker;
        private int totalBlocks;
        private int blockSize;
        private int startingPlaceName;
        private int startingStationName;
        private int currentPlaceName;
        private int currentStationName;
        private int addressInterval;
        private int stationInterval;

        public Builder marker (CurbsideMarker marker) {
            this.marker = marker;
            return this;
        }

        public Builder totalBlocks (int totalBlocks) {
            this.totalBlocks = totalBlocks;
            return this;
        }

        public Builder blockSize (int blockSize) {
            this.blockSize = blockSize;
            return this;
        }

        public Builder addressInterval (int addressInterval) {
            this.addressInterval = addressInterval;
            return this;
        }

        public Builder startingPlaceName (int startingPlaceName) {
            this.startingPlaceName = startingPlaceName;
            return this;
        }

        public Builder currentPlaceName (int currentPlaceName) {
            this.currentPlaceName = currentPlaceName;
            return this;
        }

        public Builder stationInterval (int stationInterval) {
            this.stationInterval = stationInterval;
            return this;
        }

        public Builder startingStationName (int startingStationName) {
            this.startingStationName = startingStationName;
            return this;
        }

        public Builder currentStationName (int currentStationName) {
            this.currentStationName = currentStationName;
            return this;
        }

        public CurbsideCreator build () {
            return new CurbsideCreator(this);
        }
    }
}