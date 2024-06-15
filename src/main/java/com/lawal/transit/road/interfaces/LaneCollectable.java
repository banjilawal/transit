package com.lawal.transit.road.interfaces;

public interface LaneCollectable {

    public int numberOfLanes ();
    public Lane getLeftmostLane () throws Exception;
    public Lane getRightmostLane () throws Exception;
    public void add ();
    public void remove (int id) throws Exception;



}
