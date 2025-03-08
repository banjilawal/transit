package com.lawal.transit;

import com.lawal.transit.address.model.Address;
import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.block.BlockGenerator;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.catalog.*;
import com.lawal.transit.curb.CurbGenerator;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.global.Constant;

import com.lawal.transit.global.NameGenerator;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.junction.model.JunctionCorner;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.route.TransitRouteFactory;
import com.lawal.transit.street.model.Street;

import java.util.concurrent.atomic.AtomicLong;


public class SystemBuilder {

    public static final int ADDRESS_INTERVAL = 2;
    public static final int NUMBER_OF_ADDRESSES_PER_BLOCK = 2;
    public static final int STATION_DENSITY = 43;

    private static AtomicLong roadId = new AtomicLong(0);
    private static AtomicLong avenueId = new AtomicLong(0);
    private static AtomicLong streetId = new AtomicLong(0);
    private static AtomicLong addressId = new AtomicLong(0);

    private static AtomicLong junctionId = new AtomicLong(0);
    private static AtomicLong junctionCornerId = new AtomicLong(0);

    public static void launcher() throws Exception {
        buildAvenues();
        buildStreets();
        buildBlocks();
        buildJunctions();
        buildAddresses();
        TransitRouteFactory.populate();
//        buildJunctionCorners();;
//        TurnNavigator.populateEdges();
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

                for (JunctionCorner junctionCorner : junction.getCorners()) {
                    junctionCorner.setId(junctionCornerId.incrementAndGet());
                    JunctionCornerCatalog.INSTANCE.getCatalog().add(junctionCorner);
                }
            }
        }
    }

    private static void buildAddresses() {
        for (Curb curb : CurbCatalog.INSTANCE.getCatalog()) {
            Avenue avenue = curb.getRoad().getAvenue();
            Street street = curb.getRoad().getStreet();

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

            block.getAddresses().add(address);
            AddressCatalog.INSTANCE.getCatalog().add(address);
            addressName += addressInterval;
        }
        return addressName;
    }
}