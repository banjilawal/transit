package com.lawal.transit.core.collections.graph;

import java.util.ArrayList;

public  class Graph<E> {
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;

    public Graph () {
        this.vertices = new ArrayList<Vertex>();
        this.edges = new ArrayList<Edge>();
    }

    public ArrayList<Vertex> getVertices () { return vertices; }
    public ArrayList<Edge> getEdges () { return edges; }

    public void addEdges (ArrayList<Edge> edges) {
        for (Edge edge : edges) {
            addEdge(edge);
        }
    }

    public void addEdge (Edge edge) {
        if (!edges.contains(edge)) {
            edges.add(edges.size(), edge);
        }
    }

    public void addVertices (ArrayList<Vertex> vertices) {
        for (Vertex vertex : vertices) { addVertex(vertex); }
    }

    public void addVertex (Vertex vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertices.size(), vertex);
        }
    }

    @Override
    public String toString () {
        return "vertexTotal:" + vertices.size() + " edgeTotal:" + edges.size();
    }

    public String printVertices () {
        StringBuilder stringBuilder = new StringBuilder("vertices:\n");
        for (Vertex vertex : vertices) {
            stringBuilder.append(vertex.getName()).append(", ");
        }
        return stringBuilder.delete((stringBuilder.length() - 1), stringBuilder.length()).toString() + "\n";
    }

    public String printEdges () {
        StringBuilder stringBuilder = new StringBuilder("Edges:\n");
        for (Edge edge : edges) {
            stringBuilder.append(edge.toString()).append("\n");
        }
        return stringBuilder.toString() + "\n";
    }
} // end class Graph
