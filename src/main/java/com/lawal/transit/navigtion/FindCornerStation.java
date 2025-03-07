package com.lawal.transit.navigtion;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.catalog.AvenueCatalog;
import com.lawal.transit.catalog.EdgeCatalog;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.edge.model.Edge;
import com.lawal.transit.global.Direction;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.junction.model.JunctionCorner;
import com.lawal.transit.station.model.Station;
import com.lawal.transit.street.model.Street;

import java.util.concurrent.atomic.AtomicLong;

public class FindCornerStation {

    public static AtomicLong edgeId = new AtomicLong(EdgeCatalog.INSTANCE.getCatalog().size());

    public static Station findAscendingTail(Block block) {
        if (block == null) {
            System.out.println("findDescendingTail: block is null nothing to check");
            return null;
        }

        System.out.println("findDescendingTail from block" + block);
        int counter = block.getCurb().getBlocks().indexOf(block);
        int sentinel = block.getCurb().getBlocks().size();

        Curb curb = block.getCurb();
        Station station = null;

        System.out.println("counter:" + counter + " sentinel:" + sentinel);

        for (int index = counter; index < sentinel; index++) {
            Block crossingBlock = curb.getBlocks().get(index);
            station = crossingBlock.getStation();
            System.out.println("findDescendingTail: " + index + " checking crossingBlock " + crossingBlock);
            if (station != null) {
                System.out.println("Found corner station at index " + index + " station:" + station + " at " + crossingBlock);
                return station;
            }
        }
        System.out.println("no descending tail station found from " + block);
        return station;
    }

    public static Station findDescendingTail(Block block) {
        if (block == null) {
            System.out.println("findAscendingTail: block is null nothing to check");
            return null;
        }

        System.out.println("findAscendingTail from block" + block);
        int counter = 0;
        int sentinel = block.getCurb().getBlocks().indexOf(block);

        Curb curb = block.getCurb();
        Station station = null;

        System.out.println("counter:" + counter + " sentinel:" + sentinel);

        for (int index = counter; index < sentinel; index++) {
            Block crossingBlock = curb.getBlocks().get(index);
            station = crossingBlock.getStation();
            System.out.println("findAscendingTail: " + index + " checking crossingBlock" + crossingBlock);
            if (station != null) {
                System.out.println("Found corner station at index " + index + " station:" + station.toString());
                return station;
            }
        }
        System.out.println("no ascending tail station found");
        return station;
    }

    public Block getCrossStreetStation(Street street, Curb curb, Block block) {
        if (street == null || curb == null || block == null) return null;

        if (curb.getOrientation() == Direction.EAST) {
            int counter = curb.getBlocks().indexOf(block) - 1;
            if (counter < 0) return null;
            while (counter >= 0) {
                if (curb.getBlocks().get(counter).getStation() != null) return block;
                counter--;
            }
        }

        if (curb.getOrientation() == Direction.WEST) {
            int counter = 0;
            int blockIndex = curb.getBlocks().indexOf(block);
            if (counter >= curb.getBlocks().size() - 1) return null;
            while (counter < blockIndex) {
                if (curb.getBlocks().get(counter).getStation() != null) return block;
                counter++;
            }
        }
        return null;
    }

    public static Block processSharedAvenue(Station station, Junction junction) {
        if (station == null || junction == null) return null;
        Avenue stationAvenue = station.getBlock().getCurb().getAvenue();

        if (stationAvenue == null) return null;
        if (!junction.getAvenue().equals(stationAvenue)) return null;

        Curb avenueCurb = station.getBlock().getCurb();
        JunctionCorner sharedCorner = junction.getCornerByOrientation(Direction.NORTHWEST);

        Block junctionAvenueBlock = sharedCorner.getAvenueLeg();
        int junctionAvenueBlockIndex = avenueCurb.getBlocks().indexOf(junctionAvenueBlock);
        int avenueStationBlockIndex = avenueCurb.getBlocks().indexOf(station.getBlock());
        int avenueLength = Math.abs(junctionAvenueBlockIndex - avenueStationBlockIndex);

        Block streetBlock = sharedCorner.getStreetLeg();
        Curb streetCurb = streetBlock.getCurb();
        int streetBlockIndex = streetCurb.getBlocks().indexOf(streetBlock);

        if (avenueCurb.getOrientation() == Avenue.LEFT_CURB_ORIENTATION) {

            if (junctionAvenueBlockIndex < avenueStationBlockIndex) {
                System.out.println("FindCornerStation.processSharedAvenue at " + Avenue.LEFT_CURB_ORIENTATION + " junction Avenue Block:" + junctionAvenueBlock);


                Station streetStation = findAscendingTail(streetBlock);
                if (streetStation != null) {
                    System.out.println(
                        "FindCornerStation.processSharedAvenue at "
                        + Avenue.LEFT_CURB_ORIENTATION
                        + " junctionStreetBlock:" + streetBlock
                        + " streetStation:" + streetStation
                    );
                    Block streetStationBlock = streetStation.getBlock();
                    int streetStationBlockIndex = streetCurb.getBlocks().indexOf(streetStationBlock);
                    int streetLength = Math.abs(streetBlockIndex - streetStationBlockIndex) + 1;
                    int distance = avenueLength + streetLength;
                    Edge crossEdge = new Edge(edgeId.incrementAndGet(), station, streetStation,distance, 0,0);
                    System.out.println("crossEdge:" + crossEdge);
                    EdgeCatalog.INSTANCE.getCatalog().add(crossEdge);

                    System.out.println("FindCornerStation.processSharedAvenue at " + Avenue.LEFT_CURB_ORIENTATION + " DISTANCE[avenueLength:" + avenueLength + " streetLength:" + streetLength +"]");
//                    if (streetLength > 1) {
//                        System.out.println("FindCornerStation.processSharedAvenue at " + Avenue.LEFT_CURB_ORIENTATION + " streetLength:" + streetLength);
//                        return streetStationBlock;
//                    }
//                    else {
//                        System.out.println("FindCornerStation.processSharedAvenue at " + Avenue.LEFT_CURB_ORIENTATION + " streetLength:" + streetLength + " returning junctionAvenueBlock");
//                    }
                }
                return junctionAvenueBlock;
            }
        }

        if (avenueCurb.getOrientation() == Avenue.RIGHT_CURB_ORIENTATION) {
            junctionAvenueBlock = junction.getCornerByOrientation(Direction.SOUTHEAST).getAvenueLeg();
            junctionAvenueBlockIndex = avenueCurb.getBlocks().indexOf(junctionAvenueBlock);
            if (junctionAvenueBlockIndex > avenueStationBlockIndex) {
                System.out.println("FindCornerStation.processSharedAvenue at " + Avenue.LEFT_CURB_ORIENTATION + " junctionBock:" + junctionAvenueBlock);
                return junctionAvenueBlock;
            }
        }
        return null;
    }

    public static Block processSharedStreet(Station station, Junction junction) {
        if (station == null || junction == null) return null;
        Street stationStreet = station.getBlock().getCurb().getStreet();

        if (stationStreet == null) return null;
        if (!junction.getStreet().equals(stationStreet)) return null;

        Curb sharedCurb = station.getBlock().getCurb();
        if (sharedCurb.getOrientation() == Street.LEFT_CURB_ORIENTATION) {
            return junction.getCornerByOrientation(Direction.SOUTHWEST).getStreetLeg();
        }

        if (sharedCurb.getOrientation() == Street.RIGHT_CURB_ORIENTATION) {
            return junction.getCornerByOrientation(Direction.NORTHEAST).getStreetLeg();
        }
        return null;
    }



    public static Station findCrossAvenueStationBlock(Block block, Direction curbOrientation) {
        if (block == null || block.getCurb().getAvenue() == null || curbOrientation == null) return null;
        if (curbOrientation != Avenue.LEFT_CURB_ORIENTATION && curbOrientation != Avenue.RIGHT_CURB_ORIENTATION)
            return null;

        if (curbOrientation == Avenue.LEFT_CURB_ORIENTATION) return findDescendingTail(block);
        return findAscendingTail(block);
    }

    public static void getCornerStationDistance(Station station, Junction junction) {
//        System.out.println("getCornerStationDistance");
        if (station == null || junction == null) return;
        Avenue sharedAvenue;
        Street sharedStreet;
        Curb sharedCurb;
        Block adjacentJunctionBlock;

        System.out.println("FindCornerStation.getCornerDistance for STATION:" + station.toString());

        if (station.getBlock().getCurb().getAvenue() != null) {
            adjacentJunctionBlock = processSharedAvenue(station, junction);
            if (adjacentJunctionBlock == null) return;


        }
        else if (station.getBlock().getCurb().getStreet() != null) {
            adjacentJunctionBlock = processSharedStreet(station, junction);
            if (adjacentJunctionBlock == null) {
                System.out.println("FindCornerStation.getCornerDistance There is no adjacent block between the junction and station");
                return;
            }
        } else {
            System.out.println("FindCornerStation.getCornerDistance The station is not on a street or avenue");
            return;
        }

        if (adjacentJunctionBlock.getStation() != null) {
            Station junctionStation = adjacentJunctionBlock.getStation();
            System.out.println("FindCornerStation.getCornerDistance BINGO! junction station at " + adjacentJunctionBlock.toString() + " is " + junctionStation.toString());
        }

        sharedCurb = station.getBlock().getCurb();
        int stationBlockIndex = sharedCurb.getBlocks().indexOf(station.getBlock());
        int adjacentJunctionBlockIndex = sharedCurb.getBlocks().indexOf(adjacentJunctionBlock);

        System.out.println(
            "FindCornerStation.getCornerDistance stationBlock:" + station.getBlock().toString()
            + "stationBlockIndex:" + stationBlockIndex
            + "\nadjacentJunctionBlock:" + adjacentJunctionBlock.toString()
            + " adjacentJunctionBlockIndex:" + adjacentJunctionBlockIndex
            + "\nsIndex - jIndex = " + (stationBlockIndex - adjacentJunctionBlockIndex)
        );
    }

    public static void processCurb(Direction curbOrientation, Avenue avenue) {
        if (avenue == null || curbOrientation == null) return;
        Curb curb = avenue.getCurbByOrientation(curbOrientation);
        if (curb == null) return;

        for (Station station : curb.getStations()) {
            for (Junction junction : avenue.getJunctions()) {
                getCornerStationDistance(station, junction);
                System.out.println("---------------------------------------");
            }
        }
    }

    public static void launcher() {
        Avenue avenue = AvenueCatalog.INSTANCE.findById(1L);
        processCurb(Avenue.LEFT_CURB_ORIENTATION, avenue);
//        processCurb(Avenue.RIGHT_CURB_ORIENTATION, avenue);
    }
}