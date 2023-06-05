package com.lawal.transit.core.populator;

import com.lawal.transit.core.entities.*;
import com.lawal.transit.core.enums.Direction;
import com.lawal.transit.core.interfaces.NameAcceptor;
import com.lawal.transit.core.interfaces.NumberAcceptor;
import com.lawal.transit.core.interfaces.Populator;
import com.lawal.transit.core.singletons.Avenues;
import com.lawal.transit.core.singletons.Blocks;
import com.lawal.transit.core.singletons.Stations;
import com.lawal.transit.core.singletons.Streets;
import com.lawal.transit.core.visitors.NameGenerator;
import com.lawal.transit.core.visitors.SerialNumberGenerator;

public enum StationPopulator implements Populator, NumberAcceptor, NameAcceptor {
    INSTANCE;

    private Avenue avenue;
    private Street street;
    String stationName;

    private int number;
    private int blockId;
    private int stationId;
    private int northStationNumber = GlobalConstant.NORTH_STATION_STARTING_NUMBER -1;
    private int eastStationNumber = GlobalConstant.EAST_STATION_STARTING_NUMBER - 1;
    private int southStationNumber = GlobalConstant.SOUTH_STATION_STARTING_NUMBER - 1;
    private int westStationNumber = GlobalConstant.WEST_STATION_STARTING_NUMBER - 1;
    private int endBorderId = GlobalConstant.END_BORDER_ID;


    public void populate () {
        populateAvenues();
        populateStreets();
        Stations.INSTANCE.stations.neighborProcessing();
    } // close populate

    private void populateAvenues () {
        while (Avenues.INSTANCE.iterator().hasNext()) {
            Avenue avenue = Avenues.INSTANCE.iterator().next();
            while (Blocks.INSTANCE.filterByAvenue(avenue).hasNext()) {
                stationId = acceptNumber();
                Block block = Blocks.INSTANCE.filterByAvenue(avenue).next();
                buildAvenueStation(block, avenue, stationId);
            }
        }
    } // close populateAvenues

    public String buildAvenueStation (Block block, Avenue avenue, int stationId) {
        if (block.getWestAvenue().equals(avenue)) {
            stationName = NameGenerator.INSTANCE.assignName(this, westStationNumber);
            Stations.INSTANCE.stations.add(new Station(stationId, stationName, block, Direction.WEST));
        }
        if (block.getEastAvenue().equals(avenue)) {
            stationName = NameGenerator.INSTANCE.assignName(this, eastStationNumber);
            Stations.INSTANCE.stations.add(new Station(stationId, stationName, block, Direction.EAST));
        }
        return null;
    } // close buildAvenueStation


    private void populateStreets () {
        while (Streets.INSTANCE.iterator().hasNext()) {
            Street street = Streets.INSTANCE.iterator().next();
            while (Blocks.INSTANCE.filterByStreet(street).hasNext()) {
                stationId = acceptNumber();
                Block block = Blocks.INSTANCE.filterByStreet(street).next();
                buildStreetStation(block, street, stationId);
            }
        }
    } // close populateStreets

    public String buildStreetStation (Block block, Street street, int stationId) {
        if (block.getNorthStreet().equals(street)) {
            stationName = NameGenerator.INSTANCE.assignName(this, northStationNumber);
            Stations.INSTANCE.stations.add(new Station(stationId, stationName, block, Direction.NORTH));
        }
        if (block.getSouthStreet().equals(street)) {
            stationName = NameGenerator.INSTANCE.assignName(this, southStationNumber);
            Stations.INSTANCE.stations.add(new Station(stationId, stationName, block, Direction.EAST));
        }
        return null;
    } // close buildStreetStationName
/*
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
 */
    @Override
    public int acceptNumber () {
        return SerialNumberGenerator.INSTANCE.assignNumber(this);
    } // close acceptNumber

    @Override
    public String acceptName() {
        return NameGenerator.INSTANCE.assignName(this, number);
    } // close acceptName
} // end class StationPopulator


