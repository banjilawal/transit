package com.lawal.transit.graph.interfaces;

import com.lawal.transit.addresses.interfaces.*;

public interface GenericEdgeable<T> {

    public Weightable getWeight ();
    public RoadLabeler getLabel ();
}
