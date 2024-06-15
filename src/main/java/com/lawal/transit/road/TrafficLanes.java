package com.lawal.transit.road;

import com.lawal.transit.*;
import com.lawal.transit.addresses.*;
import com.lawal.transit.addresses.interfaces.*;
import com.lawal.transit.locations.*;
import com.lawal.transit.road.interfaces.*;

import java.util.*;

public class TrafficLanes implements LaneCollectable {

    public static final String ADDITION_ERROR = "A lane with that id already exists";
    private static final String LANE_WITH_LOCATIONS = "Cannot remove a lane with stations and addresses";
    public static final String EMPTY_LIST_REMOVAL_FAILURE = "Cannot remove items from an empty list";
    public static final String LANE_DOES_NOT_EXIST_ERROR = "The item does not exist in the list so it cannot be removed";
    private final ArrayList<TrafficLane> lanes;

    public TrafficLanes () {
        this.lanes = new ArrayList<>();
    }

    @Override
    public int numberOfLanes () {
        return lanes.size();
    }

    @Override
    public Lane getLeftmostLane () throws Exception {
        if (lanes.isEmpty())
            throw new ArrayIndexOutOfBoundsException("There are no lanes in the list");
        return lanes.get(0);
    }

    @Override
    public Lane getRightmostLane () throws Exception {
        if (lanes.isEmpty())
            throw new ArrayIndexOutOfBoundsException("There are no lanes in the list");
        return lanes.get(lanes.size() - 1);
    }

    public Iterator<TrafficLane> iterator () { return lanes.iterator(); }

    public void add () {
        int index = lanes.size() - 1;
        Orientation trafficDirection = lanes.get(index).getTrafficDirection();
        AddressCollection<LocationAddressable> addresses = lanes.get(index).getAddresses();
        Stations stations = lanes.get(index).getStations();
        lanes.remove(index);
        lanes.add(lanes.size(), new TrafficLane(index, trafficDirection, null, null));
        lanes.add(lanes.size(),new TrafficLane((index + 1),trafficDirection , addresses,stations ));
    }

    @Override
    public void remove (int index) throws Exception {
        if (lanes.isEmpty())
            throw new ArrayIndexOutOfBoundsException(EMPTY_LIST_REMOVAL_FAILURE);
        if (index < 0 || index > lanes.size() - 1)
            throw new ArrayIndexOutOfBoundsException(LANE_DOES_NOT_EXIST_ERROR);
        removalHelper(index);
    }



    private void removalHelper (int index) throws Exception {
        if (index == 0 || index == lanes.size() -1)
            throw new Exception(LANE_WITH_LOCATIONS);
        lanes.remove(index);
    }
}
