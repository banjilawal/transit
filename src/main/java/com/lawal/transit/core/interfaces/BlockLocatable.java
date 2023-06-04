package com.lawal.transit.core.interfaces;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.enums.Direction;

public interface BlockLocatable {
    void setBlockSide (Direction blockSide);
    void setBlockId (int blockId);
    void setBlockRoad(Road road);
    Direction getBlockSide();
    Road getBlockRoad();
    int getBlockId ();
} // end interface BlockLocatable
