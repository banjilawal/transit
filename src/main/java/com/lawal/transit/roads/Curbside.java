package com.lawal.transit.roads;

import com.lawal.transit.blocks.Blocks;
import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.roads.interfaces.*;
import com.lawal.transit.stations.Station;
import com.lawal.transit.stations.Stations;

//public record Curbside (CurbsideMarking address, Stationables stations, RoadSectionals blocks) implements Curbsideable {

public final class Curbside implements Curbsideable {

    private final CurbsideMarking marker;
    private final Stations stations;
    private final RoadSectionals blocks;

    public Curbside (CurbsideMarking marker) {
        this.marker = marker;
        this.blocks = new Blocks();
        this.stations = new Stations();
    }

    private Curbside(Builder builder) {
        this.marker = builder.marker;
        this.stations = builder.stations;
        this.blocks = builder.blocks;
    }

    @Override
    public CurbsideMarking marker () {
        return marker;
    }

    @Override
    public RoadSectionals blocks () {
        return blocks;
    }

    @Override
    public Stations stations () {
        return stations;
    }

    @Override
    public String toString () {
        return marker().travelDirection().toString()
            + " [block count:" + blocks.size() + " station count:"  + stations.size() + "]\n"
            + printMembers();
    }


    public String printMembers () {
        String stationName = "";
        StringBuilder stringBuilder = new StringBuilder()
            .append("Block ID").append(String.format("%10s", "Station")).append(String.format("%14s\n", "Places"));
        for (int i = 0; i <65; i++)
            stringBuilder.append("-");
        stringBuilder.append("\n");
        for (RoadSectional block : blocks.getList()) {
            stringBuilder.append(String.format("%-4d", block.tag().id()));
            Station station = block.getStation(stations);
            stationName = "";
            if (station != null) stationName = station.getKey().name();
            stringBuilder.append(String.format("%15s", stationName));
            stringBuilder.append(String.format("%30s", block.places().toString())).append("\n");
        }
        return stringBuilder.toString();
    }

    public static Builder builder () {
        return new Builder();
    }

    public static class Builder {
        private CurbsideMarking marker;
        private RoadSectionals blocks;
        private Stations stations;


        public Builder () {}

        public Builder key(CurbsideMarking marker) {
            this.marker = marker;
            return this;
        }

        public Builder blocks (RoadSectionals blocks) {
            this.blocks = blocks;
            return this;
        }

        public Builder stations (Stations stations) {
            this.stations = stations;
            return this;
        }

        public Curbsideable build () {
            return new Curbside(this);
        }
    }
}