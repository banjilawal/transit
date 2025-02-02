package com.lawal.transit.road.contract;


import com.lawal.transit.global.Direction;
import com.lawal.transit.road.Curb;
import com.lawal.transit.road.Lanes;
import com.lawal.transit.road.RoadLabel;

public interface Road {

    RoadLabel label ();
    Lanes leftLanes ();
    Lanes righLanes ();
    Curb leftCurb ();
    Curb rightCurb ();
    Lanes getLanesByDirection (Direction travelDirection);
    Curb getCurbByOrientation (Direction curbOrientation);
}