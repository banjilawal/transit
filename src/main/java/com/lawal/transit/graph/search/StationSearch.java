package com.lawal.transit.graph.search;

import com.lawal.transit.infrastructure.block.Block;
import com.lawal.transit.infrastructure.block.BlockEdge;
import com.lawal.transit.infrastructure.catalog.BlockCatalog;
import com.lawal.transit.graph.VertexColor;
import com.lawal.transit.infrastructure.house.House;

import java.util.LinkedList;
import java.util.Queue;

public class StationSearch {

    public static Queue<Block> search(House house) {
        // Localized state for each search
        Queue<Block> queue = new LinkedList<>();
        Queue<Block> processed = new LinkedList<>();

        if (house == null) return processed;
        Block source = house.getBlock();

        // Initialize all blocks in the catalog
        for (Block block : BlockCatalog.INSTANCE.getCatalog()) {
            block.setColor(VertexColor.WHITE);
            block.setHopCount(Integer.MAX_VALUE);
            block.setPredecessorId(null);
        }

        // Handle the edge case if the source block has a station
        if (source.getStation() != null) {
            source.setColor(VertexColor.BLACK);
            source.setHopCount(0); // Hop count for the source is always 0
            processed.add(source);
            return processed;
        }

        // Initialize the starting block
        source.setColor(VertexColor.GRAY);
        source.setHopCount(0);
        queue.add(source);

        return bfs(queue, processed);
    }


    private static Queue<Block> bfs (Queue<Block> queue, Queue<Block> processed) {
        while (!queue.isEmpty()) {
            Block u = queue.poll();

//            System.out.println("popped:" + u);
            for (BlockEdge e : u.getOutgoingEdges()) {
                Block v = e.getTail();
                if (v.getColor() == VertexColor.WHITE) {
                    v.setColor(VertexColor.GRAY);
                    v.setHopCount(u.getHopCount() + 1);
                    v.setPredecessorId(u.getId());
                    if (v.getStation() != null) {
                        v.setColor(VertexColor.BLACK);
                        System.out.println("found station!! v:" + v.getId()
                            + " hopCount:" + v.getHopCount()
                            + " predecessorId:" + u.getId()
                            + " station:" + v.getStation()
                        );
                        processed.add(v);
                        return processed;
                    }
                    System.out.println("v outgoings " + v.getOutgoingEdges().size() + " hopCount:" + v.getHopCount() + " predecessorId:" + v.getPredecessorId());
                    queue.add(v);
                }
            }
            u.setColor(VertexColor.BLACK);
            System.out.println("processed:" + u + " hopCount:" + u.getHopCount());
            processed.add(u);
        }
        return processed;
    }
}