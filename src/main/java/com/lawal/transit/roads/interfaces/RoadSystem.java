package com.lawal.transit.roads.interfaces;

import com.lawal.transit.roads.Avenues;
import com.lawal.transit.junctions.Junctions;
import com.lawal.transit.roads.Streets;


public interface RoadSystem {

    Avenues getAvenues ();
    Streets getStreets ();
    Junctions getJunctions();
}