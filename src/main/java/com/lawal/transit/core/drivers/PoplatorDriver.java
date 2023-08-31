package com.lawal.transit.core.drivers;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.entities.Block;
import com.lawal.transit.core.entities.Station;
import com.lawal.transit.core.singletons.Buildings;
import com.lawal.transit.graph.entities.Vertex;
import com.lawal.transit.graph.graphs.StationGraph;
import com.lawal.transit.core.populator.*;
import com.lawal.transit.graph.search.BreadthFirstSearch;


public class PoplatorDriver {

    public static String vertexInfo (StationGraph stationGraph,Vertex vertex) {
       String string = "";
        Station station = stationGraph.getStation(vertex);
        if (station != null) {
            Block block = station.getBlock();
            Road road = block.getBorderRoad(station.getOrientation());
            string += vertex
                + " inDegree:" + vertex.getInDegree()
                + " outDegree:" + vertex.getOutDegree()
                + " block:" + block.getName()
                + " " + road.toString()
                + " station: " + station.getOrientation().abbreviation()
                + " " + station.getBusDirection();
        }
        return string;
    }
    public static void main (String[] args) {
        RoadPopulator.INSTANCE.populate();
//        System.out.println("Roads\n-------" + Roads.INSTANCE.getBag().toString() + "\n");

        IntersectionPopulator.INSTANCE.populate();
//        System.out.println("Intersections\n-------" + Intersections.INSTANCE.getBag().toString() + "\n");

        BlockPopulator.INSTANCE.populate();

        StationPopulator.INSTANCE.populate();
        RegularBusRoutePopulator.INSTANCE.populate();
//        System.out.println("Regular Bus Routes\n--------" + RegularBusRoutes.INSTANCE.getBag().toString() + "\n");
//        System.out.println("Stations\n--------" + Stations.INSTANCE.getBag().toString() + "\n");

        BuildingPopulator.INSTANCE.populate();
        System.out.println("Buildings\n--------" + Buildings.INSTANCE.getBag().toString() + "\n");
//
//        System.out.println("Stations\n--------" + Stations.INSTANCE.getBag().toString() + "\n");
//        System.out.println("Blocks\n--------" + Blocks.INSTANCE.getBag().toString() + "\n");

        StationGraph stationGraph = new StationGraph();
        stationGraph.addStations();
//        System.out.println("Station Graph\n" + stationGraph.toString());
        for (Vertex vertex : stationGraph.getGraph().getVertices()) {
            if (vertex.getInDegree() < 2) {
                System.out.println(vertexInfo(stationGraph, vertex));
            }

            if (vertex.getOutDegree() < 2) {
                System.out.println(vertexInfo(stationGraph, vertex));
            }
//            System.out.println(vertex.getName() + " inDegree:" + vertex.getInDegree() + " outDegree:" + vertex.getOutDegree());
        }
//        BreadthFirstSearch<Station> breadthFirstSearch = new BreadthFirstSearch<Station>(stationGraph.getGraph(), stationGraph.getGraph().random());
    } // close main
} // end class PopulatorDriver