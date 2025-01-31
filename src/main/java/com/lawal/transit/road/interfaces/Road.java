package com.lawal.transit.road.interfaces;


import com.lawal.transit.global.Direction;

public interface Road {

    RoadIdentifier label ();
    Lanes leftCarriageway ();
    Lanes rightCarriageway ();
    Curbsideable leftCurb ();
    Curbsideable rightCurb ();
    Lanes getCarriageway (Direction travelDirection);
    Curbsideable getCurb(Direction travelDirection);
}