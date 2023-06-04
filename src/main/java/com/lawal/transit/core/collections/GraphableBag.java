package com.lawal.transit.core.collections;

import com.lawal.transit.core.enums.Direction;
import com.lawal.transit.core.interfaces.Graphable;
import com.lawal.transit.core.interfaces.GraphableCollection;

import java.util.ArrayList;

public class GraphableBag<T> extends Bag<T> implements GraphableCollection {
    private int NORTH_ROW_INDEX_OUT_OF_BOUND_FLAG;
    private int SOUTH_ROW_INDEX_OUT_OF_BOUND_FLAG;
    private int WEST_COLUMN_INDEX_OUT_OF_BOUND_FLAG;
    private int EAST_COLUMN_INDEX_OUT_OF_BOUND_FLAG;
    private int gridDimension;

    private int northNeighborIndex;
    private int eastNeighborIndex;
    private int southNeighborIndex;
    private int westNeighborIndex;

    private int northEastNeighborIndex;
    private int northWestNeigborIndex;
    private int southWestNeighborIndex;
    private int southEastNeighborIndex;

    private int arrayLocation;
    private int rowIndex;
    private int offset;
    private ArrayList<Integer> indices;
    private ArrayList<Direction> neighborDirections;

    public GraphableBag (ArrayList<Direction> neighborDirections) {
        super();
        this.NORTH_ROW_INDEX_OUT_OF_BOUND_FLAG = -1;
        this.SOUTH_ROW_INDEX_OUT_OF_BOUND_FLAG = Integer.MAX_VALUE;
        this.WEST_COLUMN_INDEX_OUT_OF_BOUND_FLAG = -1;
        this.EAST_COLUMN_INDEX_OUT_OF_BOUND_FLAG = Integer.MAX_VALUE;

        this.northNeighborIndex = Integer.MIN_VALUE;
        this.eastNeighborIndex = Integer.MIN_VALUE;
        this.southNeighborIndex = Integer.MIN_VALUE;
        this.westNeighborIndex = Integer.MIN_VALUE;

        this.northEastNeighborIndex = Integer.MIN_VALUE;
        this.northWestNeigborIndex = Integer.MIN_VALUE;
        this.southWestNeighborIndex = Integer.MIN_VALUE;
        this.southEastNeighborIndex = Integer.MIN_VALUE;
        this.gridDimension = Integer.MIN_VALUE;

        this.arrayLocation = WEST_COLUMN_INDEX_OUT_OF_BOUND_FLAG;
        this.rowIndex = NORTH_ROW_INDEX_OUT_OF_BOUND_FLAG;
        this.offset = Integer.MAX_VALUE;
        this.indices = new ArrayList<Integer>();
        this.neighborDirections = neighborDirections;
    } // close constructor

    public void neighborProcessing () {
        this.SOUTH_ROW_INDEX_OUT_OF_BOUND_FLAG = super.size();
        this.EAST_COLUMN_INDEX_OUT_OF_BOUND_FLAG = super.size();
        this.gridDimension = size();
        for (T t : super.getContents()) {
//            if (t instanceof Graphable) {
            indices.clear();
            Graphable g = (Graphable) t;
            processNeighborIndices(g);
//            }
        }
    }

    private void processNeighborIndices (Graphable g) {
        if (arrayLocation >= 0) {
            setIndices((T) g);
            for (Integer index : indices) {
                T neighbor = (T) super.get(index.intValue());
                g.addNeighbor(neighbor);
            }
        }
    } // close addNeighbors

    private void setIndices (T t) {
        setArrayLocation(t);
        setRowIndex();
        setOffset(t);

        addWestNeighborIndex(arrayLocation);
        addEastNeighborIndex(arrayLocation);
        addNorthNeighborIndex();
        addSouthNeighborIndex();
    } // close calculateNeighborIndices

    public void setOffset (T t) {
        setArrayLocation(t);
        this.offset = gridDimension - arrayLocation;
    }

    public void setArrayLocation (T t) {
        arrayLocation = super.indexOf(t);
    }

    public void setRowIndex () {
        if (arrayLocation >= 0) {
            rowIndex = arrayLocation % gridDimension;
        }
    } // close setRowIndex



    private void addNorthNeighborIndex () {
        int northRowStartLocation = (rowIndex - 1) * gridDimension;

        if (northRowStartLocation > NORTH_ROW_INDEX_OUT_OF_BOUND_FLAG) {
            northNeighborIndex = northRowStartLocation + (gridDimension - offset);
            indices.add(indices.size(), northNeighborIndex);
            if (neighborDirections.contains(Direction.NORTHEAST) || neighborDirections.contains(Direction.NORTHWEST)) {
                addNorthWestNeighborIndex();
                addNorthEastNeighborIndex();
            }
        }
    }

    private void addWestNeighborIndex (int arrayLocation) {
        westNeighborIndex = arrayLocation - 1;
        if (westNeighborIndex > WEST_COLUMN_INDEX_OUT_OF_BOUND_FLAG) {
            indices.add(indices.size(), westNeighborIndex);
        }
    } // close handleWestNeighborIndex

    private void addEastNeighborIndex (int arrayLocation) {
        eastNeighborIndex = arrayLocation + 1;
        if (eastNeighborIndex < EAST_COLUMN_INDEX_OUT_OF_BOUND_FLAG) {
            indices.add(indices.size(), eastNeighborIndex);
        }
    } // close handleEastNeighborIndex

    private void addNorthWestNeighborIndex () {
        northWestNeigborIndex = northNeighborIndex - 1;
        if (northWestNeigborIndex > WEST_COLUMN_INDEX_OUT_OF_BOUND_FLAG) {
            indices.add(indices.size(), northWestNeigborIndex);
        }
    } // close addNorthWestIndex

    private void addNorthEastNeighborIndex () {
        northEastNeighborIndex = northNeighborIndex + 1;
        if (northEastNeighborIndex < EAST_COLUMN_INDEX_OUT_OF_BOUND_FLAG) {
            indices.add(indices.size(), northEastNeighborIndex);
        }
    } // close addNorthEastNeighborIndex

    private void addSouthNeighborIndex () {
        int southRowStartLocation = (rowIndex + 1) * gridDimension;

        if (southRowStartLocation < SOUTH_ROW_INDEX_OUT_OF_BOUND_FLAG) {
            southNeighborIndex = southRowStartLocation + (gridDimension - offset);
            indices.add(indices.size(), southNeighborIndex);
            if (neighborDirections.contains(Direction.SOUTHWEST) || neighborDirections.contains(Direction.SOUTHEAST)) {
                addSouthWestNeigborIndex();
                addSouthEastNeighborIndex();
            }
        }
    } // close southernNeighborIndices

    private void addSouthWestNeigborIndex () {
        southWestNeighborIndex = southNeighborIndex - 1;
        if (southWestNeighborIndex > WEST_COLUMN_INDEX_OUT_OF_BOUND_FLAG) {
            indices.add(indices.size(), southWestNeighborIndex);
        }
    } // close addSouthWestNeigborIndex

    private void addSouthEastNeighborIndex () {
        int southEastNeighborIndex = southNeighborIndex + 1;
        if (southEastNeighborIndex < EAST_COLUMN_INDEX_OUT_OF_BOUND_FLAG) {
            indices.add(indices.size(), southEastNeighborIndex);
        }
    } // close addSouthEastNeighborIndex
} // end class Bag
