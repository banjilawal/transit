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

public enum BuildingPopulator implements Populator {
    INSTANCE;

    private int startingEvenAddressNumber = 0;
    private int startingOddAddressNumber = 0;

    public void populate () {
        processAvenues();
        processStreets();
    } // close populate


    private void processAvenues () {
        for (Avenue avenue : Avenues.INSTANCE.getAvenues()) {
            resetBaseAddress(avenue.getId());
            Predicate<Block> predicate = (block) -> block.getBorderRoad(Direction.EAST) == avenue;
            createBuildings(avenue, predicate, Direction.EAST, startingEvenAddressNumber); // GlobalConstant.INITAL_EVEN_ADDRESS_NUMBER); //startingEvenAddressNumber);

            predicate = (block) -> block.getBorderRoad(Direction.WEST) == avenue;
            createBuildings(avenue, predicate, Direction.WEST, startingOddAddressNumber); //GlobalConstant.INITIAL_ODD_ADDRESS_NUMBER); //startingOddAddressNumber);
        }
    } // close

    private void processStreets () {
        for (Street street : Streets.INSTANCE.getStreets()) {
            resetBaseAddress(street.getId());
            Predicate<Block> predicate = (block) -> block.getNorthernStreet() == street;
            createBuildings(street, predicate, Direction.NORTH, startingEvenAddressNumber);

            predicate = (block) -> block.getSouthernStreet() == street;
            createBuildings(street, predicate, Direction.SOUTH, startingOddAddressNumber);
        }
    } // close

    private void createBuildings (Road road, Predicate<Block> predicate, Direction orientation, int addressNumber) {
        Iterator<Block> iterator = Blocks.INSTANCE.filter(predicate).iterator();
        while (iterator.hasNext()) {
            Block block = iterator.next();
            for (int index = 0; index < Constant.BUILDINGS_PER_BLOCK_BORDER; index++) {
                Buildings.INSTANCE.add(new Building(SerialNumberGenerator.INSTANCE.assignNumber(this),
                    NameGenerator.INSTANCE.assignName(this, addressNumber),
                    block,
                    orientation)
                );
                addressNumber += Constant.ADDRESS_INTERVAL;
            }
        }
     } // close

    private void resetBaseAddress (int roadId) {
        startingEvenAddressNumber = roadId * Constant.MULTIPLICATION_FACTOR;
        startingOddAddressNumber = startingEvenAddressNumber + 1;
    } // close resetSinisterDexter

} // end class BuildingPopulator
