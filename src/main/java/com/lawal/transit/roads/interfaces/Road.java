package com.lawal.transit.roads.interfaces;


import com.lawal.transit.blocks.interfaces.*;

public interface Road {


    public RoadIdentifier label ();
    public Lanes leftCarriageway ();
    public Lanes rightCarriageway ();
    public Curbsideable leftFrontage ();
    public Curbsideable rightFrontage ();
}