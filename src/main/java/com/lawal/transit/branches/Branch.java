package com.lawal.transit.branches;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.branches.interfaces.*;
import com.lawal.transit.roads.interfaces.*;

import java.util.*;

public record Branch (int id, RoadSectionTag blockTag, RoadIdentifier roadLabel) implements Branchable {

    public Builder builder () {
        return new Builder();
    }

    public static class Builder {
        private int id;
        private RoadSectionTag blockTag;
        private RoadIdentifier roadLabel;
        private HashMap<RoadIdentifier, ArrayList<RoadSectionTag>> branches;

        public Builder id (int id) {
            this.id = id;
            return this;
        }

        public Builder blockTag (RoadSectionTag blockTag) {
            this.blockTag = blockTag;
            return (this);
        }

        public Builder roadLabel (RoadIdentifier roadLabel) {
            this.roadLabel = roadLabel;
            return (this);
        }

        public Builder blockTags (ArrayList<RoadSectionTag> blockTags)
        public Branchable build () {
            return new Branch(id, blockTag, roadLabel);
        }
    }
}
