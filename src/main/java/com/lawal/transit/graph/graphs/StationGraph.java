package com.lawal.transit.graph.graphs;

import com.lawal.transit.core.concretes.Station;
import com.lawal.transit.graph.entities.Edge;
import com.lawal.transit.graph.entities.Graph;
import com.lawal.transit.graph.entities.Vertex;
import com.lawal.transit.core.singletons.Stations;

public class StationGraph {
    Graph<Station> graph;

    public StationGraph () {
        this.graph = new Graph<Station>();
    }

    public Graph<Station> getGraph () { return graph; }

    public Station getStation (Vertex vertex) {
        return Stations.INSTANCE.search(vertex.getName());
    }

    public void addStations () {
        for (Station station :  Stations.INSTANCE.getStations()) {
            addStation(station);
        }
    }

    private void addStation (Station station) {
        Vertex vertex = new Vertex((station.getName() + station.getOrientation().abbreviation()));

        station.getIncomingNeighbors().forEach(((direction, neighbor) -> {
            Vertex head = new Vertex(neighbor.getName() + neighbor.getOrientation().abbreviation());
            Edge edge = new Edge(head, vertex);
            vertex.addIncomingEdge(edge);
            head.addOutgoingEdge(edge);
            addVertex(vertex);
            addVertex(head);
            addEdge(edge);
        }));

        station.getOutgoingNeighbors().forEach(((direction, neighbor) -> {
            Vertex tail = new Vertex(neighbor.getName() + neighbor.getOrientation().abbreviation());
            Edge edge = new Edge(vertex, tail);
            vertex.addOutgoingEdge(edge);
            tail.addIncomingEdge(edge);
            addVertex(tail);
            addEdge(edge);
        }));
    }

    private void addVertex (Vertex vertex) {
        if (!graph.getVertices().contains(vertex)) {
            graph.getVertices().add(graph.getVertices().size(), vertex);
        }
    }
    
    public void addEdge (Edge edge) {
        if (!graph.getEdges().contains(edge)) {
            graph.getEdges().add(graph.getEdges().size(), edge);
        }
    }

    @Override
    public String toString () { return graph.toString(); }
} // end class
