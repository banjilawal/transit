package com.lawal.transit.graph;

import com.lawal.transit.globals.*;

public interface Vertex {
    public FormattedAddress getAddress ();
    public EdgeCollection getIncomingEdges ();
    public EdgeCollection getOutgoingEdges ();
}
