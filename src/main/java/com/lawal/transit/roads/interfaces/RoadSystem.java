package com.lawal.transit.roads.interfaces;

import com.lawal.transit.catalogs.Avenues;
import com.lawal.transit.catalogs.Junctions;
import com.lawal.transit.catalogs.Streets;
import com.lawal.transit.junctions.Intersectionals;
import com.lawal.transit.roads.Avenue;
import com.lawal.transit.roads.Street;

import java.util.ArrayList;

public interface RoadSystem {

    Avenues getAvenues ();
    Streets getStreets ();
    Junctions getJunctions();
}
