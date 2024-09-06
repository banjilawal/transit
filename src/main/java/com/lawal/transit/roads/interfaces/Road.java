package com.lawal.transit.roads.interfaces;


import com.lawal.transit.globals.Orientation;

public interface Road {

    RoadIdentifier label ();
    Lanes leftCarriageway ();
    Lanes rightCarriageway ();
    Curbsideable leftCurb ();
    Curbsideable rightCurb ();
    Lanes getCarriageway (Orientation orientation);
    Curbsideable getCurb(Orientation orientation);
}