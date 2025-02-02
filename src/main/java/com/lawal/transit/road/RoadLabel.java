package com.lawal.transit.road;

import com.lawal.transit.road.interfaces.*;

public record RoadLabel(int id, String name, RoadCategory category) {
//
//    private final int id;
//    private final String name;
//    private final RoadCategory category;
//    private RoadLabel (Builder builder) {
//        this.id = builder.id;
//        this.name = builder.name;
//        this.category = builder.category;
//    }
//
//

    @Override
    public String toString () {
        return getClass().getSimpleName() + " id:" + id + "  " + name + ": " + category.abbreviation();
    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {
        private int id;
        private String name;
        private RoadCategory category;;

        public Builder () {}
        public Builder id (int id) {
            this.id = id;
            return this;
        }

        public Builder name (String name) {
            this.name = name;
            return this;
        }

        public Builder category (RoadCategory category) {
            this.category = category;
            return this;
        }

        public RoadLabel build () {
            return new RoadLabel(id, name, category);
        }
    }

//    @Override
//    public boolean equals (Object object) {
//        if (object == this) return true;
//        if (object == null) return false;
//        if (object instanceof RoadLabel identifier)
//            return id == identifier.id()
//                && name.equalsIgnoreCase(identifier.name())
//                && category.equals(identifier.category());
//        return false;
//    }
//
}