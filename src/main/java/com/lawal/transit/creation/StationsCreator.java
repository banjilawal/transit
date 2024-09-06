package com.lawal.transit.creation;

import com.lawal.transit.blocks.interfaces.RoadSectionTag;
import com.lawal.transit.edges.Edges;
import com.lawal.transit.globals.IdGenerator;
import com.lawal.transit.addressing.Key;
import com.lawal.transit.addressing.LocationKey;
import com.lawal.transit.stations.Station;
import com.lawal.transit.stations.Stations;
import com.lawal.transit.stations.interfaces.Stationable;
import com.lawal.transit.stations.interfaces.Stationables;

public final class StationsCreator {

    private final int size;
    private final int addressInterval;
    private final int startingAddressNumber;
    private int endingAddressNumber;
    private final RoadSectionTag blockTag;

    private StationsCreator (Builder builder) {
        this.size = builder.size;
        this.addressInterval = builder.addressInterval;
        this.startingAddressNumber = builder.startingAddressNumber;
        this.endingAddressNumber = startingAddressNumber;
        this.blockTag = builder.blockTag;
    }

    public int getSize() {
        return size;
    }

    public int getAddressInterval() {
        return addressInterval;
    }

    public int getStartingAddressNumber() {
        return startingAddressNumber;
    }

    public int getEndingAddressNumber() {
        return endingAddressNumber;
    }

    public RoadSectionTag getBlockTag() {
        return blockTag;
    }

    public Stationables createStations () throws Exception {
        Stationables stations = new Stations();
        for (int index = 0; index < size; index++) {
            LocationKey key = new Key.Builder()
                .id(IdGenerator.INSTANCE.nextStationID())
                .name("MT-" + startingAddressNumber + addressInterval * index)
//                        .name(startingAddressNumber + addressInterval * index + "")
                .blockTag(blockTag).build();
            Stationable station = new Station.Builder().key(key).incomingEdges(new Edges()).outgoingEdges(new Edges()).build();
            stations.add(station);
            endingAddressNumber = startingAddressNumber + addressInterval * index;
        }
        return stations;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int size;
        private int addressInterval;
        private int startingAddressNumber;
        private RoadSectionTag blockTag;

        public Builder size (int size) {
            this.size = size;
            return this;
        }

        public Builder addressInterval(int addressInterval) {
            this.addressInterval = addressInterval;
            return this;
        }

        public Builder startingAddressNumber(int startingAddressNumber) {
            this.startingAddressNumber = startingAddressNumber;
            return this;
        }

        public Builder blockTag(RoadSectionTag blockTag) {
            this.blockTag = blockTag;
            return this;
        }

        public StationsCreator build() {
            return new StationsCreator(this);
        }
    }
}