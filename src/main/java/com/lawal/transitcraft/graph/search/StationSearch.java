package com.lawal.transitcraft.graph.search;

import com.lawal.transitcraft.infrastructure.block.Block;
import com.lawal.transitcraft.infrastructure.block.BlockEdge;
import com.lawal.transitcraft.infrastructure.catalog.BlockCatalog;
import com.lawal.transitcraft.graph.VertexColor;
import com.lawal.transitcraft.infrastructure.house.House;
import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

public class StationSearch {

    @Getter
    private static int hopCount = 0;

    public static Queue<Block> search(House house) {
        // Localized state for each search
        Queue<Block> queue = new LinkedList<>();
        Queue<Block> processed = new LinkedList<>();

        if (house == null) return processed;
        Block source = house.getBlock();

        // Initialize all blocks in the catalog
        for (Block block : BlockCatalog.INSTANCE.getCatalog()) {
            block.setColor(VertexColor.WHITE);
//            block.setHopCount(0);
            block.setPredecessorId(null);
        }

        // Handle the edge case if the source block has a station
        if (source.getStation() != null) {
            source.setColor(VertexColor.BLACK);
//            source.setHopCount(0); // Hop count for the source is always 0
            processed.add(source);
            return processed;
        }

        // Initialize the starting block
        source.setColor(VertexColor.GRAY);
//        source.setHopCount(0);
        queue.add(source);

        return bfs(queue, processed);
    }

    private static Queue<Block> bfs(Queue<Block> queue, Queue<Block> processed) {
        // Add a level marker (null) to indicate the end of the current level
        queue.add(null);
        hopCount = 0; // Reset hopCount for the new search

        while (!queue.isEmpty()) {
            Block u = queue.poll();

            // Check for level marker
            if (u == null) {
                // Increment hopCount when moving to the next level
                hopCount++;

                // If the queue still has elements, add another level marker
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                continue;
            }

            // Process the current node
            for (BlockEdge e : u.getOutgoingEdges()) {
                Block v = e.getTail();
                if (v.getColor() == VertexColor.WHITE) {
                    v.setColor(VertexColor.GRAY);
                    v.setPredecessorId(u.getId());
                    v.setHopCount(hopCount + 1);
                    if (v.getStation() != null) {
                        // Stop search once the station is found
                        v.setColor(VertexColor.BLACK);
//                        System.out.println("Found station!! v:" + v.getId()
//                            + " hopCount:" + hopCount
//                            + " predecessorId:" + u.getId()
//                            + " station:" + v.getStation());
                        processed.add(v);
                        return processed;
                    }
                    queue.add(v);
                }
            }
            u.setColor(VertexColor.BLACK);
            processed.add(u);
//            System.out.println("Processed:" + u + " hopCount:" + hopCount);
        }
        return processed;
    }


}