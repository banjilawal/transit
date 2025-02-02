package com.lawal.transit.road;

import com.lawal.transit.global.*;
import lombok.Getter;

import java.util.*;

@Getter
public class Lanes {
    public static final String LANE_DOES_NOT_EXISTS_EXCEPTION = "There is no lane with that specified id";
    private static final String BORDER_LANE_REMOVAL_EXCEPTION = "TRemoving the border lane is not allowed.";
    public static final String LANE_DOES_NOT_EXIST_ERROR = "The item does not exist in the list so it cannot be removed";

    private final List<Lane> lanes;
    private final Direction trafficDirection;

    public Lanes (Direction trafficDirection) {
        this.lanes = new ArrayList<>();
        this.trafficDirection = trafficDirection;
        this.lanes.add(new Lane(1, trafficDirection));
    }

    public void addLane () {
        lanes.add(lanes.size(), new Lane(lanes.size(), trafficDirection));
    }


    public int numberOfLanes () {
        return lanes.size();
    }


    public Iterator<Lane> iterator () {
        return lanes.iterator();
    }

    public Lane getLane (int id) throws Exception {
        if (id >= lanes.size()) {
            throw new Exception(LANE_DOES_NOT_EXIST_ERROR);
        }
        return lanes.get(id);
    }

    public void removeLane (int id) throws Exception {
        if (id == 0)
            throw new Exception(BORDER_LANE_REMOVAL_EXCEPTION);
        lanes.remove(id);
    }

    @Override
    public String toString () {
        StringBuilder string = new StringBuilder("Lanes:\n");
        for(Lane lane : lanes) {
            string.append(lane.toString()).append("\n");
        }
        return string.toString();
    }
}