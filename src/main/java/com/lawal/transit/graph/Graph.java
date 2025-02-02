package com.lawal.transit.graph;

import com.lawal.transit.graph.contract.Edgeables;
import com.lawal.transit.graph.contract.Vertices;

public interface Graph {

    Edgeables edges ();
    Vertices vertices ();
}