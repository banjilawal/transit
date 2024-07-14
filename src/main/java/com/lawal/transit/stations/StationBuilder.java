package com.lawal.transit.stations;

import com.lawal.transit.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.graph.*;
import com.lawal.transit.graph.interfaces.*;
import com.lawal.transit.road.interfaces.*;

import java.util.*;

//public final class StationBuilder implements VertexBuildable {
//
//    private final FormattedAddress address;
//    private final EdgeCollection incomingEdges;
//    private final EdgeCollection outgoingEdges;
//
//    public StationBuilder (
//        EdgeCollection incomingEdges,
//        EdgeCollection outgoingEdges,
//        RoadIdentifiable roadIdentity,
//        Orientation orientation,
//        String name,
//        int id
//    ) throws Exception {
//        this.address = new Address(id, name, roadIdentity, orientation);
//        this.incomingEdges = setEdges(incomingEdges);
//        this.outgoingEdges = setEdges(outgoingEdges);
//    }
//
//    @Override
//    public FormattedAddress getAddress () {
//        return address;
//    }
//
//    @Override
//    public EdgeCollection getIncomingEdges () {
//        return incomingEdges;
//    }
//
//    @Override
//    public EdgeCollection getOutgoingEdges () {
//        return outgoingEdges;
//    }
//
//    @Override
//    public Vertex build () {
//        return new Station(address, incomingEdges , outgoingEdges);
//    }
//
//    private EdgeCollection setEdges (EdgeCollection collection) throws Exception {
//        EdgeCollection edges  = new Edges();
//        Iterator<Edgeable> iterator = collection.iterator();
//        while(iterator.hasNext()) {
//            edges.add(iterator.next());
//        }
//        return edges;
//    }
//
//}
