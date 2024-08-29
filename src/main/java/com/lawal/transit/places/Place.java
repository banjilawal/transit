package com.lawal.transit.places;

import com.lawal.transit.globals.*;
import com.lawal.transit.places.interfaces.*;

public record Place (LocationKey key) implements Placeable, Visitee {

    @Override
    public void accept (Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + ":" + key.toString();
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
