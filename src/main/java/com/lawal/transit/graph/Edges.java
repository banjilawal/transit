package com.lawal.transit.graph;

import com.lawal.transit.graph.interfaces.Edgeable;
import com.lawal.transit.graph.interfaces.Edgeables;


import java.util.*;

public class Edges implements Edgeables {

    public static final String ADD_EDGE_ERROR = "The edge already exists";
    public static final String ENDPOINT_ERROR = "The vertex does exist on that edge";
    public static final String REMOVE_EDGE_ERROR = "No edge exists at that orientation";
    private final ArrayList<Edgeable> edges;

    public Edges () {
        this.edges = new ArrayList<>();
    }

    @Override
    public int getDegree () {
        return edges.size();
    }

    @Override
    public Iterator<Edgeable> iterator () {
        return edges.iterator();
    }

    @Override
    public void add (Edgeable edgeable) throws Exception {
        if (edges.contains(edgeable))
            throw new Exception(ADD_EDGE_ERROR);
        edges.add(edges.size(), edgeable);
    }

    public void remove (int edgeId) throws Exception {
        int index = edges.indexOf(search(edgeId));
        if (index < 0)
            throw new Exception(REMOVE_EDGE_ERROR);
        edges.remove(index);
    }

    public Edgeable search (int edgeId) {
        for (Edgeable edge: edges) {
            if (edge.id() == edgeId)
                return edge;
        }
        return null;
    }

    public Edgeable search (Vertex head, Vertex tail) {
        for (Edgeable edge: edges) {
            if (edge.head().equals(head) && edge.tail().equals(tail))
                return edge;
        }
        return null;
    }
}