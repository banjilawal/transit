package com.lawal.transit.search;

import com.lawal.transit.blocks.interfaces.*;

public record Address(int id, String name, RoadSectionTag blockTag) implements FormattedAddress {

    @Override
    public String toString () {
        return name + " " + blockTag.toString();
    }

    public static Builder builder () { return new Builder(); }
    public static class Builder {
        private int id;
        private String name;
        private RoadSectionTag blockTag;

        public Builder () {}

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

        public FormattedAddress build () {
            return new Address(id, name, blockTag);
        }
    }
//
//    @Override
//    public boolean equals (Object object) {
//        if (this == object) return true;
//        if (object == null) return false;
//        if (object instanceof FormattedAddress address) {
//            return id == address.id()
//                && blockId == address.blockId()
//                && name.equalsIgnoreCase(address.name())
//                && orientation.equals(address.orientation())
//                && roadLabel.equals(address.roadLabel());
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode () {
//        return Objects.hash(id, name, orientation, roadLabel);
//    }
//
//    @Override
//    public String toString () {
//        return name + " " + roadLabel.name() + " " + roadLabel.category().abbreviation()
//            + " " + orientation.abbreviation() + " blockId:" + blockId();
//    }
//
//    private Orientation getOrientation (Road roads, Laterality laterality) {
//        if (laterality == Laterality.RIGHT)
//            return roads.getRightCarriageway().getTrafficDirection();
//        else
//            return roads.getLeftCarriageway().getTrafficDirection();
//    }
}
