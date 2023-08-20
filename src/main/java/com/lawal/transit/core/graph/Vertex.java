package com.lawal.transit.core.graph;

import com.lawal.transit.core.enums.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.util.Objects.hash;

public class Vertex {

    private enum State { WHITE, GRAY, BLACK; }
    private String name;
    private State  state;
    private Direction outgoingDirection;
    private ArrayList<Edge> incomingEdges;
    private ArrayList<Edge> outgoingEdges;
    private HashMap<Direction, Vertex> incomingNeighbors;
    private HashMap<Direction, Vertex> outgoingNeighbors;

    public Vertex (Direction outgoingDirection, String name) {
        this.name = name;
        this.state = State.WHITE;
        this.outgoingDirection = outgoingDirection;
        this.incomingEdges = new ArrayList<Edge>();
        this.outgoingEdges= new ArrayList<Edge>();
        this.incomingNeighbors = new HashMap<Direction, Vertex>();
        this.outgoingNeighbors = new HashMap<Direction, Vertex>();
    } //

    public String getName () {
        return name;
    }

    public Direction getOutgoingDirection () { return outgoingDirection; }

    public int getOutDegree () { return outgoingNeighbors.size(); }

    public int getInDegree () { return incomingNeighbors.size(); }

    public State getState () {
        return state;
    }

    public Edge findIncomingEdge (Vertex vertex) {
        for (Edge edge : incomingEdges) {
            if (edge.getHead().equals(vertex)) return edge;
        }
        return null;
    } //

    public Edge findOutgoingEdge (Vertex vertex) {
        for (Edge edge : outgoingEdges) {
            if (edge.getTail().equals(vertex)) return edge;
        }
        return null;
    } //

    public Vertex fingOutgoingNeighbor (Edge edge) {
        return findVertex(outgoingNeighbors, edge);
    }

    public Vertex findIncomingNeighbor (Edge edge) {
        return findVertex(incomingNeighbors, edge);
    }

    private Vertex findVertex (HashMap<Direction, Vertex> vertices, Edge edge) {
        Iterator<Map.Entry<Direction, Vertex>> iterator = vertices.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Direction, Vertex> entry = iterator.next();
            if (entry.getValue().equals(edge.getTail())) return entry.getValue();
        }
        return null;
    } //

    private boolean keyValueExists (HashMap<Direction, Vertex> vertices, Direction direction, Vertex vertex) {
        Iterator<Map.Entry<Direction, Vertex>> iterator = vertices.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Direction, Vertex> entry = iterator.next();
            if (entry.getValue().equals(vertex) && entry.getKey().equals(direction)) return true;
        }
        return false;
    } //

    private boolean neighborExists (HashMap<Direction, Vertex> vertices, Vertex vertex) {
        Iterator<Map.Entry<Direction, Vertex>> iterator = vertices.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Direction, Vertex> entry = iterator.next();
            if (entry.getValue().equals(vertex)) return true;
        }
        return false;
    }

    private boolean keyExists (HashMap<Direction, Vertex> vertices, Direction direction) {
        Iterator<Map.Entry<Direction, Vertex>> iterator = vertices.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Direction, Vertex> entry = iterator.next();
            if (entry.getKey().equals(direction)) return true;
        }
        return false;
    }

    public HashMap<Direction, Vertex> getIncomingNeighbors () {
        return incomingNeighbors;
    }

    public HashMap<Direction, Vertex> getOutgoingNeighbors () {
        return outgoingNeighbors;
    }

    public ArrayList<Edge> getIncomingEdges () {
        return incomingEdges;
    }

    public ArrayList<Edge> getOutgoingEdges () {
        return outgoingEdges;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setState (State state) {
        this.state = state;
    }

    public void addIncomingNeighbors (HashMap<Direction, Vertex> vertices) {
       vertices.forEach(((direction, vertex) -> addIncomingNeighbor(vertex)));
    }

    public void addIncomingNeighbor (Vertex vertex) {
        Edge edge = vertex.findOutgoingEdge(this);
        if (!neighborExists(incomingNeighbors, vertex) && (edge != null)) {
            incomingNeighbors.put(vertex.getOutgoingDirection(), vertex);
            if (!incomingEdges.contains(edge)) incomingEdges.add(incomingEdges.size(), edge);
        }
    } //

    public void addOutgoingNeighbors (HashMap<Direction, Vertex> vertices) {
        vertices.forEach(((direction, neighbor) -> addOutgoingNeighbor(neighbor)));
    }

    public void addOutgoingNeighbor (Vertex vertex) {
        Edge edge = vertex.findIncomingEdge(this);
        if (!neighborExists(outgoingNeighbors, vertex) &&  edge != null) {
            outgoingNeighbors.put(vertex.getOutgoingDirection().oppositeDirection(), vertex);
            if (!outgoingEdges.contains(edge)) outgoingEdges.add(outgoingEdges.size(), edge);
        }
    } //

    public void addIncomingEdges (ArrayList<Edge> edges) {
        for (Edge edge : edges) {
            addIncomingEdge(edge);
        }
    }

    public void addIncomingEdge (Edge edge) {
        if (!getIncomingEdges().contains(edge)) {
            Vertex vertex = edge.getHead();
            addIncomingNeighbor(edge.getHead());
        }
    }

    public void addOutgoingEdges (ArrayList<Edge> edges) {
        for (Edge edge : edges) {
            addOutgoingEdge(edge);
        }
    }

    public void addOutgoingEdge (Edge edge) {
        if (!getOutgoingEdges().contains(edge)) {
            addOutgoingNeighbor(edge.getTail());
        }
    } //

    @Override
    public boolean equals (Object object) {
        if (object instanceof Vertex vertex) {
            return name.equalsIgnoreCase(vertex.getName()) && state.equals(vertex.getState())
                && (getOutDegree() == vertex.getOutDegree()) && (getInDegree() == vertex.getInDegree());
         }
        return false;
    }

    @Override
    public int hashCode() {
        return hash(name, state);
    }
} // end class
