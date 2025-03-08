package com.lawal.transit.navigtion;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.catalog.JunctionCatalog;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.global.TurnCategory;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.junction.model.JunctionCorner;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.station.model.Station;
import com.lawal.transit.street.model.Street;

import java.util.ArrayList;
import java.util.List;

public class TurnNavigationTest {


    public static void avenueTurningTest() {

        Block destinationBlock = null;
        for (Junction junction : JunctionCatalog.INSTANCE.getCatalog()) {
            for (JunctionCorner corner : junction.getCorners()) {
                Block sourceBlock = corner.getAvenueLeg();

                destinationBlock = TurnNavigator.destinationFromAvenue(junction, corner.getOrientation(), TurnCategory.LEFT_TURN);
                System.out.println(
                    TurnCategory.LEFT_TURN
                    + " from corner:" + corner.getOrientation().abbreviation()
                    + " " + sourceBlock
                    + " onto " + destinationBlock
                );

                destinationBlock = TurnNavigator.destinationFromAvenue(junction, corner.getOrientation(), TurnCategory.RIGHT_TURN);
                System.out.println(
                    TurnCategory.RIGHT_TURN
                    + " from corner:" + corner.getOrientation().abbreviation()
                    + " " + sourceBlock
                    + " onto " + destinationBlock
                );

                destinationBlock = TurnNavigator.destinationFromAvenue(junction, corner.getOrientation(), TurnCategory.REVERSE);
                System.out.println(
                    TurnCategory.REVERSE
                    + " from corner:" + corner.getOrientation().abbreviation()
                    + " " + sourceBlock
                    + " onto " + destinationBlock
                );

                destinationBlock = TurnNavigator.destinationFromAvenue(junction, corner.getOrientation(), TurnCategory.NO_TURN);
                System.out.println(
                    TurnCategory.NO_TURN
                    + " from corner:" + corner.getOrientation().abbreviation()
                    + " " + sourceBlock
                    + " onto " + destinationBlock
                );
            }
        }
    }

    public static void streetTurningTest() {

        Block destinationBlock = null;
        for (Junction junction : JunctionCatalog.INSTANCE.getCatalog()) {
            for (JunctionCorner corner : junction.getCorners()) {
                Block sourceBlock = corner.getStreetLeg();

                destinationBlock = TurnNavigator.destinationFromStreet(junction, corner.getOrientation(), TurnCategory.LEFT_TURN);
                System.out.println(
                    TurnCategory.LEFT_TURN
                    + " from corner:" + corner.getOrientation().abbreviation()
                    + " " + sourceBlock
                    + " onto " + destinationBlock
                );

                destinationBlock = TurnNavigator.destinationFromStreet(junction, corner.getOrientation(), TurnCategory.RIGHT_TURN);
                System.out.println(
                    TurnCategory.RIGHT_TURN
                        + " from corner:" + corner.getOrientation().abbreviation()
                        + " " + sourceBlock
                        + " onto " + destinationBlock
                );

                destinationBlock = TurnNavigator.destinationFromStreet(junction, corner.getOrientation(), TurnCategory.REVERSE);
                System.out.println(
                    TurnCategory.REVERSE
                        + " from corner:" + corner.getOrientation().abbreviation()
                        + " " + sourceBlock
                        + " onto " + destinationBlock
                );

                destinationBlock = TurnNavigator.destinationFromStreet(junction, corner.getOrientation(), TurnCategory.NO_TURN);
                System.out.println(
                    TurnCategory.NO_TURN
                        + " from corner:" + corner.getOrientation().abbreviation()
                        + " " + sourceBlock
                        + " onto " + destinationBlock
                );
            }
        }
    }
}