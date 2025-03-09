package com.lawal.transit.search;

import com.lawal.transit.address.model.Address;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.junction.model.JunctionCorner;

import java.util.*;

public class ClosestStationFinder {

    // Find the closest block with a station using a radius-based search
    public static Block findClosestBlockWithStation(Address address, List<Junction> allJunctions) {
        if (address == null || address.getBlock() == null) {
            throw new IllegalArgumentException("Address or its associated block cannot be null.");
        }

        Block startingBlock = address.getBlock();

        // Set to track already visited blocks to prevent redundant searches
        Set<Block> visitedBlocks = new HashSet<>();
        Queue<Block> queue = new LinkedList<>();

        // Add initial block and its JunctionCorner blocks as the first "layer" of radius
        queue.addAll(getJunctionCornerBlocks(startingBlock, allJunctions));

        while (!queue.isEmpty()) {
            int layerSize = queue.size();  // process this layer of blocks (current "radius")

            // Check all blocks in the current layer for stations
            for (int i = 0; i < layerSize; i++) {
                Block currentBlock = queue.poll();
                if (currentBlock == null || visitedBlocks.contains(currentBlock)) {
                    continue;
                }

                // Mark as visited
                visitedBlocks.add(currentBlock);

                // If the block has a station, return it
                if (currentBlock.getStation() != null) {
                    return currentBlock;
                }

                // Discover neighboring blocks and add to the queue for the next layer
                queue.addAll(getNeighboringBlocks(currentBlock, allJunctions));
            }
        }

        // No block with a station found in the search
        return null;
    }

    // Get related blocks via the same JunctionCorner as the current block
    private static List<Block> getJunctionCornerBlocks(Block block, List<Junction> allJunctions) {
        List<Block> relatedBlocks = new ArrayList<>();

        if (block == null) return relatedBlocks;

        // Add the block itself
        relatedBlocks.add(block);

        // Find and add blocks from the relevant JunctionCorner
        for (Junction junction : allJunctions) {
            for (JunctionCorner corner : junction.getCorners()) {
                if (corner.containsBlock(block)) {
                    Block avenueLeg = corner.getAvenueLeg();
                    Block streetLeg = corner.getStreetLeg();

                    if (avenueLeg != null && !relatedBlocks.contains(avenueLeg)) {
                        relatedBlocks.add(avenueLeg);
                    }

                    if (streetLeg != null && !relatedBlocks.contains(streetLeg)) {
                        relatedBlocks.add(streetLeg);
                    }

                    // Add all blocks belonging to neighboring corners in the same junction
                    for (JunctionCorner otherCorner : junction.getCorners()) {
                        if (!otherCorner.equals(corner)) {
                            Block otherCornerAvenueLeg = otherCorner.getAvenueLeg();
                            Block otherCornerStreetLeg = otherCorner.getStreetLeg();

                            if (otherCornerAvenueLeg != null && !relatedBlocks.contains(otherCornerAvenueLeg)) {
                                relatedBlocks.add(otherCornerAvenueLeg);
                            }
                            if (otherCornerStreetLeg != null && !relatedBlocks.contains(otherCornerStreetLeg)) {
                                relatedBlocks.add(otherCornerStreetLeg);
                            }
                        }
                    }
                }
            }
        }

        return relatedBlocks;
    }

    // Get neighboring blocks of a given block via other junctions and connections
    private static List<Block> getNeighboringBlocks(Block block, List<Junction> allJunctions) {
        List<Block> neighbors = new ArrayList<>();

        if (block == null) return neighbors;

        // Find relevant JunctionCorner for the block
        for (Junction junction : allJunctions) {
            for (JunctionCorner corner : junction.getCorners()) {
                if (corner.containsBlock(block)) {
                    // Add other blocks in this corner
                    Block avenueLeg = corner.getAvenueLeg();
                    Block streetLeg = corner.getStreetLeg();

                    if (avenueLeg != null && !neighbors.contains(avenueLeg)) {
                        neighbors.add(avenueLeg);
                    }
                    if (streetLeg != null && !neighbors.contains(streetLeg)) {
                        neighbors.add(streetLeg);
                    }

                    // Add blocks from corners of connected junctions
                    for (Junction connectedJunction : getConnectedJunctions(junction, allJunctions)) {
                        for (JunctionCorner connectedCorner : connectedJunction.getCorners()) {
                            Block connectedAvenueLeg = connectedCorner.getAvenueLeg();
                            Block connectedStreetLeg = connectedCorner.getStreetLeg();

                            if (connectedAvenueLeg != null && !neighbors.contains(connectedAvenueLeg)) {
                                neighbors.add(connectedAvenueLeg);
                            }
                            if (connectedStreetLeg != null && !neighbors.contains(connectedStreetLeg)) {
                                neighbors.add(connectedStreetLeg);
                            }
                        }
                    }
                }
            }
        }

        return neighbors;
    }

    // Get connected junctions (expand search radius)
    private static List<Junction> getConnectedJunctions(Junction junction, List<Junction> allJunctions) {
        List<Junction> connectedJunctions = new ArrayList<>();
        if (junction == null) return connectedJunctions;

        // This logic depends on your domain model. For simplicity, let's assume a basic connection rule:
        for (Junction otherJunction : allJunctions) {
            if (otherJunction.equals(junction)) continue;

            if (junction.getAvenue().equals(otherJunction.getAvenue()) ||
                junction.getStreet().equals(otherJunction.getStreet())) {
                connectedJunctions.add(otherJunction);
            }
        }

        return connectedJunctions;
    }
}