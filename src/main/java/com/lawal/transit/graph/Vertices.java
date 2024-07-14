package com.lawal.transit.graph;

import com.lawal.transit.globals.*;
import com.lawal.transit.graph.interfaces.*;

import java.util.*;

public class Vertices implements VertexCollection {
    public static final String ADDITION_ERROR = "The item is already in the list. It cannot be added again";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";
    private final ArrayList<Vertex> vertices;

    public Vertices () {
        this.vertices = new ArrayList<>();
    }

    public int getOrder () {
        return vertices.size();
    }

    public Iterator<Vertex> iterator () {
        return vertices.iterator();
    }


    @Override
    public void add (Vertex  vertex) throws Exception {
        if (vertices.contains(vertex))
            throw new Exception(ADDITION_ERROR);
        vertices.add(vertices.size(), vertex);;
    }

    @Override
    public void remove (Vertex station) throws Exception {
        int index = vertices.indexOf(station);
        if (index < 0)
            throw new Exception(REMOVAL_ERROR);
        vertices.remove(index);
    }


    @Override
    public Vertex search (FormattedAddress addressable) {
        for (Vertex vertex: vertices) {
            if (vertex.getAddress().equals(addressable))
                return vertex;
        }
        return null;
    }

}
