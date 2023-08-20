package com.lawal.transit.core.graph;

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
            if (!vertices.contains(edge.getTail())) vertices.add(vertices.size(), edge.getTail());
            if (!vertices.contains(edge.getHead())) vertices.add(vertices.size(), edge.getHead());
            edges.add(edges.size(), edge);
        }
    }

    public void addVertices (ArrayList<Vertex> vertices) {
        for (Vertex vertex : vertices) { addVertex(vertex); }
    }

    public void addVertex (Vertex vertex) {
        if (!vertices.contains(vertex)) {
            for (Edge edge : vertex.getOutgoingEdges()) { addEdge(edge); }
            for (Edge edge : vertex.getIncomingEdges()) { addEdge(edge); }
            vertices.add(vertices.size(), vertex);
        }
    }

    public E getEntity (String name) {

    }


} // end class Graph
