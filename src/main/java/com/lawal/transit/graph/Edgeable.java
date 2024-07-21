package com.lawal.transit.graph;

import com.lawal.transit.road.*;

public interface Edgeable {

    public Vertex getHead ();
    public Vertex getTail ();
    public RoadIdentifiable getRoadIdentifier ();
    public Weightable getWeight ();


}
