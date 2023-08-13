package com.lawal.transit.core.populator;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.entities.*;
import com.lawal.transit.core.enums.Direction;
import com.lawal.transit.core.interfaces.NameAcceptor;
import com.lawal.transit.core.interfaces.NumberAcceptor;
import com.lawal.transit.core.interfaces.Populator;
import com.lawal.transit.core.singletons.*;
import com.lawal.transit.core.visitors.NameGenerator;
import com.lawal.transit.core.visitors.SerialNumberGenerator;

import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public enum StationPopulator implements Populator {
    INSTANCE;

    public void populate () {
        processAvenues();
        processStreets();
    } // close populate

    private void processAvenues () {
        for (Avenue avenue : Avenues.INSTANCE.getBagContents()) {
            Direction busDirection = Direction.NORTH;
            createStations(avenue, busDirection, GlobalConstant.NORTH_STATION_STARTING_NUMBER);

            busDirection = Direction.SOUTH;
            createStations(avenue, busDirection, GlobalConstant.SOUTH_STATION_STARTING_NUMBER);
        }
    } // close

    private void processStreets() {
        for (Street street : Streets.INSTANCE.getBagContents()) {
            Direction busDirection = Direction.EAST;
            createStations(street, busDirection, GlobalConstant.EAST_STATION_STARTING_NUMBER);

            busDirection = Direction.WEST;
            createStations(street, busDirection, GlobalConstant.WEST_STATION_STARTING_NUMBER);
        }
    } // close

    private void createStations (Road road, Direction busDirection, int stationNumber) {
        Direction orientation = Block.borderOrientation(busDirection);
        Predicate<Block> predicate = (block) -> block.getBorderRoad(orientation).equals(road);

        Iterator<Block> iterator = Blocks.INSTANCE.getBag().search(predicate);
        int buildCount = 0;
        while(iterator.hasNext()) {
            Block block = iterator.next();
            if (canBuildMore(buildCount)) {
                int id = SerialNumberGenerator.INSTANCE.assignNumber(this);
                String name = NameGenerator.INSTANCE.assignName(this, (stationNumber + (id - 2)));
                Station station = new Station(id, name, block, busDirection);
                Stations.INSTANCE.add(station);
                int size = Stations.INSTANCE.size();
                if (size >= 2) {
                    Station previous = Stations.INSTANCE.getBagContents().get(size - 2);
                    station.addIncomigNeighbor(previous);
                    previous.addOutGoingNeighbor(station);
                }
            }
            buildCount++;
        }
    } // close

    private boolean canBuildMore (int buildCount) { return buildCount % GlobalConstant.STATION_BLOCK_INTERVAL == 0; }
} // end class StationPopulator


