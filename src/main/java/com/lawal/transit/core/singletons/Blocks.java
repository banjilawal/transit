package com.lawal.transit.core.singletons;

import com.lawal.transit.core.collections.GraphableBag;
import com.lawal.transit.core.entities.Avenue;
import com.lawal.transit.core.entities.Block;
import com.lawal.transit.core.collections.Bag;
import com.lawal.transit.core.entities.Street;
import com.lawal.transit.core.enums.Direction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public enum Blocks {
    INSTANCE;
//    private int NORTH_ROW_INDEX_OUT_OF_BOUND_FLAG = Integer.MIN_VALUE;
//    private int SOUTH_ROW_INDEX_OUT_OF_BOUND_FLAG = Integer.MIN_VALUE;
//    private int WEST_COLUMN_INDEX_OUT_OF_BOUND_FLAG = Integer.MIN_VALUE;
//    private int EAST_COLUMN_INDEX_OUT_OF_BOUND_FLAG = Integer.MIN_VALUE;
//
//    private int northNeighborIndex = Integer.MIN_VALUE;
//    private int eastNeighborIndex = Integer.MIN_VALUE;
//    private int southNeighborIndex = Integer.MIN_VALUE;
//    private int westNeighborIndex = Integer.MIN_VALUE;
//
//    private int northEastNeighborIndex = Integer.MIN_VALUE;
//    private int northWestNeigborIndex = Integer.MIN_VALUE;
//    private int southWestNeighborIndex = Integer.MIN_VALUE;
//    private int southEastNeighborIndex = Integer.MIN_VALUE;

    public final GraphableBag<Block> blocks; // = new GraphableBag<Block>();

    Blocks () {
        this.blocks = new GraphableBag<>(getNeighborDirections());
    }

    private ArrayList<Direction> getNeighborDirections () {
        ArrayList<Direction> neighborDirections = new ArrayList<Direction>();
        neighborDirections.add(neighborDirections.size(), Direction.NORTH);
        neighborDirections.add(neighborDirections.size(), Direction.NORTHEAST);
        neighborDirections.add(neighborDirections.size(), Direction.EAST);
        neighborDirections.add(neighborDirections.size(), Direction.SOUTHEAST);
        neighborDirections.add(neighborDirections.size(), Direction.SOUTH);
        neighborDirections.add(neighborDirections.size(), Direction.SOUTHWEST);
        neighborDirections.add(neighborDirections.size(), Direction.WEST);
        neighborDirections.add(neighborDirections.size(), Direction.NORTHWEST);
        return neighborDirections;
    } // close getNeighborDirections

    public Bag<Block> getBlocks () {
        return blocks;
    }

//    public int getRowIndex (Block block) {
//        return getRowIndex(bag.indexOf(block));
//    } // close getRowIndex
//
//    public int getRowIndex (int arrayLocation) {
//        if (arrayLocation >= 0) {
//            return arrayLocation % gridDimension();
//        }
//        return Integer.MIN_VALUE;
//    } // close getRowIndex
//
//    public int gridDimension () {
//        int dimension = (int) Math.sqrt(bag.size());
//        EAST_COLUMN_INDEX_OUT_OF_BOUND_FLAG = dimension;
//        SOUTH_ROW_INDEX_OUT_OF_BOUND_FLAG = dimension;
//        return dimension;
//    } // close totalColumns
//
//    private void addNeighbors (Block block) {
//        int arrayLocation = bag.indexOf(block);
//        if (arrayLocation >= 0) {
//            ArrayList<Integer> neighborIndices = calculateNeighborIndices();
//            for (Integer index : neighborIndices) {
//                Block neighbor = Blocks.INSTANCE.bag.get(index.intValue());
//                block.addNeighbor(neighbor);
//            }
//        }
//    } // close addNeighbors
//
//    private ArrayList<Integer> calculateNeighborIndices (int arrayLocation) {
//        ArrayList<Integer> indices = new ArrayList<Integer>();
//        int rowIndex = getRowIndex(arrayLocation);
//        int offset = gridDimension() - arrayLocation;
//        int griDimension = gridDimension();
//
//        indices = addWestNeighborIndex(indices, arrayLocation);
//        indices = addEastNeighborIndex(indices, arrayLocation);
//
//        for (Integer index : northenNeighborIndices(arrayLocation, rowIndex, offset, gridDimension)) {
//            indices.add(indices.size(), index);
//        }
//        for (Integer index : southernNeighborIndices(arrayLocation, rowIndex, offset, gridDimension)) {
//            indices.add(indices.size(), index);
//        }
//        return indices;
//    } // close calculateNeighborIndices
//
//    private ArrayList<Integer> addWestNeighborIndex (ArrayList<Integer> indices, int arrayLocation) {
//        westNeighborIndex = arrayLocation - 1;
//        if (westNeighborIndex > WEST_COLUMN_INDEX_OUT_OF_BOUND_FLAG) {
//            indices.add(indices.size(), westNeighborIndex);
//        }
//        return indices;
//    } // close addWestNeighborIndex
//
//    private ArrayList<Integer> addEastNeighborIndex (ArrayList<Integer> indices, int arrayLocation) {
//        eastNeighborIndex = arrayLocation + 1;
//        if (eastNeighborIndex < EAST_COLUMN_INDEX_OUT_OF_BOUND_FLAG) {
//            indices.add(indices.size(), eastNeighborIndex);
//        }
//        return indices;
//    } // close addEastNeighborIndex
//
//    private ArrayList<Integer> northenNeighborIndices (int arrayLocation, int rowIndex, int offset, int gridDimension ) {
//        ArrayList<Integer> indices = new ArrayList<Integer>();
//        int northRowStartLocation = (rowIndex - 1) * gridDimension;
//
//        if (northRowStartLocation > NORTH_ROW_INDEX_OUT_OF_BOUND_FLAG) {
//            northNeighborIndex = northRowStartLocation + (gridDimension - offset);
//            indices.add(indices.size(), northNeighborIndex);
//
//            northWestNeigborIndex = northNeighborIndex - 1;
//            if (northWestNeigborIndex > WEST_COLUMN_INDEX_OUT_OF_BOUND_FLAG) {
//                indices.add(indices.size(), northWestNeigborIndex);
//            }
//
//            northEastNeighborIndex = northNeighborIndex + 1;
//            if (northEastNeighborIndex < EAST_COLUMN_INDEX_OUT_OF_BOUND_FLAG) {
//                indices.add(indices.size(), northEastNeighborIndex);
//            }
//        }
//        return indices;
//    } // close northernNeighborIndices
//
//    private ArrayList<Integer> southernNeighborIndices (int arrayLocation, int rowIndex, int offset, int gridDimension ) {
//        ArrayList<Integer> indices = new ArrayList<Integer>();
//        int southRowStartLocation = (rowIndex + 1) * gridDimension;
//
//        if (southRowStartLocation < SOUTH_ROW_INDEX_OUT_OF_BOUND_FLAG) {
//            southNeighborIndex = southRowStartLocation + (gridDimension - offset);
//            indices.add(indices.size(), southNeighborIndex);
//
//            southWestNeighborIndex = southNeighborIndex - 1;
//            if (southWestNeighborIndex > WEST_COLUMN_INDEX_OUT_OF_BOUND_FLAG) {
//                indices.add(indices.size(), southWestNeighborIndex);
//            }
//
//            int southEastNeighborIndex = southNeighborIndex + 1;
//            if (southEastNeighborIndex < EAST_COLUMN_INDEX_OUT_OF_BOUND_FLAG) {
//                indices.add(indices.size(), southEastNeighborIndex);
//            }
//        }
//        return indices;
//    } // close southernNeighborIndices
//
//    public int size () { return bag.size(); }
//
//    public void add (Block block) {
//        bag.add(block);
//    }
//
//    public boolean remove (Block block) {
//        return bag.remove(block.getId());
//    }
//
//    public Iterator<Block> iterator () {
//        return bag.iterator();
//    }

//    public String fullString () {
//        return bag.fullString();
//    }


//     public  <Block> Iterator<Block> filterBlocks (Predicate<Block> predicate) {
//        return new FilteredIterator<>(getBag().iterator(), predicate);
//    } // close filter

//    public Iterator<Block> search (Predicate<Block> predicate) {
//        ArrayList<Block> blocks = new ArrayList<Block>();
//        for (Block block : this.blocks.getContents()) {
//            if (predicate.test(block)) {
//                blocks.add(blocks.size(), block);
//            }
//        }
//        return blocks.iterator();
//    } // close search

    public Block search (Avenue westAvenue, Street northStreet, Avenue eastAvenue, Street southStreet) {
        for (Block block : blocks.getContents()) {
            if (avenuesMatch(block, westAvenue, eastAvenue) && streetsMatch(block, northStreet, southStreet)) {
                return block;
            }
        }
        return null;
    } // close search

    public Iterator<Block> filterByAvenue (Avenue avenue) {
        ArrayList<Block> matches = new ArrayList<Block>();
        Predicate<Block> predicate = block -> block.getWestAvenue().equals(avenue)
                || block.getEastAvenue().equals(avenue);
        for (Block block : Blocks.INSTANCE.blocks.getContents()) {
            if (predicate.test(block)) {
                matches.add(matches.size(), block);
            }
        }
        return matches.iterator();
    } // close filterByAvenue

    public Iterator<Block> filterByStreet (Street street) {
        ArrayList<Block> matches = new ArrayList<Block>();
        Predicate<Block> predicate = block -> block.getNorthStreet().equals(street)
                || block.getSouthStreet().equals(street);
        for (Block block : Blocks.INSTANCE.blocks.getContents()) {
            if (predicate.test(block)) {
                matches.add(matches.size(), block);
            }
        }
        return matches.iterator();
    } // close filterByAvenue

    private boolean avenuesMatch (Block block, Avenue westAvenue, Avenue eastAvenue) {
        return (block.getWestAvenue().equals(westAvenue) && block.getEastAvenue().equals(eastAvenue));
    } // close avenuesMatch

    private boolean streetsMatch (Block block, Street northStreet, Street southStreet) {
        return (block.getNorthStreet().equals(northStreet) && block.getSouthStreet().equals(southStreet));
    } // close streetsMatch
} // end class BLocks
