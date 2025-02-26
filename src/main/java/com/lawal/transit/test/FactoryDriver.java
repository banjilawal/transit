package com.lawal.transit.test;

import com.lawal.transit.catalog.*;
import com.lawal.transit.junction.Junction;
//import com.lawal.transit.road.creation.EdgePopulator;
import com.lawal.transit.road.creation.SystemBuilder;

public class FactoryDriver {

    public static void main(String[] args) throws Exception {
        SystemBuilder systemBuilder = new SystemBuilder();
        systemBuilder.buildAvenues();
        systemBuilder.buildStreets();
        systemBuilder.curbHelper();
        systemBuilder.buildJunctions();

//        AvenueCatalog.INSTANCE.getCatalog().getAvenues().forEach(System.out::println);
//        StreetCatalog.INSTANCE.getCatalog().getStreets().forEach(System.out::println);
//        CurbCatalog.INSTANCE.getCatalog().getCurbs().forEach(System.out::println);
//        BlockCatalog.INSTANCE.getCatalog().getList().forEach(System.out::println);
//        StationCatalog.INSTANCE.getCatalog().getStations().forEach(System.out::println);
        JunctionCornerCatalog.INSTANCE.getCorners().forEach(System.out::println);
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