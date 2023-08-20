package com.lawal.transit.core.drivers;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.graphs.StationGraph;
import com.lawal.transit.core.populator.*;
import com.lawal.transit.core.singletons.*;

public class PoplatorDriver {
    public static void main (String[] args) {
        RoadPopulator.INSTANCE.populate();
        System.out.println("Roads\n-------" + Roads.INSTANCE.getBag().toString() + "\n");

        IntersectionPopulator.INSTANCE.populate();
        System.out.println("Intersections\n-------" + Intersections.INSTANCE.getBag().toString() + "\n");

        BlockPopulator.INSTANCE.populate();

        StationPopulator.INSTANCE.populate();
        RegularBusRoutePopulator.INSTANCE.populate();
        System.out.println("Regular Bus Routes\n--------" + RegularBusRoutes.INSTANCE.getBag().toString() + "\n");
//        System.out.println("Stations\n--------" + Stations.INSTANCE.getBag().toString() + "\n");

        BuildingPopulator.INSTANCE.populate();
        System.out.println("Buildings\n--------" + Buildings.INSTANCE.getBag().toString() + "\n");

        System.out.println("Stations\n--------" + Stations.INSTANCE.getBag().toString() + "\n");
        System.out.println("Blocks\n--------" + Blocks.INSTANCE.getBag().toString() + "\n");

        StationGraph stationGraph = new StationGraph();
        stationGraph.addStations();
        System.out.println("Station Graph\n" + stationGraph.toString());
    } // close main
} // end class PopulatorDriver