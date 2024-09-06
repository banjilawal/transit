package com.lawal.transit.addressing;

import com.lawal.transit.blocks.interfaces.*;

public interface LocationKey {

    int id ();
    String name();
    RoadSectionTag blockTag ();
}