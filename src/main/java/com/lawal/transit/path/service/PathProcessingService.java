package com.lawal.transit.path.service;

import com.lawal.transit.edge.EdgeRepo;
import com.lawal.transit.edge.model.Edge;
import com.lawal.transit.path.model.Path;
import com.lawal.transit.station.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service // Mark this as a Spring service
public class PathProcessingService {

    private final EdgeRepo edgeRepo;

    @Autowired
    public PathProcessingService(EdgeRepo edgeRepo) {
        this.edgeRepo = edgeRepo; // Inject the EdgeRepository for querying edges
    }

    /**
     * Finds the cheapest path between two stations using Dijkstra's Algorithm.
     * @param startStation The source station.
     * @param endStation The destination station.
     * @return A Path object representing the cheapest path, or null if no path exists.
     */
    public Path findCheapestPath(Station startStation, Station endStation) {
        // Priority Queue for Dijkstra's algorithm
        PriorityQueue<StationWeightPair> pq = new PriorityQueue<>(Comparator.comparingInt(StationWeightPair::getWeight));
        Map<Station, Integer> distances = new HashMap<>();
        Map<Station, Station> predecessors = new HashMap<>(); // To track the actual path

        // Initialize distances and populate the priority queue
        for (Station station : getAllStations()) { // Simulated getAllStations() here
            distances.put(station, Integer.MAX_VALUE); // Infinity as initial distance
        }
        distances.put(startStation, 0);
        pq.add(new StationWeightPair(startStation, 0));

        // Dijkstra's Algorithm
        while (!pq.isEmpty()) {
            StationWeightPair current = pq.poll();
            Station currentStation = current.getStation();

            // Stop if we've reached the destination
            if (currentStation.equals(endStation)) {
                break;
            }

            // Fetch outgoing edges from the current station
            List<Edge> outgoingEdges = edgeRepo.findByHeadStation(currentStation);
            for (Edge edge : outgoingEdges) {
                Station tailStation = edge.getTailStation();
                int newDistance = distances.get(currentStation) + edge.getWeight();

                // Relaxation step: If a shorter path to the tailStation is found
                if (newDistance < distances.get(tailStation)) {
                    distances.put(tailStation, newDistance);
                    predecessors.put(tailStation, currentStation);
                    pq.add(new StationWeightPair(tailStation, newDistance));
                }
            }
        }

        // Backtrack to construct the path
        List<Edge> pathEdges = new ArrayList<>();
        int totalWeight = buildPath(predecessors, endStation, pathEdges);

        // If no path found, return null
        if (totalWeight < 0) {
            return null; // No path exists
        }

        return new Path(startStation, endStation, pathEdges, totalWeight);
    }

    private int buildPath(Map<Station, Station> predecessors, Station endStation, List<Edge> pathEdges) {
        Station current = endStation;
        int totalWeight = 0;

        while (predecessors.containsKey(current)) {
            Station predecessor = predecessors.get(current);
            Edge edge = edgeRepo.findByHeadStationAndTailStation(predecessor, current).get(0); // Simplified to get the first matching edge (can fetch all and filter the shortest)
            pathEdges.add(0, edge); // Add edge to the front of the path list (reverse order)
            totalWeight += edge.getWeight();
            current = predecessor;
        }

        return pathEdges.isEmpty() ? -1 : totalWeight; // If no edges, no path exists
    }

    // Mocked method to fetch all stations for demonstration. Replace with repository call.
    private List<Station> getAllStations() {
        return new ArrayList<>(); // Use StationRepository or a service to fetch stations
    }

    /**
     * Helper class to represent a station and its distance/weight in the Dijkstra's priority queue.
     */
    private static class StationWeightPair {
        private final Station station;
        private final int weight;

        public StationWeightPair(Station station, int weight) {
            this.station = station;
            this.weight = weight;
        }

        public Station getStation() {
            return station;
        }

        public int getWeight() {
            return weight;
        }
    }
}