package com.lawal.transit.road.creation;

import com.lawal.transit.block.Block;
import com.lawal.transit.catalog.*;
import com.lawal.transit.global.Direction;
import com.lawal.transit.graph.Edge;
import com.lawal.transit.junction.Junction;
import com.lawal.transit.road.Avenue;
import com.lawal.transit.road.Street;
import com.lawal.transit.station.Station;
import com.lawal.transit.station.Stations;

import java.util.concurrent.atomic.AtomicInteger;

//public class EdgePopulator {
//
//    public static void populateEdgesForJunction(Junction junction) {
//        // Iterate through all cardinal directions: NE, NW, SE, SW
//        for (Direction direction : Direction.values()) {
//            populateEdgesForCorner(junction, direction);
//        }
//    }
//
//    private static void populateEdgesForCorner(Junction junction, Direction direction) {
//        // Fetch the avenue and street legs for the current corner
//        Block avenueLeg = junction.getLeg(direction, Junction.RoadType.AVENUE);
//        Block streetLeg = junction.getLeg(direction, Junction.RoadType.STREET);
//
//        // Apply right-turn and left-turn connections
//        applyTurningRules(avenueLeg, streetLeg, direction);
//    }
//
//    private static void applyTurningRules(Block avenueLeg, Block streetLeg, Direction direction) {
//        // Define the specific turning behavior based on the direction
//
//        // Right Turn: From Avenue -> Street
//        if (isRightTurnDirection(direction)) {
//            connectBlocks(avenueLeg, streetLeg);
//        }
//
//        // Left Turn: From Street -> Avenue
//        if (isLeftTurnDirection(direction)) {
//            connectBlocks(streetLeg, avenueLeg);
//        }
//    }
//
//    private static boolean isRightTurnDirection(Direction direction) {
//        // Right turns occur at NE and SW corners for avenue -> street
//        return (direction == Direction.NORTHEAST || direction == Direction.SOUTHWEST);
//    }
//
//    private static boolean isLeftTurnDirection(Direction direction) {
//        // Left turns occur at NW and SE corners for street -> avenue
//        return (direction == Direction.NORTHWEST || direction == Direction.SOUTHEAST);
//    }
//
//    private static void connectBlocks(Block fromBlock, Block toBlock) {
//        if (fromBlock != null && toBlock != null) {
//            // Connect the provided blocks
//            createEdge(fromBlock, toBlock);
//        }
//    }
//
//    private static void createEdge(Block fromBlock, Block toBlock) {
//        // Placeholder logic to represent edge creation
//        System.out.println("Connecting " + fromBlock + " to " + toBlock);
//    }
//}

//private static void populateEdgesForJunction(Junction junction) {
//    // Iterate through all corners of the junction
//    for (Corner corner : junction.getCorners()) {
//        determineTurnRulesForCorner(corner);
//    }
//}
//
//private static void determineTurnRulesForCorner(Corner corner) {
//    switch (corner.getName()) {
//        case "NW":
//            // Left-turn Avenue -> Street (South-facing Avenue Left Curb to West-facing Street Left Curb)
//            connectStations(corner.getAvenueLeg().getLeftCurb(), corner.getStreetLeg().getLeftCurb());
//
//            // Right-turn Street -> Avenue (West-facing Street Right Curb to South-facing Avenue Right Curb)
//            connectStations(corner.getStreetLeg().getRightCurb(), corner.getAvenueLeg().getRightCurb());
//            break;
//
//        case "NE":
//            // Right-turn Avenue -> Street (North-facing Avenue Right Curb to East-facing Street Right Curb)
//            connectStations(corner.getAvenueLeg().getRightCurb(), corner.getStreetLeg().getRightCurb());
//
//            // Left-turn Street -> Avenue (East-facing Street Left Curb to North-facing Avenue Left Curb)
//            connectStations(corner.getStreetLeg().getLeftCurb(), corner.getAvenueLeg().getLeftCurb());
//            break;
//
//        case "SE":
//            // Left-turn Avenue -> Street (South-facing Avenue Left Curb to West-facing Street Left Curb)
//            connectStations(corner.getAvenueLeg().getLeftCurb(), corner.getStreetLeg().getLeftCurb());
//
//            // Right-turn Street -> Avenue (East-facing Street Right Curb to North-facing Avenue Right Curb)
//            connectStations(corner.getStreetLeg().getRightCurb(), corner.getAvenueLeg().getRightCurb());
//            break;
//
//        case "SW":
//            // Right-turn Avenue -> Street (North-facing Avenue Right Curb to East-facing Street Right Curb)
//            connectStations(corner.getAvenueLeg().getRightCurb(), corner.getStreetLeg().getRightCurb());
//
//            // Left-turn Street -> Avenue (West-facing Street Left Curb to South-facing Avenue Left Curb)
//            connectStations(corner.getStreetLeg().getLeftCurb(), corner.getAvenueLeg().getLeftCurb());
//            break;
//
//        default:
//            throw new IllegalStateException("Unknown corner: " + corner.getName());
//    }
//}
//public class EdgePopulator {
//
//    private static AtomicInteger edgeId = new AtomicInteger(0);
//
//    public static void populateEdges() throws Exception {
//        for (Junction junction : JunctionCatalog.INSTANCE.getCatalog().getJunctions()) {
//            findIntersectionEdges(junction);
//        }
//    }
//
//    private static void findIntersectionEdges(Junction junction) throws Exception {
//        // Process outgoing and incoming edges for the right-turn rules
//        findEdgesForRightTurns(junction);
//
//        // Process outgoing and incoming edges for the left-turn rules
//        findEdgesForLeftTurns(junction);
//    }
//
//    private static void findEdgesForRightTurns(Junction junction) throws Exception {
//        // From Avenue's right curb to Street's right curb
//        findEdgesForCurbConnections(junction.avenue().rightCurb(), junction.street().rightCurb());
//
//        // From Street's right curb to Avenue's right curb
//        findEdgesForCurbConnections(junction.getStreet().rightCurb(), junction.getAvenue().rightCurb());
//    }
//
//    private static void findEdgesForLeftTurns(Junction junction) throws Exception {
//        // From Avenue's left curb to Street's left curb
//        findEdgesForCurbConnections(junction.getAvenue().leftCurb(), junction.getStreet().leftCurb());
//
//        // From Street's left curb to Avenue's left curb
//        findEdgesForCurbConnections(junction.getStreet().leftCurb(), junction.getAvenue().leftCurb());
//    }
//
//    private static void findEdgesForCurbConnections(Curb fromCurb, Curb toCurb) {
//        // Get all stations on the "from curb"
//        for (Station fromStation : fromCurb.getStations().getStations()) {
//            // Find a matching station on the "to curb"
//            for (Station toStation : toCurb.getStations().getStations()) {
//                if (canConnect(fromStation, toStation)) {
//                    // Calculate distance (if required)
//                    int distance = Math.abs(fromStation.getBlock().getId() - toStation.getBlock().getId());
//
//                    // Create edge
//                    Edge edge = new Edge(edgeId.incrementAndGet(), fromStation, toStation);
//
//                    // Add the edge to the corresponding stations
//                    fromStation.getOutgoingEdges().add(edge);
//                    toStation.getIncomingEdges().add(edge);
//
//                    // Add the edge to the catalog
//                    EdgeCatalog.INSTANCE.getCatalog().add(edge);
//
//                    // Print debug information (optional)
//                    System.out.println("Created edge: " + edge);
//                }
//            }
//        }
//    }
//
//    private static boolean canConnect(Station fromStation, Station toStation) {
//        // Logic for filtering connections between stations
//        // Example: Check if they are on complementary curbs with valid directions
//        return fromStation.getRoad() != toStation.getRoad(); // Ensure they are crossing roads
//    }
//}