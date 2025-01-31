package com.lawal.transit.block.interfaces;

import com.lawal.transit.block.BlockTag;
import com.lawal.transit.places.interfaces.*;
import com.lawal.transit.station.Station;

public interface RoadSegment {

    BlockTag getTag ();
    Placeables getPlaces ();
    Station getStation ();
    void setStation (Station station);
}