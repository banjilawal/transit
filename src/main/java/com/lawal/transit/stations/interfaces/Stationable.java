package com.lawal.transit.stations.interfaces;

import com.lawal.transit.edges.interfaces.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.roads.interfaces.*;

public interface Stationable {

    LocationKey key ();
    Edgeables outgoingEdges ();
    Edgeables incomingEdges ();
    Orientation trafficDirection ();
    Stationable crossStation (Road crossRoad);
}
