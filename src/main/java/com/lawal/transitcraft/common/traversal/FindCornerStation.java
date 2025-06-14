package com.lawal.transitcraft.common.traversal;

import com.lawal.transitcraft.infrastructure.avenue.Avenue;
import com.lawal.transitcraft.infrastructure.block.Block;
import com.lawal.transitcraft.infrastructure.catalog.AvenueCatalog;
import com.lawal.transitcraft.infrastructure.catalog.StationEdgeCatalog;
import com.lawal.transitcraft.infrastructure.catalog.StreetCatalog;
import com.lawal.transitcraft.infrastructure.curb.Curb;
import com.lawal.transitcraft.infrastructure.station.StationEdge;
import com.lawal.transitcraft.common.Direction;
import com.lawal.transitcraft.infrastructure.junction.Junction;
import com.lawal.transitcraft.infrastructure.junction.JunctionCorner;
import com.lawal.transitcraft.infrastructure.station.Station;
import com.lawal.transitcraft.infrastructure.street.Street;

import java.util.concurrent.atomic.AtomicLong;

public class FindCornerStation {

    public static AtomicLong edgeId = new AtomicLong(StationEdgeCatalog.INSTANCE.getCatalog().size());

    public static Station findAscendingTail(Block block) {
        if (block == null) {
//            System.out.println("findDescendingTail: block is null nothing to check");
            return null;
        }

//        System.out.println("findDescendingTail from block" + block);
        int counter = block.getCurb().getBlocks().indexOf(block);
        int sentinel = block.getCurb().getBlocks().size();

        Curb curb = block.getCurb();
        Station station = null;

//        System.out.println("counter:" + counter + " sentinel:" + sentinel);

        for (int index = counter; index < sentinel; index++) {
            Block crossingBlock = curb.getBlocks().get(index);
            station = crossingBlock.getStation();
//            System.out.println("findDescendingTail: " + index + " checking crossingBlock " + crossingBlock);
            if (station != null) {
//                System.out.println("Found corner station at index " + index + " station:" + station + " at " + crossingBlock);
                return station;
            }
        }
//        System.out.println("no descending tail station found from " + block);
        return station;
    }

    public static Station findDescendingTail(Block block) {
        if (block == null) {
//            System.out.println("findAscendingTail: block is null nothing to check");
            return null;
        }

//        System.out.println("findAscendingTail from block" + block);
        int counter = 0;
        int sentinel = block.getCurb().getBlocks().indexOf(block);

        Curb curb = block.getCurb();
        Station station = null;

        System.out.println("counter:" + counter + " sentinel:" + sentinel);

        for (int index = counter; index < sentinel; index++) {
            Block crossingBlock = curb.getBlocks().get(index);
            station = crossingBlock.getStation();
//            System.out.println("findAscendingTail: " + index + " checking crossingBlock" + crossingBlock);
            if (station != null) {
//                System.out.println("Found corner station at index " + index + " station:" + station);
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
//                System.out.println("FindCornerStation.processSharedAvenue at"
//                    + " " + Avenue.LEFT_CURB_ORIENTATION
//                    + " junction Avenue Block:"
//                    + junctionAvenueBlock
//                );

                Station streetStation = findAscendingTail(streetBlock);
                if (streetStation != null) {
//                    System.out.println(
//                        "FindCornerStation.processSharedAvenue at "
//                            + Avenue.LEFT_CURB_ORIENTATION
//                            + " junctionStreetBlock:" + streetBlock
//                            + " streetStation:" + streetStation
//                    );
                    Block streetStationBlock = streetStation.getBlock();
                    int streetStationBlockIndex = streetCurb.getBlocks().indexOf(streetStationBlock);
                    int streetLength = Math.abs(streetBlockIndex - streetStationBlockIndex) + 1;
                    int distance = avenueLength + streetLength;
                    StationEdge crossStationEdge = new StationEdge(edgeId.incrementAndGet(), station, streetStation, distance, 0, 0);
//                    System.out.println("crossStationEdge:" + crossStationEdge);
                    StationEdgeCatalog.INSTANCE.getCatalog().add(crossStationEdge);

//                    System.out.println("FindCornerStation.processSharedAvenue at"
//                        + " " + Avenue.LEFT_CURB_ORIENTATION
//                        + " DISTANCE[avenueLength:" + avenueLength
//                        + " streetLength:" + streetLength + "]"
//                    );
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

            if (junctionAvenueBlockIndex > avenueStationBlockIndex) {
                System.out.println("FindCornerStation.processSharedAvenue at " + Avenue.RIGHT_CURB_ORIENTATION + " junction Avenue Block:" + junctionAvenueBlock);

                Station streetStation = findDescendingTail(streetBlock);
                if (streetStation != null) {
//                    System.out.println(
//                        "FindCornerStation.processSharedAvenue at "
//                            + Avenue.RIGHT_CURB_ORIENTATION
//                            + " junctionStreetBlock:" + streetBlock
//                            + " streetStation:" + streetStation
//                    );
                    Block streetStationBlock = streetStation.getBlock();
                    int streetStationBlockIndex = streetCurb.getBlocks().indexOf(streetStationBlock);
                    int streetLength = Math.abs(streetBlockIndex - streetStationBlockIndex) + 1;
                    int distance = avenueLength + streetLength;
                    StationEdge crossStationEdge = new StationEdge(edgeId.incrementAndGet(), station, streetStation, distance, 0, 0);
//                    System.out.println("crossStationEdge:" + crossStationEdge);
                    StationEdgeCatalog.INSTANCE.getCatalog().add(crossStationEdge);

//                    System.out.println("FindCornerStation.processSharedAvenue at"
//                        + " " + Avenue.RIGHT_CURB_ORIENTATION
//                        + " DISTANCE[avenueLength:" + avenueLength
//                        + " streetLength:" + streetLength + "]"
//                    );
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
        return null;
    }

    public static Block processSharedStreet(Station station, Junction junction) {
        if (station == null || junction == null) return null;
        Street stationStreet = station.getBlock().getCurb().getStreet();

        if (stationStreet == null) return null;
        if (!junction.getStreet().equals(stationStreet)) return null;

        Curb streetCurb = station.getBlock().getCurb();
        JunctionCorner sharedCorner = junction.getCornerByOrientation(Direction.SOUTHEAST);

        Block junctionStreetBlock = sharedCorner.getStreetLeg();
        int junctionStreetBlockIndex = streetCurb.getBlocks().indexOf(junctionStreetBlock);
        int streetStationBlockIndex = streetCurb.getBlocks().indexOf(station.getBlock());
        int streetLength = Math.abs(junctionStreetBlockIndex - streetStationBlockIndex);

        Block avenueBlock = sharedCorner.getAvenueLeg();
        Curb avenueCurb = avenueBlock.getCurb();
        int avenueBlockIndex = avenueCurb.getBlocks().indexOf(avenueBlock);

        if (streetCurb.getOrientation() == Street.LEFT_CURB_ORIENTATION) {

            if (junctionStreetBlockIndex < streetStationBlockIndex) {
//                System.out.println("FindCornerStation.processSharedAvenue at"
//                    + " " + Street.LEFT_CURB_ORIENTATION
//                    + " junction Avenue Block:" + junctionStreetBlock
//                );

                Station avenueStation = findAscendingTail(avenueBlock);
                if (avenueStation != null) {
//                    System.out.println(
//                        "FindCornerStation.processSharedAvenue at "
//                            + Street.LEFT_CURB_ORIENTATION
//                            + " junctionAvenueBlock:" + avenueBlock
//                            + " avenueStation:" + avenueStation
//                    );
                    Block avenueStationBlock = avenueStation.getBlock();
                    int avenueStationBlockIndex = streetCurb.getBlocks().indexOf(avenueStationBlock);
                    int avenueLength = Math.abs(avenueBlockIndex - avenueStationBlockIndex) + 1;
                    int distance = streetLength + avenueLength;
                    StationEdge crossStationEdge = new StationEdge(edgeId.incrementAndGet(), station, avenueStation, distance, 0, 0);
//                    System.out.println("crossStationEdge:" + crossStationEdge);
                    StationEdgeCatalog.INSTANCE.getCatalog().add(crossStationEdge);

//                    System.out.println("FindCornerStation.processSharedAvenue at"
//                        + " " + Avenue.LEFT_CURB_ORIENTATION
//                        + " DISTANCE[avenueLength:" + avenueLength
//                        + " streetLength:" + avenueLength + "]"
//                    );
//                    if (streetLength > 1) {
//                        System.out.println("FindCornerStation.processSharedAvenue at " + Avenue.LEFT_CURB_ORIENTATION + " streetLength:" + streetLength);
//                        return streetStationBlock;
//                    }
//                    else {
//                        System.out.println("FindCornerStation.processSharedAvenue at " + Avenue.LEFT_CURB_ORIENTATION + " streetLength:" + streetLength + " returning junctionAvenueBlock");
//                    }
                }
                return avenueBlock;
            }
        }

        if (streetCurb.getOrientation() == Street.RIGHT_CURB_ORIENTATION) {
            junctionStreetBlock = junction.getCornerByOrientation(Direction.SOUTHWEST).getStreetLeg();

            if (junctionStreetBlockIndex > streetStationBlockIndex) {
                System.out.println("FindCornerStation.processSharedAvenue at " + Street.RIGHT_CURB_ORIENTATION + " junction Avenue Block:" + junctionStreetBlock);

                Station avenueStation = findDescendingTail(avenueBlock);
                if (avenueStation != null) {
//                    System.out.println(
//                        "FindCornerStation.processSharedAvenue at "
//                            + Avenue.RIGHT_CURB_ORIENTATION
//                            + " junctionStreetBlock:" + avenueBlock
//                            + " streetStation:" + avenueStation
//                    );
                    Block avenueStationBlock = avenueStation.getBlock();
                    int avenueStationBlockIndex = streetCurb.getBlocks().indexOf(avenueStationBlock);
                    int avenueLength = Math.abs(avenueBlockIndex - avenueStationBlockIndex) + 1;
                    int distance = avenueLength + streetLength;
                    StationEdge crossStationEdge = new StationEdge(edgeId.incrementAndGet(), station, avenueStation, distance, 0, 0);
//                    System.out.println("crossStationEdge:" + crossStationEdge);
                    StationEdgeCatalog.INSTANCE.getCatalog().add(crossStationEdge);

//                    System.out.println("FindCornerStation.processSharedAvenue at"
//                        + " " + Avenue.RIGHT_CURB_ORIENTATION
//                        + " DISTANCE[avenueLength:" + avenueLength
//                        + " streetLength:" + streetLength
//                        + "]");
//                    if (streetLength > 1) {
//                        System.out.println("FindCornerStation.processSharedAvenue at " + Avenue.LEFT_CURB_ORIENTATION + " streetLength:" + streetLength);
//                        return streetStationBlock;
//                    }
//                    else {
//                        System.out.println("FindCornerStation.processSharedAvenue at " + Avenue.LEFT_CURB_ORIENTATION + " streetLength:" + streetLength + " returning junctionAvenueBlock");
//                    }
                }
                return avenueBlock;
            }
        }
        return null;
    }

//    public static Block processSharedStreet(Station station, Junction junction) {
//        if (station == null || junction == null) return null;
//        Street stationStreet = station.getBlock().getCurb().getStreet();
//
//        if (stationStreet == null) return null;
//        if (!junction.getStreet().equals(stationStreet)) return null;
//
//        Curb sharedCurb = station.getBlock().getCurb();
//        if (sharedCurb.getOrientation() == Street.LEFT_CURB_ORIENTATION) {
//            return junction.getCornerByOrientation(Direction.SOUTHWEST).getStreetLeg();
//        }
//
//        if (sharedCurb.getOrientation() == Street.RIGHT_CURB_ORIENTATION) {
//            return junction.getCornerByOrientation(Direction.NORTHEAST).getStreetLeg();
//        }
//        return null;
//    }



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

//        System.out.println("FindCornerStation.getCornerDistance for STATION:" + station.toString());

        if (station.getBlock().getCurb().getAvenue() != null) {
            adjacentJunctionBlock = processSharedAvenue(station, junction);
            if (adjacentJunctionBlock == null) return;


        }
        else if (station.getBlock().getCurb().getStreet() != null) {
            adjacentJunctionBlock = processSharedStreet(station, junction);
            if (adjacentJunctionBlock == null) {
//                System.out.println("FindCornerStation.getCornerDistance There is no adjacent block between the junction and station");
                return;
            }
        } else {
//            System.out.println("FindCornerStation.getCornerDistance The station is not on a street or avenue");
            return;
        }

        if (adjacentJunctionBlock.getStation() != null) {
            Station junctionStation = adjacentJunctionBlock.getStation();
//            System.out.println(
//                "FindCornerStation.getCornerDistance BINGO! junction station at"
//                + " " + adjacentJunctionBlock
//                + " is " + junctionStation
//            );
        }

        sharedCurb = station.getBlock().getCurb();
        int stationBlockIndex = sharedCurb.getBlocks().indexOf(station.getBlock());
        int adjacentJunctionBlockIndex = sharedCurb.getBlocks().indexOf(adjacentJunctionBlock);

//        System.out.println(
//            "FindCornerStation.getCornerDistance stationBlock:" + station.getBlock().toString()
//            + "stationBlockIndex:" + stationBlockIndex
//            + "\nadjacentJunctionBlock:" + adjacentJunctionBlock.toString()
//            + " adjacentJunctionBlockIndex:" + adjacentJunctionBlockIndex
//            + "\nsIndex - jIndex = " + (stationBlockIndex - adjacentJunctionBlockIndex)
//        );
    }

    public static void processStreet(Direction curbOrientation, Street street) {
        if (street == null || curbOrientation == null) return;
        Curb curb = street.getCurbByOrientation(curbOrientation);
        if (curb == null) return;

        for (Station station : curb.getStations()) {
            for (Junction junction : street.getJunctions()) {
                getCornerStationDistance(station, junction);
//                System.out.println("---------------------------------------");
            }
        }
    }

    public static void processAvenueCurb (Direction curbOrientation, Avenue avenue) {
        if (avenue == null || curbOrientation == null) return;
        Curb curb = avenue.getCurbByOrientation(curbOrientation);
        if (curb == null) return;

        for (Station station : curb.getStations()) {
            for (Junction junction : avenue.getJunctions()) {
                getCornerStationDistance(station, junction);
//                System.out.println("---------------------------------------");
            }
        }
    }

    public static void processStreetCurb(Direction curbOrientation, Street street) {
        if (street == null || curbOrientation == null) return;
        Curb curb = street.getCurbByOrientation(curbOrientation);
        if (curb == null) return;

        for (Station station : curb.getStations()) {
            for (Junction junction : street.getJunctions()) {
                getCornerStationDistance(station, junction);
//                System.out.println("---------------------------------------");
            }
        }
    }

    public static void launcher() {
        for (Avenue avenue : AvenueCatalog.INSTANCE.getCatalog()) {
            processAvenueCurb(Avenue.LEFT_CURB_ORIENTATION, avenue);
            processAvenueCurb(Avenue.RIGHT_CURB_ORIENTATION, avenue);
        }

        for (Street street : StreetCatalog.INSTANCE.getCatalog()) {
            processStreetCurb(Street.LEFT_CURB_ORIENTATION, street);
            processStreetCurb(Street.RIGHT_CURB_ORIENTATION, street);
        }
    }
}