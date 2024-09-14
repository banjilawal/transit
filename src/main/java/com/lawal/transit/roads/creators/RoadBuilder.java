package com.lawal.transit.roads.creators;

import com.lawal.transit.globals.Constant;
import com.lawal.transit.globals.Direction;
import com.lawal.transit.roads.*;
import com.lawal.transit.roads.interfaces.Curbsideable;
import com.lawal.transit.roads.interfaces.Road;
import com.lawal.transit.roads.interfaces.RoadIdentifier;


public class RoadBuilder {

    private int roadId;
    private String roadName;
    private int numberOfBlocks;
    private int placesPerBlock;
    private int placeNameInterval;

    private RoadIdentifier roadLabel;
    private RoadCategory roadCategory;
    private CurbsideCreator curbsideCreator;

    public RoadBuilder () {}

    public int getRoadId () {
        return roadId;
    }

    public String getRoadName () {
        return roadName;
    }

    public int getNumberOfBlocks () {
        return numberOfBlocks;
    }

    public int getPlacesPerBlock () {
        return placesPerBlock;
    }

    public int getPlaceNameInterval () {
        return placeNameInterval;
    }

    public RoadCategory getRoadCategory () {
        return roadCategory;
    }

    public RoadBuilder roadId(int roadId) {
        this.roadId = roadId;
        return this;
    }

    public RoadBuilder roadName(String roadName) {
        this.roadName = roadName;
        return this;
    }

    public RoadBuilder numberOfBlocks (int numberOfBlocks) {
        this.numberOfBlocks = numberOfBlocks;
        return this;
    }

    public RoadBuilder placesPerBlock(int placesPerBlock) {
        this.placesPerBlock = placesPerBlock;
        return this;
    }

    public RoadBuilder placeNameInterval (int placeNameInterval) {
        this.placeNameInterval = placeNameInterval;
        return this;
    }

    public RoadBuilder roadCategory(RoadCategory roadCategory) {
        this.roadCategory = roadCategory;
        return this;
    }

    public Road getProduct () throws Exception {
        this.roadLabel = new RoadLabel(roadId, roadName, roadCategory);
        curbsideCreator = new CurbsideCreator()
            .placeNameInterval(placeNameInterval)
            .numberOfBlocks(numberOfBlocks)
            .placesPerBlock(placesPerBlock)
            .roadLabel(roadLabel);
        switch (roadCategory) {
            case AVENUE:
                return buildAvenue();
            case STREET:
                return buildStreet();
            default:
                System.out.println("Unknown road category");
                break;
        }
        return null;
    }

    private Avenue buildAvenue () throws Exception {
        return new Avenue.Builder()
            .leftCarriageway(new Carriageway(Avenue.LEFTWARD_TRAFFIC_DIRECTION))
            .rightCarriageway(new Carriageway(Avenue.RIGHTWARD_TRAFFIC_DIRECTION))
            .leftCurb(getCurbside(Avenue.LEFTWARD_TRAFFIC_DIRECTION, roadId * Constant.MULTIPLICATION_FACTOR + 1))
            .rightCurb(getCurbside(Avenue.RIGHTWARD_TRAFFIC_DIRECTION, roadId * Constant.MULTIPLICATION_FACTOR))
            .label(roadLabel)
            .build();
    }

    private Street buildStreet () throws Exception {
        return new Street.Builder()
            .leftCarriageway(new Carriageway(Avenue.LEFTWARD_TRAFFIC_DIRECTION))
            .rightCarriageway(new Carriageway(Avenue.RIGHTWARD_TRAFFIC_DIRECTION))
            .leftCurb(getCurbside(Street.LEFTWARD_TRAFFIC_DIRECTION, roadId * Constant.MULTIPLICATION_FACTOR + 1))
            .rightCurb(getCurbside(Street.RIGHTWARD_TRAFFIC_DIRECTION, roadId * Constant.MULTIPLICATION_FACTOR))
            .label(roadLabel)
            .build();
    }

    private Curbsideable getCurbside (Direction trafficDirection, int startingPlaceName) throws Exception {
            return curbsideCreator.trafficDirection(trafficDirection)
                .startingPlaceName(startingPlaceName).getProduct();
    }
}