package com.lawal.transit.roads.interfaces;


import com.lawal.transit.globals.Direction;

public interface Road {

    RoadIdentifier label ();
    Lanes leftCarriageway ();
    Lanes rightCarriageway ();
    Curbsideable leftCurb ();
    Curbsideable rightCurb ();
    Lanes getCarriageway (Direction travelDirection);
    Curbsideable getCurb(Direction travelDirection);
}