package com.lawal.transit.blocks.interfaces;

import com.lawal.transit.places.interfaces.*;
import com.lawal.transit.roads.interfaces.Road;

import java.util.*;

public interface RoadSectionals {

    int size ();
    ArrayList<RoadSectional> getList ();
    Iterator<RoadSectional> iterator ();
    void addBlock (RoadSectional block) throws Exception;
    RoadSectional findBlock (int blockId);
    RoadSectional nextBlock (int currentBlockId);
    RoadSectional previousBlock (int currentBlockId);
    Placeable findPlace (int placeId);
    Placeable findPlace (String placeName);
    void addPlace (Placeable placeable) throws Exception;
    void removePlace (int placeId) throws  Exception;
}