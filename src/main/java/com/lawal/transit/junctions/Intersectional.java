package com.lawal.transit.junctions;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.roads.*;

public interface Intersectional {

    int id ();
    Avenue avenue ();
    Street street ();
    RoadSectional northBranch ();
    RoadSectional eastBranch ();
    RoadSectional southBranch ();
    RoadSectional westBranch ();
    RoadSectional turnNorthEastBranch ();
    RoadSectional turnSouthEastBranch ();
    RoadSectional turnSouthWestBranch ();
    RoadSectional turnNorthWestBranch ();
}