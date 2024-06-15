package com.lawal.transit.graph;

import com.lawal.transit.graph.interfaces.*;
import com.lawal.transit.graph.interfaces.DirectedVertex;

import java.util.*;

public interface DirectedGraph {

    public EdgeCollection getEdges ();
    public ArrayList<DirectedVertex> getVertices ();
}
