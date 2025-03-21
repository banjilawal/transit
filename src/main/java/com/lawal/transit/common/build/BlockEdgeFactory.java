package com.lawal.transit.common.build;

import com.lawal.transit.infrastructure.block.Block;
import com.lawal.transit.infrastructure.block.BlockEdge;
import com.lawal.transit.infrastructure.catalog.BlockEdgeCatalog;
import com.lawal.transit.infrastructure.catalog.JunctionCatalog;
import com.lawal.transit.common.Direction;
import com.lawal.transit.infrastructure.junction.Junction;

import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicLong;

public enum BlockEdgeFactory {

    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public void run() {
        for (Junction junction : JunctionCatalog.INSTANCE.getCatalog()) {
            buildJunctionCornerEdges(junction);
            buildNorthSouthEdges(junction);
            buildEastWestEdges(junction);
        }
    }

    private void buildNorthSouthEdges(Junction junction) {

        if (junction == null) return;;

        Block u = junction.getCornerByOrientation(Direction.NORTHWEST).getAvenueLeg();
        Block v = junction.getCornerByOrientation(Direction.SOUTHWEST).getAvenueLeg();

        BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), u, v));
        BlockEdgeCatalog.INSTANCE.addEdge( new BlockEdge(id.incrementAndGet(), v, u));

        u = junction.getCornerByOrientation(Direction.NORTHEAST).getAvenueLeg();
        v = junction.getCornerByOrientation(Direction.SOUTHEAST ).getAvenueLeg();

        BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), u, v));
        BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), v, u));
    }

    private void buildEastWestEdges(Junction junction) {
        if (junction == null) return;;

        Block u = junction.getCornerByOrientation(Direction.NORTHWEST).getStreetLeg();
        Block v = junction.getCornerByOrientation(Direction.SOUTHWEST).getStreetLeg();


        if (!u.equals(v)) {
//            System.out.println("u:" + u  + " v:" + v);
            BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), u, v));
            BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), v, u));
        }

        u = junction.getCornerByOrientation(Direction.NORTHEAST).getStreetLeg();
        v = junction.getCornerByOrientation(Direction.SOUTHEAST ).getStreetLeg();
        if (!u.equals(v)) {
            BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), u, v));
            BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), v, u));
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

        Block a = junction.getCornerByOrientation(cornerOrientation).getStreetLeg();
        Block b = junction.getCornerByOrientation(cornerOrientation).getAvenueLeg();

        BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), a, b));
        BlockEdgeCatalog.INSTANCE.addEdge(new BlockEdge(id.incrementAndGet(), b, a));
    }
}