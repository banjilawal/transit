package com.lawal.transit.stations;

import com.lawal.transit.addressing.Addressable;
import com.lawal.transit.graph.Edges;
import com.lawal.transit.graph.interfaces.Edgeables;
import com.lawal.transit.graph.interfaces.Vertex;
import com.lawal.transit.graph.VertexColor;
import lombok.*;

import java.util.*;

@Getter
@Setter
@EqualsAndHashCode(of = {"key"})
public final class Station implements Vertex {

    private int discoveryTime;
    private int finishTime;
    private VertexColor color;
    private Vertex predecessor;

    @Setter(AccessLevel.NONE)
    private final Addressable key;

    @Setter(AccessLevel.NONE)
    private final Edgeables incomingEdges;

    @Setter(AccessLevel.NONE)
    private final Edgeables outgoingEdges;

//    public Station (Builder builder) { this(builder.key); }

    public Station (Addressable key) {
        this.key = key;

        this.discoveryTime = -1;
        this.finishTime = -1;
        this.predecessor = null;
        this.color = VertexColor.WHITE;
        this.incomingEdges = new Edges();
        this.outgoingEdges =new Edges();
    }

//    @Override
//    public int getDiscoveryTime () { return discoveryTime; }
//
//    @Override
//    public int getFinishTime () { return finishTime; }
//
//    @Override
//    public Addressable getKey () {
//        return key;
//    }
//
//    @Override
//    public VertexColor getColor () {
//        return color;
//    }
//
//    @Override
//    public Vertex getPredecessor () {
//        return predecessor;
//    }
//
//    @Override
//    public Edgeables getIncomingEdges () {
//        return incomingEdges;
//    }
//
//    @Override
//    public Edgeables getOutgoingEdges () {
//        return outgoingEdges;
//    }
//
//    @Override
//    public void setDiscoveryTime (int discoveryTime) { this.discoveryTime = discoveryTime; }
//
//    @Override
//    public void setFinishTime (int finishTime) { this.finishTime = finishTime; }
//
//    @Override
//    public void setColor (VertexColor color) {
//        this.color = color;
//    }
//
//    @Override
//    public void setPredecessor (Vertex predecessor) {
//        this.predecessor = predecessor;
//    }
//
//    @Override
//    public boolean equals (Object object) {
//        if (this == object) return true;
//        if (object == null) return false;
//        if (object instanceof Station station)
//            return key.equals(station.getKey());
//        return false;
//    }
//
//    @Override
//    public int hashCode () {
//        return Objects.hash(key, color, incomingEdges.getDegree(), outgoingEdges.getDegree());
//    }

    @Override
    public String toString () {
        String predecessorName = predecessor == null ? " predecessor:null" : " predecessor:" + predecessor.getKey().name();
        return getClass().getSimpleName()
            + " id:" + key.id()
            + " name:" + key.name()
            + " color:" + color.print()
            + predecessorName
//            + " predecessor:" + predecessor.getKey().name()
            + " blockId:" + key.blockTag().id() + " " + key.blockTag().curbsideMarker().roadLabel()
            + " inDegree:" + incomingEdges.getDegree() + " outDegree:" + outgoingEdges.getDegree();
    }
//
//    public static Builder builder () {
//        return new Builder();
//    }
//
//    public static class Builder {
//
//        private Addressable key;
//
//        public Builder () {}
//
//        public Builder key (Addressable key) {
//            this.key = key;
//            return this;
//        }
//
//        public Station build () {
//            return new Station(this);
//        }
//    }
}