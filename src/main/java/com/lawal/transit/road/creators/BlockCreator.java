package com.lawal.transit.road.creators;

import com.lawal.transit.block.Block;
import com.lawal.transit.block.BlockTag;
import com.lawal.transit.block.interfaces.RoadSegment;
import com.lawal.transit.catalog.PlaceCatalog;
import com.lawal.transit.global.IdGenerator;
import com.lawal.transit.global.Address;
import com.lawal.transit.places.Place;
import com.lawal.transit.places.Places;
import com.lawal.transit.places.interfaces.Placeable;
import com.lawal.transit.places.interfaces.Placeables;
import com.lawal.transit.road.interfaces.CurbsideMarking;

public final class BlockCreator {

    private int blockId;
    private int numberOfPlaces;
    private int startingPlaceName;
    private int placeName;
    private int placeNameInterval;
    private CurbsideMarking curbsideMarker;

    public BlockCreator() {}

    public CurbsideMarking getCurbsideMarker () {
        return curbsideMarker;
    }

    public int getBlockId () {
        return blockId;
    }

    public int getNumberOfPlaces () {
        return numberOfPlaces;
    }

    public int getStartingPlaceName () {
        return startingPlaceName;
    }

    public int getPlaceName () {
        return placeName;
    }

    public int getPlaceNameInterval () {
        return placeNameInterval;
    }

    @Override
    public String toString () {
        return "BlockCreator{" + "blockId=" + blockId + ", numberOfPlaces=" + numberOfPlaces
            + ", startingPlaceNameInfix=" + startingPlaceName
            + ", placeNameInfix=" + placeName
            + ", placeNameInterval=" + placeNameInterval
            + ", curbsideMarker=" + curbsideMarker;
    }

    public BlockCreator blockId (int blockId) {
        this.blockId = blockId;
        return this;
    }

    public BlockCreator numberOfPlaces (int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
        return this;
    }

    public BlockCreator startingPlaceName (int startingPlaceName) {
        this.startingPlaceName = startingPlaceName;
        this.placeName = startingPlaceName;
        return this;
    }

    public BlockCreator placeNameInterval (int placeNameInterval) {
        this.placeNameInterval = placeNameInterval;
        return this;
    }

    public BlockCreator curbsideMarker (CurbsideMarking curbsideMarker) {
        this.curbsideMarker = curbsideMarker;
        return this;
    }

    public RoadSegment createBlock () throws Exception {
//        System.out.println("block creation parameters " + toString());
        PlaceCatalog placeCatalog = PlaceCatalog.INSTANCE;
        BlockTag blockTag = new BlockTag(blockId, curbsideMarker);
        Placeables places = new Places();
        for (int index = 0; index < numberOfPlaces; index++) {
            Placeable place = new Place(new Address(IdGenerator.INSTANCE.nextPlaceId(), "" + placeName, blockTag));
            placeCatalog.getCatalog().add(place);
            places.add(place);
            placeName += placeNameInterval;
        }
        return new Block(blockTag, null);
    }
}