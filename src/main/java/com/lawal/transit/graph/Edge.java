package com.lawal.transit.graph;

public interface Edge {
    Vertex<?> getHead();
    Vertex<?> getTail();
    Integer getWeight();

}