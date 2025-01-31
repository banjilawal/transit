package com.lawal.transit.road.interfaces;

import com.lawal.transit.global.*;

import java.util.*;

public interface Lanes {

    public void addLane ();
    public int numberOfLanes ();
    public Iterator<Lane> iterator ();
    public Direction getTrafficDirection ();
    public Lane getLane (int id) throws Exception;
    public void removeLane (int id) throws Exception;
}