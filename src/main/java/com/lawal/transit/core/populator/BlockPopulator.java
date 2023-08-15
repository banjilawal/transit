package com.lawal.transit.core.populator;

import com.lawal.transit.core.entities.*;
import com.lawal.transit.core.enums.Direction;
import com.lawal.transit.core.enums.GlobalConstant;
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
        int nodeTotal = Intersections.INSTANCE.getBagContents().size();
        int gridDimension = (int) Math.sqrt(nodeTotal);
        for (int nodeIndex = 0; nodeIndex < (nodeTotal - (gridDimension + 1)); nodeIndex++) {
            int southWestIndex = nodeIndex + gridDimension;

            Intersection northWestCorner = Intersections.INSTANCE.getBagContents().get(nodeIndex);
            Intersection northEastCorner = Intersections.INSTANCE.getBagContents().get(nodeIndex + 1);
            Intersection southWestCorner = Intersections.INSTANCE.getBagContents().get(southWestIndex);
            Intersection southEastCorner = Intersections.INSTANCE.getBagContents().get(southWestIndex + 1);

            if (northWestCorner.getAvenue().getId() != GlobalConstant.END_BORDER_ID)
                createBlock(northWestCorner, northEastCorner, southEastCorner, southWestCorner);
        }
    } // close processIntersections


    private void handleNeighbors () {
        int blockTotal = Blocks.INSTANCE.size();
        int gridDimension = (int) Math.sqrt(blockTotal);

        for (Block block : Blocks.INSTANCE.getBagContents()) {
            int currentArrayIndex = Blocks.INSTANCE.getBagContents().lastIndexOf(block);
            int quotient = currentArrayIndex / gridDimension;
            int remainder = currentArrayIndex % gridDimension;

            // Handling the first row
            if (currentArrayIndex > 0 && currentArrayIndex < gridDimension) {
                int westernNeighborIndex = currentArrayIndex - 1;
                Block westernNeighbor = Blocks.INSTANCE.getBagContents().get(westernNeighborIndex);
                block.addNeighbor(Direction.WEST, westernNeighbor);
                westernNeighbor.addNeighbor(Direction.EAST,block);
            }

            if (quotient > 0 && currentArrayIndex >= gridDimension) {
                int northernNeighborIndex = currentArrayIndex - gridDimension;
                Block northernNeighbor = Blocks.INSTANCE.getBagContents().get(northernNeighborIndex);
                block.addNeighbor(Direction.NORTH,northernNeighbor);
                northernNeighbor.addNeighbor(Direction.SOUTH, block);

                if (remainder == 0) {
                    int easternNeighborIndex = currentArrayIndex + 1;
                    int northEasternNeighborIndex = northernNeighborIndex + 1;

                    Block easterNeighbor = Blocks.INSTANCE.getBagContents().get(easternNeighborIndex);
                    block.addNeighbor(Direction.EAST, easterNeighbor);
                    easterNeighbor.addNeighbor(Direction.WEST, block);

                    Block northEasternNeighbor = Blocks.INSTANCE.getBagContents().get(northEasternNeighborIndex);
                    block.addNeighbor(Direction.NORTHEAST,northEasternNeighbor);
                    northEasternNeighbor.addNeighbor(Direction.SOUTHWEST,block);
                }

                if (remainder == (gridDimension - 1)) {
                    int westernNeighborIndex = currentArrayIndex - 1;
                    int northWesternNeighborIndex = northernNeighborIndex - 1;

                    Block westernNeighbor = Blocks.INSTANCE.getBagContents().get(westernNeighborIndex);
                    block.addNeighbor(Direction.WEST, westernNeighbor);
                    westernNeighbor.addNeighbor(Direction.EAST, block);

                    Block northWesternNeighbor = Blocks.INSTANCE.getBagContents().get(northWesternNeighborIndex);
                    block.addNeighbor(Direction.NORTHWEST, northWesternNeighbor);
                    northWesternNeighbor.addNeighbor(Direction.SOUTHEAST,block);
                }

                if (remainder != 0 && remainder != (gridDimension -1)) {
                    int easternNeighborIndex = currentArrayIndex + 1;
                    int westernNeighborIndex = currentArrayIndex - 1;
                    int northWesternNeighborIndex = northernNeighborIndex - 1;
                    int northEasternNeighborIndex = northernNeighborIndex + 1;

                    Block easterNeighbor = Blocks.INSTANCE.getBagContents().get(easternNeighborIndex);
                    block.addNeighbor(Direction.EAST, easterNeighbor);
                    easterNeighbor.addNeighbor(Direction.WEST, block);

                    Block westernNeighbor = Blocks.INSTANCE.getBagContents().get(westernNeighborIndex);
                    block.addNeighbor(Direction.WEST, westernNeighbor);
                    westernNeighbor.addNeighbor(Direction.EAST,block);

                    Block northEasternNeighbor = Blocks.INSTANCE.getBagContents().get(northEasternNeighborIndex);
                    block.addNeighbor(Direction.NORTHEAST,northEasternNeighbor);
                    northEasternNeighbor.addNeighbor(Direction.SOUTHWEST,block);

                    Block northWesternNeighbor = Blocks.INSTANCE.getBagContents().get(northWesternNeighborIndex);
                    block.addNeighbor(Direction.NORTHWEST, northWesternNeighbor);
                    northWesternNeighbor.addNeighbor(Direction.SOUTHEAST,block);
                }
            }
        }
    } // close handleNeighbors

    private void createBlock (Intersection northWestCorner, Intersection northEastCorner, Intersection southEastCorner, Intersection southWestCorner) {
        int gridDimension = GlobalConstant.AVENUE_NAMES.length;
        Block block = new Block(
            SerialNumberGenerator.INSTANCE.assignNumber(this),
            NameGenerator.INSTANCE.assignName(this, northWestCorner),
            northWestCorner,
            northEastCorner,
            southEastCorner,
            southWestCorner
        );
        Blocks.INSTANCE.add(block);
    } // close createBlock
} // end enum BlockPopulator