package com.lawal.transit.graph.interfaces;

import com.lawal.transit.global.Address;

import com.lawal.transit.graph.VertexColor;

public interface Vertex {

    int getDiscoveryTime();
    int getFinishTime ();
    Address getAddress();
    VertexColor getColor();
    Vertex getPredecessor ();
    Edgeables getIncomingEdges();
    Edgeables getOutgoingEdges();
    void setDiscoveryTime (int discoveryTIme);
    void setFinishTime (int finishingTime);
    void setColor (VertexColor color);
    void setPredecessor(Vertex predecessor);
}