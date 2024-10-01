package com.lawal.transit.graph;

import com.lawal.transit.graph.interfaces.Edgeables;
import com.lawal.transit.graph.interfaces.Vertices;

public interface Graph {

    Edgeables edges ();
    Vertices vertices ();
}