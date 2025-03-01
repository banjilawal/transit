package com.lawal.transit;

import com.lawal.transit.address.model.Address;
import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.block.BlockGenerator;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.catalog.*;
import com.lawal.transit.curb.CurbGenerator;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.global.Constant;

import com.lawal.transit.global.Direction;
import com.lawal.transit.global.NameGenerator;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.junction.model.JunctionCorner;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.street.model.Street;

import java.util.concurrent.atomic.AtomicLong;


public class SystemBuilder {

    public static final int ADDRESS_INTERVAL = 2;
    public static final int NUMBER_OF_ADDRESSES_PER_BLOCK = 2;
    public static final int STATION_DENSITY = 32;

    private static AtomicLong roadId = new AtomicLong(0);
    private static AtomicLong avenueId = new AtomicLong(0);
    private static AtomicLong streetId = new AtomicLong(0);
    private static AtomicLong addressId = new AtomicLong(0);

    private static AtomicLong curbId = new AtomicLong(0);
    private static AtomicLong junctionId = new AtomicLong(0);
    private static AtomicLong junctionCornerId = new AtomicLong(0);

    public static void launcher() {
        buildAvenues();
        buildStreets();
        buildBlocks();
        buildJunctions();
        buildAddresses();
        buildJunctionCorners();;
    }

    private static void buildAvenues() {
        for (String name : Constant.AVENUE_NAMES) {
            Road road = new Road(roadId.incrementAndGet());
            Avenue avenue = new Avenue(avenueId.incrementAndGet(), name, road);
            RoadCatalog.INSTANCE.getCatalog().add(road);
            AvenueCatalog.INSTANCE.getCatalog().add(avenue);
        }
        CurbGenerator.generateAvenueCurbs();
    }

    private static void buildStreets() {
        for (int i = 0; i < AvenueCatalog.INSTANCE.getCatalog().size(); i++) {
            Road road = new Road(roadId.incrementAndGet());
            long id = streetId.incrementAndGet();
            Street street = new Street(id, NameGenerator.streetName(id), road);
            RoadCatalog.INSTANCE.getCatalog().add(road);
            StreetCatalog.INSTANCE.getCatalog().add(street);
        }
        CurbGenerator.generateStreetCurbs();
    }

    private static void buildBlocks() {
        BlockGenerator.generateBlocks();
    }

    private static void buildJunctions() {
        for (Avenue avenue : AvenueCatalog.INSTANCE.getCatalog()) {
            for (Street street : StreetCatalog.INSTANCE.getCatalog()) {
                Junction junction = new Junction(junctionId.incrementAndGet(), avenue, street);
                JunctionCatalog.INSTANCE.getCatalog().add(junction);
            }
        }
    }

    private static void buildAddresses() {
        for (Curb curb : CurbCatalog.INSTANCE.getCatalog()) {
            Avenue avenue = curb.getAvenue();
            Street street = curb.getStreet();

            int currentAddress = 2;
            if (avenue != null)
                currentAddress = avenue.getId().intValue() * Constant.MULTIPLICATION_FACTOR;
            else currentAddress = street.getId().intValue() * Constant.MULTIPLICATION_FACTOR;


            if (curb.getOrientation() == Avenue.LEFT_CURB_ORIENTATION || curb.getOrientation() == Street.LEFT_CURB_ORIENTATION)
                currentAddress += 1;

            for (Block block : curb.getBlocks()) {
                currentAddress = populateBlock(block, currentAddress, ADDRESS_INTERVAL, NUMBER_OF_ADDRESSES_PER_BLOCK);
            }
        }
    }

    public static int populateBlock (Block block, int startingAddressName, int addressInterval, int numberOfAddresses)  {

        int addressName = startingAddressName;

        for (int index = 0; index < numberOfAddresses; index++) {
            Address address = new Address(addressId.incrementAndGet(), (addressName + ""), block);
//            Address address  = new Address(addressId.incrementAndGet(), addressName + "", block);

            block.getAddresses().add(address);
            AddressCatalog.INSTANCE.getCatalog().add(address);
            addressName += addressInterval;
        }
        return addressName;
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
    private static void buildJunctionCorners () {
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