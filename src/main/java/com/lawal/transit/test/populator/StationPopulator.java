package com.lawal.transit.test.populator;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.concretes.*;
import com.lawal.transit.core.enums.Direction;
import com.lawal.transit.core.global.Constant;
import com.lawal.transit.core.interfaces.Populator;
import com.lawal.transit.core.singletons.*;
import com.lawal.transit.core.visitors.NameGenerator;
import com.lawal.transit.core.visitors.SerialNumberGenerator;

import java.util.Iterator;
import java.util.function.Predicate;

public enum StationPopulator implements Populator {
    INSTANCE;

    public void populate () {
        processAvenues();
        processStreets();
        adjacentNeighbors();
    } // close populate

    private void processAvenues () {
        for (Avenue avenue : Avenues.INSTANCE.getAvenues()) {
            Direction busDirection = Direction.NORTH;
            createStations(avenue, Constant.AVENUE_ROUTE_OUTBOUND_DIRECTION, Constant.NORTH_STATION_STARTING_NUMBER);

            busDirection = Direction.SOUTH;
            createStations(avenue, Constant.AVENUE_ROUTE_OUTBOUND_DIRECTION.oppositeDirection(), Constant.SOUTH_STATION_STARTING_NUMBER);
        }
    } // close

    private void processStreets() {
        for (Street street : Streets.INSTANCE.getStreets()) {
            Direction busDirection = Direction.EAST;
            createStations(street, Constant.STREET_ROUTE_OUTBOUND_DIRECTION, Constant.EAST_STATION_STARTING_NUMBER);

            busDirection = Direction.WEST;
            createStations(street, Constant.STREET_ROUTE_OUTBOUND_DIRECTION.oppositeDirection(), Constant.WEST_STATION_STARTING_NUMBER);
        }
    } // close

    private void adjacentNeighbors () {
        for (Station station : Stations.INSTANCE.getStations()) {
            station.setIncomingNeighbors();
            station.setOutgoingNeighbors();
        }
    } //

    private void createStations (Road road, Direction busDirection, int stationNumber) {
        Direction orientation = Block.borderOrientation(busDirection);
        Predicate<Block> predicate = (block) -> block.getBorderRoad(orientation).equals(road);

        Iterator<Block> iterator = Blocks.INSTANCE.filter(predicate).iterator();
        int buildCount = 0;
        while(iterator.hasNext()) {
            Block block = iterator.next();
            if (canBuildMore(buildCount)) {
                int id = SerialNumberGenerator.INSTANCE.assignNumber(this);
                String name = NameGenerator.INSTANCE.assignName(this, (stationNumber + (id - 2)));
                Station station = new Station(id, name, block, orientation);
                Stations.INSTANCE.add(station);
                int size = Stations.INSTANCE.size();
                if (size >= 2) {
                    Station previous = Stations.INSTANCE.getStations().get(size - 2);
                    station.addIncomingNeighbor(previous);
                    previous.addOutGoingNeighbor(station);
                }
            }
            buildCount++;
        }
    } // close

    private boolean canBuildMore (int buildCount) { return buildCount % Constant.STATION_BLOCK_INTERVAL == 0; }
} // end class StationPopulator


