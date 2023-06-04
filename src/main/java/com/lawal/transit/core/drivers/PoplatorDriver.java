package com.lawal.transit.core.drivers;

import com.lawal.transit.core.populator.*;

public class PoplatorDriver {
    public static void main (String[] args) {
        RoadPopulator.INSTANCE.populate();
//        System.out.println(Roads.INSTANCE.fullString() + "\n");
        BlockPopulator.INSTANCE.populate();
//        System.out.println(Blocks.INSTANCE.toString() + "\n");
        BuildingPopulator.INSTANCE.populate();
//        BlockGrid.INSTANCE.populate();
//        System.out.println(Buildings.INSTANCE.toString() + "\n");
//        StationPopulator.INSTANCE.populate();
//        System.out.println(Stations.INSTANCE.toString() + "\n");
//        TransitRoutePopulator.INSTANCE.populate();
//        System.out.println(TransitRoutes.INSTANCE.toString() + "\n");
//        System.out.println(Stations.INSTANCE.toString() + "\n");
//        for (String name : Stations.INSTANCE.filter((Road) Avenues.INSTANCE.getBag().get(1))) {
//            System.out.println(name);
//        }
//        IntersectionPopulator.INSTANCE.populate();
//        System.out.println(Intersections.INSTANCE.toString());
//        System.out.println(Buildings.INSTANCE.search("1000", "Alpha").toString());

    } // close main
} // end class PopulatorDriver