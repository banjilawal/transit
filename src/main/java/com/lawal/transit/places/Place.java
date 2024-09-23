package com.lawal.transit.places;

import com.lawal.transit.addressing.Addressable;
import com.lawal.transit.globals.*;
import com.lawal.transit.places.interfaces.*;

public record Place (Addressable address) implements Placeable, Visitee {

    @Override
    public void accept (Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName()
            + " id:" + address.id()
            + " name:" + address.name()
            +  " " + address.blockTag().curbsideMarker().roadLabel().name()
            + " " + address.blockTag().curbsideMarker().roadLabel().category().abbreviation()
            + " " + address.blockTag().curbsideMarker().travelDirection().print();
    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {

        private Addressable key;

        public Builder key (Addressable key) {
            this.key = key;
            return this;
        }

        public Place build () {
            return new Place(key);
        }
    }
}