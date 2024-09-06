package com.lawal.transit.roads;

import com.lawal.transit.globals.*;
import com.lawal.transit.roads.interfaces.*;


public final class Avenue implements Road {

    public static final RoadCategory ROAD_CATEGORY = RoadCategory.AVENUE;
    public static final Orientation RIGHTWARD_TRAFFIC_DIRECTION = Orientation.WEST;
    public static final Orientation LEFTWARD_TRAFFIC_DIRECTION = Orientation.EAST;
    public static final int RIGHTWARD_STATION_BASE_NAME = 2000;
    public static final int LEFTWARD_STATION_BASE_NAME = 4000;

    private final RoadIdentifier label;
    private final Lanes leftCarriageway;
    private final Lanes rightCarriageway;
    private final Curbsideable leftCurb;
    private final Curbsideable rightCurb;

    public Avenue (RoadIdentifier label) {
        this.label = label;
        this.leftCarriageway = new Carriageway(LEFTWARD_TRAFFIC_DIRECTION);
        this.rightCarriageway = new Carriageway(RIGHTWARD_TRAFFIC_DIRECTION);
        this.leftCurb = new Curbside(new CurbsideKey(label, LEFTWARD_TRAFFIC_DIRECTION));
        this.rightCurb = new Curbside(new CurbsideKey(label, RIGHTWARD_TRAFFIC_DIRECTION));
    }

    private Avenue (Builder builder) {
        this.label = builder.label;
        this.leftCurb = builder.leftCurb;
        this.rightCurb = builder.rightCurb;
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
    public Curbsideable leftCurb() {
        return leftCurb;
    }
    @Override
    public Curbsideable rightCurb() {
        return rightCurb;
    }

    @Override
    public Lanes getCarriageway(Orientation orientation) {
        if (orientation.equals(LEFTWARD_TRAFFIC_DIRECTION))
            return leftCarriageway;
        if (orientation.equals(RIGHTWARD_TRAFFIC_DIRECTION))
            return rightCarriageway;
        return null;
    }

    @Override
    public Curbsideable getCurb (Orientation orientation) {
        if (orientation.equals(LEFTWARD_TRAFFIC_DIRECTION))
            return leftCurb;
        if (orientation.equals(RIGHTWARD_TRAFFIC_DIRECTION))
            return rightCurb;
        return null;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Avenue avenue) {
            return label.equals(avenue.label());
//                && rightCarriageway.numberOfLanes() == avenue.rightCarriageway().numberOfLanes()
//                && leftCarriageway.numberOfLanes() == avenue.leftCarriageway().numberOfLanes();
        }
        return false;
    }

    @Override
    public String toString () {
        return label.name() + " " + label.category().abbreviation();
    }

    public int totalStations () {
        return leftCurb.stations().size() + rightCurb.stations().size();
    }

    public int totalPlaces () {
        return leftCurb.blocks().size() + rightCurb.blocks().size();
    }

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

        public Avenue build () {
            return new Avenue(this);
        }
    }
}