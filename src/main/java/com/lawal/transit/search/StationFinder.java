package com.lawal.transit.search;

import com.lawal.transit.address.model.Address;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.block.model.BlockEdge;
import com.lawal.transit.station.model.Station;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class StationFinder {

    /**
     * Finds the closest station to the given address
     * using the Block and BlockEdge structure, and returns
     * the station along with the number of hops to reach it.
     *
     * @param address The starting address
     * @return A result containing the station and the number of hops, or null if no station is reachable
     */
    public static ClosestStationResult findClosestStationWithHops(Address address) {
        if (address == null || address.getBlock() == null) {
            throw new IllegalArgumentException("Address or its Block cannot be null");
        }

        Block startBlock = address.getBlock();

        // If the starting block itself has a station, return it immediately with 0 hops
        if (startBlock.getStation() != null) {
            return new ClosestStationResult(startBlock.getStation(), 0);
        }

        // Use a queue for breadth-first traversal of blocks
        Queue<BlockWithHops> queue = new LinkedList<>();
        Set<Block> visited = new HashSet<>();

        // Initialize with the starting block and 0 hops
        queue.add(new BlockWithHops(startBlock, 0));
        visited.add(startBlock);

        while (!queue.isEmpty()) {
            BlockWithHops current = queue.poll();
            Block currentBlock = current.block;
            int currentHops = current.hops;

            // Look for outgoing edges from the current block
            for (BlockEdge edge : currentBlock.getOutgoingEdges()) {
                Block nextBlock = edge.getTail(); // Tail is the connected block

                if (nextBlock != null && !visited.contains(nextBlock)) {
                    // Check if this block has a station
                    if (nextBlock.getStation() != null) {
                        return new ClosestStationResult(nextBlock.getStation(), currentHops + 1);
                    }

                    // Otherwise, add it to the queue for further traversal
                    visited.add(nextBlock);
                    queue.add(new BlockWithHops(nextBlock, currentHops + 1));
                }
            }
        }

        // No station found
        return null;
    }

    /**
     * Helper class to represent a block with its corresponding number of hops
     */
    private static class BlockWithHops {
        private final Block block;
        private final int hops;

        public BlockWithHops(Block block, int hops) {
            this.block = block;
            this.hops = hops;
        }
    }

    /**
     * Result class to store the closest station and the number of hops
     */
    public static class ClosestStationResult {
        private final Station station;
        private final int hops;

        public ClosestStationResult(Station station, int hops) {
            this.station = station;
            this.hops = hops;
        }

        public Station getStation() {
            return station;
        }

        public int getHops() {
            return hops;
        }

        @Override
        public String toString() {
            return "ClosestStationResult{" +
                "station=" + station +
                ", hops=" + hops +
                '}';
        }
    }
}