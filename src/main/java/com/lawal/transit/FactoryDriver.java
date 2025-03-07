package com.lawal.transit;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.catalog.*;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.navigtion.CurbEdgeFactory;
import com.lawal.transit.navigtion.FindCornerStation;
import com.lawal.transit.street.model.Street;


public class FactoryDriver {

    public static void main(String[] args) throws Exception {
        SystemBuilder.launcher();

        Street street = StreetCatalog.INSTANCE.findById(1L);
        Avenue avenue = AvenueCatalog.INSTANCE.findById(1L);
        Junction junction = JunctionCatalog.INSTANCE.findById(1L);

        CurbEdgeFactory.processCurbs();
//        TurnNavigationTest.avenueTurningTest();
//        TurnNavigationTest.streetTurningTest();
        FindCornerStation.launcher();

//        RoadCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        AvenueCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        StreetCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        CurbCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        BlockCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        JunctionCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        StationCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        AddressCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        List<Junction> junctions = JunctionCatalog.INSTANCE.filterByAvenue(avenue);
//        junctions.forEach(j -> {if(j.equals(junction)) j.getCorners().forEach(System.out::println);});
//        JunctionCornerCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
        EdgeCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
        EdgeCatalog.INSTANCE.filterByStreet(street).forEach(System.out::println);
 //       StationCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
    }
}