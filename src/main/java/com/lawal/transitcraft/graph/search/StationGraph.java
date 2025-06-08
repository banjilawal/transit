package com.lawal.transitcraft.graph.search;

import com.lawal.transitcraft.infrastructure.station.Station;
import com.lawal.transitcraft.infrastructure.station.StationEdge;

import java.util.*;

public class StationGraph {

    /**
     * Finds the shortest path between two stations using Dijkstra's Algorithm,
     * and returns the result including the path and its total distance.
     *
     * @param fromStation  The starting station.
     * @param toStation    The destination station.
     * @param stationGraph A map representing the graph of stations (edges between stations).
     * @return PathResult containing the shortest path and distance, or null if no path exists.
     */
    public static PathResult findShortestPath(Station fromStation, Station toStation, Map<Station, List<StationEdge>> stationGraph) {
        if (fromStation == null || toStation == null) {
            throw new IllegalArgumentException("Stations cannot be null");
        }

        // Priority queue for Dijkstra's algorithm
        PriorityQueue<StationDistance> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(StationDistance::getDistance));
        Map<Station, Integer> distances = new HashMap<>();
        Map<Station, Station> previous = new HashMap<>();
        Set<Station> visited = new HashSet<>();

        distances.put(fromStation, 0);
        priorityQueue.add(new StationDistance(fromStation, 0));

        while (!priorityQueue.isEmpty()) {
            StationDistance current = priorityQueue.poll();
            Station currentStation = current.getStation();

            if (visited.contains(currentStation)) {
                continue;
            }
            visited.add(currentStation);

            if (currentStation.equals(toStation)) {
                return reconstructPath(previous, toStation, distances.get(toStation)); // Return when reaching the target
            }

            for (StationEdge edge : stationGraph.getOrDefault(currentStation, Collections.emptyList())) {
                Station neighbor = edge.getTail();
                int weight = edge.getWeight();
                int newDistance = distances.getOrDefault(currentStation, Integer.MAX_VALUE) + weight;

                if (newDistance < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distances.put(neighbor, newDistance);
                    previous.put(neighbor, currentStation);
                    priorityQueue.add(new StationDistance(neighbor, newDistance));
                }
            }
        }

        return null; // No path found
    }

    private static PathResult reconstructPath(Map<Station, Station> previous, Station targetStation, int distance) {
        List<Station> path = new LinkedList<>();
        Station current = targetStation;

        while (current != null) {
            path.add(0, current);
            current = previous.get(current);
        }

        return new PathResult(path, distance, 0); // We'll calculate total hops later
    }

    private static class StationDistance {
        private final Station station;
        private final int distance;

        public StationDistance(Station station, int distance) {
            this.station = station;
            this.distance = distance;
        }

        public Station getStation() {
            return station;
        }

        public int getDistance() {
            return distance;
        }
    }
}