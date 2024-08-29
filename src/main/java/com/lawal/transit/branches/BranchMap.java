package com.lawal.transit.branches;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.branches.interfaces.*;
import com.lawal.transit.roads.interfaces.*;

import java.util.*;

public class BranchMap implements Branchable  {
    private int id;
    private HashMap<RoadIdentifier, ArrayList<RoadSectionTag>> mapping;

    @Override
    public int id () {
        return 0;
    }

    @Override
    public RoadSectionTag blockTag () {
        return null;
    }

    @Override
    public RoadIdentifier roadLabel () {
        return mapping.g;
    }
}
