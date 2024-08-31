package com.lawal.transit.edges.interfaces;

import com.lawal.transit.edges.*;

public interface EdgeProperties {
    int id ();
    //    RoadIdentifier roadLabel ();
//    RoadSectionTag blockTag ();
    Weightable weight ();
    EdgeCategory category ();
}
