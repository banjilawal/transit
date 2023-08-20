package com.lawal.transit.core.collections;

import com.lawal.transit.core.entities.Station;
import com.lawal.transit.core.graph.Edge;
import com.lawal.transit.core.graph.Graph;
import com.lawal.transit.core.graph.Vertex;
import com.lawal.transit.core.singletons.Stations;

public class StationGraph {
    Graph<Station> graph;

    public StationGraph () {
        this.graph = new Graph<Station>();
    }

    public Station getStationn (Vertex vertex) {
        return Stations.INSTANCE.getBag().search(vertex.getName());
    }


    private Edge createEdge (Station origin, Station destination) {
        Vertex head = new Vertex(origin.getBusDirection(), origin.getName());
        Vertex tail = new Vertex(destination.getBusDirection(), destination.getName());
        return new Edge(head, tail);
    }

    private void addStation (Station station) {
        Vertex vertex = new Vertex(station.getBusDirection(), station.getName());

        station.getIncomingNeighbors().forEach(((direction, neighbor) -> {
            Vertex head = new Vertex(neighbor.getBusDirection(), neighbor.getName());
            Edge edge = new Edge(head, vertex);
            head.getOutgoingNeighbors().put(vertex.getOutgoingDirection(), vertex);
            vertex.getIncomingNeighbors().put(head.getOutgoingDirection(), head);
            addVertex(vertex);
            addVertex(head);
            addEdge(edge);
        }));

        station.getOutgoingNeighbors().forEach(((direction, neighbor) -> {
            Vertex tail = new Vertex(neighbor.getBusDirection(), neighbor.getName());
            Edge edge = new Edge(vertex, tail);
            tail.getIncomingNeighbors().put(vertex.getOutgoingDirection(), vertex);
            vertex.getOutgoingNeighbors().put(tail.getOutgoingDirection().oppositeDirection(), tail);
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



} // end class
