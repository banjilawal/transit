package com.lawal.transit.roadEntity.contract;


import com.lawal.transit.global.Direction;
import com.lawal.transit.roadEntity.OldCurb;
import com.lawal.transit.roadEntity.Lanes;

public interface RoadEntity {

    int getId();
    String getName();
    Lanes leftLanes();
    Lanes righLanes();
    OldCurb leftCurb();
    OldCurb rightCurb();
    Lanes getLanesByDirection(Direction travelDirection);
    OldCurb getCurbByOrientation(Direction curbOrientation);
}