package com.lawal.transit.stations;

import com.lawal.transit.globals.*;
import com.lawal.transit.graph.*;

import java.util.*;

public class Stations implements VertexCollection {
    public static final String ADDITION_ERROR = "The item is already in the list. It cannot be added again";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";
    private final ArrayList<Vertex> stations;

    public Stations () {
        this.stations = new ArrayList<>();
    }

    public ArrayList<Vertex> getList () {
        return this.stations;
    }

    public Vertex getByIndex (int index) {
        return stations.get(index);
    }

    @Override
    public int getOrder () {
        return stations.size();
    }


    public int size () {
        return stations.size();
    }

    public Iterator<Vertex> iterator () {
        return stations.iterator();
    }


    @Override
    public void add (Vertex  vertex) throws Exception {
        if (vertex == null) //vertices.contains(vertex))
            throw new Exception(ADDITION_ERROR);
        stations.add(stations.size(), vertex);;
    }

    @Override
    public void remove (Vertex station) throws Exception {
        int index = stations.indexOf(station);
        if (index < 0)
            throw new Exception(REMOVAL_ERROR);
        stations.remove(index);
    }


    @Override
    public Vertex search (FormattedAddress addressable) {
        for (Vertex vertex: stations) {
            if (vertex.getAddress().equals(addressable))
                return vertex;
        }
        return null;
    }

}
