package com.lawal.transit.road.creation;

import com.lawal.transit.catalog.*;
import com.lawal.transit.global.Direction;
import com.lawal.transit.graph.Edge;
import com.lawal.transit.junction.Junction;
import com.lawal.transit.junction.JunctionCorner;
import com.lawal.transit.road.Avenue;
import com.lawal.transit.road.Curb;
import com.lawal.transit.road.Street;
import com.lawal.transit.road.contract.Road;
import com.lawal.transit.station.Station;

import java.util.concurrent.atomic.AtomicInteger;

public class EdgePopulator {

    private static AtomicInteger edgeId = new AtomicInteger(0);

    public static void populateEdges() throws Exception {
        // Process each Station in the StationCatalog
        for (Station station : StationCatalog.INSTANCE.getCatalog().getStations()) {
            discoverOutgoingEdges(station);
        }
    }

    private static void discoverOutgoingEdges(Station station) throws Exception {
        // Get the curb and road for this station
        Curb curb = station.getCurb();
        Road road = curb.getRoad();

        // Use JunctionCatalog to find all relevant Junctions for this road
        for (Junction junction : JunctionCatalog.INSTANCE.getCatalog().getJunctions()) {
            if (road instanceof Avenue && junction.avenue().equals(road)) {
                createEdgesForAvenueStation(station, junction);
            } else if (road instanceof Street && junction.street().equals(road)) {
                createEdgesForStreetStation(station, junction);
            }
        }
    }

    private static void createEdgesForAvenueStation(Station station, Junction junction) throws Exception {
        // Get the connected Street and its corners for navigation
        Street connectedStreet = junction.street();

        // Get the direction of the curb on the Avenue
        Direction avenueOrientation = station.getCurb().getOrientation();
        Curb streetTargetCurb;

        // Determine the target curb based on Avenue orientation
        switch (avenueOrientation) {
            case NORTH -> {
                // NORTH-facing Avenue connects to EAST-facing or WEST-facing Streets
                streetTargetCurb = getStreetCurbForTurn("NORTHEAST", "NORTHWEST", connectedStreet, junction);
            }
            case SOUTH -> {
                // SOUTH-facing Avenue connects to EAST-facing or WEST-facing Streets
                streetTargetCurb = getStreetCurbForTurn("SOUTHEAST", "SOUTHWEST", connectedStreet, junction);
            }
            default -> throw new IllegalArgumentException("Unexpected Avenue orientation: " + avenueOrientation);
        }

        if (streetTargetCurb != null) {
            addEdgesFromStationToCurb(station, streetTargetCurb);
        }
    }

    private static void createEdgesForStreetStation(Station station, Junction junction) throws Exception {
        // Get the connected Avenue and its corners for navigation
        Avenue connectedAvenue = junction.avenue();

        // Get the direction of the curb on the Street
        Direction streetOrientation = station.getCurb().getOrientation();
        Curb avenueTargetCurb;

        // Determine the target curb based on Street orientation
        switch (streetOrientation) {
            case EAST -> {
                // EAST-facing Street connects to NORTH-facing or SOUTH-facing Avenues
                avenueTargetCurb = getAvenueCurbForTurn("NORTHEAST", "SOUTHEAST", connectedAvenue, junction);
            }
            case WEST -> {
                // WEST-facing Street connects to NORTH-facing or SOUTH-facing Avenues
                avenueTargetCurb = getAvenueCurbForTurn("NORTHWEST", "SOUTHWEST", connectedAvenue, junction);
            }
            default -> throw new IllegalArgumentException("Unexpected Street orientation: " + streetOrientation);
        }

        if (avenueTargetCurb != null) {
            addEdgesFromStationToCurb(station, avenueTargetCurb);
        }
    }

    private static Curb getStreetCurbForTurn(String corner1, String corner2, Street street, Junction junction) {
        // Use JunctionCorner and direction to determine the correct curb
        for (JunctionCorner corner : JunctionCornerCatalog.INSTANCE.filterByJunction(junction)) {
            if (corner.getCornerOrientation().name().equalsIgnoreCase(corner1) ||
                corner.getCornerOrientation().name().equalsIgnoreCase(corner2)) {
                return corner.getStreetLeg().getCurb();
            }
        }
        return null;
    }

    private static Curb getAvenueCurbForTurn(String corner1, String corner2, Avenue avenue, Junction junction) {
        // Use JunctionCorner and direction to determine the correct curb
        for (JunctionCorner corner : JunctionCornerCatalog.INSTANCE.filterByJunction(junction)) {
            if (corner.getCornerOrientation().name().equalsIgnoreCase(corner1) ||
                corner.getCornerOrientation().name().equalsIgnoreCase(corner2)) {
                return corner.getAvenueLeg().getCurb();
            }
        }
        return null;
    }

    private static void addEdgesFromStationToCurb(Station sourceStation, Curb targetCurb) throws Exception {
        // Find the closest station on the target curb
        Station targetStation = findClosestStation(targetCurb, sourceStation);

        if (targetStation != null) {
            // Create a new edge
            Edge newEdge = new Edge(edgeId.incrementAndGet(), sourceStation, targetStation);

            // Add the edge to the outgoing and incoming edge lists
            sourceStation.getOutgoingEdges().add(newEdge);
            targetStation.getIncomingEdges().add(newEdge);
            EdgeCatalog.INSTANCE.getCatalog().add(newEdge);

            System.out.println("Created Edge: " + newEdge);
        }
    }

    private static Station findClosestStation(Curb targetCurb, Station sourceStation) {
        // Find the station on the target Curb with the smallest block ID difference
        Station closestStation = null;
        int minDistance = Integer.MAX_VALUE;

        for (Station targetStation : targetCurb.getStations().getStations()) {
            int distance = Math.abs(sourceStation.getBlock().getId() - targetStation.getBlock().getId());
            if (distance < minDistance) {
                closestStation = targetStation;
                minDistance = distance;
            }
        }

        return closestStation;
    }
}