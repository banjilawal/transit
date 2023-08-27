package com.lawal.transit.graph.entities;

import java.util.Objects;

public class Edge {
    private Vertex head;
    private Vertex tail;
    private int weight;

    public Edge (Vertex head, Vertex tail) {
        this(head, tail, 0);
    }

    public Edge (Vertex head, Vertex tail, int weight) {
        this.head = head;
        this.tail = tail;
        this.weight = weight;
    }

    public Vertex getHead () {
        return head;
    }

    public Vertex getTail () {
        return tail;
    }

    public int getWeight () {
        return weight;
    }

    public void setHead (Vertex head) {
        this.head = head;
    }

    public void setTail (Vertex tail) {
        this.tail = tail;
    }

    public void setWeight (int weight) {
        this.weight = weight;
    }

    public boolean equals (Object object) {
        if (object instanceof  Edge edge) {
            return head.equals(edge.getHead()) && tail.equals(edge.getTail()) && weight == edge.getWeight();
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(head, tail, weight);
    }

    @Override
    public String toString () {
        return head.getName() + "-->" + tail.getName();
    }
} // end class Edge
