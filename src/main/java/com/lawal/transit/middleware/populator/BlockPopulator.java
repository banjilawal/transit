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
        Streets streets = Streets.INSTANCE;
        Avenues avenues = Avenues.INSTANCE;
        String blockName;
        int blockId;

        southIndex = 1;
        while (southIndex < streets.size()) {
            northIndex = southIndex - 1;
            northStreet = (Street) streets.getBag().get(northIndex);
            southStreet = (Street) streets.getBag().get(southIndex);
            eastIndex = 1;
            while (eastIndex < avenues.size()) {
                westIndex = eastIndex - 1;
                eastAvenue = (Avenue) avenues.getBag().get(eastIndex);
                westAvenue = (Avenue) avenues.getBag().get(westIndex);
                blockId = acceptNumber();
                blockName = acceptName();
                Block block = new Block(blockId, blockName, westAvenue, eastAvenue, northStreet, southStreet);
                blocks.add(block);
//                System.out.print("id:" + blockId + " name:" + blockName);
//                System.out.print(" north:" + northStreet + " east:" + eastAvenue);
//                System.out.println(" south:" + southStreet + " west:" + westAvenue);
//                System.out.println(Direction.NORTH.toString() + ": " + northIndex + " " + northStreet.getName());
//                System.out.println("\t" + Direction.EAST.toString() + ": " + eastIndex + " " + eastAvenue.getName());
//                System.out.println(Direction.SOUTH.toString() + ": " + southIndex + " " + southStreet.getName());
//                System.out.println("\t" + Direction.WEST.toString() + ": " + westIndex + " " + westAvenue.getName());
                eastIndex += 1; //borderCount;
            }
            southIndex += 1; //borderCount; //streetCounter++;
        }
    } // close populate

    public String acceptName () {
        return NameGenerator.INSTANCE.assignName(this, northStreet, westAvenue);
    }

    public int acceptNumber () {
        return SerialNumberGenerator.INSTANCE.assignNumber(this);
    }
} // end enum BlockPopulator