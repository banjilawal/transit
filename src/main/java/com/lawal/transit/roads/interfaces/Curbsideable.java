package com.lawal.transit.roads.interfaces;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.stations.interfaces.*;

public interface Curbsideable {

    CurbsideMarker key();
    RoadSectionals blocks ();
    Stationables stations ();
}