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

    @Override
    public void populate () {
        Blocks blocks = Blocks.INSTANCE;
        String blockName;
        int blockId;

        southIndex = 1;
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
                blocks.getBag().add(new Block(blockId, blockName, westAvenue, eastAvenue, northStreet, southStreet));
                eastIndex++; //borderCount;
            }
            southIndex++; //borderCount; //streetCounter++;
        }
    } // close populate

    public String acceptName () {
        return NameGenerator.INSTANCE.assignName(this, northStreet, westAvenue);
    }

    public int acceptNumber () {
        return SerialNumberGenerator.INSTANCE.assignNumber(this);
    }
} // end enum BlockPopulator