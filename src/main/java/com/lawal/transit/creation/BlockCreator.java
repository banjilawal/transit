package com.lawal.transit.creation;

import com.lawal.transit.blocks.Block;
import com.lawal.transit.blocks.interfaces.RoadSectionTag;
import com.lawal.transit.blocks.interfaces.RoadSectional;
import com.lawal.transit.globals.IdGenerator;
import com.lawal.transit.addressing.Key;
import com.lawal.transit.addressing.LocationKey;
import com.lawal.transit.places.Place;
import com.lawal.transit.places.Places;
import com.lawal.transit.places.interfaces.Placeable;
import com.lawal.transit.places.interfaces.Placeables;

public final class BlockCreator {
    private final int size;
    private final int addressInterval;
    private final int startingAddressNumber;
    private int endingAddressNumber;
    private final RoadSectionTag blockTag;

    private BlockCreator (Builder builder) {
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

    public RoadSectional createBlock () throws Exception {
        Placeables places = new Places();
        for (int index = 0; index < size; index++) {
            LocationKey key = new Key.Builder()
                .id(IdGenerator.INSTANCE.nextPlaceId())
                .name(startingAddressNumber + addressInterval * index + "")
                .blockTag(blockTag).build();
            Placeable place = new Place.Builder().key(key).build();
            places.add(place);
            endingAddressNumber = startingAddressNumber + addressInterval * index;
        }
        return new Block.Builder().tag(blockTag).places(places).build();
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

        public BlockCreator build() {
            return new BlockCreator(this);
        }
    }
}