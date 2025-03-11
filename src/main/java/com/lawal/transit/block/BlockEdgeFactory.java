package com.lawal.transit.block;

import com.lawal.transit.block.model.Block;
import com.lawal.transit.block.model.BlockEdge;
import com.lawal.transit.catalog.BlockEdgeCatalog;
import com.lawal.transit.catalog.JunctionCatalog;
import com.lawal.transit.global.Direction;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.junction.model.JunctionCorner;

import java.util.concurrent.atomic.AtomicLong;

public enum BlockEdgeFactory {

    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    private void cornerEdgeHelper (JunctionCorner corner) {
        Block streetBlock = corner.getStreetLeg();
        Block avenueBlock = corner.getAvenueLeg();

        BlockEdge edge1 = new BlockEdge(id.incrementAndGet(), streetBlock, avenueBlock, 1);
        BlockEdgeCatalog.INSTANCE.addEdge(edge1);

        BlockEdge edge2 = new BlockEdge(id.incrementAndGet(), avenueBlock, streetBlock, 1);
        BlockEdgeCatalog.INSTANCE.addEdge(edge2);
    }

    public void buildCornerEdges (Junction junction) {
        for (JunctionCorner corner : junction.getCorners()) {
            cornerEdgeHelper(corner);
        }
    }

    public void buildEastWestCurbEdges (Junction junction) {
        Block eastBlockA = junction.getCornerByOrientation(Direction.NORTHEAST).getStreetLeg();
        Block westBlockA = junction.getCornerByOrientation(Direction.NORTHWEST).getStreetLeg();

        BlockEdge edge1 = new BlockEdge(id.incrementAndGet(), eastBlockA, westBlockA, 1);
        BlockEdgeCatalog.INSTANCE.addEdge(edge1);

        BlockEdge edge2 = new BlockEdge(id.incrementAndGet(), westBlockA, eastBlockA, 1);
        BlockEdgeCatalog.INSTANCE.addEdge(edge2);

        Block eastBlockB = junction.getCornerByOrientation(Direction.SOUTHEAST).getStreetLeg();
        Block westBlockB = junction.getCornerByOrientation(Direction.SOUTHWEST).getStreetLeg();

        BlockEdge edge3 = new BlockEdge(id.incrementAndGet(), eastBlockB, westBlockB, 1);
        BlockEdgeCatalog.INSTANCE.addEdge(edge3);

        BlockEdge edge4 = new BlockEdge(id.incrementAndGet(), westBlockB, eastBlockB, 1);
        BlockEdgeCatalog.INSTANCE.addEdge(edge4);
    }

    public void buildNorthSouthCurbEdges (Junction junction) {
        Block northBlockA = junction.getCornerByOrientation(Direction.NORTHWEST).getAvenueLeg();
        Block southBlockA = junction.getCornerByOrientation(Direction.SOUTHWEST).getAvenueLeg();

        BlockEdge edge1 = new BlockEdge(id.incrementAndGet(), northBlockA, southBlockA, 1);
        BlockEdgeCatalog.INSTANCE.addEdge(edge1);

        BlockEdge edge2 = new BlockEdge(id.incrementAndGet(), southBlockA, northBlockA, 1);
        BlockEdgeCatalog.INSTANCE.addEdge(edge2);

        Block northBlockB = junction.getCornerByOrientation(Direction.NORTHEAST).getAvenueLeg();
        Block southBlockB = junction.getCornerByOrientation(Direction.SOUTHEAST).getAvenueLeg();

        BlockEdge edge3 = new BlockEdge(id.incrementAndGet(), northBlockB, southBlockB, 1);
        BlockEdgeCatalog.INSTANCE.addEdge(edge3);

        BlockEdge edge4 = new BlockEdge(id.incrementAndGet(), southBlockB, northBlockB, 1);
        BlockEdgeCatalog.INSTANCE.addEdge(edge4);
    }

    public void run() {
        for (Junction junction : JunctionCatalog.INSTANCE.getCatalog()) {
            buildCornerEdges(junction);
            buildEastWestCurbEdges(junction);
            buildNorthSouthCurbEdges(junction);
        }
    }
}