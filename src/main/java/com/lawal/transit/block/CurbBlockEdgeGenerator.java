package com.lawal.transit.block;

import com.lawal.transit.block.model.Block;
import com.lawal.transit.block.model.BlockEdge;
import com.lawal.transit.catalog.*;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.junction.model.JunctionCorner;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.station.model.Station;
import com.lawal.transit.station.model.StationEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class CurbBlockEdgeGenerator {

    private static AtomicLong id = new AtomicLong(0);

    public static Block getFirstBlock(Curb curb) {
        if (curb == null) return null;
        if (curb.getBlocks().isEmpty()) return null;
        return curb.getBlocks().get(0);
    }

    public static Block getLastBlock(Curb curb) {
        if (curb == null) return null;
        if (curb.getBlocks().isEmpty()) return null;
        return curb.getBlocks().get(curb.getBlocks().size() - 1);
    }

    public static void createEdges(Curb curb) {
        if (curb == null || curb.getBlocks().isEmpty()) return;

        Block previousBlock = getFirstBlock(curb);
//        System.out.println("previous block" + previousBlock);
        if (previousBlock == null) return;

        for (Block block : curb.getBlocks()) {
            if (block.equals(previousBlock)) continue;
            BlockEdge edge = new BlockEdge(id.incrementAndGet(), previousBlock, block, 1);
            BLockEdgeCatalog.INSTANCE.addEdge(edge);
//            System.out.println("Curb Edge:" + edge);
            previousBlock = block;
        }
    }

    public static void createCornerEdges() {
        for (JunctionCorner corner : JunctionCornerCatalog.INSTANCE.getCatalog()) {
            BlockEdge edge = new BlockEdge(id.incrementAndGet(), corner.getAvenueLeg(), corner.getStreetLeg(), 1);
            BLockEdgeCatalog.INSTANCE.addEdge(edge);
//            System.out.println("\tCorner Edge:" + edge);
        }
    }

    public static void createRoadEdges() {
        for (Road road : RoadCatalog.INSTANCE.getCatalog()) {
            Curb leftCurb = road.getLeftCurb();
            Curb rightCurb = road.getRightCurb();
            for (Block leftBlock : leftCurb.getBlocks()) {
                int leftIndex = leftCurb.getBlocks().indexOf(leftBlock);
                for (Block rightBlock : rightCurb.getBlocks()) {
                    int rightIndex = rightCurb.getBlocks().indexOf(rightBlock);
//                    System.out.println("Left blockId:" + leftBlock.getId() + " Right blockId:" + rightBlock.getId());
                    if (leftIndex == rightIndex) {
                        BlockEdge edge = new BlockEdge(id.incrementAndGet(), leftBlock, rightBlock, 1);
                        BLockEdgeCatalog.INSTANCE.addEdge(edge);
//                        System.out.println("\tRoad Edge:" + edge);
                    }
                }
            }
        }
    }


    public static void launcher() {
        for (Curb curb : CurbCatalog.INSTANCE.getCatalog()) {
            createEdges(curb);
        }
        createCornerEdges();
        createRoadEdges();


    }
}