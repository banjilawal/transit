package com.lawal.transit.navigtion;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.catalog.AvenueCatalog;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.global.Direction;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.station.model.Station;
import com.lawal.transit.street.model.Street;

import java.util.List;

public class FindCornerStation {

    public static Block processSharedAvenue(Station station, Junction junction) {
        if (station == null || junction == null) return null;
        Avenue stationAvenue = station.getBlock().getCurb().getAvenue();

        if (stationAvenue == null) return null;
        if (!junction.getAvenue().equals(stationAvenue)) return null;

        Curb sharedCurb = station.getBlock().getCurb();
        if (sharedCurb.getOrientation() == Avenue.LEFT_CURB_ORIENTATION) {
            return junction.getCornerByOrientation(Direction.NORTHWEST).getAvenueLeg();
        }

        if (sharedCurb.getOrientation() == Avenue.RIGHT_CURB_ORIENTATION) {
            return junction.getCornerByOrientation(Direction.SOUTHEAST).getAvenueLeg();
        }
        return null;
    }

    public static Block processSharedStreet(Station station, Junction junction) {
        if (station == null || junction == null) return null;
        Street stationStreet = station.getBlock().getCurb().getStreet();

        if (stationStreet == null) return null;
        if (!junction.getStreet().equals(stationStreet)) return null;

        Curb sharedCurb = station.getBlock().getCurb();
        if (sharedCurb.getOrientation() == Street.LEFT_CURB_ORIENTATION) {
            return junction.getCornerByOrientation(Direction.SOUTHWEST).getStreetLeg();
        }

        if (sharedCurb.getOrientation() == Street.RIGHT_CURB_ORIENTATION) {
            return junction.getCornerByOrientation(Direction.NORTHEAST).getStreetLeg();
        }
        return null;
    }

    public static void getCornerStationDistance(Station station, Junction junction) {
        if (station == null || junction == null) return;
        Avenue sharedAvenue;
        Street sharedStreet;
        Curb sharedCurb;
        Block adjacentJunctionBlock;

        System.out.println("STATION:" + station.toString());

        if (station.getBlock().getCurb().getAvenue() != null) {
            adjacentJunctionBlock = processSharedAvenue(station, junction);
        }
        else if (station.getBlock().getCurb().getStreet() != null) {
            adjacentJunctionBlock = processSharedStreet(station, junction);
        } else {
            System.out.println("The station is not on a street or avenue");
            return;
        }
        if (adjacentJunctionBlock == null) {
            System.out.println("There is no adjacent block between the junction and station");
            return;
        }

        if (adjacentJunctionBlock.getStation() != null) {
            Station junctionStation = adjacentJunctionBlock.getStation();
            System.out.println("Bingo! junction station at " + adjacentJunctionBlock.toString() + " is " + junctionStation.toString());
        }

        sharedCurb = station.getBlock().getCurb();
        int stationBlockIndex = sharedCurb.getBlocks().indexOf(station.getBlock());
        int adjacentJunctionBlockIndex = sharedCurb.getBlocks().indexOf(adjacentJunctionBlock);

        System.out.println(
            "stationBlock:" + station.getBlock().toString()
            + "stationBlockIndex:" + stationBlockIndex
            + "\nadjacentJunctionBlock:" + adjacentJunctionBlock.toString()
            + " adjacentJunctionBlockIndex:" + adjacentJunctionBlockIndex
            + "\nsIndex - jIndex = " + (stationBlockIndex - adjacentJunctionBlockIndex)
        );
    }

    public static void processCurb(Direction curbOrientation, Avenue avenue) {
        if (avenue == null || curbOrientation == null) return;
        Curb curb = avenue.getCurbByOrientation(curbOrientation);
        if (curb == null) return;
        for (Station station : curb.getStations()) {
            for (Junction junction : avenue.getJunctions()) {
                getCornerStationDistance(station, junction);
                System.out.println("---------------------------------------");
            }
        }
    }

    public static void launcher() {
        Avenue avenue = AvenueCatalog.INSTANCE.findById(1L);
        processCurb(Avenue.LEFT_CURB_ORIENTATION, avenue);
        processCurb(Avenue.RIGHT_CURB_ORIENTATION, avenue);
    }
}