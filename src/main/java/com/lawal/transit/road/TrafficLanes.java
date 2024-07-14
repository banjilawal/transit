package com.lawal.transit.road;

import com.lawal.transit.*;
import com.lawal.transit.road.interfaces.*;

import java.util.*;

public class TrafficLanes implements LaneCollection {

    private final Orientation trafficDirection;
    public static final String ADDITION_ERROR = "A lane with that id already exists";
    public static final String EMPTY_LIST_REMOVAL_FAILURE = "Cannot remove items from an empty list";
    private static final String ILLEGAL_ZEROTH_LANE_REMOVAL_ATTEMPT = "The zeroth lane borders stations and addresses it cannot be removed";
    public static final String LANE_DOES_NOT_EXIST_ERROR = "The item does not exist in the list so it cannot be removed";
    private final List<Lane> lanes;

    public TrafficLanes (Orientation trafficDirection) {
        this.trafficDirection = trafficDirection;
        this.lanes = new ArrayList<>();
    }

    @Override
    public Orientation getTrafficDirection () {
        return trafficDirection;
    }

    @Override
    public int numberOfLanes () {
        return lanes.size();
    }

    @Override
    public Lane getZerothLane () throws Exception {
        if (lanes.isEmpty())
            throw new ArrayIndexOutOfBoundsException("There are no lanes in the list");
        return lanes.get(0);
    }

    @Override
    public Lane getLastLane () throws Exception {
        if (lanes.isEmpty())
            throw new ArrayIndexOutOfBoundsException("There are no lanes in the list");
        return lanes.get(lanes.size() - 1);
    }

    @Override
    public void add () throws Exception {
        int laneId = lanes.size();
        lanes.add(lanes.size(), new TrafficLane(trafficDirection, laneId));
    }

    @Override
    public void remove (int laneNumber) throws Exception {
        if (lanes.isEmpty())
            throw new Exception(EMPTY_LIST_REMOVAL_FAILURE);
        if (lanes.get(laneNumber) == null)
            throw new Exception(LANE_DOES_NOT_EXIST_ERROR);
        if (laneNumber == 0)
            throw new Exception(ILLEGAL_ZEROTH_LANE_REMOVAL_ATTEMPT);
        lanes.remove(laneNumber);
    }

    @Override
    public void addLanes (int numberOfLanes) throws Exception {
        for (int index = 0; index < numberOfLanes; index++) {
            add();
        }
    }
}
