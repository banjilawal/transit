package com.lawal.transit.road;


import com.lawal.transit.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.graph.*;

public interface Road {

    public RoadIdentifiable getIdentifier ();
    public LaneCollection getLeftLanes ();
    public LaneCollection getRightLanes ();
    public VertexCollection getLeftSideStations ();
    public VertexCollection getRightSideStations ();
    public AddressableCollection getLeftSideBuildings ();
    public AddressableCollection getRightSideBuildings ();


}