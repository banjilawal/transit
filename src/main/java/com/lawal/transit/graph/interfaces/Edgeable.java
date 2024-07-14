package com.lawal.transit.graph.interfaces;

import com.lawal.transit.road.interfaces.*;

public interface Edgeable {

    public Vertex getHead ();
    public Vertex getTail ();
    public RoadIdentifiable getRoadIdentifier ();
    public Weightable getWeight ();


}
