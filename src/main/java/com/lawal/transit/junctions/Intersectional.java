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


//    int size ();
//    Iterator<Branchable> iterator ();
//    void add (Branchable branchable) throws Exception;
//    void remove (int branchId) throws Exception;
//    Branchable search (int branchId);
//    Branchable next (int currentBranchId);
//    Branchable previous (int currentBranchId);
}