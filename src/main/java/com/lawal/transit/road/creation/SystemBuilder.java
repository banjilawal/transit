package com.lawal.transit.road.creation;

import com.lawal.transit.catalog.*;
import com.lawal.transit.global.Constant;

import com.lawal.transit.global.Direction;
import com.lawal.transit.global.NameGenerator;
import com.lawal.transit.junction.Junction;
import com.lawal.transit.junction.JunctionCorner;
import com.lawal.transit.road.*;


import java.util.concurrent.atomic.AtomicInteger;


public class SystemBuilder {

    private static final int ADDRESS_INTERVAL = 2;
    private static final int NUMBER_OF_ADDRESSES_PER_BLOCK = 2;
    private static final int STATION_DENSITY = 32;

    private AtomicInteger avenueId = new AtomicInteger(0);
    private AtomicInteger streetId = new AtomicInteger(0);

    private AtomicInteger curbId = new AtomicInteger(0);
    private AtomicInteger junctionId = new AtomicInteger(0);
    private AtomicInteger junctionCornerId = new AtomicInteger(0);
//    private String roadName;
//    private int numberOfBlocks;
//    private int placesPerBlock;
//    private int placeNameInterval;
//
//    private RoadLabel roadLabel;
//    private RoadCategory roadCategory;
//    private PopulateCurb populateCurb;
//
//    public SystemBuilder () {}
//
//    public int getRoadId () {
//        return roadId;
//    }
//
//    public String getRoadName () {
//        return roadName;
//    }
//
//    public int getNumberOfBlocks () {
//        return numberOfBlocks;
//    }
//
//    public int getPlacesPerBlock () {
//        return placesPerBlock;
//    }
//
//    public int getPlaceNameInterval () {
//        return placeNameInterval;
//    }
//
//    public RoadCategory getRoadCategory () {
//        return roadCategory;
//    }
//
//    public SystemBuilder roadId(int roadId) {
//        this.roadId = roadId;
//        return this;
//    }
//
//    public SystemBuilder roadName(String roadName) {
//        this.roadName = roadName;
//        return this;
//    }
//
//    public SystemBuilder numberOfBlocks (int numberOfBlocks) {
//        this.numberOfBlocks = numberOfBlocks;
//        return this;
//    }
//
//    public SystemBuilder placesPerBlock(int placesPerBlock) {
//        this.placesPerBlock = placesPerBlock;
//        return this;
//    }
//
//    public SystemBuilder placeNameInterval (int placeNameInterval) {
//        this.placeNameInterval = placeNameInterval;
//        return this;
//    }
//
//    public SystemBuilder roadCategory(RoadCategory roadCategory) {
//        this.roadCategory = roadCategory;
//        return this;
//    }

    public void buildAvenues () {
        for (String name : Constant.AVENUE_NAMES) {
            RoadLabel roadLabel = new RoadLabel(avenueId.incrementAndGet(), name, RoadCategory.AVENUE);
            Avenue avenue = new Avenue(roadLabel, curbId.incrementAndGet(), curbId.incrementAndGet());
            AvenueCatalog.INSTANCE.getCatalog().getAvenues().add(avenue);
        }
    }

    public void buildStreets () {
        for (int i = 0; i < AvenueCatalog.INSTANCE.getCatalog().getAvenues().size(); i++) {
            int id = streetId.incrementAndGet();
            RoadLabel roadLabel = new RoadLabel(id, NameGenerator.streetName(id), RoadCategory.STREET);
            Street street = new Street(roadLabel, curbId.incrementAndGet(), curbId.incrementAndGet());
            StreetCatalog.INSTANCE.getCatalog().getStreets().add(street);
        }
    }

    public void curbHelper () {
        for (Avenue avenue : AvenueCatalog.INSTANCE.getCatalog().getAvenues()) {
            curbBuilder(avenue.leftCurb(), avenue.label().id() * Constant.MULTIPLICATION_FACTOR + 1);
            curbBuilder(avenue.rightCurb(), avenue.label().id() * Constant.MULTIPLICATION_FACTOR);
        }

        for (Street street : StreetCatalog.INSTANCE.getCatalog().getStreets()) {
            curbBuilder(street.leftCurb(), street.label().id() * Constant.MULTIPLICATION_FACTOR + 1);
            curbBuilder(street.rightCurb(), street.label().id() * Constant.MULTIPLICATION_FACTOR);
        }
    }

    public void curbBuilder (Curb curb, int startingAddress) {
        PopulateCurb.createBlocks(
            curb,
            AvenueCatalog.INSTANCE.getCatalog().size(),
            ADDRESS_INTERVAL,
            NUMBER_OF_ADDRESSES_PER_BLOCK,
            startingAddress
        );
        PopulateCurb.createStations(curb, STATION_DENSITY);
        CurbCatalog.INSTANCE.getCatalog().getCurbs().add(curb);
    }

    public void buildJunctions () {
        for (Avenue avenue : AvenueCatalog.INSTANCE.getCatalog().getAvenues()) {
            for (Street street : StreetCatalog.INSTANCE.getCatalog().getStreets()) {
                Junction junction = new Junction(junctionId.incrementAndGet(), avenue, street);
                JunctionCatalog.INSTANCE.getCatalog().add(junction);
            }
        }
        buildJunctionCorners();
    }

    public void buildJunctionCorners () {
        for (Junction junction : JunctionCatalog.INSTANCE.getCatalog().getJunctions()) {
            JunctionCorner nwCorner = new JunctionCorner(junctionCornerId.incrementAndGet(), junction, Direction.NORTHWEST);
//            System.out.println("nw corner:" + nwCorner.toString());
            JunctionCornerCatalog.INSTANCE.getCatalog().add(nwCorner);

            JunctionCorner swCorner = new JunctionCorner(junctionId.incrementAndGet(), junction, Direction.SOUTHWEST);
//            System.out.println("sw corner:" + swCorner.toString());
            JunctionCornerCatalog.INSTANCE.getCatalog().add(swCorner);

            JunctionCorner neCorner = new JunctionCorner(junctionId.incrementAndGet(), junction, Direction.NORTHEAST);
//            System.out.println("ne corner:" + neCorner.toString());
            JunctionCornerCatalog.INSTANCE.getCatalog().add(neCorner);

            JunctionCorner seCorner = new JunctionCorner(junctionId.incrementAndGet(), junction, Direction.SOUTHEAST);
//            System.out.println("se corner:" + seCorner.toString());
            JunctionCornerCatalog.INSTANCE.getCatalog().add(seCorner);
        }
    }
}