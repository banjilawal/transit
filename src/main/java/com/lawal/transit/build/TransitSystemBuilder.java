package com.lawal.transit.build;

import com.lawal.transit.global.Direction;
import com.lawal.transit.house.model.House;
import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.catalog.*;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.global.Constant;
import com.lawal.transit.global.NameGenerator;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.junction.model.JunctionCorner;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.station.model.Station;
import com.lawal.transit.street.model.Street;

import java.util.EnumSet;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public enum TransitSystemBuilder {
    INSTANCE;

    private final AtomicLong roadId = new AtomicLong(0);
    private final AtomicLong avenueId = new AtomicLong(0);
    private final AtomicLong streetId = new AtomicLong(0);
    private final AtomicLong curbId = new AtomicLong(0);
    private final AtomicLong blockId = new AtomicLong(0);
    private final AtomicLong stationId = new AtomicLong(0);
    private final AtomicLong houseId = new AtomicLong(0);
    private final AtomicLong junctionId = new AtomicLong(0);
    private final AtomicLong junctionCornerId = new AtomicLong(0);

    private static final int MAX_STATION_DENSITY = 30;
    private static final int NUMBER_OF_HOUSES_PER_BLOCK = 2;
    private static final int ADDRESS_INTERVAL = 2;

    public void run() {
        buildAvenues();
        buildStreets();
        buildBlocks();
        buildJunctions();
        StationEdgeFactory.INSTANCE.run();
        BlockEdgeFactory.INSTANCE.run();
        TransitRouteFactory.INSTANCE.run();
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
            System.out.println("Cannot build curbs for a road with avenue and curb null");
        }
    }

    private void buildBlocks () {
        if (CurbCatalog.INSTANCE.getCatalog() == null) return;

        for (Curb curb : CurbCatalog.INSTANCE.getCatalog()) {
            blockCreationHelper(curb, AvenueCatalog.INSTANCE.size());
            buildStations(curb, MAX_STATION_DENSITY);
            buildHouses(curb);
        }
    }

    private void blockCreationHelper(Curb curb, int numberOfBlocks) {
        if (curb == null) return;

        for (int index = 0; index < numberOfBlocks; index++) {
            String blockName = "Block-" + (curb.getBlocks().size() + 1) * Constant.MULTIPLICATION_FACTOR;
            Block block = new Block(blockId.incrementAndGet(), blockName, curb);
            BlockCatalog.INSTANCE.addBlock(block);
        }
    }

    private void buildStations(Curb curb, int percentStationDensity) {
        for (Block block : curb.getBlocks()) {
            int outcome = new Random().nextInt(101);
            if ( outcome < percentStationDensity) {
                System.out.println("outcome: " + outcome + " adding station");
                Station station = new Station(stationId.incrementAndGet(), NameGenerator.INSTANCE.stationName(curb.getOrientation()), block);
                StationCatalog.INSTANCE.addStation(station);
            }
        }
    }

    private void buildHouses(Curb curb) {
        if (curb == null || curb.getBlocks() == null) return;
        if (curb.getAvenue() == null && curb.getStreet() == null) return;

        long address = 0L;
        if (curb.getRoad().getAvenue() != null) {
            address = (long) avenueId.intValue() * Constant.MULTIPLICATION_FACTOR;
        } else {
            address = (long) streetId.intValue() * Constant.MULTIPLICATION_FACTOR;
        }

        if (curb.getOrientation() == Avenue.LEFT_CURB_ORIENTATION || curb.getOrientation() == Street.LEFT_CURB_ORIENTATION)
            address += 1;

        Block previousBlock = curb.getBlocks().get(0);
        for (Block block : curb.getBlocks()) {
            putHousesOnBlock(block, address, ADDRESS_INTERVAL, NUMBER_OF_HOUSES_PER_BLOCK);
            previousBlock = block;
            address = previousBlock.getLastHouse().getAddress() + ADDRESS_INTERVAL;
        }
    }

    private void putHousesOnBlock(Block block, long address, int addressInterval, int numberOfHouses)  {
        if (block == null) return;

        for (int index = 0; index < numberOfHouses; index++) {
            House house = new House(houseId.incrementAndGet(), address, block);
            HouseCatalog.INSTANCE.addHouse(house);
            address += addressInterval;
        }
    }

    private void buildJunctions () {
        for (Avenue avenue : AvenueCatalog.INSTANCE.getCatalog()) {
            for (Street street : StreetCatalog.INSTANCE.getCatalog()) {
                Junction junction = new Junction(junctionId.incrementAndGet(), avenue, street);

                buildJunctionCorners(junction);
                JunctionCatalog.INSTANCE.addJunction(junction);
            }
        }
    }

    private void buildJunctionCorners (Junction junction) {
        if (junction == null) return;

        EnumSet<Direction> cornerDirections = EnumSet.of(
            Direction.NORTHWEST,
            Direction.NORTHEAST,
            Direction.SOUTHEAST,
            Direction.SOUTHWEST
        );

        for (Direction direction : cornerDirections) {
            JunctionCorner corner = JunctionCornerBuilder.INSTANCE.build(junction, direction);
            corner.setId(junctionCornerId.incrementAndGet());
            JunctionCornerCatalog.INSTANCE.addCorner(corner);
        }
    }

}