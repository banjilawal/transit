package com.lawal.transit.addressing;

import com.lawal.transit.blocks.interfaces.*;

public interface Addressable {

    int id ();
    String name();
    RoadSectionTag blockTag ();
}