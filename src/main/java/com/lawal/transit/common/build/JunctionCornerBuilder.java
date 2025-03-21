package com.lawal.transit.common.build;

import com.lawal.transit.infrastructure.block.Block;
import com.lawal.transit.infrastructure.curb.Curb;
import com.lawal.transit.common.Direction;
import com.lawal.transit.infrastructure.junction.Junction;
import com.lawal.transit.infrastructure.junction.JunctionCorner;
import com.lawal.transit.infrastructure.junction.exception.NullJunctionException;

import java.util.EnumSet;

public enum JunctionCornerBuilder {

    INSTANCE;

    public JunctionCorner build (Junction junction, Direction cornerOrientation) {
        if (junction == null)
            throw new NullJunctionException(NullJunctionException.MESSAGE);

        if (!isValidOrientation(cornerOrientation))
            throw new IllegalArgumentException("Invalid junction corner orientation: " + cornerOrientation);

        String name = cornerOrientation.name() + " Corner";
        Block avenueLeg = getAvenueLeg(junction, cornerOrientation);
        Block streetLeg = getStreetLeg(junction, cornerOrientation);

        return new JunctionCorner(null, name, junction, cornerOrientation, avenueLeg, streetLeg);
    }

    private Block getAvenueLeg(Junction junction, Direction cornerOrientation) {
        if (junction == null || junction.getAvenue() == null) return null;

        Curb avenueCurb = getAvenueCurb(junction, cornerOrientation);

        int streetId = (int) junction.getStreet().getId().intValue();
        int avenueLength = avenueCurb.getBlocks().size();

        Block avenueLeg = avenueCurb.getBlockByArrayIndex(streetId - 1);

        if (cornerOrientation == Direction.SOUTHWEST && streetId < avenueLength) {
            avenueLeg = avenueCurb.getBlockByArrayIndex(streetId);
        }
        return avenueLeg;
    }

    private static Block getStreetLeg(Junction junction, Direction cornerOrientation) {
        if (junction == null || junction.getStreet() == null) return null;

        Curb streetCurb = getStreetCurb(junction, cornerOrientation);
        int avenueId = (int) junction.getAvenue().getId().intValue();
        int streetLength = streetCurb.getBlocks().size();

        Block streetLeg = streetCurb.getBlockByArrayIndex(avenueId - 1);
        if (cornerOrientation == Direction.SOUTHWEST && avenueId < streetLength) {
            streetLeg = streetCurb.getBlockByArrayIndex(avenueId);
        }
        return streetLeg;
    }

    private static Curb getAvenueCurb(Junction junction, Direction cornerOrientation) {
        if (junction == null || cornerOrientation == null) return null;

        Direction curbOrientation = Direction.NORTH;

        if (cornerOrientation != Direction.NORTHEAST && cornerOrientation != Direction.NORTHWEST)
            curbOrientation = Direction.SOUTH;
        return junction.getAvenue().getCurbByOrientation(curbOrientation);
    }

    private static Curb getStreetCurb(Junction junction, Direction cornerOrientation) {
        if (junction == null || cornerOrientation == null) return null;

        Direction curbOrientation = Direction.EAST;

        if (cornerOrientation == Direction.SOUTHEAST)
            curbOrientation = Direction.WEST;
        return junction.getStreet().getCurbByOrientation(curbOrientation);
    }

    private static boolean isValidOrientation(Direction cornerOrientation) {
        if (cornerOrientation == null) return false;

        return EnumSet.of(Direction.NORTHEAST, Direction.NORTHWEST, Direction.SOUTHEAST, Direction.SOUTHWEST)
            .contains(cornerOrientation);
    }
}