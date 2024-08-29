package com.lawal.transit.branches.interfaces;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.roads.interfaces.*;

public interface Branchable {
    int id ();
    RoadSectionTag blockTag ();
    RoadIdentifier roadLabel ();
}
