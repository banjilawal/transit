package com.lawal.transit.road;

import com.lawal.transit.global.*;
import com.lawal.transit.road.interfaces.*;

public final class Street implements Road {

    public static final RoadCategory ROAD_CATEGORY = RoadCategory.STREET;
    public static final Direction RIGHTWARD_TRAFFIC_DIRECTION = Direction.SOUTH;
    public static final Direction LEFTWARD_TRAFFIC_DIRECTION = Direction.NORTH;
    public static final int RIGHTWARD_STATION_BASE_NAME = 1000;
    public static final int LEFTWARD_STATION_BASE_NAME = 3000;

    private final RoadIdentifier label;
    private final Curbsideable leftCurb;
    private final Curbsideable rightCurb;
    private final Lanes leftCarriageway;
    private final Lanes rightCarriageway;

    private Street (Builder builder) {
        this.label = builder.label;
        this.leftCurb = builder.leftCurb;
        this.rightCurb = builder.rightCurb;
        this.rightCarriageway = builder.leftCarriageway;
        this.leftCarriageway = builder.rightCarriageway;
    }

    @Override
    public RoadIdentifier label () {
        return label;
    }

    @Override
    public Lanes leftCarriageway () {
        return leftCarriageway;
    }

    @Override
    public Lanes rightCarriageway () {
        return rightCarriageway;
    }

    @Override
    public Curbsideable leftCurb() {
        return leftCurb;
    }

    @Override
    public Curbsideable rightCurb() {
        return rightCurb;
    }

    @Override
    public Lanes getCarriageway(Direction travelDirection) {
        if (travelDirection.equals(LEFTWARD_TRAFFIC_DIRECTION))
            return leftCarriageway;
        if (travelDirection.equals(RIGHTWARD_TRAFFIC_DIRECTION))
            return rightCarriageway;
        return null;
    }

    @Override
    public Curbsideable getCurb(Direction travelDirection) {
        return null;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Street street) {
            return label.equals(street.label());
//                && rightCarriageway.numberOfLanes() == street.rightCarriageway().numberOfLanes()
//                && leftCarriageway.numberOfLanes() == street.leftCarriageway().numberOfLanes();
        }
        return false;
    }

    @Override
    public String toString () {
        return label.name() + " " + label.category().abbreviation() + " ["
            + leftCarriageway.getTrafficDirection().adjective() + " block count:" + leftCurb.blocks().size() + " "
            + rightCarriageway.getTrafficDirection().adjective() + " block count:" + rightCurb.blocks().size() + "]";
    }

//    public static Direction getTrafficeDirection (Laterality laterality) {
//        if (laterality.equals(Laterality.LEFT))
//            return LEFTWARD_TRAFFIC_DIRECTION;
//        else
//            return RIGHTWARD_TRAFFIC_DIRECTION;
//    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {

        private RoadIdentifier label;
        private Lanes leftCarriageway;
        private Lanes rightCarriageway;
        private Curbsideable leftCurb;
        private Curbsideable rightCurb;

        public Builder () {}

        public Builder label (RoadIdentifier label) {
            this.label = label;
            return this;
        }

        public Builder leftCurb (Curbsideable leftCurb) {
            this.leftCurb = leftCurb;
            return this;
        }

        public Builder rightCurb (Curbsideable rightCurb) {
            this.rightCurb = rightCurb;
            return this;
        }

        public Builder leftCarriageway (Lanes leftCarriageway) {
            this.leftCarriageway = leftCarriageway;
            return this;
        }

        public Builder rightCarriageway (Lanes rightCarriageway) {
            this.rightCarriageway = rightCarriageway;
            return this;
        }

        public Street build () {
            return new Street(this);
        }
    }
}