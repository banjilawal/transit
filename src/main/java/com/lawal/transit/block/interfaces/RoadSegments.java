package com.lawal.transit.block.interfaces;

import com.lawal.transit.places.interfaces.*;

import java.util.*;

public interface RoadSegments {

    int size ();
    ArrayList<RoadSegment> getList ();
    Iterator<RoadSegment> iterator ();
    void addBlock (RoadSegment block) throws Exception;
    RoadSegment findBlock (int blockId);
    RoadSegment nextBlock (int currentBlockId);
    RoadSegment previousBlock (int currentBlockId);
    Placeable findPlaceById (int placeId);
    Placeable findPlaceByName (String placeName);
    void addPlace (Placeable placeable) throws Exception;
    void removePlace (int placeId) throws  Exception;
}