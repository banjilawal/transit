package com.lawal.transit.graph;

import com.lawal.transit.graph.interfaces.Edgeable;
import com.lawal.transit.graph.interfaces.Vertex;
import com.lawal.transit.graph.interfaces.Weightable;
import com.lawal.transit.road.RoadLabel;

import java.util.ArrayList;

public record Edge (
    int id,
    Vertex head,
    Vertex tail,
    Weightable weight,
    ArrayList<EdgeCategory> categories,
    RoadLabel roadLabel
) implements Edgeable {
//
//    private int id;
//    private Vertex head;
//    private Vertex tail;
//    private Weightable weight;
//    private RoadIdentifier roadLabel;
//    private ArrayList<EdgeCategory> categories;
//
//    private Edge (Builder builder) {
//        this.id = builder.id;
//        this.head = builder.head;
//        this.tail = builder.tail;
//        this.weight = builder.weight;
//        this.roadLabel = builder.roadLabel;
//        this.categories = builder.categories;
//    }
//
//    @Override
//    public int id () {
//        return id;
//    }
//
//    @Override
//    public Vertex head () {
//        return head;
//    }
//
//    @Override
//    public Vertex tail () {
//        return tail;
//    }
//
//    @Override
//    public Weightable weight () {
//        return weight;
//    }
//
//    @Override
//    public ArrayList<EdgeCategory> categories () {
//        return categories;
//    }
//
//    @Override
//    public RoadIdentifier roadLabel () {
//        return roadLabel;
//    }
//
//    public boolean equals (Object object) {
//        if (object == this) return true;
//        if (object == null) return false;
//        if (object instanceof Edgeable edgeable)
//            return head.equals(edgeable.head()) && tail.equals(edgeable.tail());
//        return false;
//    }
//
//    @Override
//    public int hashCode () {
//        return Objects.hash(id, head, tail, weight, roadLabel);
//    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {

        private int id;
        private Vertex head;
        private Vertex tail;
        private Weightable weight;
        private RoadLabel roadLabel;
        private ArrayList<EdgeCategory> categories;


        public Builder () {}

        public Builder id (int id) {
            this.id = id;
            return this;
        }

        public Builder head (Vertex head) {
            this.head = head;
            return this;
        }

        public Builder tail (Vertex tail) {
            this.tail = tail;
            return this;
        }

        public Builder weight (Weightable weight) {
            this.weight = weight;
            return this;
        }

        public Builder roadLabel (RoadLabel roadLabel) {
            this.roadLabel = roadLabel;
            return this;
        }

        public Builder categories (ArrayList<EdgeCategory> categories) {
            this.categories = categories;
            return this;
        }

        public Edgeable build () {
            return new Edge(id, head, tail, weight, categories, roadLabel);
        }
    }
//    @Override
//    public String toString () {
//        return getClass().getSimpleName() + " weight:" + weight.toString()
//           + " head:" + head.getName() + " |-->" + " tail:" + tail.getName();
//    }
}