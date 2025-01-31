//package com.lawal.transit.junction;
//
////import com.lawal.transit.catalog.JunctionCatalog;
//import com.lawal.transit.global.IdGenerator;
//import com.lawal.transit.road.Avenue;
//import com.lawal.transit.road.Avenues;
//import com.lawal.transit.road.Street;
//import com.lawal.transit.road.Streets;
//
//public class JunctionFactory {
//
//    private Avenues avenues;
//    private Streets streets;
//
//    public JunctionFactory() {}
//
//    public Avenues getAvenues () {
//        return avenues;
//    }
//
//    public Streets getStreets () {
//        return streets;
//    }
//
//    public JunctionFactory avenues (Avenues avenues) {
//        this.avenues = avenues;
//        return this;
//    }
//
//    public JunctionFactory streets (Streets streets) {
//        this.streets = streets;
//        return this;
//    }
//
//    public Junctions getProduct () throws Exception {
//        Junctions junctions = new Junctions();
//        for (Avenue avenue : avenues.getAvenues()) {
//            for (Street street : streets.getStreets()) {
//                JunctionEntity junction = new Junction.Builder().id(IdGenerator.INSTANCE.nextJunctionId()).avenue(avenue)
//                    .street(street).build();
//                JunctionCatalog.INSTANCE.getCatalog().add(junction);
//                junctions.add(junction);
//            }
//        }
//        return junctions;
//    }
//}