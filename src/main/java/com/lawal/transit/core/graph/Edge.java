package com.lawal.transit.core.graph;

public class Edge {
    private String name;
    private Vertex head;
    private Vertex tail;
    private int weight;

    public Edge (Vertex head, Vertex tail) {
        this((head.getName() + "->" + tail.getName()), head, tail, 0);
    }

    public Edge (String name, Vertex head, Vertex tail, int weight) {
        this.name = name;
        this.head = head;
        this.tail = tail;
        this.weight = weight;
    }

    public String getName () {
        return name;
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

    public void setName (String name) {
        this.name = name;
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


} // end class Edge
