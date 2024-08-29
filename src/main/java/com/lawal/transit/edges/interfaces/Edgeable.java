package com.lawal.transit.edges.interfaces;

import com.lawal.transit.stations.interfaces.*;

public interface Edgeable {

    Stationable head ();
    Stationable tail ();
    EdgeProperties properties ();
}
