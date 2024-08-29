package com.lawal.transit.edges;

import com.lawal.transit.edges.interfaces.*;
import com.lawal.transit.places.interfaces.*;
import com.lawal.transit.stations.interfaces.*;

public record Edge (Stationable head, Stationable tail, EdgeProperties properties) implements Edgeable {

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {
        private Stationable head;
        private Stationable tail;
        private EdgeProperties properties;

        public Builder () {}

        public Builder (Placeable placeA) {

        }

        public Builder head (Stationable head) {
            this.head = head;
            return this;
        }

        public Builder tail (Stationable tail) {
            this.tail = tail;
            return this;
        }

        public Builder properties (EdgeProperties properties) {
            this.properties = properties;
            return this;
        }

        public Edgeable build () {
            return new Edge(head,tail, properties);
        }


    }
//
//    private final Stationable head;
//    private final Stationable tail;
//    private final EdgeProperties title;
//    private final Weightable weight;
//
//
//    public Edge (
//        Stationable head,
//        Stationable tail,
//        RoadIdentifier roadLabel,
//        Weightable weight
//    ) {
//        this.head = head;
//        this.tail = tail;
//        this.roadLabel = roadLabel;
//        this.weight = weight;
//    }
//
//    @Override
//    public Stationable getHead () {
//        return head;
//    }
//
//    @Override
//    public Stationable getTail () {
//        return tail;
//    }
//
//    @Override
//    public RoadIdentifier getRoadLabel () {
//        return roadLabel;
//    }
//
//    @Override
//    public Weightable getWeight () {
//        return weight;
//    }
//
//    public boolean equals (Object object) {
//        if (object == this) return true;
//        if (object == null) return false;
//        if (object instanceof Edgeable edgeable) {
//            return weight.equals(edgeable.getWeight())
//                && head.equals(edgeable.getHead())
//                && tail.equals(edgeable.getTail())
//                && roadLabel.equals(edgeable.getRoadLabel());
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode () {
//        return Objects.hash(weight, head, tail, roadLabel);
//    }
//
//    @Override
//    public String toString () {
//        return getClass().getSimpleName() + " weight:" + weight.toString()
//           + " head:" + head.getName() + " |-->" + " tail:" + tail.getName();
//    }
}
