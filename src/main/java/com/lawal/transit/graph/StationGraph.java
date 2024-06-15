package com.lawal.transit.graph;

import com.lawal.transit.addresses.*;
import com.lawal.transit.graph.interfaces.*;
import com.lawal.transit.locations.*;

public class StationGraph implements Graph<Station> {

    private final VertexCollection<Station> vertices;
    private final EdgeCollection<Vertex<Address>> edges;

    public StationGraph (VertexCollection<Station> vertices, EdgeCollection<Vertex<Address>> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    @Override
    public VertexCollection<Station> getVertices () {
        return vertices;
    }
    @Override
    public EdgeCollection<Vertex<Address>> getEdges () {
        return edges;
    }


}
