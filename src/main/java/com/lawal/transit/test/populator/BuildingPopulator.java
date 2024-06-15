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

public enum BuildingPopulator implements Populator {
    INSTANCE;

    private int startingEvenAddressNumber = 0;
    private int startingOddAddressNumber = 0;

    public void populate () {
        processAvenues();
        processStreets();
    } // close populate


    private void processAvenues () {
        for (ConcreteAvenue concreteAvenue : Avenues.INSTANCE.getAvenues()) {
            resetBaseAddress(concreteAvenue.getId());
            Predicate<OldConcreteBlock> predicate = (block) -> block.getBorderRoad(Orientation.EAST) == concreteAvenue;
            createBuildings(concreteAvenue, predicate, Orientation.EAST, startingEvenAddressNumber); // GlobalConstant.INITAL_EVEN_ADDRESS_NUMBER); //startingEvenAddressNumber);

            predicate = (block) -> block.getBorderRoad(Orientation.WEST) == concreteAvenue;
            createBuildings(concreteAvenue, predicate, Orientation.WEST, startingOddAddressNumber); //GlobalConstant.INITIAL_ODD_ADDRESS_NUMBER); //startingOddAddressNumber);
        }
    } // close

    private void processStreets () {
        for (ConcreteStreet concreteStreet : Streets.INSTANCE.getStreets()) {
            resetBaseAddress(concreteStreet.getId());
            Predicate<OldConcreteBlock> predicate = (block) -> block.getNorthernStreet() == concreteStreet;
            createBuildings(concreteStreet, predicate, Orientation.NORTH, startingEvenAddressNumber);

            predicate = (block) -> block.getSouthernStreet() == concreteStreet;
            createBuildings(concreteStreet, predicate, Orientation.SOUTH, startingOddAddressNumber);
        }
    } // close

    private void createBuildings (AbstractRoad abstractRoad, Predicate<OldConcreteBlock> predicate, Orientation orientation, int addressNumber) {
        Iterator<OldConcreteBlock> iterator = Blocks.INSTANCE.filter(predicate).iterator();
        while (iterator.hasNext()) {
            OldConcreteBlock concreteBlock = iterator.next();
            for (int index = 0; index < Constant.BUILDINGS_PER_BLOCK_BORDER; index++) {
                Buildings.INSTANCE.add(new AbstractBuilding(SerialNumberGenerator.INSTANCE.assignNumber(this),
                    NameGenerator.INSTANCE.assignName(this, addressNumber),
                    concreteBlock,
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
