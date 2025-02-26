package com.lawal.transit.graph;

import com.lawal.transit.graph.contract.Edgeable;
import com.lawal.transit.graph.contract.Edgeables;
import com.lawal.transit.graph.contract.Vertex;


import java.util.*;

public class Edges {

    public static final String ADD_EDGE_ERROR = "The edge already exists";
    public static final String ENDPOINT_ERROR = "The vertex does exist on that edge";
    public static final String REMOVE_EDGE_ERROR = "No edge exists at that orientation";
    private final ArrayList<Edge> edges;

    public Edges () {
        this.edges = new ArrayList<>();
    }

    public int getDegree () {
        return edges.size();
    }

    public Iterator<Edge> iterator () {
        return edges.iterator();
    }

    public void add (Edge edge) throws Exception {
        if (edges.contains(edge)) throw new Exception(ADD_EDGE_ERROR);
        edges.add(edge);
    }

    public void remove (int edgeId) throws Exception {
        int index = edges.indexOf(search(edgeId));
        if (index < 0)
            throw new Exception(REMOVE_EDGE_ERROR);
        edges.remove(index);
    }

    public Edge search (int edgeId) {
        for (Edge edge: edges) {
            if (edge.getId() == edgeId) return edge;
        }
        return null;
    }

    public Edge search (Vertex head, Vertex tail) {
        for (Edge edge: edges) {
            if (edge.getHead().equals(head) && edge.getTail().equals(tail)) return edge;
        }
        return null;
    }
}