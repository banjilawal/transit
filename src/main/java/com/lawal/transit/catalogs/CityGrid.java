//package com.lawal.transit.catalogs;
//
//import com.lawal.transit.creation.RoadFactory;
//import com.lawal.transit.junctions.Junctions;
//import com.lawal.transit.roads.Avenues;
//import com.lawal.transit.roads.Streets;
//import com.lawal.transit.roads.interfaces.RoadSystem;
//
//public final class CityGrid implements RoadSystem {
//
//    private final Avenues avenues;
//    private final Streets streets;
//    private final Junctions junctions;
//
//    public CityGrid(RoadFactory roadFactory) throws Exception {
//        avenues = roadFactory.deliverAvenues();
//        streets = roadFactory.deliverStreets();
//        junctions = new Junctions();
//    }
//
//    @Override
//    public Avenues getAvenues() {
//        return avenues;
//    }
//
//    @Override
//    public Streets getStreets() {
//        return streets;
//    }
//
//    @Override
//    public Junctions getJunctions() {
//        return junctions;
//    }
//}