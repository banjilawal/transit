package com.lawal.transit.graph.contract;

import com.lawal.transit.address.Address;

import com.lawal.transit.graph.Edges;
import com.lawal.transit.graph.VertexColor;

public interface Vertex {

    int getDiscoveryTime();
    int getFinishTime ();
    Address getAddress();
    VertexColor getColor();
    Vertex getPredecessor ();
    Edges getIncomingEdges();
    Edges getOutgoingEdges();
    void setDiscoveryTime (int discoveryTIme);
    void setFinishTime (int finishingTime);
    void setColor (VertexColor color);
    void setPredecessor(Vertex predecessor);
}