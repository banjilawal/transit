package com.lawal.transit.graph.entities;

import java.util.*;

import static java.util.Objects.hash;

public class Vertex {
    private String name;
    private Color color;
    private int originDistance;
    private Vertex predecessor;
//    private Direction outgoingDirection;
    private ArrayList<Edge> incomingEdges;
    private ArrayList<Edge> outgoingEdges;
//    private HashMap<Direction, Vertex> incomingNeighbors;
//    private HashMap<Direction, Vertex> outgoingNeighbors;

    public Vertex (String name) {
        this.name = name;
        this.color = Color.WHITE;
        this.predecessor = null;
        this.originDistance = 0;
//        this.outgoingDirection = outgoingDirection;
        this.incomingEdges = new ArrayList<Edge>();
        this.outgoingEdges= new ArrayList<Edge>();
//        this.incomingNeighbors = new HashMap<Direction, Vertex>();
//        this.outgoingNeighbors = new HashMap<Direction, Vertex>();
    } //

    public String getName () {
        return name;
    }

    public int getOriginDistance () { return originDistance; }

//    public Direction getOutgoingDirection () { return outgoingDirection; }

    public Vertex getPredecessor () { return predecessor; }

    public Color getColor() {
        return color;
    }
    public int getOutDegree () { return outgoingEdges.size(); }

    public int getInDegree () { return incomingEdges.size(); }

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


//    public Vertex findIncomingNeighbor (Edge edge) {
//        return findVertex(incomingNeighbors, edge);
//    }

//    private Vertex findVertex (HashMap<Direction, Vertex> vertices, Edge edge) {
//        Iterator<Map.Entry<Direction, Vertex>> iterator = vertices.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Direction, Vertex> entry = iterator.next();
//            if (entry.getValue().equals(edge.getTail())) return entry.getValue();
//        }
//        return null;
//    } //
//
//    private boolean keyValueExists (HashMap<Direction, Vertex> vertices, Direction direction, Vertex vertex) {
//        Iterator<Map.Entry<Direction, Vertex>> iterator = vertices.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Direction, Vertex> entry = iterator.next();
//            if (entry.getValue().equals(vertex) && entry.getKey().equals(direction)) return true;
//        }
//        return false;
//    } //
//
//    private boolean neighborExists (HashMap<Direction, Vertex> vertices, Vertex vertex) {
//        Iterator<Map.Entry<Direction, Vertex>> iterator = vertices.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Direction, Vertex> entry = iterator.next();
//            if (entry.getValue().equals(vertex)) return true;
//        }
//        return false;
//    }
//
//    private boolean keyExists (HashMap<Direction, Vertex> vertices, Direction direction) {
//        Iterator<Map.Entry<Direction, Vertex>> iterator = vertices.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Direction, Vertex> entry = iterator.next();
//            if (entry.getKey().equals(direction)) return true;
//        }
//        return false;
//    }

//    public HashMap<Direction, Vertex> getIncomingNeighbors () {
//        return incomingNeighbors;
//    }
//
//    public HashMap<Direction, Vertex> getOutgoingNeighbors () {
//        return outgoingNeighbors;
//    }

    public ArrayList<Edge> getIncomingEdges () {
        return incomingEdges;
    }

    public ArrayList<Edge> getOutgoingEdges () {
        return outgoingEdges;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setOriginDistance (int originDistance) { this.originDistance = originDistance; }

    public void setPredecessor (Vertex precesssor) { this.predecessor = precesssor; }

    public void setColor(Color color) {
        this.color = color;
    }

//    public void addIncomingNeighbors (HashMap<Direction, Vertex> vertices) {
//       vertices.forEach(((direction, vertex) -> addIncomingNeighbor(vertex)));
//    }
//
//    public void addIncomingNeighbor (Vertex vertex) {
//        Edge edge = vertex.findOutgoingEdge(this);
//        if (!neighborExists(incomingNeighbors, vertex) && (edge != null)) {
//            incomingNeighbors.put(vertex.getOutgoingDirection(), vertex);
//            if (!incomingEdges.contains(edge)) incomingEdges.add(incomingEdges.size(), edge);
//        }
//    } //

//    public void addOutgoingNeighbors (HashMap<Direction, Vertex> vertices) {
//        vertices.forEach(((direction, neighbor) -> addOutgoingNeighbor(neighbor)));
//    }
//
//    public void addOutgoingNeighbor (Vertex vertex) {
//        Edge edge = vertex.findIncomingEdge(this);
//        if (!neighborExists(outgoingNeighbors, vertex) &&  edge != null) {
//            outgoingNeighbors.put(vertex.getOutgoingDirection().oppositeDirection(), vertex);
//            if (!outgoingEdges.contains(edge)) outgoingEdges.add(outgoingEdges.size(), edge);
//        }
//    } //

    public void setIncomingEdges (ArrayList<Edge> edges) {
        for (Edge edge : edges) {
            addIncomingEdge(edge);
        }
    }

    public void setOutgoingEdges (ArrayList<Edge> edges) {
        for (Edge edge : edges) {
            addOutgoingEdge(edge);
        }
    }

    public void addIncomingEdge (Vertex vertex) {
        addIncomingEdge(new Edge(vertex, this));
    }

    public void addOutgoingEdge (Vertex vertex) {
        addOutgoingEdge(new Edge(this, vertex));
    }

    public void addIncomingEdge (Edge edge) {
        if (!incomingEdges.contains(edge)) incomingEdges.add(incomingEdges.size(), edge);
    }

    public void addOutgoingEdge (Edge edge) {
        if (!outgoingEdges.contains(edge)) outgoingEdges.add(outgoingEdges.size(), edge);
    } //

    @Override
    public boolean equals (Object object) {
        if (object instanceof Vertex vertex) {
            return name.equalsIgnoreCase(vertex.getName()) && color.equals(vertex.getColor())
                && (getOutDegree() == vertex.getOutDegree()) && (getInDegree() == vertex.getInDegree());
         }
        return false;
    }

    @Override
    public int hashCode () {
        return hash(name, color, predecessor, incomingEdges, outgoingEdges);
    }

    @Override
    public String toString () {
        return name + " incoming:" + printIncomingEdges() + "\n" + "outgoing:" + printOutgoingEdges();
    }

    public String printOutgoingEdges () {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (Edge edge : outgoingEdges) {
            stringBuilder.append(edge.getTail().getName()).append(", ");
        }
        return stringBuilder.delete((stringBuilder.length() - 1), stringBuilder.length()).toString() + "]";
    }

    public String printIncomingEdges () {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (Edge edge : incomingEdges) {
            stringBuilder.append(edge.getTail().getName()).append(", ");
        }
        return stringBuilder.delete((stringBuilder.length() - 1), stringBuilder.length()).toString() + "]";
    }
} // end class
