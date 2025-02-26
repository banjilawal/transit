package com.lawal.transit.station;

import com.lawal.transit.block.Block;
import com.lawal.transit.address.Address;
import com.lawal.transit.graph.Edges;
import com.lawal.transit.graph.contract.Edgeables;
import com.lawal.transit.graph.contract.Vertex;
import com.lawal.transit.graph.VertexColor;
import com.lawal.transit.road.Curb;
import com.lawal.transit.road.contract.Road;
import lombok.*;

@Data
@EqualsAndHashCode(of = {"address"})
public final class Station implements Vertex {

    private final int id;
    private final String name;

    private int discoveryTime;
    private int finishTime;
    private VertexColor color;
    private Vertex predecessor;
    private Block block;

    @Setter(AccessLevel.NONE)
    private final Address address;

    @Setter(AccessLevel.NONE)
    private final Edges incomingEdges;

    @Setter(AccessLevel.NONE)
    private final Edges outgoingEdges;

    public Station (Address address, Block block) {
        this.id = address.id();
        this.name = address.name();
        this.address = address;
        this.block = block;
        this.discoveryTime = -1;
        this.finishTime = -1;
        this.predecessor = null;
        this.color = VertexColor.WHITE;
        this.incomingEdges = new Edges();
        this.outgoingEdges =new Edges();
    }

    public Curb getCurb () { return block.getCurb(); }

    public Road getRoad () { return block.getCurb().getRoad(); }

//    @Override
//    public int getDiscoveryTime () { return discoveryTime; }
//
//    @Override
//    public int getFinishTime () { return finishTime; }
//
//    @Override
//    public AddressEntity getKey () {
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
//        String predecessorName = predecessor == null ? " predecessor:null" : " predecessor:" + predecessor.getAddress().name();
        return getClass().getSimpleName()
            + "[id:" + id
            + " name:" + name
            + " (" + block.getName()
            + " blockId:" + block.getId()
            + ") curbId:" + block.getCurb().getId()
            + " " + block.getCurb().getRoad().toString()
            + " " + block.getCurb().getOrientation().print() + "]"
            + " in degree:" + incomingEdges.getDegree() + " out degree:" + outgoingEdges.getDegree();
    }
}