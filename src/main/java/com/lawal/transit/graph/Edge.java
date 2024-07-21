package com.lawal.transit.graph;

import com.lawal.transit.*;
import com.lawal.transit.road.*;
import javafx.scene.canvas.*;

import java.util.*;

public class Edge implements Edgeable, GraphicRenderer {

    private final Vertex head;
    private final Vertex tail;
    private final RoadIdentifiable roadIdentifier;
    private final Weightable weightable;


    public Edge (
        Vertex head,
        Vertex tail,
        RoadIdentifiable roadIdentifier,
        Weightable weightable
    ) {
        this.head = head;
        this.tail = tail;
        this.roadIdentifier = roadIdentifier;
        this.weightable = weightable;
    }

    @Override
    public Vertex getHead () {
        return head;
    }

    @Override
    public Vertex getTail () {
        return tail;
    }

    @Override
    public RoadIdentifiable getRoadIdentifier () {
        return roadIdentifier;
    }

    @Override
    public Weightable getWeight () {
        return weightable;
    }

    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof Edge edge) {
            return weightable.equals(edge.getWeight())
                && head.equals(edge.getHead())
                && tail.equals(edge.getTail())
                && roadIdentifier.equals(edge.getRoadIdentifier());
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(weightable, head, tail, roadIdentifier);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + " weight:" + weightable.toString()
            + " tail:" + tail.getAddress() + " --|" + roadIdentifier + "|-->" + " head:" + head.getAddress();
    }

    @Override
    public void render (GraphicsContext gc) {

    }
}
