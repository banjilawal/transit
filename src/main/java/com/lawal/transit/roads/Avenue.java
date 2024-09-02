package com.lawal.transit.roads;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.roads.interfaces.*;


public final class Avenue implements Road {

    public static final RoadCategory ROAD_CATEGORY = RoadCategory.AVENUE;
    public static final Orientation RIGHTWARD_TRAFFIC_DIRECTION = Orientation.WEST;
    public static final Orientation LEFTWARD_TRAFFIC_DIRECTION = Orientation.EAST;


    private final RoadIdentifier label;
    private final Lanes leftCarriageway;
    private final Lanes rightCarriageway;
    private final Curbsideable leftFrontage;
    private final Curbsideable rightFrontage;

    private Avenue (Builder builder) {
        this.label = builder.label;
        this.leftFrontage = builder.leftFrontage;
        this.rightFrontage = builder.rightFrontage;
        this.leftCarriageway = builder.leftCarriageway;
        this.rightCarriageway = builder.rightCarriageway;
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

    public static Orientation getTrafficeDirection (Laterality laterality) {
        if (laterality.equals(Laterality.LEFT))
            return LEFTWARD_TRAFFIC_DIRECTION;
        else
            return RIGHTWARD_TRAFFIC_DIRECTION;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Avenue avenue) {
            return label.equals(avenue.label())
                && rightCarriageway.numberOfLanes() == avenue.rightCarriageway().numberOfLanes()
                && leftCarriageway.numberOfLanes() == avenue.leftCarriageway().numberOfLanes();
        }
        return false;
    }

    @Override
    public String toString () {
        return label.name() + " " + label.category().abbreviation();
    }

    public int totalStations () {
        return leftFrontage.stations().size() + rightFrontage.stations().size();
    }

    public int totalPlaces () {
        return leftFrontage.blocks().size() + rightFrontage.blocks().size();
    }

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

        public Builder label (RoadIdentifier label) {
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

        public Avenue build () {
            return new Avenue(this);
        }
    }
}