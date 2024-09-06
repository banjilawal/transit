package com.lawal.transit.places;

import com.lawal.transit.addressing.LocationKey;
import com.lawal.transit.globals.*;
import com.lawal.transit.places.interfaces.*;

public record Place (LocationKey key) implements Placeable, Visitee {

    @Override
    public void accept (Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName()
            + " id:" + key.id()
            + " name:" + key.name()
            +  " " + key.blockTag().curbsideMarker().roadLabel().name()
            + " " + key.blockTag().curbsideMarker().roadLabel().category().abbreviation()
            + " " +key.blockTag().curbsideMarker().trafficDirection().print();
    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {

        private LocationKey key;

        public Builder key (LocationKey key) {
            this.key = key;
            return this;
        }

        public Place build () {
            return new Place(key);
        }
    }
}