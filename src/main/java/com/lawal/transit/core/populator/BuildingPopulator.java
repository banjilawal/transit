package com.lawal.transit.core.populator;

import com.lawal.transit.core.entities.*;
import com.lawal.transit.core.enums.Direction;
import com.lawal.transit.core.interfaces.NameAcceptor;
import com.lawal.transit.core.interfaces.NumberAcceptor;
import com.lawal.transit.core.interfaces.Populator;
import com.lawal.transit.core.singletons.*;
import com.lawal.transit.core.visitors.NameGenerator;
import com.lawal.transit.core.visitors.SerialNumberGenerator;

public enum BuildingPopulator implements Populator, NumberAcceptor, NameAcceptor {
    INSTANCE;
//    public static final int BUILDINGS_PER_BLOCK_BORDER = 1;
//    public static final int MULTIPLICATION_FACTOR = 1000;
//    public static final int ADDRESS_INTERVAL = 2;
//    private int startBorderId = RoadPopulator.INSTANCE.START_BORDER_ID;
//    private int endBorderId = RoadPopulator.INSTANCE.END_BORDER_ID;
    private int currentIndex;
    private int buildingId = 0;
    private int blockId = 0;
    private int number = 0;
    private int dexterNumber = 0;
    private int sinisterNumber = 0;
    private Avenue avenue = null;
    private Street street = null;
    private String buildingName = "";
    private Direction curbSide = Direction.NONE;

    public void populate () {
        populateAvenues();
        populateStreets();
    } // close populate

    private void populateAvenues () {
        for (Avenue avenue : Avenues.INSTANCE.getAvenues().getContents()) {
            if (avenue.getId() != GlobalConstant.START_BORDER_ID && avenue.getId() != GlobalConstant.END_BORDER_ID) {
                resetSinisterDexter(avenue.getId());
                populateBlock(avenue, null);
            }
        }
    } // close populateAvenues

    private void populateStreets () {
        for (Street street : Streets.INSTANCE.getStreets().getContents()) {
            if (street.getId() != GlobalConstant.START_BORDER_ID && street.getId() != GlobalConstant.END_BORDER_ID) {
                populateBlock(null, street);
            }
        }
    } // close populateAvenues

    private void populateBlock (Avenue avenue, Street street) {
        if (avenue != null) {
            for (Block block : Blocks.INSTANCE.getBlocks().getContents()) {
                buildingId = acceptNumber();
                setAvenueBuildingFields(avenue, block);
                Buildings.INSTANCE.buildings.add(new Building(buildingId, buildingName, block, curbSide));
                updateSinisterDexter();
            }
        }
        if (street != null) {
            for (Block block : Blocks.INSTANCE.blocks.getContents()) {
                buildingId = acceptNumber();
                setStreetBuildingFields(street, block);
                Buildings.INSTANCE.buildings.add(new Building(buildingId, buildingName, block, curbSide));
                updateSinisterDexter();
            }
        }
    } // close populateBlock

/*    private void populateBlock (Avenue avenue, Street street) {
        if (avenue != null) {
            for (Block block : Blocks.INSTANCE.getBlocks().getContents()) {
                buildingId = acceptNumber();
                setAvenueBuildingFields(avenue, block);
                if (block.getWestAvenue().equals(avenue)) {
                    buildingName = NameGenerator.INSTANCE.assignName(this, dexterNumber);
                    curbSide = Direction.WEST;
                }
                if (block.getEastAvenue().equals(avenue)) {
                    buildingName = NameGenerator.INSTANCE.assignName(this, sinisterNumber);
                    curbSide = Direction.EAST;
                }
                Buildings.INSTANCE.buildings.add(new Building(buildingId, buildingName, block, curbSide));
                updateSinisterDexter();
            }
        }
        if (street != null) {
            for (Block block : Blocks.INSTANCE.blocks.getContents()) {
                buildingId = acceptNumber();
                setStreetBuildingFields(street, block);
                if (block.getNorthStreet().equals(street)) {
                    buildingName = NameGenerator.INSTANCE.assignName(this, dexterNumber);
                    curbSide = Direction.NORTH;
                }
                if (block.getSouthStreet().equals(street)) {
                    buildingName = NameGenerator.INSTANCE.assignName(this, sinisterNumber);
                    curbSide = Direction.SOUTH;
                }
                Buildings.INSTANCE.buildings.add(new Building(buildingId, buildingName, block, curbSide));
                updateSinisterDexter();
            }
        }
    } // close populateBlock*/

    private void setAvenueBuildingFields (Avenue avenue, Block block) {
        if (block.getWestAvenue().equals(avenue)) {
            buildingName = NameGenerator.INSTANCE.assignName(this, dexterNumber);
            curbSide = Direction.WEST;
        }
        if (block.getEastAvenue().equals(avenue)) {
            buildingName = NameGenerator.INSTANCE.assignName(this, sinisterNumber);
            curbSide = Direction.EAST;
        }
    } // close setAvenueBuildingFields

    private void setStreetBuildingFields (Street street, Block block) {
        if (block.getNorthStreet().equals(street)) {
            buildingName = NameGenerator.INSTANCE.assignName(this, dexterNumber);
            curbSide = Direction.NORTH;
        }
        if (block.getSouthStreet().equals(street)) {
            buildingName = NameGenerator.INSTANCE.assignName(this, sinisterNumber);
            curbSide = Direction.SOUTH;
        }
    } // close setStreetBuildingFields

    private void resetSinisterDexter (int roadId) {
        dexterNumber = roadId * GlobalConstant.MULTIPLICATION_FACTOR;
        sinisterNumber = dexterNumber + 1;
    } // close resetSinisterDexter

    private void updateSinisterDexter () {
        dexterNumber += GlobalConstant.ADDRESS_INTERVAL;
        sinisterNumber += GlobalConstant.ADDRESS_INTERVAL;
    } // close updateSinisterDexter

    @Override
    public int acceptNumber () {
        return SerialNumberGenerator.INSTANCE.assignNumber(this);
    } // close acceptNumber

    @Override
    public String acceptName() {
        return NameGenerator.INSTANCE.assignName(this, number);
    } // close acceptName
} // end class BuildingPopulator
