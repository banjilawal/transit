package com.lawal.transit.test;

import com.lawal.transit.globals.IdGenerator;
import com.lawal.transit.globals.NameGenerator;
import com.lawal.transit.roads.RoadCategory;
import com.lawal.transit.roads.Street;
import com.lawal.transit.roads.creators.RoadBuilder;

public class RoadBuilderDriver {
    public static void main(String[] args) throws Exception {

        RoadBuilder roadBuilder = new RoadBuilder()
            .roadCategory(RoadCategory.STREET)
            .numberOfBlocks(4)
            .placeNameInterval(2)
            .placesPerBlock(4);
        for (int i = 0; i < 10; i++) {
            int roadId = IdGenerator.INSTANCE.nextStreetId();
            Street street = (Street) roadBuilder
                .roadName(NameGenerator.INSTANCE.streetName(roadId))
                .roadId(roadId)
                .getProduct();
            System.out.println("id:" + street.label().id() + " " + street.toString());
            System.out.println("\t" + street.leftCurb().toString());
            System.out.println("\t" + street.rightCurb().toString());
        }
    }
}