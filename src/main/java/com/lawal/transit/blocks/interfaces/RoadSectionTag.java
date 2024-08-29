package com.lawal.transit.blocks.interfaces;

import com.lawal.transit.globals.*;
import com.lawal.transit.roads.interfaces.*;

public interface RoadSectionTag {

    public int id ();
    public RoadIdentifier roadLabel ();
    public Orientation trafficDirection ();
}
