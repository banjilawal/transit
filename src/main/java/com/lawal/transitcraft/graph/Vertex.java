package com.lawal.transitcraft.graph;

import java.util.List;

public class Vertex<T> {
    private VertexColor color;
    private Vertex<T> predecessor;
    private Integer discoveryTime;
    private Integer finishTime;

    private T item;
    private List<Edge> outgoingEdges;
    private List<Edge> incomingEdges;
}