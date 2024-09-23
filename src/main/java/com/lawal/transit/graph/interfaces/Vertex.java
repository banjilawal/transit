package com.lawal.transit.graph.interfaces;

import com.lawal.transit.addressing.Addressable;
import com.lawal.transit.graph.VertexColor;

public interface Vertex {

    Addressable getKey ();
    VertexColor getColor();
    Vertex getPredecessor ();
    Edgeables getIncomingEdges();
    Edgeables getOutgoingEdges();
    void setColor (VertexColor color);
    void setPredecessor(Vertex predecessor);
}