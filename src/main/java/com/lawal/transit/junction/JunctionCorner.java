package com.lawal.transit.junction;

import com.lawal.transit.block.Block;
import com.lawal.transit.catalog.AvenueCatalog;
import com.lawal.transit.catalog.CurbCatalog;
import com.lawal.transit.catalog.StreetCatalog;
import com.lawal.transit.global.Direction;
import com.lawal.transit.road.Avenue;
import com.lawal.transit.road.Curb;
import com.lawal.transit.road.Street;
import lombok.Getter;

@Getter

public class JunctionCorner {

    private final int id;
    private final String name;
    private final Direction cornerOrientation;
    private final Junction junction;

    private Block avenueLeg;
    private Block streetLeg;

    public JunctionCorner(int id, Junction junction, Direction cornerOrientation) {
        this.id = id;
        this.junction = junction;
        if (isValidOrientation(cornerOrientation))
            this.cornerOrientation = cornerOrientation;
        else throw new IllegalArgumentException("Invalid junction corner orientation: " + cornerOrientation);
        setAvenueLeg();
        getStreetCurb();
        setStreetLeg();
        this.name = this.cornerOrientation.name() + " Corner";

    }

    private void setAvenueLeg() {
        Curb avenueCurb = getAvenueCurb();
        int streetId = junction.street().getId();
        int avenueLength = avenueCurb.getBlocks().size();


        this.avenueLeg = avenueCurb.getBlocks().getList().get(streetId - 1);

        if (cornerOrientation != Direction.NORTHWEST && cornerOrientation == Direction.SOUTHWEST && streetId < avenueLength) {
            this.avenueLeg = avenueCurb.getBlocks().getList().get(streetId);
        }

        System.out.println("avenueLeg:" + avenueLeg.toString()
            + " avenue_curb_arrayIndex:" + avenueCurb.getBlocks().getList().indexOf(avenueLeg)
            + " cornerId:" + id + " cornerOrientation:"
            + cornerOrientation.print() + "");
    }

    private void setStreetLeg() {
        Curb streetCurb = getStreetCurb();
        int avenueId = junction.avenue().getId();
        int streetLength = streetCurb.getBlocks().size();

        this.streetLeg = streetCurb.getBlocks().getList().get(avenueId - 1);

        if (cornerOrientation != Direction.NORTHWEST && cornerOrientation == Direction.SOUTHWEST && avenueId < streetLength) {
            this.streetLeg = streetCurb.getBlocks().getList().get(avenueId);
        }

        System.out.println("streetLeg:" + streetLeg.toString()
            + " street_curb_arrayIndex:" + streetCurb.getBlocks().getList().indexOf(streetLeg)
            + " cornerId:" + id
            + " cornerOrientation:" + cornerOrientation.print() + "");
    }

    private boolean isValidOrientation(Direction cornerOrientation) {
        return cornerOrientation == Direction.NORTHEAST ||
            cornerOrientation == Direction.SOUTHEAST ||
            cornerOrientation == Direction.SOUTHWEST ||
            cornerOrientation == Direction.NORTHWEST;
    }

    public Curb getAvenueCurb() {
        Direction curbOrientation = Direction.NORTH;

        if (cornerOrientation != Direction.NORTHEAST && cornerOrientation != Direction.NORTHWEST)
            curbOrientation = Direction.SOUTH;
        return junction.avenue().getCurbByOrientation(curbOrientation);
    }


    private Curb getStreetCurb() {
        Direction curbOrientation = Direction.EAST;

        if (cornerOrientation != Direction.NORTHEAST && cornerOrientation == Direction.SOUTHEAST)
            curbOrientation = Direction.WEST;
        return junction.street().getCurbByOrientation(curbOrientation);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
            + "[id:" + id
            + " name:" + name
            + " avenueLeg:" + avenueLeg.toString()
            + " streetLeg:" + streetLeg.toString() + "]";
    }
}