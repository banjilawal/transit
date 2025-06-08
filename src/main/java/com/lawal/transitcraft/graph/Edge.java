package com.lawal.transitcraft.graph;

public interface Edge {
    Vertex<?> getHead();
    Vertex<?> getTail();
    Integer getWeight();

}