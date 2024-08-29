package com.lawal.transit.roads.interfaces;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.stations.interfaces.*;

public interface Curbsideable {

    RoadIdentifier roadLabel ();
    RoadSectionals blocks ();
    Stationables stations ();
    Orientation trafficDirection ();
}
