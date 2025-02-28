package com.lawal.transit.roadEntity.creation;


import com.lawal.transit.catalog.*;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.global.Direction;
import com.lawal.transit.edge.model.Edge;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.junction.model.JunctionCorner;
import com.lawal.transit.avenue.model.Avenue;

import com.lawal.transit.street.model.Street;
import com.lawal.transit.station.model.Station;


import java.util.concurrent.atomic.AtomicLong;

public class EdgePopulator {

    private static AtomicLong edgeId = new AtomicLong(0);

    public static void populateEdges() throws Exception {
        // Process each Station in the StationCatalog
        for (Station station : StationCatalog.INSTANCE.getCatalog().getStations()) {
            discoverOutgoingEdges(station);
        }
    }

    private static void discoverOutgoingEdges(Station station) throws Exception {
        // Get the curb and road for this station
        Curb curb = station.getBlock().getCurb();
        Avenue avenue = curb.getAvenue();
        Street street = curb.getStreet();

        if (avenue == null && street == null)
            throw new IllegalArgumentException("The avenue and street are null");

        if (avenue != null) {
            for (Junction junction : JunctionCatalog.INSTANCE.getCatalog().getJunctions()) {
                if (junction.getAvenue().equals(avenue)) createEdgesForAvenueStation(station, junction);
            }
        } else {
            for (Junction junction : JunctionCatalog.INSTANCE.getCatalog().getJunctions()) {
                if (junction.getStreet().equals(street)) createEdgesForStreetStation(station, junction);
            }
        }
    }

    private static void createEdgesForAvenueStation(Station station, Junction junction) throws Exception {
        // Get the connected Street and its corners for navigation
        Curb streetTargetCurb;
        Street junctionStreet = junction.getStreet();

        // Get the direction of the curb on the Avenue
        Direction avenueOrientation = station.getBlock().getCurb().getOrientation();

        // Determine the target curb based on Avenue orientation
        switch (avenueOrientation) {
            case NORTH -> {
                // NORTH-facing Avenue connects to EAST-facing or WEST-facing Streets
                streetTargetCurb = getStreetCurbForTurn("NORTHEAST", "NORTHWEST", junctionStreet, junction);
            }
            case SOUTH -> {
                // SOUTH-facing Avenue connects to EAST-facing or WEST-facing Streets
                streetTargetCurb = getStreetCurbForTurn("SOUTHEAST", "SOUTHWEST", junctionStreet, junction);
            }
            default -> throw new IllegalArgumentException("Unexpected Avenue orientation: " + avenueOrientation);
        }

        if (streetTargetCurb != null) {
            addEdgesFromStationToCurb(station, streetTargetCurb);
        }
    }

    private static void createEdgesForStreetStation(Station station, Junction junction) throws Exception {
        // Get the connected Avenue and its corners for navigation
        Curb avenueTargetCurb;
        Avenue junctionAvenue = junction.getAvenue();

        // Get the direction of the curb on the Street
        Direction streetOrientation = station.getBlock().getCurb().getOrientation();

        // Determine the target curb based on Street orientation
        switch (streetOrientation) {
            case EAST -> {
                // EAST-facing Street connects to NORTH-facing or SOUTH-facing Avenues
                avenueTargetCurb = getAvenueCurbForTurn("NORTHEAST", "SOUTHEAST", junctionAvenue, junction);
            }
            case WEST -> {
                // WEST-facing Street connects to NORTH-facing or SOUTH-facing Avenues
                avenueTargetCurb = getAvenueCurbForTurn("NORTHWEST", "SOUTHWEST", junctionAvenue, junction);
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

    private static void addEdgesFromStationToCurb(Station headStation, Curb targetCurb) throws Exception {
        // Find the closest station on the target curb
        Station tailStation = findClosestStation(targetCurb, headStation);

        if (tailStation != null) {
            // Create a new edge
            Edge newEdge = new Edge(edgeId.incrementAndGet(), headStation, tailStation, 0, 0, 0);

            // Add the edge to the outgoing and incoming edge lists
            headStation.getOutgoingEdges().add(newEdge);
            tailStation.getIncomingEdges().add(newEdge);
            EdgeCatalog.INSTANCE.getCatalog().add(newEdge);

            System.out.println("Created Edge: " + newEdge);
        }
    }

    private static Station findClosestStation(Curb targetCurb, Station sourceStation) {
        // Find the station on the target Curb with the smallest block ID difference
        Station closestStation = null;
        long distance = Long.MAX_VALUE;
        long minDistance = Long.MAX_VALUE;

        for (Station targetStation : StationCatalog.INSTANCE.getCatalog().getStations()) {
            if (targetStation.getBlock().getCurb().equals(targetCurb)) {
                distance = Math.abs(sourceStation.getBlock().getId() - targetStation.getBlock().getId());
            }
            if (distance < minDistance) {
                closestStation = targetStation;
                minDistance = distance;
            }
        }

        return closestStation;
    }
}