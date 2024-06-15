package com.lawal.transit.graph;

import com.lawal.transit.*;
import com.lawal.transit.addresses.interfaces.*;
import com.lawal.transit.graph.interfaces.*;
import javafx.scene.canvas.*;

import java.util.*;

public class Edge implements Edgeable<Vertex<Addressable>>, GraphicRenderer {
    private final Weightable weightable;
    private final Vertex<Addressable> head;
    private final Vertex<Addressable> tail;
    private final RoadLabeler label;


    public Edge (
        Weightable weightable,
        Vertex<Addressable> head,
        Vertex<Addressable> tail,
        RoadLabeler label
    ) {
        this.weightable = weightable;
        this.head = head;
        this.tail = tail;
        this.label = label;
    }

    @Override
    public Weightable getWeight () {
        return weightable;
    }

    @Override
    public Vertex<Addressable> getHead () {
        return head;
    }

    @Override
    public Vertex<Addressable> getTail () {
        return tail;
    }

    @Override
    public RoadLabeler getLabel () {
        return label;
    }

    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof Edge edge) {
            return weightable.equals(edge.getWeight())
                && head.equals(edge.getHead())
                && tail.equals(edge.getTail())
                && label.equals(edge.getLabel());
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(weightable, head, tail, label);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + " weight:" + weightable.toString()
            + " tail:" + tail.getAddress() + " --|" + label + "|-->" + " head:" + head.getAddress();
    }

    @Override
    public void render (GraphicsContext gc) {

    }
}
