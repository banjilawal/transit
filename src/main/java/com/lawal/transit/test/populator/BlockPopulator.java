package com.lawal.transit.test.populator;

import com.lawal.transit.core.concretes.*;
import com.lawal.transit.Orientation;
import com.lawal.transit.core.global.Constant;
import com.lawal.transit.core.interfaces.Populator;
import com.lawal.transit.core.singletons.Blocks;
import com.lawal.transit.core.singletons.Intersections;
import com.lawal.transit.core.visitors.NameGenerator;
import com.lawal.transit.core.visitors.SerialNumberGenerator;

public enum BlockPopulator implements Populator {
    INSTANCE;

    @Override
    public void populate () {
        processIntersections();
        handleNeighbors();
    } // close populate

    private void processIntersections () {
        int nodeTotal = Intersections.INSTANCE.size();
        int gridDimension = (int) Math.sqrt(nodeTotal);
        for (int nodeIndex = 0; nodeIndex < (nodeTotal - (gridDimension + 1)); nodeIndex++) {
            int southWestIndex = nodeIndex + gridDimension;

            Intersection northWestCorner = Intersections.INSTANCE.getIntersections().get(nodeIndex);
            Intersection northEastCorner = Intersections.INSTANCE.getIntersections().get(nodeIndex + 1);
            Intersection southWestCorner = Intersections.INSTANCE.getIntersections().get(southWestIndex);
            Intersection southEastCorner = Intersections.INSTANCE.getIntersections().get(southWestIndex + 1);

            if (northWestCorner.getAvenue().getId() != Constant.END_BORDER_ID)
                createBlock(northWestCorner, northEastCorner, southEastCorner, southWestCorner);
        }
    } // close processIntersections


    private void handleNeighbors () {
        int blockTotal = Blocks.INSTANCE.size();
        int gridDimension = (int) Math.sqrt(blockTotal);

        for (OldConcreteBlock concreteBlock : Blocks.INSTANCE.getBlocks()) {
            int currentArrayIndex = Blocks.INSTANCE.getBlocks().lastIndexOf(concreteBlock);
            int quotient = currentArrayIndex / gridDimension;
            int remainder = currentArrayIndex % gridDimension;

            // Handling the first row
            if (currentArrayIndex > 0 && currentArrayIndex < gridDimension) {
                int westernNeighborIndex = currentArrayIndex - 1;
                OldConcreteBlock westernNeighbor = Blocks.INSTANCE.getBlocks().get(westernNeighborIndex);
                concreteBlock.addNeighbor(Orientation.WEST, westernNeighbor);
                westernNeighbor.addNeighbor(Orientation.EAST, concreteBlock);
            }

            if (quotient > 0 && currentArrayIndex >= gridDimension) {
                int northernNeighborIndex = currentArrayIndex - gridDimension;
                OldConcreteBlock northernNeighbor = Blocks.INSTANCE.getBlocks().get(northernNeighborIndex);
                concreteBlock.addNeighbor(Orientation.NORTH,northernNeighbor);
                northernNeighbor.addNeighbor(Orientation.SOUTH, concreteBlock);

                if (remainder == 0) {
                    int easternNeighborIndex = currentArrayIndex + 1;
                    int northEasternNeighborIndex = northernNeighborIndex + 1;

                    OldConcreteBlock easterNeighbor = Blocks.INSTANCE.getBlocks().get(easternNeighborIndex);
                    concreteBlock.addNeighbor(Orientation.EAST, easterNeighbor);
                    easterNeighbor.addNeighbor(Orientation.WEST, concreteBlock);

                    OldConcreteBlock northEasternNeighbor = Blocks.INSTANCE.getBlocks().get(northEasternNeighborIndex);
                    concreteBlock.addNeighbor(Orientation.NORTHEAST,northEasternNeighbor);
                    northEasternNeighbor.addNeighbor(Orientation.SOUTHWEST, concreteBlock);
                }

                if (remainder == (gridDimension - 1)) {
                    int westernNeighborIndex = currentArrayIndex - 1;
                    int northWesternNeighborIndex = northernNeighborIndex - 1;

                    OldConcreteBlock westernNeighbor = Blocks.INSTANCE.getBlocks().get(westernNeighborIndex);
                    concreteBlock.addNeighbor(Orientation.WEST, westernNeighbor);
                    westernNeighbor.addNeighbor(Orientation.EAST, concreteBlock);

                    OldConcreteBlock northWesternNeighbor = Blocks.INSTANCE.getBlocks().get(northWesternNeighborIndex);
                    concreteBlock.addNeighbor(Orientation.NORTHWEST, northWesternNeighbor);
                    northWesternNeighbor.addNeighbor(Orientation.SOUTHEAST, concreteBlock);
                }

                if (remainder != 0 && remainder != (gridDimension -1)) {
                    int easternNeighborIndex = currentArrayIndex + 1;
                    int westernNeighborIndex = currentArrayIndex - 1;
                    int northWesternNeighborIndex = northernNeighborIndex - 1;
                    int northEasternNeighborIndex = northernNeighborIndex + 1;

                    OldConcreteBlock easterNeighbor = Blocks.INSTANCE.getBlocks().get(easternNeighborIndex);
                    concreteBlock.addNeighbor(Orientation.EAST, easterNeighbor);
                    easterNeighbor.addNeighbor(Orientation.WEST, concreteBlock);

                    OldConcreteBlock westernNeighbor = Blocks.INSTANCE.getBlocks().get(westernNeighborIndex);
                    concreteBlock.addNeighbor(Orientation.WEST, westernNeighbor);
                    westernNeighbor.addNeighbor(Orientation.EAST, concreteBlock);

                    OldConcreteBlock northEasternNeighbor = Blocks.INSTANCE.getBlocks().get(northEasternNeighborIndex);
                    concreteBlock.addNeighbor(Orientation.NORTHEAST,northEasternNeighbor);
                    northEasternNeighbor.addNeighbor(Orientation.SOUTHWEST, concreteBlock);

                    OldConcreteBlock northWesternNeighbor = Blocks.INSTANCE.getBlocks().get(northWesternNeighborIndex);
                    concreteBlock.addNeighbor(Orientation.NORTHWEST, northWesternNeighbor);
                    northWesternNeighbor.addNeighbor(Orientation.SOUTHEAST, concreteBlock);
                }
            }
        }
    } // close handleNeighbors

    private void createBlock (
        Intersection northWestCorner,
        Intersection northEastCorner,
        Intersection southEastCorner,
        Intersection southWestCorner
    ) {
        OldConcreteBlock concreteBlock = new OldConcreteBlock(
            SerialNumberGenerator.INSTANCE.assignNumber(this),
            NameGenerator.INSTANCE.assignName(this, northWestCorner),
            northWestCorner,
            northEastCorner,
            southEastCorner,
            southWestCorner
        );
        Blocks.INSTANCE.add(concreteBlock);
    }
} // end enum BlockPopulator