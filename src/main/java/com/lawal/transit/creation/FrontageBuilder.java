package com.lawal.transit.creation;

public class FrontageBuilder {
//
//    public static final int INCREMENT = 2;
//    public static final int BUILDING_NUMBER_MULTIPLICATION_FACTOR = 1000;
//    public static final int STATION_NUMBER_MULTIPLICATION_FACTOR = 100;
//
//    private int startingIndex;
//    private int currentIndex;
//    private int numberOfBlocks;
//    private int stationInterval;
//    private int currentBlockId;
//    private int buildingsPerBlock;
//    private Orientation trafficDirection;
//    private RoadIdentifier roadLabel;
//    private RoadSectionals blocks;
//    private Stationables stations;
//
//    public FrontageBuilder () {}
//
//    public FrontageBuilder roadLabel (RoadIdentifier roadLabel) {
//        this.roadLabel = roadLabel;
//        return this;
//    }
//
//    public FrontageBuilder startingIndex (int startingIndex) {
//        this.startingIndex = startingIndex;
//        this.currentIndex = startingIndex;
//        return this;
//    }
//
//    public FrontageBuilder numberOfBlocks (int numberOfBlocks) {
//        this.numberOfBlocks = numberOfBlocks;
//        return this;
//    }
//
//    public FrontageBuilder buildingsPerBlock (int buildingsPerBlock) {
//        this.buildingsPerBlock = buildingsPerBlock;
//        return this;
//    }
//
//    public FrontageBuilder stationInterval (int stationInterval) {
//        this.stationInterval = stationInterval;
//        return this;
//    }
//
//    public FrontageBuilder trafficDirection (Orientation trafficDirection) {
//        this.trafficDirection = trafficDirection;
//        return this;
//    }
//
//    public FrontageBuilder blocks () throws Exception {
//        this.blocks = new Blocks();
//        for (currentBlockId = 0; currentBlockId < numberOfBlocks; currentBlockId++) {
//            blocks.addBlock();
//            populateBlock(blocks);
//        }
//        return this;
//    }
//
//    public FrontageBuilder stations () throws Exception {
//        this.stations = new Stations();
//        int stationNumber = startingIndex;
//        for (int blockId = 0; blockId < numberOfBlocks; blockId++) {
//            if (blockId % stationInterval == 0) {
//                FormattedAddress address = new AddressBuilder()
//                    .id(IdGenerator.INSTANCE.nextStationID())
//                    .blockId(blockId)
//                    .name("MT" + roadLabel.id() * STATION_NUMBER_MULTIPLICATION_FACTOR + stationNumber)
//                    .roadIdentity(roadLabel)
//                    .orientation(trafficDirection)
//                    .build();
//                stations.add(new Station(address));
//                stationNumber += INCREMENT;
//            }
//        }
//        addEdges();
//        return this;
//    }
//
//    private void populateBlock (RoadSectionals blocks) throws Exception {
//        for (int cursorValue = 0; cursorValue < buildingsPerBlock * INCREMENT; cursorValue += INCREMENT) {
//            addBlockBuilding(blocks, currentIndex);
//            currentIndex += cursorValue;
//        }
//    }
//
//    private void addBlockBuilding (RoadSectionals blocks, int currentIndex) throws Exception {
//        FormattedAddress address = new AddressBuilder()
//            .blockId(currentBlockId)
//            .id(IdGenerator.INSTANCE.nextPlaceId())
//            .name(currentIndex + roadLabel.id() * BUILDING_NUMBER_MULTIPLICATION_FACTOR + "" )
//            .roadIdentity(roadLabel)
//            .orientation(trafficDirection)
//            .build();
//        blocks.(new Place(address));
//    }
//
//    private void addEdges () throws Exception {
//        int startingArrayIndex = 1;
//        for (int index = 1; index < stations.size(); index++) {
//            Stationable previous = stations.getByIndex(index - 1);
//            Stationable current = stations.getByIndex(index);
//            Edge edge = new Edge(previous, current, roadLabel, new Weight(current.getAddress().blockId() - previous.getAddress().blockId()));
//            previous.getOutgoingEdges().add(edge);
//            current.getIncomingEdges().add(edge);
//        }
//    }
//
//    public RoadSectional build () {
//        return new Frontage(trafficDirection, blocks, stations);
//    }
}
