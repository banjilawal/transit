package com.lawal.transit.roads;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.roads.interfaces.*;


public final class Street implements Road {
    public static final RoadCategory ROAD_CATEGORY = RoadCategory.STREET;
    public static final Orientation RIGHTWARD_TRAFFIC_DIRECTION = Orientation.SOUTH;
    public static final Orientation LEFTWARD_TRAFFIC_DIRECTION = Orientation.NORTH;

    private final RoadIdentifier label;
    private final Curbsideable leftFrontage;
    private final Curbsideable rightFrontage;
    private final Lanes leftCarriageway;
    private final Lanes rightCarriageway;

    private Street (Builder builder) {
        this.label = builder.label;
        this.leftFrontage = builder.leftFrontage;
        this.rightFrontage = builder.rightFrontage;
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
    public Curbsideable leftFrontage () {
        return leftFrontage;
    }

    @Override
    public Curbsideable rightFrontage () {
        return rightFrontage;
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
        return label.name() + " " + label.category().print();
    }

//    public static Orientation getTrafficeDirection (Laterality laterality) {
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
        private Curbsideable leftFrontage;
        private Curbsideable rightFrontage;

        public Builder () {}

        public Builder roadLabel (RoadIdentifier label) {
            this.label = label;
            return this;
        }

        public Builder leftFrontage (Curbsideable leftFrontage) {
            this.leftFrontage = leftFrontage;
            return this;
        }

        public Builder rightFrontage (Curbsideable rightFrontage) {
            this.rightFrontage = rightFrontage;
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
            return new Street(this) ;
        }
    }
}
