package com.lawal.transit.graph;

import com.lawal.transit.graph.interfaces.*;
import com.lawal.transit.road.interfaces.*;
import javafx.scene.canvas.*;

import java.util.*;

public class Edges implements EdgeCollection {

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
    public Edgeable search (RoadIdentifiable roadIdentifier) {
        for (Edgeable edge: edges) {
            if (edge.getRoadIdentifier().equals(roadIdentifier))
                return edge;
        }
        return null;
    }

    @Override
    public void add (Edgeable edgeable) throws Exception {
        if (edges.contains(edgeable))
            throw new Exception(ADD_EDGE_ERROR);
        edges.add(edges.size(), edgeable);
    }

    public void remove (Edgeable edgeable) throws Exception {
        int index = edges.indexOf(edgeable);
        if (index < 0)
            throw new Exception(REMOVE_EDGE_ERROR);
        edges.remove(index);
    }

    public void render (GraphicsContext gc) {

    }

}
