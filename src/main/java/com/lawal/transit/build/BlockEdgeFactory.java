package com.lawal.transit.build;

import com.lawal.transit.block.model.Block;
import com.lawal.transit.block.model.BlockEdge;
import com.lawal.transit.catalog.BlockEdgeCatalog;
import com.lawal.transit.catalog.JunctionCatalog;
import com.lawal.transit.global.Direction;
import com.lawal.transit.junction.model.Junction;

import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicLong;

public enum BlockEdgeFactory {

    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public void run() {
        buildJunctionCornerEdges();
    }

    private void buildNorthSourEdges(Junction junction) {

        if (junction == null) return;;

        Block u1 = junction.getCornerByOrientation(Direction.NORTHWEST).getAvenueLeg();
        Block v1 = junction.getCornerByOrientation(Direction.SOUTHWEST   ).getAvenueLeg();

        BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), u1, v1));
        BlockEdgeCatalog.INSTANCE.addEdge( new BlockEdge(id.incrementAndGet(), v1, u1));

        Block u2 = junction.getCornerByOrientation(Direction.NORTHEAST).getAvenueLeg();
        Block v2 = junction.getCornerByOrientation(Direction.SOUTHEAST ).getAvenueLeg();

        BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), u2, v2 ));
        BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), v2, u2));
    }

    private void buildEastWestEdges(Junction junction) {
        if (junction == null) return;;

        Block u1 = junction.getCornerByOrientation(Direction.NORTHWEST).getStreetLeg();
        Block v1 = junction.getCornerByOrientation(Direction.SOUTHWEST).getStreetLeg();

        BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), u1, v1));
        BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), v1, u1));

        Block u2 = junction.getCornerByOrientation(Direction.NORTHEAST).getStreetLeg();
        Block v2 = junction.getCornerByOrientation(Direction.SOUTHEAST ).getStreetLeg();

        BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), u2, v2));
        BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), v2, u2));
    }

    private void buildEdges () {
        for (Junction junction : JunctionCatalog.INSTANCE.getCatalog()) {
            buildJunctionCornerEdges(junction);
        }
    }

    private void buildJunctionCornerEdges (Junction junction) {
        if (junction == null) return;;

        EnumSet<Direction> cornerEdges = EnumSet.of(
            Direction.NORTHWEST,
            Direction.NORTHEAST,
            Direction.SOUTHWEST,
            Direction.SOUTHEAST
        );
        for (Direction cornerOrientation : cornerEdges) { cornerEdgeBuildHelper(junction, cornerOrientation); }
    }

    private void cornerEdgeBuildHelper (Junction junction, Direction cornerOrientation) {
        if (junction == null || cornerOrientation == null) return;;

        Block u = junction.getCornerByOrientation(cornerOrientation).getStreetLeg();
        Block v = junction.getCornerByOrientation(cornerOrientation).getAvenueLeg();

        BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), u, v));
        BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), v, u));
    }
}