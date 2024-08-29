package com.lawal.transit.blocks;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.places.interfaces.*;

public record Block (RoadSectionTag tag, Placeables places) implements RoadSectional {

    public static Builder builder () { return new Builder(); }

    @Override
    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof RoadSectional roadSectional)
            return tag.equals(roadSectional.tag());
        return false;
    }

    public static class Builder {
        private RoadSectionTag tag;
        private Placeables places;

        public Builder () {}

        public Builder tag (RoadSectionTag tag) {
            this.tag = tag;
            return this;
        }

        public Builder places (Placeables places) {
            this.places = places;
            return this;
        }

        public RoadSectional build () {
            return new Block(tag, places);
        }
    }
}
