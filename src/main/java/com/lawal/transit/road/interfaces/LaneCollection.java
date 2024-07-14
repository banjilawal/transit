package com.lawal.transit.road.interfaces;

import com.lawal.transit.*;

public interface LaneCollection {

    public int numberOfLanes ();
    public Orientation getTrafficDirection ();
    public Lane getZerothLane () throws Exception;
    public Lane getLastLane () throws Exception;
    public void remove (int laneNumber) throws Exception;
    public void add () throws Exception;

    public void addLanes (int numberOfLanes) throws Exception;
}
