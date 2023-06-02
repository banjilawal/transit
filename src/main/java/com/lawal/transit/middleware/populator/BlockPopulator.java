package com.lawal.transit.middleware.populator;

import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.entities.Block;
import com.lawal.transit.middleware.entities.Street;
import com.lawal.transit.middleware.interfaces.NameAcceptor;
import com.lawal.transit.middleware.interfaces.NumberAcceptor;
import com.lawal.transit.middleware.singletons.Avenues;
import com.lawal.transit.middleware.singletons.Blocks;
import com.lawal.transit.middleware.singletons.Streets;
import com.lawal.transit.middleware.visitors.NameGenerator;
import com.lawal.transit.middleware.visitors.SerialNumberGenerator;

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
    } // close populate

    private Block createBlocks () {
        southIndex = 1;
        Block block;
        while (southIndex < Streets.INSTANCE.getBag().size()) {
            northIndex = southIndex - 1;
            northStreet = Streets.INSTANCE.getBag().get(northIndex);
            southStreet = Streets.INSTANCE.getBag().get(southIndex);
            eastIndex = 1;
            while (eastIndex < Avenues.INSTANCE.getBag().size()) {
                westIndex = eastIndex - 1;
                eastAvenue = Avenues.INSTANCE.getBag().get(eastIndex);
                westAvenue = Avenues.INSTANCE.getBag().get(westIndex);
                blockId = acceptNumber();
                blockName = acceptName();
                block = new Block(blockId, blockName, westAvenue, eastAvenue, northStreet, southStreet);
                Blocks.INSTANCE.bag.add(block);
                ArrayList<Integer> neighborIndices = calculateNeighborIndices(Blocks.INSTANCE.bag.size());
                addNeighbors(block, neighborIndices);
                eastIndex++; //borderCount;
            }
            southIndex++; //borderCount; //streetCounter++;
        }
    } // close createBlocks

    private void addNeighbors (Block block, ArrayList<Integer> neighborIndices) {
        for (Integer index : neighborIndices) {
            Block neighbor = Blocks.INSTANCE.bag.get(index.intValue());
            block.addNeighbor(neighbor);
            neighbor.addNeighbor(block);
        }
    } // close addNeighbors

    private ArrayList<Integer> calculateNeighborIndices (int arrayLocation) {
        ArrayList<Integer> neighborIndices = new ArrayList<Integer>();
        return neighborIndices;
    } // close calculateNeighborIndices

    public String acceptName () {
        return NameGenerator.INSTANCE.assignName(this, northStreet, westAvenue);
    }

    public int acceptNumber () {
        return SerialNumberGenerator.INSTANCE.assignNumber(this);
    }
} // end enum BlockPopulator