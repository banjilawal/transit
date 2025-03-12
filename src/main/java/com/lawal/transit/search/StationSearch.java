package com.lawal.transit.search;

import com.lawal.transit.block.model.Block;
import com.lawal.transit.block.model.BlockEdge;
import com.lawal.transit.catalog.BlockCatalog;
import com.lawal.transit.global.VertexColor;
import com.lawal.transit.house.model.House;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StationSearch {

    public static Queue<Block> search(House house) {

        Queue<Block> queue = new LinkedList<>();
        Queue<Block> processed = new LinkedList<>();
        Queue<Block> path = new LinkedList<>();

        if (house == null) return processed;
        Block source = house.getBlock();

        for (Block block : BlockCatalog.INSTANCE.getCatalog()) {
            block.setColor(VertexColor.WHITE);
            block.setHopCount(Integer.MAX_VALUE);
            block.setPredecessorId(null);
        }
        source.setColor(VertexColor.GRAY);
        source.setHopCount(0);
        queue.add(source);

        while (!queue.isEmpty()) {
            Block u = queue.poll();
            for (BlockEdge e : u.getOutgoingEdges()) {
                Block v = e.getTail();
                if (v.getColor() == VertexColor.WHITE) {
                    v.setColor(VertexColor.GRAY);
                    v.setHopCount(u.getHopCount() + 1);
                    v.setPredecessorId(u.getId());
                    if (v.getStation() != null) {
                        path.add(v);
                        System.out.println("v:" + v.getId()
                            + " hopCount:" + v.getHopCount()
                            + " predecessorId:" + u.getId()
                            + " station:" + v.getStation().getName()
                        );
                        return path;
                    }
                    queue.add(v);
                } if (v.getColor() == VertexColor.GRAY) {
                    v.setColor(VertexColor.BLACK);
                    processed.add(v);
                }
            }
        }
        return path;
    }


}