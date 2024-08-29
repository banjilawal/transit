package com.lawal.transit.globals;

import com.lawal.transit.blocks.interfaces.*;

public record Key(int id, String name, RoadSectionTag blockTag) implements LocationKey {

    @Override
    public String toString () {
        return " name:" + name + " blockId:" + blockTag.id() + " " + blockTag.trafficDirection().abbreviation();
    }

    public Builder builder () {
        return new Builder();
    }
    public static class Builder  {

        private int id;
        private String name;
        private RoadSectionTag blockTag;

        public Builder id (int id) {
            this.id = id;
            return this;
        }


        public Builder name (String name) {
            this.name = name;
            return this;
        }

        public Builder blockTag (RoadSectionTag blockTag) {
            this.blockTag = blockTag;
            return this;
        }

        public LocationKey build () {
            return new Key(id, name, blockTag) ;
        }
    }
}
