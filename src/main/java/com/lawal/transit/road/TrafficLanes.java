package com.lawal.transit.road;

import com.lawal.transit.*;

import java.util.*;


public class TrafficLanes implements LaneCollection {

    public static final String LANE_DOES_NOT_EXISTS_EXCEPTION = "There is no lane with that specified id";
    private static final String BORDER_LANE_REMOVAL_EXCEPTION = "TRemoving the border lane is not allowed.";
    public static final String LANE_DOES_NOT_EXIST_ERROR = "The item does not exist in the list so it cannot be removed";

    private final List<Lane> lanes;
    private final Orientation trafficDirection;


    public TrafficLanes (Orientation trafficDirection) {
        this.lanes = new ArrayList<>();
        this.trafficDirection = trafficDirection;
        this.lanes.add(new TrafficLane(0, trafficDirection));
    }

    @Override
    public void addLane () {
        lanes.add(lanes.size(), new TrafficLane(lanes.size() - 1, trafficDirection));
    }

    @Override
    public int numberOfLanes () {
        return lanes.size();
    }

    @Override
    public Iterator<Lane> iterator () {
        return lanes.iterator();
    }

    @Override
    public Orientation getTrafficDirection () {
        return trafficDirection;
    }

    @Override
    public Lane getLane (int id) throws Exception {
        if (id >= lanes.size()) {
            throw new Exception(LANE_DOES_NOT_EXIST_ERROR);
        }
        return lanes.get(id);
    }

    @Override
    public void removeLane (int id) throws Exception {
        if (id == 0)
            throw new Exception(BORDER_LANE_REMOVAL_EXCEPTION);
        lanes.remove(id);
    }
//
//    @Override
//    public Lane getBorderLane () throws {
//        return lanes.get(0);
//    }
//
//    @Override
//    public void addLane (Lane lane) throws Exception {
//        if (lane instanceof BorderLane)
//    }
//
//    @Override
//    public Lane getLane () throws Exception {
//        if (lanes.isEmpty())
//            throw new ArrayIndexOutOfBoundsException("There are no lanes in the list");
//        return lanes.get(lanes.size() - 1);
//    }
//
//    @Override
//    public void add () throws Exception {
//        int laneId = lanes.size();
//        lanes.add(lanes.size(), new TrafficLane(trafficDirection, laneId));
//    }
//
//    @Override
//    public void removeLane (int laneNumber) throws Exception {
//        if (lanes.isEmpty())
//            throw new Exception(EMPTY_LIST_REMOVAL_FAILURE);
//        if (lanes.get(laneNumber) == null)
//            throw new Exception(LANE_DOES_NOT_EXIST_ERROR);
//        if (laneNumber == 0)
//            throw new Exception(ILLEGAL_ZEROTH_LANE_REMOVAL_ATTEMPT);
//        lanes.remove(laneNumber);
//    }
//
//    @Override
//    public Lane getLane (int laneNumber) throws Exception {
//        return null;
//    }
//
//    @Override
//    public void addLanes (int numberOfLanes) throws Exception {
//        for (int index = 0; index < numberOfLanes; index++) {
//            add();
//        }
//    }
}
