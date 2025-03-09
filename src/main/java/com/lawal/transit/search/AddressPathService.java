package com.lawal.transit.search;

import com.lawal.transit.address.model.Address;
import com.lawal.transit.station.model.Station;
import com.lawal.transit.station.model.StationEdge;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AddressPathService {

    /**
     * Finds the shortest path between two addresses by computing the closest stations and then
     * finding the shortest path between these stations.
     *
     * @param fromAddress  The starting address.
     * @param toAddress    The destination address.
     * @param stationGraph The graph of stations and connections (edges).
     * @return PathResult containing the shortest path including hops and its distance, or an empty collection if no path is possible.
     */
    public static PathResult findShortestPathBetweenAddresses(Address fromAddress, Address toAddress, Map<Station, List<StationEdge>> stationGraph) {
        // Validate input addresses
        if (fromAddress == null || toAddress == null) {
            throw new IllegalArgumentException("Addresses must not be null.");
        }

        // Find the closest station for the source address
        StationFinder.ClosestStationResult fromStationResult = StationFinder.findClosestStationWithHops(fromAddress);
        if (fromStationResult == null) {
            System.err.println("No reachable station for the source address: " + fromAddress);
            return new PathResult(Collections.emptyList(), 0, 0); // Return empty path result
        }

        // Find the closest station for the destination address
        StationFinder.ClosestStationResult toStationResult = StationFinder.findClosestStationWithHops(toAddress);
        if (toStationResult == null) {
            System.err.println("No reachable station for the destination address: " + toAddress);
            return new PathResult(Collections.emptyList(), 0, 0); // Return empty path result
        }

        // Extract stations and hops
        Station fromStation = fromStationResult.getStation();
        int fromHops = fromStationResult.getHops();
        Station toStation = toStationResult.getStation();
        int toHops = toStationResult.getHops();

        // Validate the station graph and connectivity
        if (stationGraph == null || stationGraph.isEmpty()) {
            System.err.println("Station graph is empty or null. Cannot compute the path.");
            return new PathResult(Collections.emptyList(), 0, 0); // Return empty path result
        }

        // Find the shortest path between the two closest stations
        PathResult stationToStationResult = StationGraph.findShortestPath(fromStation, toStation, stationGraph);
        if (stationToStationResult == null || stationToStationResult.getPath().isEmpty()) {
            System.err.println("No path exists between stations: " + fromStation + " and " + toStation);
            return new PathResult(Collections.emptyList(), 0, 0); // Return empty path result
        }

        // Calculate total hops (address-to-station hops + station-to-station path hops)
        int totalHops = fromHops + toHops;
        return new PathResult(stationToStationResult.getPath(), stationToStationResult.getDistance(), totalHops);
    }
}