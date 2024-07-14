package com.lawal.transit.road.interfaces;


import com.lawal.transit.*;

public interface Road {

    public RoadIdentifiable getIdentifier ();
    public LaneCollection getRightLanes ();
    public LaneCollection getLeftLanes ();
    public Orientation getRightLaneTrafficeDirection ();
    public Orientation getLeftLaneTrafficDirection ();
} // end interface Road