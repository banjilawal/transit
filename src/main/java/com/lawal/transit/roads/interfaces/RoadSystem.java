package com.lawal.transit.roads.interfaces;

import com.lawal.transit.catalogs.Avenues;
import com.lawal.transit.catalogs.Junctions;
import com.lawal.transit.catalogs.Streets;


public interface RoadSystem {

    Avenues getAvenues ();
    Streets getStreets ();
    Junctions getJunctions();
}