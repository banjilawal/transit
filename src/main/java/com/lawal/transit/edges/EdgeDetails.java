package com.lawal.transit.edges;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.edges.interfaces.*;
import com.lawal.transit.graph.*;
import com.lawal.transit.roads.interfaces.*;

public record EdgeDetails(int id, Weightable weight,EdgeCategory category) implements EdgeProperties {
    @Override
    public String toString () {
        return "id:" + id + " weight:" + weight.toString() + " category:" + category.toString();
    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {
        private int id;
        private Weightable weight;
        private EdgeCategory category;


        public Builder id (int id) {
            this.id =id;
            return this;
        }

        public Builder weight (Weightable weight) {
            this.weight = weight;
            return this;
        }

        public Builder category (EdgeCategory category) {
            this.category = category;
            return this;
        }

        public EdgeProperties build () {
            return new EdgeDetails(id, weight, category);
        }
    }
}


