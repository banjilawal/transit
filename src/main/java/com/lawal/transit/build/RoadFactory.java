package com.lawal.transit.build;

import com.lawal.transit.address.model.Address;
import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.catalog.*;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.global.Constant;
import com.lawal.transit.global.NameGenerator;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.station.model.Station;
import com.lawal.transit.street.model.Street;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public enum RoadFactory {
    INSTANCE;

    private final AtomicLong roadId = new AtomicLong(0);
    private final AtomicLong avenueId = new AtomicLong(0);
    private final AtomicLong streetId = new AtomicLong(0);
    private final AtomicLong curbId = new AtomicLong(0);
    private final AtomicLong blockId = new AtomicLong(0);
    private final AtomicLong stationId = new AtomicLong(0);
    private final AtomicLong addressId = new AtomicLong(0);

    private static final int MAX_STATION_DENSITY = 65;
    private static final int NUMBER_OF_ADDRESSES_PER_BLOCK = 2;
    private static final int ADDRESS_INTERVAL = 2;

    private int addressCreationHelper(Block block, int startingAddressName, int addressInterval, int numberOfAddresses)  {

        int addressName = startingAddressName;

        for (int index = 0; index < numberOfAddresses; index++) {
            Address address = new Address(addressId.incrementAndGet(), (addressName + ""), block);

            block.getAddresses().add(address);
            AddressCatalog.INSTANCE.addAddress(address);
            addressName += addressInterval;
        }
        return addressName;
    }

    private void buildAddresses(Curb curb) {
        if (curb == null || curb.getBlocks() == null) return;
        if (curb.getAvenue() == null && curb.getStreet() == null) return;

        int addressName = 0;
        if (curb.getRoad().getAvenue() != null) {
            addressName = avenueId.intValue() * Constant.MULTIPLICATION_FACTOR;
        } else {
            addressName = streetId.intValue() * Constant.MULTIPLICATION_FACTOR;
        }

        if (curb.getOrientation() == Avenue.LEFT_CURB_ORIENTATION || curb.getOrientation() == Street.LEFT_CURB_ORIENTATION)
            addressName += 1;

        for (Block block : curb.getBlocks()) {
            addressName = addressCreationHelper(block, addressName, ADDRESS_INTERVAL, NUMBER_OF_ADDRESSES_PER_BLOCK);
        }
    }

    private void buildStations(Curb curb, int percentStationDensity) {
        for (Block block : curb.getBlocks()) {
            if (new Random().nextInt(101) <= percentStationDensity) {
                Station station = new Station(stationId.incrementAndGet(), NameGenerator.INSTANCE.stationName(curb.getOrientation()), block);
                StationCatalog.INSTANCE.addStation(station);
            }
        }
    }

    private void blockCreationHelper(Curb curb, int numberOfBlocks) {
        if (curb == null) return;

        for (int index = 0; index < numberOfBlocks; index++) {
            String blockName = "Block-" + (curb.getBlocks().size() + 1) * Constant.MULTIPLICATION_FACTOR;
            Block block = new Block(blockId.incrementAndGet(), blockName, curb);
            BlockCatalog.INSTANCE.addBlock(block);
        }
        buildStations(curb, MAX_STATION_DENSITY);
    }

    private void blockBlocks () {
        if (CurbCatalog.INSTANCE.getCatalog() == null) return;

        for (Curb curb : CurbCatalog.INSTANCE.getCatalog()) {
            blockCreationHelper(curb, AvenueCatalog.INSTANCE.size());
        }
    }

    private void buildCurbs (Road road) {
        if (road == null) return;

        if (road.getAvenue() != null) {
            Curb leftCurb = new Curb(curbId.incrementAndGet(), Avenue.LEFT_CURB_ORIENTATION, road, null);
            Curb rightCurb = new Curb(curbId.incrementAndGet(), Avenue.RIGHT_CURB_ORIENTATION, null, road);
            CurbCatalog.INSTANCE.addCurb(leftCurb);
            CurbCatalog.INSTANCE.addCurb(rightCurb);
        }
        else if (road.getStreet() != null) {
            Curb leftCurb = new Curb(curbId.incrementAndGet(), Street.LEFT_CURB_ORIENTATION, road, null);
            Curb rightCurb = new Curb(curbId.incrementAndGet(), Street.RIGHT_CURB_ORIENTATION, null, road);
            CurbCatalog.INSTANCE.addCurb(leftCurb);
            CurbCatalog.INSTANCE.addCurb(rightCurb);
        } else {
            System.out.println("Cannot create curbs for a road with avenue and curb null");
        }
    }

    private void buildStreets() {
        for (int index = 0; index < AvenueCatalog.INSTANCE.size(); index++) {
            Road road = new Road(roadId.incrementAndGet());

            long id = streetId.incrementAndGet();
            Street street = new Street(id, NameGenerator.streetName(id), road);
            buildCurbs(road);

            RoadCatalog.INSTANCE.addRoad(road);
            StreetCatalog.INSTANCE.addStreet(street);
        }
    }

    private void buildAvenues() {

        for (String name : Constant.AVENUE_NAMES) {
            Road road = new Road(roadId.incrementAndGet());
            Avenue avenue = new Avenue(avenueId.incrementAndGet(), name, road);
            buildCurbs(road);

            RoadCatalog.INSTANCE.addRoad(road);
            AvenueCatalog.INSTANCE.addAvenue(avenue);
        }
    }

    public void run() {
        buildAvenues();
        buildStreets();
        blockBlocks();
    }
}