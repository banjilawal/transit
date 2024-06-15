package com.lawal.transit.graph;

import com.lawal.transit.addresses.interfaces.*;
import com.lawal.transit.graph.interfaces.*;
import javafx.scene.canvas.*;

import java.util.*;

public class Edges implements EdgeCollection<Vertex<Addressable>> {

    public static final String ADD_EDGE_ERROR = "The edge already exists";
    public static final String ENDPOINT_ERROR = "The vertex does exist on that edge";
    public static final String REMOVE_EDGE_ERROR = "No edge exists at that orientation";
    private final ArrayList<Edgeable<Vertex<Addressable>>> edges;

    public Edges () {
        this.edges = new ArrayList<>();
    }

    @Override
    public int getDegree () {
        return edges.size();
    }

    @Override
    public Iterator<Edgeable<Vertex<Addressable>>> iterator () {
        return edges.iterator();
    }

    @Override
    public Edgeable<Vertex<Addressable>> search (RoadLabeler roadLabeler) {
        for (Edgeable<Vertex<Addressable>> edge: edges) {
            if (edge.getLabel().equals(roadLabeler))
                return edge;
        }
        return null;
    }

    @Override
    public void add (Edgeable<Vertex<Addressable>> edgeable) throws Exception {
        if (edges.contains(edgeable))
            throw new Exception(ADD_EDGE_ERROR);
        edges.add(edges.size(), edgeable);
    }

    public void remove (Edgeable<Vertex<Addressable>> edgeable) throws Exception {
        int index = edges.indexOf(edgeable);
        if (index < 0)
            throw new Exception(REMOVE_EDGE_ERROR);
        edges.remove(index);
    }

    public void render (GraphicsContext gc) {

    }

}
