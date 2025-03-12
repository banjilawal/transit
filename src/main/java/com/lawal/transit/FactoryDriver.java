package com.lawal.transit;

import com.lawal.transit.block.model.Block;
import com.lawal.transit.build.TransitSystemBuilder;
import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.catalog.*;
import com.lawal.transit.house.model.House;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.search.StationSearch;
import com.lawal.transit.street.model.Street;

import java.util.Queue;


public class FactoryDriver {

//    public static List<Station> findShortestPath(Station start, Station end, Map<Station, List<StationEdge>> graph) {
//        // Priority queue to hold stations and their current known shortest distance
//        PriorityQueue<Station> queue = new PriorityQueue<>(Comparator.comparingInt(distanceMap::get));
//        Map<Station, Integer> distanceMap = new HashMap<>(); // Distance from start to each station
//        Map<Station, Station> previousNodeMap = new HashMap<>(); // To reconstruct the path
//
//        // Initialize distances to infinity and previous nodes to null
//        for (Station station : graph.keySet()) {
//            distanceMap.put(station, Integer.MAX_VALUE);
//            previousNodeMap.put(station, null);
//        }
//
//        // Distance to the start node is always 0
//        distanceMap.put(start, 0);
//        queue.add(start);
//
//        while (!queue.isEmpty()) {
//            Station current = queue.poll();
//
//            // If we reached the destination, stop
//            if (current.equals(end)) {
//                break;
//            }
//
//            // Process all edges (neighbors of the current node)
//            for (StationEdge edge : graph.get(current)) {
//                Station neighbor = edge.target;
//                int tentativeDistance = distanceMap.get(current) + edge.weight;
//
//                // If a shorter path to the neighbor is found
//                if (tentativeDistance < distanceMap.get(neighbor)) {
//                    distanceMap.put(neighbor, tentativeDistance); // Update distance
//                    previousNodeMap.put(neighbor, current); // Update the previous node
//                    queue.add(neighbor); // Add neighbor to queue
//                }
//            }
//        }
//
//        // Reconstruct path from end to start
//        List<Station> path = new LinkedList<>();
//        for (Station at = end; at != null; at = previousNodeMap.get(at)) {
//            path.add(0, at);
//        }
//
//        // If no path exists, return an empty list
//        if (path.size() == 1 && !path.get(0).equals(start)) {
//            return Collections.emptyList();
//        }
//        return path;
//    }

    public static void main(String[] args) throws Exception {
        TransitSystemBuilder.INSTANCE.run();

//        SystemBuilder.launcher();
//        CurbBlockEdgeGenerator.launcher();

        Street street = StreetCatalog.INSTANCE.findById(1L);
        Avenue avenue = AvenueCatalog.INSTANCE.findById(1L);
        Junction junction = JunctionCatalog.INSTANCE.findById(1L);

//        CurbStationEdgeFactory.processCurbs();
//        TurnNavigationTest.avenueTurningTest();
//        TurnNavigationTest.streetTurningTest();
//        FindCornerStation.launcher();
//        TransitRouteFactory.populate();

//        RoadCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        AvenueCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        StreetCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        CurbCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        BlockCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        JunctionCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        StationCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        HouseCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        List<Junction> junctions = JunctionCatalog.INSTANCE.filterByAvenue(avenue);
//        junctions.forEach(j -> {if(j.equals(junction)) j.getCorners().forEach(System.out::println);});
//        JunctionCornerCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        StationEdgeCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        System.out.println(StationEdgeCatalog.INSTANCE.filterByAvenue(avenue).size());
//        StationEdgeCatalog.INSTANCE.filterByStreet(street).forEach(System.out::println);
//        System.out.println(StationEdgeCatalog.INSTANCE.filterByStreet(street).size());
//        StationCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//        TransitRouteCatalog.INSTANCE.filterByRoad(avenue.getRoad()).forEach(System.out::println);
//        TransitRouteCatalog.INSTANCE.filterByRoad(street.getRoad()).forEach(System.out::println);
//        TransitRouteCatalog.INSTANCE.getCatalog().forEach(System.out::println);
//        System.out.println(TransitRouteCatalog.INSTANCE.getCatalog().size());
//        BlockEdgeCatalog.INSTANCE.filterByAvenue(avenue).forEach(System.out::println);
//
        House source = HouseCatalog.INSTANCE.randomHouse();
        System.out.println("source:" + source + " " + source.getBlock().getCurb().getRoadName() + source.getBlock().getOutgoingEdges());
        House destination = HouseCatalog.INSTANCE.findById(20L);

        Queue<Block> path = StationSearch.search(source);
        for (Block block : path) {
            System.out.println(block.getStation().getName()
                + " " +block.getCurb().getRoadName() + block.getCurb().getOrientation() + " predecessor:" +block.getPredecessorId());
        }
//        System.out.println("search path: " + path.size() + " total path=" + path.size() + " total stations="
//            + StationCatalog.INSTANCE.size());
//        System.out.println("search bloks: " + BlockCatalog.INSTANCE.size());
//        System.out.println(source + " " + source.getBlock());
//        StationFinder.ClosestStationResult sourceResult = StationFinder.findClosestStationWithHops(source);
//        StationFinder.ClosestStationResult destinationResult = StationFinder.findClosestStationWithHops(destination);
//
//        if (sourceResult  != null) {
//            System.out.println("Closest source station: " + sourceResult .getStation() + " " + sourceResult.getStation().getBlock());// + " " + result.getStation().getBlock().getCurb().getRoadName());
//            System.out.println("Number of hops to source station: " + sourceResult.getHops());
//        } else {
//            System.out.println("No station reachable from the source house.");
//        }
//
//        if (destinationResult != null) {
//            System.out.println("Closest destination station: " + destinationResult.getStation() + " " + destinationResult.getStation().getBlock());// + " " + result.getStation().getBlock().getCurb().getRoadName());
//            System.out.println("Number of hops to destination station: " + destinationResult.getHops());
//        } else {
//            System.out.println("No station reachable from the destination house.");
//        }

//        Map<Station, List<StationEdge>> stationGraph = new HashMap<>();
//        PathResult result1 = AddressPathService.findShortestPathBetweenAddresses(source, destination, stationGraph);
//        if (result1 != null) {
//            System.out.println("Shortest path: " + result1.getPath());
//            System.out.println("Distance: " + result1.getDistance());
//            System.out.println("Total hops: " + result1.getTotalHops());
//        } else {
//            System.out.println("No path exists between the given addresses.");
//        }
//        Block block = house.getBlock();
//        System.out.println(house);
//        System.out.println(house.getBlock());
//        List<Junction> junctions = JunctionCatalog.INSTANCE.filterByRoad(block.getCurb().getRoad());
    }
}