package com.lawal.transit.graph;

import com.lawal.transit.addressing.LocationKey;
import com.lawal.transit.graph.interfaces.Edgeables;

public interface Vertex {

    LocationKey getKey ();
    VertexColor getColor();
    Vertex getPredecessor ();
    Edgeables getIncomingEdges();
    Edgeables getOutgoingEdges();
    void setColor (VertexColor color);
    void setPredecessor(Vertex predecessor);
}