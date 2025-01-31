package com.lawal.transit.junction;

import com.lawal.transit.block.interfaces.*;
import com.lawal.transit.road.*;

public interface JunctionEntity {

    int id ();
    Avenue avenue ();
    Street street ();
    RoadSegment northBranch ();
    RoadSegment eastBranch ();
    RoadSegment southBranch ();
    RoadSegment westBranch ();
    RoadSegment turnNorthEastBranch ();
    RoadSegment turnSouthEastBranch ();
    RoadSegment turnSouthWestBranch ();
    RoadSegment turnNorthWestBranch ();
}