package com.lawal.transit.graph;

import com.lawal.transit.graph.interfaces.Weightable;
import com.lawal.transit.roads.interfaces.RoadIdentifier;

public interface EdgeDescriptable {
    int id ();
    Weightable weight ();
    EdgeCategory category ();
    RoadIdentifier roadLabel ();
}