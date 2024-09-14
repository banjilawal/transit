//package com.lawal.transit.graph;
//
//import com.lawal.transit.graph.Edges;
//import com.lawal.transit.edges.interfaces.*;
//import com.lawal.transit.stations.*;
//import com.lawal.transit.stations.interfaces.*;
//
//public final class StationMap implements StationableGraph {
//
//    private final Stationables nodes;
//    private final Edgeables edges;
//
//    public StationMap () {
//        this.nodes = new Stations();
//        this.edges = new Edges();
//    }
//    @Override
//    public Stationables getNodes () {
//        return nodes;
//    }
//
//    @Override
//    public Edgeables getEdges () {
//        return edges;
//    }
//}