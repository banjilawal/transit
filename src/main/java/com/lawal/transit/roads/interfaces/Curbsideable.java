package com.lawal.transit.roads.interfaces;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.stations.Stations;

public interface Curbsideable {

    CurbsideMarking marker ();
    RoadSectionals blocks ();
    Stations stations ();
}