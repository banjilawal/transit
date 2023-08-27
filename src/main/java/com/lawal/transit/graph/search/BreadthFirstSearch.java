package com.lawal.transit.graph.search;
import com.lawal.transit.graph.entities.Color;
import com.lawal.transit.graph.entities.Edge;
import com.lawal.transit.graph.entities.Graph;
import com.lawal.transit.graph.entities.Vertex;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<E> {
    private Graph<E> graph;
    private Vertex origin;
    private Queue<Vertex> queue;

    public BreadthFirstSearch(Graph<E> graph, Vertex origin) {
        this.graph = graph;
        this.origin = origin;
        this.queue = new LinkedList<Vertex>();
        runWork();
    }

    public void runWork () {
        initialize();
        search();
    }

    private void initialize () {
        for (Vertex vertex : graph.getVertices()) {
            if (!vertex.equals(origin)) {
                vertex.setColor(Color.WHITE);
                vertex.setPredecessor(null);
                vertex.setOriginDistance(0);
            }
        }
        origin.setColor(Color.GRAY);
        queue.add(origin);
        System.out.println("origin: " + origin.getName() + " " + origin.getOutDegree() + origin.getOriginDistance() + origin.getColor().toString());
    }

    private void search () {
        System.out.println(queue.size());
        while (!queue.isEmpty()) {
            Vertex u = queue.remove();
            System.out.println("removed " + u.getName() + u.getColor() + " " + u.getOutDegree());
            for (Edge e : u.getOutgoingEdges()) {
                Vertex v = e.getTail();
                if (v.getColor().equals(Color.WHITE)) {
                    v.setColor(Color.GRAY);
                    v.setOriginDistance(1 + u.getOriginDistance());
                    v.setPredecessor(u);
                    queue.add(v);
                    System.out.println(v.getPredecessor().getName() + v.getPredecessor().getColor().abbreviation()
                            + " --> " + v.getName() + v.getColor().abbreviation() + " "  + v.getOriginDistance());
                }
            }
            u.setColor(Color.BLACK);
        }
    }

} // end class BreadthFirstSearch
