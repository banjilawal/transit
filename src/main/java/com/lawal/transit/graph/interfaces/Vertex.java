package com.lawal.transit.graph.interfaces;

import com.lawal.transit.globals.*;

public interface Vertex {
    public FormattedAddress getAddress ();
    public EdgeCollection getIncomingEdges ();
    public EdgeCollection getOutgoingEdges ();
}
