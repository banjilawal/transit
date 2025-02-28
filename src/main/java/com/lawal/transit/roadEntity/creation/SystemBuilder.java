package com.lawal.transit.roadEntity.creation;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.catalog.*;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.global.Constant;

import com.lawal.transit.global.Direction;
import com.lawal.transit.global.NameGenerator;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.junction.model.JunctionCorner;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.roadEntity.*;
import com.lawal.transit.street.model.Street;

import java.util.concurrent.atomic.AtomicLong;


public class SystemBuilder {

    private static final int ADDRESS_INTERVAL = 2;
    private static final int NUMBER_OF_ADDRESSES_PER_BLOCK = 2;
    private static final int STATION_DENSITY = 32;

    private AtomicLong roadId = new AtomicLong(0);
    private AtomicLong avenueId = new AtomicLong(0);
    private AtomicLong streetId = new AtomicLong(0);

    private AtomicLong curbId = new AtomicLong(0);
    private AtomicLong junctionId = new AtomicLong(0);
    private AtomicLong junctionCornerId = new AtomicLong(0);

    public void buildAvenues () {
        for (String name : Constant.AVENUE_NAMES) {
            Road road = new Road(roadId.incrementAndGet());
            Avenue avenue = new Avenue(avenueId.incrementAndGet(), name, road);
            AvenueCatalog.INSTANCE.getCatalog().getAvenues().add(avenue);
        }
    }

    public void buildStreets () {
        for (int i = 0; i < AvenueCatalog.INSTANCE.getCatalog().getAvenues().size(); i++) {
            long id = streetId.incrementAndGet();
            Street street = new Street(id, NameGenerator.streetName(id), new Road(roadId.incrementAndGet()));
            StreetCatalog.INSTANCE.getCatalog().getStreets().add(street);
        }
    }
//
//    public void curbHelper () {
//        for (Avenue avenue : AvenueCatalog.INSTANCE.getCatalog().getAvenues()) {
//            Road road = avenue.getRoad();
//
//            curbBuilder(Avenue.LEFT_CURB_ORIENTATION, road, avenue.getId() * Constant.MULTIPLICATION_FACTOR + 1);
//            curbBuilder(Avenue.RIGHT_CURB_ORIENTATION, road,  avenue.getId() * Constant.MULTIPLICATION_FACTOR);
//        }
//
//        for (Street street : StreetCatalog.INSTANCE.getCatalog().getStreets()) {
//            curbBuilder(street.leftCurb(), street.getId() * Constant.MULTIPLICATION_FACTOR + 1);
//            curbBuilder(street.rightCurb(), street.getId() * Constant.MULTIPLICATION_FACTOR);
//        }
//    }
//
//    public void curbBuilder (Direction curbOrientation, Road road, int startingAddress) {
//        Curb curb = new Curb()
//        PopulateCurb.createBlocks(
//            AvenueCatalog.INSTANCE.getCatalog().size(),
//            ADDRESS_INTERVAL,
//            NUMBER_OF_ADDRESSES_PER_BLOCK,
//            startingAddress
//        );
//        PopulateCurb.createStations(curb, STATION_DENSITY);
//        CurbCatalog.INSTANCE.getCatalog().getCurbs().add(curb);
//    }
//
//    public void buildJunctions () throws Exception {
//        for (Avenue avenue : AvenueCatalog.INSTANCE.getCatalog().getAvenues()) {
//            for (Street street : StreetCatalog.INSTANCE.getCatalog().getStreets()) {
//                Junction junction = new Junction(junctionId.incrementAndGet(), avenue, street);
//                JunctionCatalog.INSTANCE.getCatalog().add(junction);
//            }
//        }
//        buildJunctionCorners();
//        EdgePopulator.populateEdges();
//    }
//
//    public void buildJunctionCorners () {
//        for (Junction junction : JunctionCatalog.INSTANCE.getCatalog().getJunctions()) {
//            JunctionCorner nwCorner = new JunctionCorner(junctionCornerId.incrementAndGet(), junction, Direction.NORTHWEST);
////            System.out.println("nw corner:" + nwCorner.toString());
//            JunctionCornerCatalog.INSTANCE.getCatalog().add(nwCorner);
//
//            JunctionCorner swCorner = new JunctionCorner(junctionId.incrementAndGet(), junction, Direction.SOUTHWEST);
////            System.out.println("sw corner:" + swCorner.toString());
//            JunctionCornerCatalog.INSTANCE.getCatalog().add(swCorner);
//
//            JunctionCorner neCorner = new JunctionCorner(junctionId.incrementAndGet(), junction, Direction.NORTHEAST);
////            System.out.println("ne corner:" + neCorner.toString());
//            JunctionCornerCatalog.INSTANCE.getCatalog().add(neCorner);
//
//            JunctionCorner seCorner = new JunctionCorner(junctionId.incrementAndGet(), junction, Direction.SOUTHEAST);
////            System.out.println("se corner:" + seCorner.toString());
//            JunctionCornerCatalog.INSTANCE.getCatalog().add(seCorner);
//        }
//    }
}