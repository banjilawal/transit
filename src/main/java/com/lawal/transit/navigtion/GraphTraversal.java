//package com.lawal.transit;
//
//import com.lawal.transit.avenue.model.Avenue;
//import com.lawal.transit.block.model.Block;
//import com.lawal.transit.edge.model.Edge;
//import com.lawal.transit.global.TurnCategory;
//import com.lawal.transit.junction.model.Junction;
//import com.lawal.transit.junction.model.JunctionCorner;
//import com.lawal.transit.station.model.Station;
//import com.lawal.transit.street.model.Street;
//
//import java.util.List;
//
//
//public class GraphTraversal {
//
//    /**
//     * Traverse the graph to find all outgoing and incoming edges for each station.
//     */
//    public void findEdgesForAllStations(List<Station> stations, List<Junction> junctions) {
//        for (Station station : stations) {
//            Block currentBlock = station.getBlock();
//            if (currentBlock == null) {
//                continue; // Skip stations not associated with a block
//            }
//
//            Avenue avenue = currentBlock.getAvenue();
//            Street street = currentBlock.getStreet();
//
//            // Process outgoing edges
//            for (TurnCategory turn : TurnCategory.values()) {
//                findOutgoingEdge(station, currentBlock, turn, avenue, street, junctions);
//            }
//
//            // Process incoming edges
//            for (TurnCategory turn : TurnCategory.values()) {
//                findIncomingEdge(station, currentBlock, turn, avenue, street, junctions);
//            }
//        }
//    }
//
//    private void findOutgoingEdge(
//        Station station,
//        Block currentBlock,
//        TurnCategory turnCategory,
//        Avenue avenue,
//        Street street,
//        List<Junction> junctions
//    ) {
//        // Determine if the block resides on an Avenue or Street
//        Block destinationBlock = null;
//
//        // Find the junction where this station resides
//        Junction currentJunction = findJunctionForBlock(currentBlock, junctions);
//
//        if (currentBlock.getCurb().getOrientation().isVertical()) {
//            // Block is part of an Avenue
//            destinationBlock = TurnNavigator.getDestinationBlockFromAvenue(currentJunction, currentBlock, turnCategory);
//        } else {
//            // Block is part of a Street
//            destinationBlock = TurnNavigator.getDestinationBlockFromStreet(currentJunction, currentBlock, turnCategory);
//        }
//
//        if (destinationBlock != null && destinationBlock.getStation() != null) {
//            Station nextStation = destinationBlock.getStation();
//
//            // Create an edge from the current station to the next station
//            Edge outgoingEdge = new Edge(
//                edgeId.incrementAndGet(), // Unique ID for the edge
//                station,                  // Head (current station)
//                nextStation,              // Tail (next station)
//                calculateDistance(currentBlock, destinationBlock), // Example: calculate actual distance
//                estimateTime(currentBlock, destinationBlock),      // Example: calculate time cost
//                calculateHeuristic(currentBlock, destinationBlock) // Example: heuristic value
//            );
//
//            // Add the edge to the station's outgoing list
//            station.addOutgoingEdge(outgoingEdge);
//            nextStation.addIncomingEdge(outgoingEdge); // Append to the tail station's incoming edges
//        }
//    }
//
//    private void findIncomingEdge(
//        Station station,
//        Block currentBlock,
//        TurnCategory turnCategory,
//        Avenue avenue,
//        Street street,
//        List<Junction> junctions
//    ) {
//        // To find incoming edges, reverse the logic of outgoing edges
//        // Use the reverse turn to determine where the current station could be reached from
//        TurnCategory reverseTurn = turnCategory.reverse();
//
//        for (Junction junction : junctions) {
//            Block potentialSourceBlock = null;
//
//            // Attempt to find a source block using the reverse turn category
//            if (currentBlock.getCurb().getOrientation().isVertical()) {
//                potentialSourceBlock = TurnNavigator.getDestinationBlockFromAvenue(junction, currentBlock, reverseTurn);
//            } else {
//                potentialSourceBlock = TurnNavigator.getDestinationBlockFromStreet(junction, currentBlock, reverseTurn);
//            }
//
//            if (potentialSourceBlock != null && potentialSourceBlock.getStation() != null) {
//                Station sourceStation = potentialSourceBlock.getStation();
//
//                // Create an edge from the source station to the current station
//                Edge incomingEdge = new Edge(
//                    edgeId.incrementAndGet(),
//                    sourceStation,               // Head (source station)
//                    station,                     // Tail (current station)
//                    calculateDistance(potentialSourceBlock, currentBlock),
//                    estimateTime(potentialSourceBlock, currentBlock),
//                    calculateHeuristic(potentialSourceBlock, currentBlock)
//                );
//
//                // Add the edge to the station's incoming list
//                station.addIncomingEdge(incomingEdge);
//                sourceStation.addOutgoingEdge(incomingEdge); // Append to the source station's outgoing edges
//            }
//        }
//    }
//
//    private double calculateDistance(Block sourceBlock, Block destinationBlock) {
//        // Example logic to calculate distance between blocks
//        return Math.sqrt(Math.pow(sourceBlock.getId() - destinationBlock.getId(), 2));
//    }
//
//    private double estimateTime(Block sourceBlock, Block destinationBlock) {
//        // Example logic for estimating time between blocks
//        return calculateDistance(sourceBlock, destinationBlock) * 1.5; // Placeholder multiplier
//    }
//
//    private double calculateHeuristic(Block sourceBlock, Block destinationBlock) {
//        // Heuristic for A* or other algorithms
//        return calculateDistance(sourceBlock, destinationBlock);
//    }
//
//    private Junction findJunctionForBlock(Block block, List<Junction> junctions) {
//        // Example logic: Return the junction associated with the block
//        for (Junction junction : junctions) {
//            for (JunctionCorner corner : junction.getCorners()) {
//                if (corner.getAvenueLeg().equals(block) || corner.getStreetLeg().equals(block)) {
//                    return junction;
//                }
//            }
//        }
//        return null;
//    }
//}