package com.lawal.transit.stations.interfaces;

import com.lawal.transit.addressing.LocationKey;
import com.lawal.transit.edges.interfaces.*;

public interface Stationable {

    LocationKey key();
    Edgeables outgoingEdges();
    Edgeables incomingEdges();
}