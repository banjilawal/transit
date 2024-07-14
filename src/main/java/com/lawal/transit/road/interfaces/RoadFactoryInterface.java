package com.lawal.transit.road.interfaces;

import com.lawal.transit.road.*;

public interface RoadFactoryInterface {

    public int getId();
    public String getName ();
    public Avenue getAvenue ();
    public Street getStreet ();
    public int getNumberOfRightLanes ();
    public int getNumberOfLeftLanes ();
    public RoadCategory getCategory ();
}
