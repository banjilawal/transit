package com.lawal.transit.roads.interfaces;

import com.lawal.transit.globals.*;

import java.util.*;

public interface Lanes {

    public void addLane ();
    public int numberOfLanes ();
    public Iterator<Lane> iterator ();
    public Orientation getTrafficDirection ();
    public Lane getLane (int id) throws Exception;
    public void removeLane (int id) throws Exception;
}