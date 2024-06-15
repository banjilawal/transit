package com.lawal.transit.graph.interfaces;

import com.lawal.transit.addresses.*;
import com.lawal.transit.addresses.interfaces.*;

public interface Edgeable<Vertex> {

    public Vertex getHead ();
    public Vertex getTail ();
    public RoadLabeler getLabel ();
    public Weightable getWeight ();


}
