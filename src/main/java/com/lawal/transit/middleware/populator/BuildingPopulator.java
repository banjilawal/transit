package com.lawal.transit.middleware.populator;

import com.lawal.transit.middleware.entities.*;
import com.lawal.transit.middleware.interfaces.NameAcceptor;
import com.lawal.transit.middleware.interfaces.NumberAcceptor;
import com.lawal.transit.middleware.singletons.*;
import com.lawal.transit.middleware.visitors.NameGenerator;
import com.lawal.transit.middleware.visitors.SerialNumberGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public enum BuildingPopulator implements Populator, NumberAcceptor, NameAcceptor {
    INSTANCE;

    private Avenue avenue;
    private Street street;
    String buildingName;

    private int number;
    private int blockId;
    private int buildingId;
    private int currentIndex;
    private int endBorderId = RoadPopulator.INSTANCE.END_BORDER_ID;

    public static int BUILDINGS_PER_BLOCK_BORDER = 1;
    public static int MULTIPLICATION_FACTOR = 1000;
    public static int ADDRESS_INTERVAL = 2;

    public void populate () {
        populateAvenues();
        populateStreets();
    } // close populate

    private void populateAvenues () {
        AvenueBuildings avenueBuildings = AvenueBuildings.INSTANCE;
        Avenues avenues = Avenues.INSTANCE;
        for (Iterator<Avenue> iterator = avenues.iterator(); iterator.hasNext();) {
            avenue = (Avenue) iterator.next();
            number = avenue.getId() * MULTIPLICATION_FACTOR;
            Predicate<Block> avenueMatch = block -> block.getEastAvenue().getId() != endBorderId && block.getEastAvenue().equals(avenue);
            ArrayList<Integer> blockKeys = filterBlocks(avenueMatch);
            for (Integer blockKey : blockKeys) {
                blockId = blockKey.intValue();
                for (int index = 0; index < BUILDINGS_PER_BLOCK_BORDER; index++) {
                    buildingId = acceptNumber();
                    buildingName = NameGenerator.INSTANCE.assignName(this, number);
                    avenueBuildings.add(new WestAvenueBuilding(buildingId, buildingName, blockId, avenue));
                    buildingName = NameGenerator.INSTANCE.assignName(this, (number + 1));
                    avenueBuildings.add(new EastAvenueBuilding(buildingId, buildingName, blockId, avenue));
                    number += ADDRESS_INTERVAL;
                }
            }
        }
//        System.out.println(avenueBuildings.toString());
    } // close populateAvenues

    private void populateStreets () {
        StreetBuildings streetBuildings = StreetBuildings.INSTANCE;
        Streets streets = Streets.INSTANCE;
        for (Iterator<Street> iterator = streets.iterator(); iterator.hasNext();) {
            street = (Street) iterator.next();
            number = street.getId() * MULTIPLICATION_FACTOR;
            Predicate<Block> streetMatch = block -> block.getSouthStreet().getId() != endBorderId && block.getSouthStreet().equals(street);
            ArrayList<Integer> blockKeys = filterBlocks(streetMatch);
            for (Integer blockKey : blockKeys) {
                blockId = blockKey.intValue();
                for (int index = 0; index < BUILDINGS_PER_BLOCK_BORDER; index++) {
                    buildingId = acceptNumber();
                    buildingName = NameGenerator.INSTANCE.assignName(this, number);
                    streetBuildings.add(new SouthStreetBuilding(buildingId, buildingName, blockId, street));
                    buildingName = NameGenerator.INSTANCE.assignName(this, (number + 1));
                    streetBuildings.add(new NorthStreetBuilding(buildingId, buildingName, blockId, street));
                    number += ADDRESS_INTERVAL;
                }
            }
        }
//        System.out.println(streetBuildings.toString());
    } // close populateStreets

    public ArrayList<Integer> filterBlocks(Predicate<Block> predicate) {
        Blocks blocks = Blocks.INSTANCE;
        ArrayList<Integer> results = new ArrayList<>();
        for (Iterator<Block> iterator = blocks.iterator(); iterator.hasNext();) {
            Block block = (Block) iterator.next();
            if (predicate.test(block)) { //.getWestAvenue().equals(avenue)) {
                results.add(block.getId());
            }
        }
        return results;
    } // close process

    @Override
    public int acceptNumber () {
        return SerialNumberGenerator.INSTANCE.assignNumber(this);
    } // close acceptNumber

    @Override
    public String acceptName() {
        return NameGenerator.INSTANCE.assignName(this, number);
    } // close acceptName
} // end class BuildingPopulator
