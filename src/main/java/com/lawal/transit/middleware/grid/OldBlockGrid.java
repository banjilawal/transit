package com.lawal.transit.middleware.grid;

import com.lawal.transit.middleware.entities.Block;
import com.lawal.transit.middleware.enums.Direction;
import com.lawal.transit.middleware.populator.Populator;
import com.lawal.transit.middleware.singletons.Blocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public enum OldBlockGrid implements Populator {
    INSTANCE;
    private ArrayList<ArrayList<String>> grid = new ArrayList<>();
    private int gridLength;
    private int titleRowCount;
    private int blockTotal;
    private String markAdjacent = "|X|";
    private String markDistant = "~~~";
    private String markSelf = "#O#";

    private int horizontalOffset;
    private int verticalOffset;
    private int northNeighborIndex;
    private int eastNeighborIndex;
    private int southNeigborIndex;
    private int westNeigborIndex;
    private int northEastNeighborIndex;
    private int soutEastNeighborIndex;
    private int southWestNeighborIndex;
    private int northWestNeighborIndex;
    private int currentColumnIndex;
    private int currentRowIndex;

    @Override
    public void populate () {
        blockTotal = Blocks.INSTANCE.size();
        titleRowCount = 1;
        gridLength = blockTotal + titleRowCount;
        intialize();
        setNeighbors();
        System.out.println("blockTotal:" + blockTotal + " gridDimension:" + gridLength + "X" + gridLength);
        System.out.println(toString());
    } // close populate

    private void intialize () {
        addHeadingRow();
        addDataRows();
    } // close intialize

    private void addHeadingRow () {
        ArrayList<String> headingRow = new ArrayList<>();
        headingRow.add(0, "///");
        for (Iterator<Block> iterator = Blocks.INSTANCE.iterator(); iterator.hasNext();) {
            Block block = (Block) iterator.next();
            headingRow.add(headingRow.size(), block.getName());
        }
        grid.add(0, headingRow);
    } // close addHeadingRow

    private void addDataRows () {
        int factor = (blockTotal- 2) / 2;
        for (Iterator<Block> iterator = Blocks.INSTANCE.iterator(); iterator.hasNext();) {
            Block block = (Block) iterator.next();
            grid.add(grid.size(), (new ArrayList<String>(Arrays.asList(block.getName()))));
            int rowIndex = grid.size() - 1;
            for (int columnIndex = 1; columnIndex < gridLength; columnIndex++) {
                int rowLength = grid.get(rowIndex).size();
                grid.get(rowIndex).add(rowLength, markDistant);
            }
//            ArrayList<String> row = grid.get(currentRowIndex);
//            int currentColumnIndex = 1;
//            System.out.println("grid row count:" + grid.size() + " row length:" + grid.get(currentRowIndex).size());
//            for (currentColumnIndex = 1; currentColumnIndex < dataFieldCount; currentColumnIndex++) {
//                grid.get(currentRowIndex).set(currentColumnIndex, markDistant);
//                if (currentColumnIndex == currentRowIndex) {
//                    grid.get(currentRowIndex).set(currentColumnIndex, (Integer.toString(currentRowIndex) + Integer.toString(currentColumnIndex))); //markSelf);
//                    System.out.println("rowindex:" + currentRowIndex + " columnindex:" + currentColumnIndex);
//                }
//                if (currentColumnIndex == currentRowIndex + 1) {
//                    grid.get(currentRowIndex).set((currentRowIndex + 1), markAdjacent); //markSelf)
//                }
//                if (currentRowIndex > 1 && currentColumnIndex == (currentRowIndex - 1)) {
//                    grid.get(currentRowIndex).set((currentRowIndex - 1), (Integer.toString(currentRowIndex) + Integer.toString(currentColumnIndex))); //markSelf)
//                }
//                if (currentColumnIndex == (currentRowIndex + factor)) {
//                    grid.get(currentRowIndex).set((currentRowIndex + factor), (Integer.toString(currentRowIndex) + Integer.toString(currentColumnIndex))); //markSelf)
//                }
//            }
        }
    } // close addDataRows

    private void setNeighbors () {
        Blocks blocks = Blocks.INSTANCE;
        ArrayList<String> row;
        for (int rowIndex = 0; rowIndex < blocks.getBag().size(); rowIndex++) {
            currentRowIndex = rowIndex + 1;
//            Block block = (Block) blocks.getBag().get(currentRowIndex); //
//            grid.add(grid.size(), (new ArrayList<String>(Arrays.asList(block.getName()))));
            for (int columnIndex = 0; columnIndex < blocks.getBag().size(); columnIndex++) {
                currentColumnIndex = columnIndex;
                processNeighborIndexes();
            }
        }
    } // close fillRows

    private void processNeighborIndexes () {
        int verticalOffset = gridLength - currentRowIndex;
//        int northOffset = currentRowIndex - (verticalOffset + 1);
//        System.out.print("northOffset:" + northOffset + " ");
//        northNeighborIndex = currentRowIndex + northOffset;
//        System.out.println("currentRowIndex:" + currentRowIndex + " " + " northNeighborIndex:" + northNeighborIndex);
        northNeighborIndex = currentRowIndex - (verticalOffset + 1);
        southNeigborIndex = gridLength - (verticalOffset + 1);

        markSelves();
        markNeighbors();
    } // close setNeigborIndexes

    private void markSelves () {
        if (currentColumnIndex == currentRowIndex) {
            System.out.print(grid.get(currentRowIndex).get(0) + " currentRowIndex:" + currentRowIndex);
            System.out.println(" currentColumnIndex:" + currentColumnIndex);
//            westNeigborIndex = currentColumnIndex - 1; //currentColumnIndex - horizontalOffset;
//            eastNeighborIndex = currentColumnIndex + 1; //currentColumnIndex + horizontalOffset;
            grid.get(currentRowIndex).set(currentColumnIndex, markSelf);
            if ((currentRowIndex + 1) == blockTotal) {
//                System.out.print(grid.get(currentRowIndex).get(0) + " currentRowIndex:" + currentRowIndex);
//                System.out.print(" currentColumnIndex:" + currentColumnIndex);
                currentRowIndex = currentRowIndex + 1;
                currentColumnIndex = currentRowIndex;
                System.out.print(grid.get(currentRowIndex).get(0) + " currentRowIndex:" + currentRowIndex);
                System.out.println(" currentColumnIndex:" + currentRowIndex);
//                System.out.print("\n" + grid.get(currentRowIndex).get(0) + " currentRowIndex:" + currentRowIndex);
//                System.out.print(" currentColumnIndex:" + currentColumnIndex);
                grid.get(currentRowIndex).set((currentColumnIndex), markSelf);
//                westNeigborIndex = currentColumnIndex - 1; //currentColumnIndex - horizontalOffset;
//                eastNeighborIndex = currentColumnIndex + 1; //currentColumnIndex + horizontalOffset;
            }
//
//            markPlanarNeighbors();
        }
    }

    private void markNeighbors () {
//        markPlanarNeighbors();
//        markNorthernNeighbors();
    } // close markNeighbors

    private void markPlanarNeighbors () {

        System.out.print(" westNeighborIndex:" + westNeigborIndex);
        if (currentColumnIndex > 0) {
            if (westNeigborIndex > 0) {
                westNeigborIndex = currentColumnIndex - 1;
                grid.get(currentRowIndex).set((westNeigborIndex), markAdjacent);
            }
        System.out.print(" eastNeigbordIndex:" + eastNeighborIndex);
            if (eastNeighborIndex < blockTotal - 1) { //(blockTotal - 1)) {
                grid.get(currentRowIndex).set((eastNeighborIndex + 1), markAdjacent);
            }
        System.out.println(" rowSize:" + grid.get(currentRowIndex).size());
        }
    } // close markPlanarNeighbors

    private void markNorthernNeighbors () {
        System.out.print(grid.get(currentRowIndex).get(0) + " currentRowIndex:" + currentRowIndex);
        System.out.print(" currentColumnIndex:" + currentColumnIndex);
        System.out.println(" NorthNeighborIndex:" + northNeighborIndex);
        if (northNeighborIndex > 0) {
            northNeighborIndex = currentRowIndex - northNeighborIndex;
            grid.get(currentRowIndex).set(northNeighborIndex, markAdjacent); //(currentRowIndex - northNeighborIndex), markAdjacent);
            if (westNeigborIndex > 0) {
                northWestNeighborIndex = northNeighborIndex - 1; //westNeigborIndex;
                grid.get(currentRowIndex).set(northWestNeighborIndex, markAdjacent);
            }
//            if (eastNeighborIndex < (blockTotal - 1)) {
//                northEastNeighborIndex = northNeighborIndex + 1;
//                grid.get(currentRowIndex).set(northEastNeighborIndex, markAdjacent);
//            }
        }
    } // close markNorthernNeighbors

    private void markSouthernNeighbors () {
        if (southNeigborIndex > 0) {
            grid.get(southNeigborIndex).set(currentRowIndex, markAdjacent);
            if (westNeigborIndex > 0) {
                southWestNeighborIndex = westNeigborIndex;
                grid.get(southNeigborIndex).set(southWestNeighborIndex, markAdjacent);
            }
            if (eastNeighborIndex > 0) {
                soutEastNeighborIndex = eastNeighborIndex;
                grid.get(southNeigborIndex).set(soutEastNeighborIndex, markAdjacent);
            }
        }
    } // close markNorthernNeighbors



//    private void initializeRows () {
//        for (Iterator<Block> iterator = Blocks.INSTANCE.iterator(); iterator.hasNext();) {
//            Block block = (Block) iterator.next();
//            grid.add(grid.size(), (new ArrayList<String>(Arrays.asList(block.getName()))));
//            int currentRowIndex = grid.size() - 1;
//            ArrayList<String> row = grid.get(currentRowIndex);
//            int currentColumnIndex = 1;
//            System.out.println("grid row count:" + grid.size() + " row length:" + grid.get(currentRowIndex).size());
//            for (currentColumnIndex = 1; currentColumnIndex < columnCount; currentColumnIndex++) {
//                grid.get(currentRowIndex).add(currentColumnIndex, markDistant);
//                horizontalOffset = columnCount - currentRowIndex;
//                eastIndex = currentColumnIndex + 1;
////                if (eastIndex < columnCount) {
////                    grid.get(currentRowIndex).add(eastIndex, markAdjacent);
////                }
//                if (currentColumnIndex == currentRowIndex) {
//                    grid.get(currentRowIndex).add(currentColumnIndex, markSelf);
//                }
////                if (currentColumnIndex == currentRowIndex + 1) {
////
////                }
//            }
////            for (int index = 1; index < grid.get(0).size(); index++) {
////                ArrayList<String> row = grid.get(grid.size());
////                row.add(row.size(), markDistant);
////            }
//        }
//    } // close initRows

    private void setValues () {
    } // close setValues

    @Override
    public String toString () {
        String string = "";
        for (ArrayList row :  grid) {
            string += rowString(row);
        }
        return string;
    } // close toString

    private String rowString (ArrayList<String> array) {
        String string = "|";
        for (String element : array) {
            string += element + "|";
        }
        return string + "\n";
    } // close rowString

    private int getAdjacentIndex (Direction indexDirection, int xPosition, int yPosition) {
        int index = 0;
        int horizontalOffset = blockTotal - xPosition;
        int verticalOffSet = blockTotal - yPosition;
        switch (indexDirection) {
            case NORTH:
                index = blockTotal - (verticalOffset + 1);
                if (index < 0) { index = 0; }
                break;
            case EAST:
                index = (blockTotal + 1) - horizontalOffset;
                if (index < 0) { index = 0; }
                break;
            case SOUTH:
                index = (blockTotal + 1) - verticalOffset;
                if (index < 0) { index = 0; }
                break;
            case WEST:
                index = blockTotal - (horizontalOffset + 1);
                if (index < 0) { index = 0; }
                break;
        }
        return index;
    } // end indexHelper
} // end class blockGrid
