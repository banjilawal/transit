package com.lawal.transit.graph.interfaces;

import com.lawal.transit.addressing.Addressable;
import com.lawal.transit.graph.VertexColor;

public interface Vertex {

    int getDiscoveryTime();
    int getFinishTime ();
    Addressable getKey ();
    VertexColor getColor();
    Vertex getPredecessor ();
    Edgeables getIncomingEdges();
    Edgeables getOutgoingEdges();
    void setDiscoveryTime (int discoveryTIme);
    void setFinishTime (int finishingTime);
    void setColor (VertexColor color);
    void setPredecessor(Vertex predecessor);
}