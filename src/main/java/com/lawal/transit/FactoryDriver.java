package com.lawal.transit;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.catalog.*;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.junction.model.JunctionCorner;

import java.util.List;

public class FactoryDriver {

    public static void main(String[] args) throws Exception {
        SystemBuilder.launcher();

        Avenue avenue = AvenueCatalog.INSTANCE.findById(1L);
        Junction junction = JunctionCatalog.INSTANCE.findById(1L);

//        RoadCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        AvenueCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        StreetCatalog.INSTANCE.getCatalog().forEach(System.out::println);
        CurbCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        BlockCatalog.INSTANCE.getCatalog().forEach(System.out::println);
        JunctionCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
        StationCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        AddressCatalog.INSTANCE.getCatalog().forEach(System.out::println);
        List<Junction> junctions = JunctionCatalog.INSTANCE.filterByAvenue(avenue);
        for (Junction j : junctions) {
            if (j.equals(junction)) {
                for (JunctionCorner jc : j.getCorners())
                    System.out.println(jc);
            }
        }
//        JunctionCornerCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        EdgeCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        StationCatalog.INSTANCE.getCatalog().getStations().forEach(System.out::println);
    }
}