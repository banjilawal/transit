package com.lawal.transit;

import com.lawal.transit.catalog.*;

public class FactoryDriver {

    public static void main(String[] args) throws Exception {
        SystemBuilder.launcher();

//        RoadCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        AvenueCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        StreetCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        CurbCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        BlockCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        JunctionCatalog.INSTANCE.getCatalog().getJunctions().forEach(System.out::println);
//        StationCatalog.INSTANCE.getCatalog().getStations().forEach(System.out::println);
//        AddressCatalog.INSTANCE.getCatalog().forEach(System.out::println);
        JunctionCornerCatalog.INSTANCE.getCorners().forEach(System.out::println);
//        EdgeCatalog.INSTANCE.getCatalog().getEdges().forEach(System.out::println);
//        StationCatalog.INSTANCE.getCatalog().getStations().forEach(System.out::println);
    }
}