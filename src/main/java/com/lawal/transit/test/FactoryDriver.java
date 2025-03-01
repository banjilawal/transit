package com.lawal.transit.test;

import com.lawal.transit.catalog.*;
//import com.lawal.transit.road.creation.EdgePopulator;
import com.lawal.transit.SystemBuilder;

public class FactoryDriver {

    public static void main(String[] args) throws Exception {
        SystemBuilder.launcher();
//        SystemBuilder systemBuilder = new SystemBuilder();
//        systemBuilder.buildAvenues();
//        systemBuilder.buildStreets();
//        systemBuilder.buildBlocks();
//        systemBuilder.curbHelper();
//        systemBuilder.buildJunctions();

        RoadCatalog.INSTANCE.getCatalog().forEach(System.out::println);
        AvenueCatalog.INSTANCE.getCatalog().forEach(System.out::println);
        StreetCatalog.INSTANCE.getCatalog().forEach(System.out::println);
        CurbCatalog.INSTANCE.getCatalog().forEach(System.out::println);
        BlockCatalog.INSTANCE.getCatalog().forEach(System.out::println);
        JunctionCatalog.INSTANCE.getCatalog().getJunctions().forEach(System.out::println);
        StationCatalog.INSTANCE.getCatalog().getStations().forEach(System.out::println);
        AddressCatalog.INSTANCE.getCatalog().forEach(System.out::println);

//        BlockCatalog.INSTANCE.getCatalog().getList().forEach(System.out::println);
//        StationCatalog.INSTANCE.getCatalog().getStations().forEach(System.out::println);
//        EdgeCatalog.INSTANCE.getCatalog().getEdges().forEach(System.out::println);
//        JunctionCornerCatalog.INSTANCE.getCorners().forEach(System.out::println);
//        EdgePopulator.populateEdges();
//        JunctionCatalog.INSTANCE.getCatalog().getJunctions().forEach(System.out::println);
//        for (Junction junction : JunctionCatalog.INSTANCE.getCatalog().getJunctions()) {
//            System.out.println(junction.toString());
//            System.out.println("\t NE Ave Leg:" + junction.getNorthEastAveLeg().getTag());
//            System.out.println("\t NE Street Leg:" + junction.getNorthEastStreetLeg().getTag().toString());
//            System.out.println("\t NW Ave Leg:" + junction.getNorthWestAveLeg().getTag());
//            System.out.println("\t NW Street Leg:" + junction.getNorthWestStreetLeg().getTag().toString());
//
//            System.out.println(junction.toString());
//            System.out.println("\t SE Ave Leg:" + junction.getSouthEastAveLeg().getTag());
//            System.out.println("\t SE Street Leg:" + junction.getSouthEastStreetLeg().getTag().toString());
//            System.out.println("\t SW Ave Leg:" + junction.getSouthEastAveLeg().getTag());
//            System.out.println("\t SW Street Leg:" + junction.getNorthWestStreetLeg().getTag().toString());
//        }

    }
}