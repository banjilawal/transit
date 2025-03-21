package com.lawal.transit.common.traversal;

import com.lawal.transit.infrastructure.block.Block;
import com.lawal.transit.infrastructure.catalog.JunctionCatalog;
import com.lawal.transit.common.TurnCategory;
import com.lawal.transit.infrastructure.junction.Junction;
import com.lawal.transit.infrastructure.junction.JunctionCorner;

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