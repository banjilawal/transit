package com.lawal.transit.roads.creators;

import com.lawal.transit.globals.IdGenerator;
import com.lawal.transit.globals.NameGenerator;
import com.lawal.transit.roads.Avenues;
import com.lawal.transit.roads.Streets;
import com.lawal.transit.roads.Avenue;
import com.lawal.transit.roads.RoadCategory;
import com.lawal.transit.roads.Street;

import java.util.ArrayList;


public final class RoadFactory {

    private ArrayList<String> avenueNames;
    private int placeNameInterval;
    private int placesPerBlock;
    private int numberOfBlocks;

    public RoadFactory() {}

    public int getPlacesPerBlock () { return placesPerBlock; }

    public int getPlaceNameInterval () { return placeNameInterval; }

    public ArrayList<String> getAvenueNames() {
        return avenueNames;
    }

    public RoadFactory placesPerBlock (int placesBerBlock) {
        this.placesPerBlock = placesBerBlock;
        return this;
    }

    public RoadFactory placeNameInterval(int placeNameInterval) {
        this.placeNameInterval = placeNameInterval;
        return this;
    }

    public RoadFactory avenueNames (ArrayList<String> avenueNames) {
        this.avenueNames = avenueNames;
        this.numberOfBlocks = avenueNames.size();
        return this;
    }

    public Avenues deliverAvenues() throws Exception {
        Avenues avenues = new Avenues();
        RoadBuilder roadBuilder = new RoadBuilder()
            .roadCategory(RoadCategory.AVENUE)
            .placeNameInterval(placeNameInterval)
            .numberOfBlocks(numberOfBlocks)
            .placesPerBlock(placesPerBlock);
        for (String name: avenueNames) {
            avenues.add((Avenue) roadBuilder.roadId(IdGenerator.INSTANCE.nextAvenueId()).roadName(name).getProduct());
        }
        return avenues;
    }

    public Streets deliverStreets () throws Exception {
        Streets streets = new Streets();
        RoadBuilder roadBuilder = new RoadBuilder()
            .roadCategory(RoadCategory.STREET)
            .placeNameInterval(placeNameInterval)
            .numberOfBlocks(numberOfBlocks)
            .placesPerBlock(placesPerBlock);
        for (int index = 0; index < numberOfBlocks; index++) {
            int roadId = IdGenerator.INSTANCE.nextStreetId();
            streets.add((Street) roadBuilder.roadId(roadId).roadName(NameGenerator.INSTANCE.streetName(roadId)).getProduct());
        }
        return streets;
    }
}