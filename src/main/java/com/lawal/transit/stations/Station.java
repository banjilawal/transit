package com.lawal.transit.stations;

import com.lawal.transit.addressing.Addressable;
import com.lawal.transit.graph.interfaces.Edgeables;
import com.lawal.transit.graph.interfaces.Vertex;
import com.lawal.transit.graph.VertexColor;

import java.util.*;

public final class Station implements Vertex {

    private VertexColor color;
    private Vertex predecessor;
    private final Addressable key;
    private final Edgeables incomingEdges;
    private final Edgeables outgoingEdges;

    private Station (Builder builder) {
        this.key = builder.key;
        this.color = builder.color;
        this.predecessor = builder.predecessor;
        this.incomingEdges = builder.incomingEdges;
        this.outgoingEdges = builder.outgoingEdges;
    }

    @Override
    public Addressable getKey () {
        return key;
    }

    @Override
    public VertexColor getColor () {
        return color;
    }

    @Override
    public Vertex getPredecessor () {
        return predecessor;
    }

    @Override
    public Edgeables getIncomingEdges () {
        return incomingEdges;
    }

    @Override
    public Edgeables getOutgoingEdges () {
        return outgoingEdges;
    }

    @Override
    public void setColor (VertexColor color) {
        this.color = color;
    }

    @Override
    public void setPredecessor (Vertex predecessor) {
        this.predecessor = predecessor;
    }

//    public void accept (Visitor visitor) {
//        visitor.visit(this);
//    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Station station)
            return key.equals(station.getKey());
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(key, color, incomingEdges.getDegree(), outgoingEdges.getDegree());
    }

    @Override
    public String toString () {
        return getClass().getSimpleName()
            + " id:" + key.id()
            + " name:" + key.name()
            + " color:" + color
            + " predecessor:" + predecessor.getKey().name()
            + " blockId:" + key.blockTag().id() + " " + key.blockTag().curbsideMarker().roadLabel();
    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {

        private Addressable key;
        private VertexColor color;
        private Vertex predecessor;
        private Edgeables incomingEdges;
        private Edgeables outgoingEdges;

        public Builder () {}

        public Builder key (Addressable key) {
            this.key = key;
            return this;
        }

        public Builder color (VertexColor color) {
            this.color = color;
            return this;
        }

        public Builder predecessor (Vertex predecessor) {
            this.predecessor = predecessor;
            return this;
        }

        public Builder incomingEdges (Edgeables incomingEdges) {
            this.incomingEdges = incomingEdges;
            return this;
        }

        public Builder outgoingEdges (Edgeables outgoingEdges) {
            this.outgoingEdges = outgoingEdges;
            return this;
        }

        public Station build () {
            return new Station(this);
        }
    }
}