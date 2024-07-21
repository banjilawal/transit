package com.lawal.transit.graph;

import com.lawal.transit.globals.*;

public interface VertexBuildable {

    public FormattedAddress getAddress ();
    public EdgeCollection getIncomingEdges ();
    public EdgeCollection getOutgoingEdges ();
    public Vertex build ();
}
