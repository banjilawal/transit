package com.lawal.transit.test.populator;

import com.lawal.transit.core.abstracts.AbstractRoad;
import com.lawal.transit.core.concretes.*;
import com.lawal.transit.Orientation;
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
        for (ConcreteAvenue concreteAvenue : Avenues.INSTANCE.getAvenues()) {
            Orientation busOrientation = Orientation.NORTH;
            createStations(concreteAvenue, Constant.avenueRouteOutboundOrientation, Constant.NORTH_STATION_STARTING_NUMBER);

            busOrientation = Orientation.SOUTH;
            createStations(concreteAvenue, Constant.avenueRouteOutboundOrientation.oppositeDirection(), Constant.SOUTH_STATION_STARTING_NUMBER);
        }
    } // close

    private void processStreets() {
        for (ConcreteStreet concreteStreet : Streets.INSTANCE.getStreets()) {
            Orientation busOrientation = Orientation.EAST;
            createStations(concreteStreet, Constant.streetRouteOutboundOrientation, Constant.EAST_STATION_STARTING_NUMBER);

            busOrientation = Orientation.WEST;
            createStations(concreteStreet, Constant.streetRouteOutboundOrientation.oppositeDirection(), Constant.WEST_STATION_STARTING_NUMBER);
        }
    } // close

    private void adjacentNeighbors () {
        for (OldAbstractStation oldAbstractStation : Stations.INSTANCE.getStations()) {
            oldAbstractStation.setIncomingNeighbors();
            oldAbstractStation.setOutgoingNeighbors();
        }
    } //

    private void createStations (AbstractRoad abstractRoad, Orientation busOrientation, int stationNumber) {
        Orientation orientation = OldConcreteBlock.borderOrientation(busOrientation);
        Predicate<OldConcreteBlock> predicate = (block) -> block.getBorderRoad(orientation).equals(abstractRoad);

        Iterator<OldConcreteBlock> iterator = Blocks.INSTANCE.filter(predicate).iterator();
        int buildCount = 0;
        while(iterator.hasNext()) {
            OldConcreteBlock concreteBlock = iterator.next();
            if (canBuildMore(buildCount)) {
                int id = SerialNumberGenerator.INSTANCE.assignNumber(this);
                String name = NameGenerator.INSTANCE.assignName(this, (stationNumber + (id - 2)));
                OldAbstractStation oldAbstractStation = new OldAbstractStation(id, name, concreteBlock, orientation);
                Stations.INSTANCE.add(oldAbstractStation);
                int size = Stations.INSTANCE.size();
                if (size >= 2) {
                    OldAbstractStation previous = Stations.INSTANCE.getStations().get(size - 2);
                    oldAbstractStation.addIncomingNeighbor(previous);
                    previous.addOutGoingNeighbor(oldAbstractStation);
                }
            }
            buildCount++;
        }
    } // close

    private boolean canBuildMore (int buildCount) { return buildCount % Constant.STATION_BLOCK_INTERVAL == 0; }
} // end class StationPopulator


