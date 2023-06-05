package com.lawal.transit.core.grid;

import com.lawal.transit.core.entities.Block;
import com.lawal.transit.core.interfaces.Populator;
import com.lawal.transit.core.singletons.Blocks;

import java.util.ArrayList;
import java.util.Iterator;

public enum BlockGrid implements Populator {
    INSTANCE;
    private ArrayList<ArrayList<String>> grid; // = new ArrayList<>();
    private ArrayList<ArrayList<String>> data;
    private int gridLength;
    private int titleRowCount;
    private int blockTotal;
    private String markAdjacent;
    private String markDistant;
    private String tableBlank;
    private String markSelf;

    private int blockIndex;
    private int columnHeaderWidth;
    private int rowHeaderWidth;

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
    private int previousColumnIndex;
    private int currentRowIndex;
    private int previousRowIndex;


    BlockGrid () {
        gridLength = Blocks.INSTANCE.size() + 1;
        markAdjacent = "|X|";
        markDistant = "~~~";
        tableBlank = "///";
        markSelf = "#O#";
        columnHeaderWidth = 1;
        rowHeaderWidth = 1;
        grid = new ArrayList<ArrayList <String>>();
        data = new ArrayList<ArrayList <String>>();
    } // close constructor

    @Override
    public void populate () {
        initialize();
        setNeighbors();
        System.out.println(toString());
    } // close populate

    private void initialize () {
        addHeaders();
        initializeDataCells();
    } // close initialize

    private void addHeaders () {
        ArrayList<String> columnHeaders = new ArrayList<>();
        columnHeaders.add(columnHeaders.size(), tableBlank);
        for (Iterator<Block> iterator = Blocks.INSTANCE.iterator(); iterator.hasNext();) {
            columnHeaders.add(columnHeaders.size(), iterator.next().getName());
        }
        grid.add(grid.size(), columnHeaders);

        for (Iterator<Block> iterator = Blocks.INSTANCE.iterator(); iterator.hasNext();) {
            ArrayList<String> rowHeader = new ArrayList<>();
            rowHeader.add(rowHeader.size(), iterator.next().getName());
            grid.add(grid.size(), rowHeader);
        }
    } // close addHeaders

    private void initializeDataCells () {
        for (int rowIndex = 1; rowIndex < gridLength; rowIndex++) {
            for (int columnIndex = 1; columnIndex < gridLength; columnIndex++) {
                grid.get(rowIndex).add(columnIndex, markDistant);
            }
        }
    } // close initializeData

    private void setNeighbors () {
        Blocks blocks = Blocks.INSTANCE;
        for (blockIndex = 1; blockIndex < gridLength; blockIndex++) {
            System.out.println("SET_NEIGHBORS->> blockIndex:" + blockIndex + " gridLength:" + gridLength);
            grid.get(blockIndex).set(blockIndex, markSelf);
            setLateralNeighbors();
            setNorthernNeighbors();
//            setSouthernNeighbors();
        }
    } // close setDataRows

    private void setLateralNeighbors () {
        setEastNeighbor();
        setWestNeighbor();
    } // close setLateralNeighbors

    private void setWestNeighbor () {
        System.out.println("\tSet_WEST_NEIGHBOR->> blockIndex:" + blockIndex + " gridLength:" + gridLength);
        if (blockIndex > 1) {
            int westColumnIndex = blockIndex - 1;
            grid.get(blockIndex).set(westColumnIndex, markAdjacent);
        }
    } // close setWestNeighbor

    private void setEastNeighbor () {
        if (blockIndex < gridLength - 1) {
            int eastColumnIndex = blockIndex + 1;
            grid.get(blockIndex).set(eastColumnIndex, markAdjacent);
        }
    } // close setEastNeighbor

    private void setNorthernNeighbors () {
        setNorthNeighbor();
//        setNorthEastNeighbor();
//        setNorthWestNeighbor();
    } // close setNorthernNeighbors

    private void setNorthNeighbor () {
        if (blockIndex > 1) {
            int northRowIndex = blockIndex - 1;
            int northColumnIndex = blockIndex;
            grid.get(northRowIndex).set(northColumnIndex, markAdjacent);
//            if (blockIndex < (gridLength - 2)) {
//                setNorthEastNeighbor();
//                setNorthWestNeighbor();
//            }
        }
    } // close setNorthNeighbor

    private void setNorthEastNeighbor () {
        if ((blockIndex > 0) && (blockIndex < gridLength - 2)) {
            int northEastRowIndex = blockIndex - 1;
            int northEastColumnIndex = blockIndex + 1;
            grid.get(northEastRowIndex).set(northEastColumnIndex, markAdjacent);
        }
    } // close setNorthEastNeighbor

    private void setNorthWestNeighbor () {
        if ((blockIndex > 0) && (blockIndex < gridLength - 2)) {
            int northWestRowIndex = blockIndex - 1;
            int northWestColumnIndex = blockIndex + 1;
            grid.get(northWestRowIndex).set(northWestColumnIndex, markAdjacent);
        }
    } // close setNorthWestNeighbor

    private void setSouthernNeighbors () {
        setSouthNeighbor();
        setSouthEastNeighbor();
        setSouthWestNeighbor();
    } // close setEasternNeighbors

    private void setSouthNeighbor () {
        if (blockIndex < gridLength - 2) {
            int southRowIndex = blockIndex + 1;
            int southColumnIndex = blockIndex;
            grid.get(southRowIndex).set(southColumnIndex, markAdjacent);
        }
    } // close setSouthNeighbor

    private void setSouthEastNeighbor () {
        if (blockIndex < gridLength - 2) {
            int southRowIndex = blockIndex + 1;
            int southColumnIndex = blockIndex + 1;
            grid.get(southRowIndex).set(southColumnIndex, markAdjacent);
        }
    } // close setSouthEastNeighbor


    private void setSouthWestNeighbor () {
        if (blockIndex > gridLength - 1) {
            int southWestRowIndex = blockIndex + 1;
            int southWestColumnIndex = blockIndex - 1;
            grid.get(southWestRowIndex).set(southWestColumnIndex, markAdjacent);
        }
    } // close setSouthWestNeighbor

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

    /*
    private void initializeDataRows () {
        Blocks blocks = Blocks.INSTANCE;
        int horizontalOffset = 0;
        int iPrevious = 0;

        for (int i = 0; i < gridLength; i++) {
            iPrevious = i - 1;
            ArrayList<String> row = new ArrayList<>();
            System.out.println("iPrevious:" + iPrevious + " i:" + i + " blocks[" + i + "]=" + blocks.getBag().get(i).getName());
            for (int j = 0; j < gridLength; j++) {
                row.add(j, markDistant);
                if (j == i) {
                    row.add(j, markSelf);
                }
                else if (j == i + 1) {
                    row.add(j, markAdjacent);
                }
                else if (j == i - 1) {
                    row.add(j, markAdjacent);
                }
                else {
                    row.add(j, markDistant);
                }
                System.out.println("\t(" + i + "," + j + ") row[" + j + "]=" + row.get(j));
//                System.out.println("\tj:" + j + " blocks[" + j + "]=" + blocks.getBag().get(j).getName());
            }
            dataRows.add(dataRows.size(), row);
        }
        iPrevious = 0;
        for (int i = 0; i < dataRows.size(); i++) {
            for (int j = 0; j  < dataRows.size(); j++) {
                System.out.print("[" + i + "][" + j + "]=" + dataRows.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    } // close dataRows



    private void setNorthenNeighbors () {
        Blocks blocks = Blocks.INSTANCE;
        ArrayList<ArrayList <String>> rows = new ArrayList<>();
        int horizontalOffset = 0;
        int iPrevious = 0;

        for (int i = 0; i < gridLength; i++) {
            iPrevious = i - 1;
            ArrayList<String> row = new ArrayList<>();
            System.out.println("iPrevious:" + iPrevious + " i:" + i + " blocks[" + i + "]=" + blocks.getBag().get(i).getName());
            for (int j = 0; j < gridLength; j++) {
                row.add(j, markDistant);
                if (j == i) {
                    row.add(j, markSelf);
                }
                else if (j == i + 1) {
                    row.add(j, markAdjacent);
                }
                else if (j == i - 1) {
                    row.add(j, markAdjacent);
                }
                else {
                    row.add(j, markDistant);
                }
                System.out.println("\t(" + i + "," + j + ") row[" + j + "]=" + row.get(j));
//                System.out.println("\tj:" + j + " blocks[" + j + "]=" + blocks.getBag().get(j).getName());
            }
            rows.add(rows.size(), row);
        }
        iPrevious = 0;
        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j  < rows.size(); j++) {
                System.out.print("[" + i + "][" + j + "]=" + rows.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    } // close dataRows
     */
    /*
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
     */
} // end class blockGrid
