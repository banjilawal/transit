package com.lawal.transit.block;

import com.lawal.transit.block.interfaces.*;
import com.lawal.transit.places.Places;
import com.lawal.transit.places.interfaces.*;
import com.lawal.transit.station.Station;

public class Block implements RoadSegment {
    private final BlockTag tag;
    private final Placeables places;
    private Station station;

    public Block (BlockTag tag, Station station) {
        this.tag = tag;
        this.station = station;
        this.places = new Places();
    }

    @Override
    public BlockTag getTag () { return tag; }

    @Override
    public Placeables getPlaces () { return places; }

    @Override
    public Station getStation () { return station; }

    @Override
    public void setStation (Station station) { this.station = station; }

    @Override
    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof RoadSegment roadSegment)
            return tag.equals(roadSegment.getTag());
        return false;
    }

    @Override
    public String toString () {
        String roadName = tag.curbsideMarker().roadLabel().name() + " "
            + tag.curbsideMarker().roadLabel().category().print() + " " + tag.curbsideMarker().travelDirection().print();
        return "block:" + tag.id() + " [road:" + roadName + " " + "addresses(" + places.toString() + ")]";
    }


}