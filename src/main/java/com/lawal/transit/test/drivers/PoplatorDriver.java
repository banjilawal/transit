package com.lawal.transit.test.drivers;

import com.lawal.transit.core.singletons.*;
import com.lawal.transit.test.populator.*;


public class PoplatorDriver {

//    public static String vertexInfo (StationGraph stationGraph,Vertex vertex) {
//       String string = "";
//        Station station = stationGraph.getStation(vertex);
//        if (station != null) {
//            Block block = station.getBlock();
//            Road road = block.getBorderRoad(station.getOrientation());
//            string += vertex
//                + " inDegree:" + vertex.getInDegree()
//                + " outDegree:" + vertex.getOutDegree()
//                + " block:" + block.getName()
//                + " " + road.toString()
//                + " station: " + station.getOrientation().abbreviation()
//                + " " + station.getBusDirection();
//        }
//        return string;
//    }
    public static void main (String[] args) {
        RoadPopulator.INSTANCE.populate();
        System.out.println(Roads.INSTANCE.toString() + "\n");

        IntersectionPopulator.INSTANCE.populate();
        System.out.println(Intersections.INSTANCE.toString() + "\n");

        BlockPopulator.INSTANCE.populate();
        StationPopulator.INSTANCE.populate();
        RegularBusRoutePopulator.INSTANCE.populate();
        BuildingPopulator.INSTANCE.populate();

        System.out.println(RegularBusRoutes.INSTANCE.toString() + "\n");
        System.out.println(Buildings.INSTANCE.toString() + "\n");
        System.out.println(Stations.INSTANCE.toString() + "\n");
        System.out.println(Blocks.INSTANCE.toString() + "\n");
//
//        StationGraph stationGraph = new StationGraph();
//        stationGraph.addStations();
//        System.out.println("Station Graph\n" + stationGraph.toString());
//        for (Vertex vertex : stationGraph.getGraph().getVertices()) {
//            if (vertex.getInDegree() < 2) {
//                System.out.println(vertexInfo(stationGraph, vertex));
//            }
//
//            if (vertex.getOutDegree() < 2) {
//                System.out.println(vertexInfo(stationGraph, vertex));
//            }
//            System.out.println(vertex.getName() + " inDegree:" + vertex.getInDegree() + " outDegree:" + vertex.getOutDegree());
//        }
//       BreadthFirstSearch<Station> breadthFirstSearch = new BreadthFirstSearch<Station>(stationGraph.getGraph(), stationGraph.getGraph().random());
    } // close main
} // end class PopulatorDriver