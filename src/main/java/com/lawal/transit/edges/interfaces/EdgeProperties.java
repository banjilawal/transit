package com.lawal.transit.edges.interfaces;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.edges.*;
import com.lawal.transit.graph.*;
import com.lawal.transit.roads.interfaces.*;

public interface EdgeProperties {
    int id ();
    //    RoadIdentifier roadLabel ();
//    RoadSectionTag blockTag ();
    Weightable weight ();
    EdgeCategory category ();
}
