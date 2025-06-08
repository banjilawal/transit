package com.lawal.transitcraft.graph.search;

import com.lawal.transitcraft.infrastructure.station.Station;

import java.util.List;

public class PathResult {
    private final List<Station> path; // Ordered list of stations in the shortest path
    private final int distance;      // Total distance or weight of the path
    private final int totalHops;     // Total hops (house-to-station hops + station-to-station hops)

    // Updated constructor with total hops
    public PathResult(List<Station> path, int distance, int totalHops) {
        this.path = path;
        this.distance = distance;
        this.totalHops = totalHops;
    }

    public List<Station> getPath() {
        return path;
    }

    public int getDistance() {
        return distance;
    }

    public int getTotalHops() {
        return totalHops;
    }

    @Override
    public String toString() {
        return "PathResult{" +
            "path=" + path +
            ", distance=" + distance +
            ", totalHops=" + totalHops +
            '}';
    }
}