package com.lawal.transit.graph.interfaces;

import com.lawal.transit.globals.*;
import com.lawal.transit.graph.interfaces.*;

public interface VertexBuildable {

    public FormattedAddress getAddress ();
    public EdgeCollection getIncomingEdges ();
    public EdgeCollection getOutgoingEdges ();
    public Vertex build ();
}
