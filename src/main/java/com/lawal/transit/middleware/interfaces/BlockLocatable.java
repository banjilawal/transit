package com.lawal.transit.middleware.interfaces;

import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.enums.Direction;

public interface BlockLocatable {
    void setBlockSide (Direction blockSide);
    void setBlockId (int blockId);
    void setBlockRoad(Road road);
    Direction getBlockSide();
    Road getBlockRoad();
    int getBlockId ();
} // end interface BlockLocatable
