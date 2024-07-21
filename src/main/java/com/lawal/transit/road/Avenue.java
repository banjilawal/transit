package com.lawal.transit.road;

import com.lawal.transit.*;
import com.lawal.transit.buildings.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.graph.*;
import com.lawal.transit.stations.*;


public final class Avenue implements Road {

    public static final Orientation RIGHT_LATERAL_TRAFFIC_DIRECTION = Orientation.WEST;
    public static final Orientation LEFT_LATERAL_TRAFFIC_DIRECTION = Orientation.EAST;
    private final RoadIdentifiable identifier;
    private final LaneCollection leftLanes;
    private final LaneCollection rightLanes;
    private final VertexCollection leftSideStations;
    private final VertexCollection rightSideStations;
    private final AddressableCollection leftSideBuildings;
    private final AddressableCollection rightSideBuildings;

    public Avenue (int id, String name) throws Exception {
        this(id, name, 0, 0);
    }

    public Avenue (int id, String name, int numberOfRightLanes, int numberOfLeftLanes) {
        this.identifier = new RoadIdentifier(id, name, RoadCategory.AVENUE);
        this.rightLanes = new TrafficLanes(RIGHT_LATERAL_TRAFFIC_DIRECTION);
        for (int index = 0; index < numberOfRightLanes; index++) {
            rightLanes.addLane();
        }
        this.leftLanes = new TrafficLanes(LEFT_LATERAL_TRAFFIC_DIRECTION);
        for (int index = 0; index < numberOfLeftLanes; index++) {
            leftLanes.addLane();
        }
        this.leftSideStations = new Stations();
        this.rightSideStations = new Stations();
        this.leftSideBuildings = new Buildings();
        this.rightSideBuildings = new Buildings();
    }

    @Override
    public RoadIdentifiable getIdentifier () {
        return identifier;
    }

    @Override
    public LaneCollection getLeftLanes () {
        return leftLanes;
    }

    @Override
    public LaneCollection getRightLanes () {
        return rightLanes;
    }

    @Override
    public VertexCollection getLeftSideStations () {
        return leftSideStations;
    }

    @Override
    public VertexCollection getRightSideStations () {
        return rightSideStations;
    }

    @Override
    public AddressableCollection getLeftSideBuildings () {
        return leftSideBuildings;
    }

    @Override
    public AddressableCollection getRightSideBuildings () {
        return rightSideBuildings;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Avenue avenue) {
            return identifier.equals(avenue.getIdentifier())
                && rightLanes.numberOfLanes() == avenue.getRightLanes().numberOfLanes()
                && leftLanes.numberOfLanes() == avenue.getLeftLanes().numberOfLanes();
        }
        return false;
    }

    @Override
    public String toString () {
        return identifier.getName() + " " + identifier.getCategory().abbreviation();
    }
}