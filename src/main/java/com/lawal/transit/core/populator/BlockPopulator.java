package com.lawal.transit.core.populator;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.entities.Avenue;
import com.lawal.transit.core.entities.Block;
import com.lawal.transit.core.entities.Street;
import com.lawal.transit.core.interfaces.NameAcceptor;
import com.lawal.transit.core.interfaces.NumberAcceptor;
import com.lawal.transit.core.singletons.Avenues;
import com.lawal.transit.core.singletons.Blocks;
import com.lawal.transit.core.singletons.Roads;
import com.lawal.transit.core.singletons.Streets;
import com.lawal.transit.core.visitors.NameGenerator;
import com.lawal.transit.core.visitors.SerialNumberGenerator;

import java.sql.Array;
import java.util.ArrayList;

public enum BlockPopulator implements Populator, NumberAcceptor, NameAcceptor {
    INSTANCE;
    private Avenue westAvenue;
    private Avenue eastAvenue;
    private Street northStreet;
    private Street southStreet;
    private int borderCount = 2;
    private int northIndex;
    private int southIndex;
    private int westIndex;
    private int eastIndex;
    private int blockId;
    private String blockName;

    @Override
    public void populate () {
        createBlocks();
        Blocks.INSTANCE.blocks.neighborProcessing();
    } // close populate

    private void createBlocks () {
        ArrayList<ArrayList<Road>> roadPairs = Roads.INSTANCE.roadPairs();
        int index = 0;
        while (index < (roadPairs.size() - 1)) {
            Avenue eastAvenue = (Avenue) roadPairs.get(index).get(0);
            Street northStreet = (Street) roadPairs.get(index).get(1);

            Avenue westAvenue = (Avenue) roadPairs.get(index+1).get(0);
            Street southStreet = (Street) roadPairs.get(index+1).get(1);
            blockId = acceptNumber();
            blockName = acceptName();
            Block block = new Block(blockId, blockName, westAvenue, eastAvenue, northStreet, southStreet);
            Blocks.INSTANCE.blocks.add(block);
        }
    } // close createBlocks

//    private void createBlocks () {
//        southIndex = 1;
//        Block block;
//        while (southIndex < Streets.INSTANCE.streets.size()) {
//            northIndex = southIndex - 1;
//            northStreet = Streets.INSTANCE.streets.get(northIndex);
//            southStreet = Streets.INSTANCE.streets.get(southIndex);
//            eastIndex = 1;
//            while (eastIndex < Avenues.INSTANCE.getAvenues().size()) {
//                westIndex = eastIndex - 1;
//                eastAvenue = Avenues.INSTANCE.getAvenues().get(eastIndex);
//                westAvenue = Avenues.INSTANCE.getAvenues().get(westIndex);
//                blockId = acceptNumber();
//                blockName = acceptName();
//                block = new Block(blockId, blockName, westAvenue, eastAvenue, northStreet, southStreet);
//                Blocks.INSTANCE.blocks.add(block);
//                eastIndex++; //borderCount;
//            }
//            southIndex++; //borderCount; //streetCounter++;
//        }
//    } // close createBlocks



    public String acceptName () {
        return NameGenerator.INSTANCE.assignName(this, northStreet, westAvenue);
    }

    public int acceptNumber () {
        return SerialNumberGenerator.INSTANCE.assignNumber(this);
    }
} // end enum BlockPopulator