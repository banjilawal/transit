package com.lawal.transit.road.interfaces;

import com.lawal.transit.road.Avenues;
import com.lawal.transit.junction.Junctions;
import com.lawal.transit.road.Streets;


public interface RoadSystem {

    Avenues getAvenues ();
    Streets getStreets ();
    Junctions getJunctions();
}