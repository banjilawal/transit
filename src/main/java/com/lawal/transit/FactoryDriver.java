package com.lawal.transit;

import com.lawal.transit.address.model.Address;
import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.catalog.*;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.navigtion.CurbEdgeFactory;
import com.lawal.transit.navigtion.FindCornerStation;
import com.lawal.transit.street.model.Street;

import java.util.List;


public class FactoryDriver {

    public static void main(String[] args) throws Exception {
        SystemBuilder.launcher();

        Street street = StreetCatalog.INSTANCE.findById(1L);
        Avenue avenue = AvenueCatalog.INSTANCE.findById(1L);
        Junction junction = JunctionCatalog.INSTANCE.findById(1L);

//        CurbEdgeFactory.processCurbs();
//        TurnNavigationTest.avenueTurningTest();
//        TurnNavigationTest.streetTurningTest();
//        FindCornerStation.launcher();
//        TransitRouteFactory.populate();

//        RoadCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        AvenueCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        StreetCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        CurbCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        BlockCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
        JunctionCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
        StationCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        AddressCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        List<Junction> junctions = JunctionCatalog.INSTANCE.filterByAvenue(avenue);
//        junctions.forEach(j -> {if(j.equals(junction)) j.getCorners().forEach(System.out::println);});
//        JunctionCornerCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        StationEdgeCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
        System.out.println(StationEdgeCatalog.INSTANCE.filterByAvenue(avenue).size());
        StationEdgeCatalog.INSTANCE.filterByStreet(street).forEach(System.out::println);
//        System.out.println(StationEdgeCatalog.INSTANCE.filterByStreet(street).size());
//        StationCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
        RouteCatalog.INSTANCE.filterByRoad(avenue.getRoad()).forEach(System.out::println);
        RouteCatalog.INSTANCE.filterByRoad(street.getRoad()).forEach(System.out::println);
//        System.out.println(RouteCatalog.INSTANCE.getCatalog().size());

        Address address = AddressCatalog.INSTANCE.findById(1L);
        Block block = address.getBlock();
        System.out.println(address);
        System.out.println(address.getBlock());
        List<Junction> junctions = JunctionCatalog.INSTANCE.filterByRoad(block.getCurb().getRoad());
    }
}