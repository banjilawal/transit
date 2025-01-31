package com.lawal.transit.test;


import com.lawal.transit.catalog.*;
import com.lawal.transit.global.Constant;
//import com.lawal.transit.junction.JunctionFactory;
import com.lawal.transit.junction.Junctions;
import com.lawal.transit.road.Avenue;
import com.lawal.transit.road.Avenues;
import com.lawal.transit.road.Streets;
import com.lawal.transit.road.creators.RoadFactory;


public class FactoryDriver {

    public static void main(String[] args) throws Exception {

        RoadFactory roadFactory = new RoadFactory()
            .avenueNames(Constant.AVENUE_NAMES)
            .placesPerBlock(Constant.PLACES_PER_BLOCK)
            .placeNameInterval(Constant.NAME_INFIX_INTERVAL);

        Avenues avenues = roadFactory.deliverAvenues();
        Streets streets = roadFactory.deliverStreets();

        for (Avenue avenue : avenues.getAvenues()) {
            System.out.println(avenue.label().toString() + "\n" + avenue.leftCurb().toString());
//            for (RoadSegment block : avenue.leftCurb().blocks().getList()) {
//                System.out.println("\t" + block.toString());
//            }
//            System.out.println();
//            System.out.printf("%d stations out of %d possibe\n", IdGenerator.INSTANCE.stationCount() - 1, 26 * 26 * 26);
//            System.out.println(avenue.leftCurb().toString() + "\n" + avenue.rightCurb().toString());
//            System.out.println(avenue.label().toString() + "\n" + avenue.leftCurb().toString() + "\n" + avenue.rightCurb().toString());
        }
//        RoadFactory roadFactory = new RoadFactory()
//            .avenueNames(new ArrayList<>(Arrays.asList(Constant.AVENUE_NAMES)))
//            .numberOfStreets(Constant.AVENUE_NAMES.length)
//            .placesPerBlock.
//
////        roadFactory.deliverAvenues();
//        Avenues avenues = roadFactory.deliverAvenues();

//        Streets streets = roadFactory.deliverStreets();
//        for (Street street : streets.getStreets()) {
//            System.out.println(street.label().toString());// + "\n" + street.rightCurb().toString());
//        }
//        Junctions junctions = new JunctionFactory().avenues(avenues).streets(streets).getProduct();
//        System.out.println(junctions.toString());

        StationCatalog.INSTANCE.getCatalog().getStations().forEach(System.out::println);
        AvenueCatalog.INSTANCE.getCatalog().getAvenues().forEach(System.out::println);
        StreetCatalog.INSTANCE.getCatalog().getStreets().forEach(System.out::println);
        BlockCatalog.INSTANCE.getCatalog().getList().forEach(System.out::println);
        PlaceCatalog.INSTANCE.getCatalog().forEach(System.out::println);
    }
}