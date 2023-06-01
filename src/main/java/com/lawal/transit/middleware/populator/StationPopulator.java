package com.lawal.transit.middleware.populator;
/*
import com.lawal.transit.middleware.entities.*;
import com.lawal.transit.middleware.interfaces.NameAcceptor;
import com.lawal.transit.middleware.interfaces.NumberAcceptor;
import com.lawal.transit.middleware.singletons.*;
import com.lawal.transit.middleware.visitors.NameGenerator;
import com.lawal.transit.middleware.visitors.SerialNumberGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public enum StationPopulator implements Populator, NumberAcceptor, NameAcceptor {
    INSTANCE;

    private Avenue avenue;
    private Street street;
    String stationName;

    private int number;
    private int blockId;
    private int stationId;
    private int northStationNumber = 1000;
    private int eastStationNumber = 2000;
    private int southStationNumber = 3000;
    private int westStationNumber = 4000;
    private int endBorderId = RoadPopulator.INSTANCE.END_BORDER_ID;

    public void populate () {
        populateAvenues();
        populateStreets();
    } // close populate

    private void populateAvenues () {
        Stations stations = Stations.INSTANCE;
        Avenues avenues = Avenues.INSTANCE;
        for (Iterator<Avenue> iterator = avenues.iterator(); iterator.hasNext();) {
            avenue = (Avenue) iterator.next();
            Predicate<Block> avenueMatch = block -> block.getEastAvenue().getId() != endBorderId && block.getEastAvenue().equals(avenue);
            ArrayList<Integer> blockKeys = filterBlocks(avenueMatch);
            for (Integer blockKey : blockKeys) {
                blockId = blockKey.intValue();
                stationId = acceptNumber();
                stationName = NameGenerator.INSTANCE.assignName(this, westStationNumber);
                stations.add(new WestAvenueStation(stationId, stationName, blockId, avenue));
                westStationNumber++;
                stationName = NameGenerator.INSTANCE.assignName(this, eastStationNumber);
                stations.add(new EastAvenueStation(stationId, stationName, blockId, avenue));
                eastStationNumber++;
            }
        }
//        System.out.println(avenueStations.toString());
    } // close populateAvenues

    private void populateStreets () {
        StreetStations streetStations = StreetStations.INSTANCE;
        Streets streets = Streets.INSTANCE;
        for (Iterator<Street> iterator = streets.iterator(); iterator.hasNext();) {
            street = (Street) iterator.next();
            Predicate<Block> streetMatch = block -> block.getSouthStreet().getId() != endBorderId && block.getSouthStreet().equals(street);
            ArrayList<Integer> blockKeys = filterBlocks(streetMatch);
            for (Integer blockKey : blockKeys) {
                blockId = blockKey.intValue();
                stationId = acceptNumber();
                stationName = NameGenerator.INSTANCE.assignName(this, southStationNumber);
                streetStations.add(new SouthStreetStation(stationId, stationName, blockId, street));
                southStationNumber++;
                stationName = NameGenerator.INSTANCE.assignName(this, northStationNumber);
                streetStations.add(new NorthStreetStation(stationId, stationName, blockId, street));
                northStationNumber++;
            }
        }
//        System.out.println(streetStations.toString());
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
} // end class StationPopulator

 */
