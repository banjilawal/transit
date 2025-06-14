package com.lawal.transitcraft.infrastructure.junction;

import com.lawal.transitcraft.infrastructure.block.Block;
import com.lawal.transitcraft.infrastructure.curb.Curb;
import com.lawal.transitcraft.common.Direction;
import com.lawal.transitcraft.infrastructure.junction.exception.NullJunctionException;

import java.util.EnumSet;

public class JunctionCornerFactory {

    public static JunctionCorner createJunctionCorner(Long id, Junction junction, Direction cornerOrientation) {
        if (junction == null)
            throw new NullJunctionException(NullJunctionException.MESSAGE);

        if (!isValidOrientation(cornerOrientation))
            throw new IllegalArgumentException("Invalid junction corner orientation: " + cornerOrientation);

        String name = cornerOrientation.name() + " Corner";
        Block avenueLeg = getAvenueLeg(junction, cornerOrientation);
        Block streetLeg = getStreetLeg(junction, cornerOrientation);
        return new JunctionCorner(id, name, junction, cornerOrientation, avenueLeg, streetLeg);
    }

    private static Block getAvenueLeg(Junction junction, Direction cornerOrientation) {
        Curb avenueCurb = getAvenueCurb(junction, cornerOrientation);
        int streetId = (int) junction.getStreet().getId().intValue();
        int avenueLength = avenueCurb.getBlocks().size();

        Block avenueLeg = avenueCurb.getBlockByArrayIndex(streetId - 1);
//        this.avenueLeg = avenueCurb.getBlocks().get(streetId - 1);
        if (cornerOrientation == Direction.SOUTHWEST && streetId < avenueLength) {
            avenueLeg = avenueCurb.getBlockByArrayIndex(streetId); //avenueCurb.getBlocks().get(streetId);
        }
        return avenueLeg;
    }

    private static Block getStreetLeg(Junction junction, Direction cornerOrientation) {
        Curb streetCurb = getStreetCurb(junction, cornerOrientation);
        int avenueId = (int) junction.getAvenue().getId().intValue();
        int streetLength = streetCurb.getBlocks().size();

        Block streetLeg = streetCurb.getBlockByArrayIndex(avenueId - 1);
//        this.streetLeg = streetCurb.getBlocks().get(avenueId - 1);
        if (cornerOrientation == Direction.SOUTHWEST && avenueId < streetLength) {
            streetLeg = streetCurb.getBlockByArrayIndex(avenueId); //streetCurb.getBlocks().get(avenueId);
        }
        return streetLeg;
    }

    private static Curb getAvenueCurb(Junction junction, Direction cornerOrientation) {
        Direction curbOrientation = Direction.NORTH;

        if (cornerOrientation != Direction.NORTHEAST && cornerOrientation != Direction.NORTHWEST)
            curbOrientation = Direction.SOUTH;
        return junction.getAvenue().getCurbByOrientation(curbOrientation);
    }

    private static Curb getStreetCurb(Junction junction, Direction cornerOrientation) {
        Direction curbOrientation = Direction.EAST;

        if (cornerOrientation == Direction.SOUTHEAST)
            curbOrientation = Direction.WEST;
        return junction.getStreet().getCurbByOrientation(curbOrientation);
    }

    private static boolean isValidOrientation(Direction cornerOrientation) {
        return EnumSet.of(Direction.NORTHEAST, Direction.NORTHWEST, Direction.SOUTHEAST, Direction.SOUTHWEST)
            .contains(cornerOrientation);
    }
}