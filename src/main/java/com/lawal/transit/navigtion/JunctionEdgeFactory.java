package com.lawal.transit.navigtion;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.catalog.JunctionCatalog;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.global.Direction;
import com.lawal.transit.global.TurnCategory;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.junction.model.JunctionCorner;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.station.model.Station;
import com.lawal.transit.street.model.Street;

import java.util.ArrayList;
import java.util.List;

public class JunctionEdgeFactory {

    public static List<Road> getJunctionRoads(Junction junction) {
        List<Road> roads = new ArrayList<>();
        if (junction == null) return roads;

        roads.add(junction.getAvenue().getRoad());
        roads.add(junction.getStreet().getRoad());
        return roads;
    }

    public static Road getSharedRoad(Station station, Junction junction) {
        if (station == null || junction == null) return null;
        Road stationRoad = station.getBlock().getCurb().getRoad();
        if (stationRoad == null) return null;

        Road avenueRoad = junction.getAvenue().getRoad();
        Road streetRoad = junction.getStreet().getRoad();

        if (stationRoad.equals(avenueRoad)) return avenueRoad;
        if (stationRoad.equals(streetRoad)) return streetRoad;

        return null;
    }

    public static Curb getSharedCurb(Station station, Junction junction) {
        if (station == null || junction == null) return null;

        Road sharedRoad = getSharedRoad(station, junction);
        if (sharedRoad == null) return null;

        return junction.findCurbByBlock(station.getBlock());
    }

    public static Avenue getSharedAvenue(Station station, Junction junction) {
        if (station == null || junction == null) return null;

        Avenue stationAvenue = station.getBlock().getCurb().getAvenue();
        if (stationAvenue == null) return null;
        if (junction.getAvenue().equals(stationAvenue)) return stationAvenue;
        return null;
    }

    public static Street getSharedStreet(Station station, Junction junction) {
        if (station == null || junction == null) return null;

        Street stationStreet = station.getBlock().getCurb().getStreet();
        if (stationStreet == null) return null;
        if (junction.getStreet().equals(stationStreet)) return stationStreet;
        return null;
    }

    public static Block getSharedBlock(Station station, Junction junction) {
        if (station == null || junction == null) return null;
        JunctionCorner corner = junction.getCornerByStation(station);
        if (corner == null) return null;
        return corner.getLegByStation(station);
    }

    public static boolean bothShareARoad (Station station, Junction junction) {
        if (station == null || junction == null) return false;
        return getJunctionRoads(junction).contains(station.getBlock().getCurb().getRoad());
    }

    public static JunctionCorner findCorner(Station station, Junction junction) {
        if (station == null || junction == null) return null;
        return junction.getCornerByStation(station);
    }

    public static void getLeftTurnStationEdge(Station station, Junction junction) {
        if (station == null || junction == null) return;

        Road sharedRoad = getSharedRoad(station, junction);
        if (sharedRoad == null) return;

        Block stationLeg = null;
        Block rightTurnDestination = null;
        Block leftTurnDestination = null;

        Avenue avenue = getSharedAvenue(station, junction);
        Street street = getSharedStreet(station, junction);
        if (avenue == null && street == null) return;

        Curb sharedCurb = getSharedCurb(station, junction);
        if (sharedCurb == null) return;

        int currentBlockDistance = 0;
        if (sharedCurb.getAvenue() != null) {
            stationLeg = junction.findLegByBlockId(station.getBlock().getId());
//            currentBlockDistance += sharedCurb.getBlockArrayIndex(sha)
        }

        JunctionCorner corner = findCorner(station, junction);
        if (corner != null) stationLeg = corner.getOppositeLeg(station.getBlock());
        if (stationLeg != null) {
//            rightTurnDestination = TurnNavigator;
        }
    }

//    public static void avenueTurningTest() {
//        System.out.println("avenueTurningTest");
//        Block destinationBlock = null;
//        for (Junction junction : JunctionCatalog.INSTANCE.getCatalog()) {
//            for (JunctionCorner corner : junction.getCorners()) {
//                Block sourceBlock = corner.getAvenueLeg();
//
//                destinationBlock = TurnNavigator.destinationFromAvenue(junction, corner.getOrientation(), TurnCategory.LEFT_TURN);
//                System.out.println(
//                    TurnCategory.LEFT_TURN
//                        + " from corner:" + corner.getOrientation().abbreviation()
//                        + " " + sourceBlock
//                        + " onto " + destinationBlock.toString());
//
//                destinationBlock = TurnNavigator.destinationFromAvenue(junction, corner.getOrientation(), TurnCategory.RIGHT_TURN);
//                System.out.println(
//                    TurnCategory.RIGHT_TURN
//                        + " from corner:" + corner.getOrientation().abbreviation()
//                        + " " + sourceBlock
//                        + " onto " + destinationBlock.toString());
//
//                destinationBlock = TurnNavigator.destinationFromAvenue(junction, corner.getOrientation(), TurnCategory.REVERSE);
//                System.out.println(
//                    TurnCategory.REVERSE
//                        + " from corner:" + corner.getOrientation().abbreviation()
//                        + " " + sourceBlock
//                        + " onto " + destinationBlock.toString());
//
//                destinationBlock = TurnNavigator.destinationFromAvenue(junction, corner.getOrientation(), TurnCategory.NO_TURN);
//                System.out.println(
//                    TurnCategory.NO_TURN
//                        + " from corner:" + corner.getOrientation().abbreviation()
//                        + " " + sourceBlock
//                        + " onto " + destinationBlock.toString());

//                if (leftTurnDestination == null) {
//                    System.out.println("left turn destination is null: turning test failed.");
//                    return;
//                }
//                System.out.println("found left turn destination:" + leftTurnDestination.toString());
//                Block rightTurnDestination = TurnNavigator.destinationFromAvenue(junction, Direction.NORTHEAST, TurnCategory.RIGHT_TURN);
//                if (rightTurnDestination == null) {
//                    System.out.println("right turn destination is null: turning test failed.");
//                }
//            }
//            JunctionCorner corner = junction.getCornerByOrientation(Direction.NORTHEAST);
//            if (corner == null) {
//                System.out.println("corner is null: turning test failed.");
//                return;
//            }
//            System.out.println("found NE corner:" + corner.toString());
//            Block avenueLeg = corner.getAvenueLeg();
//
//            if (avenueLeg == null) {
//                System.out.println("avenue leg is null: turning test failed.");
//                return;
//            }
//            System.out.println("found avenue leg:" + avenueLeg.toString());
//            Block streetLeg = corner.getStreetLeg();
//            if (streetLeg == null) {
//                System.out.println("street leg is null: turning test failed.");
//                return;
//            }
//            System.out.println("found street leg:" + streetLeg.toString());
//            Block block = TurnNavigator.destinationFromAvenue(junction, Direction.NORTHEAST, TurnCategory.LEFT_TURN);
//            if (block == null) {
//                System.out.println("block is null: turning test failed.");
//                return;
//            }
//            System.out.println("JunctionEdgeFactory.turningTest: found block:" + block.toString());
//            System.out.println(TurnCategory.LEFT_TURN.toString() + " from " + avenueLeg.toString() + " onto " + block.toString());
//        }
//    }

    public static void launcher(Station station, Junction junction) {
        if (station == null || junction == null) return;
//        avenueTurningTest();
//        Avenue avenue = getSharedAvenue(station, junction);
//        Street street = getSharedStreet(station, junction);


    }
}