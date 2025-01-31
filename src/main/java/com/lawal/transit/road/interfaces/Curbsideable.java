package com.lawal.transit.road.interfaces;

import com.lawal.transit.block.interfaces.*;
import com.lawal.transit.station.Stations;

public interface Curbsideable {

    CurbsideMarking marker ();
    RoadSegments blocks ();
    Stations stations ();
}