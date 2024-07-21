package com.lawal.transit.road;

import com.lawal.transit.*;

import java.util.*;

public interface LaneCollection {

    public void addLane ();
    public int numberOfLanes ();
    public Iterator<Lane> iterator ();
    public Orientation getTrafficDirection ();
    public Lane getLane (int id) throws Exception;
    public void removeLane (int id) throws Exception;

}
